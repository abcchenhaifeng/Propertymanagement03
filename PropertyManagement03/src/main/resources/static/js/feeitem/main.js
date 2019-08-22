/**
 * @date: 2019年8月22日00:24:56
 * @author: YiChen(李冠永)
 * @Description: 收费类型前端控制JS
 */

var selectRow_id = null;
var reloadList = null;
$(function() {
	var itemcode = "";
	var itemname = "";
	var feetype = {typeno: ""};
	var feepaymethod = "";
	var feecycle = "";
	var itemstatus = "";
	var itemunit = "";
	
	setBreadcrumbs(["收费管理","基本收费项目设置","收费项目列表"]);
	setMessage("收费项目列表", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#feeitemGrid").jqGrid({
		url: rootAddress+'feeitem/list/page',
		datatype: "json",
		colModel: [
			{ label: '项目代码', name: 'itemcode' },
			{ label: '项目名称', name: 'itemname' },
			{ label: '收费类型', name: 'feetype.typename' },
			{ label: '计费方式', name: 'feepaymethod' },
			{ label: '周期性', name: 'feecycle', edittype:'select', formatter:'select', editoptions:{value:"Y:是;N:否"} },
			{ label: '是否收费', name: 'itemstatus', edittype:'select', formatter:'select', editoptions:{value:"Y:是;N:否"} },
			{ label: '收费单位', name: 'itemunit' }
		],
		viewrecords: true, 
		autowidth: true,
		height: 365,
		rowNum: 10,
		rowList:[10,20,30],
		loadonce: false,
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "itemno"
		},
		pager: "#feeitemGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_id = id;
		}
	});
	
	// 加载收费类型
	$.getJSON(rootAddress+"feetype/list", (rs)=>{
		$.each(rs.list, (index, module)=>{
			$('select#feetype').append('<option value="'+module.typeno+'">'+module.typename+'</option>');
		});
	});
	
	// 点击检索事件处理
	$("button#SearchButton").on("click", function() {
		console.log(1);
		
		itemcode = $("input#itemcode").val();
		itemname = $("input#itemname").val();
		feetype.typeno = $("select#feetype").val();
		feepaymethod = $("input#feepaymethod").val();
		feecycle = $("select#feecycle").val();
		itemstatus = $("select#itemstatus").val();
		itemunit = $("input#itemunit").val();
		
		reloadList();
	});
	
	// 更新jQGrid的列表显示
	reloadList = function () {
		
		postData = { };
		if (itemcode != "") postData.itemcode = itemcode;
		if (itemname != "") postData.itemname = itemname;
		if (feetype.typeno != "") postData['feetype.typeno'] = feetype.typeno;
		if (feepaymethod != "") postData.feepaymethod = feepaymethod;
		if (feecycle != "") postData.feecycle = feecycle;
		if (itemstatus != "") postData.itemstatus = itemstatus;
		if (itemunit != "") postData.itemunit = itemunit;
		
		$("table#feeitemGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 添加、查看、删除、年度价格
	$(".list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		var url = $(this).attr("href");
		var method = $(this).attr("method");
		
		// 删除
		if ( /delete/.test(url) ) {
			if ( $("table#feeitemGrid").jqGrid("getGridParam","selrow") == null ) {
				setMessage("请选择一个项目", 5000);
			} else {
				jqueryEject.Econfirm({
					title: '删除',
					message: '确认删除此项目么?',
					define: function() {
						$.post(rootAddress+url, {no: selectRow_id}, (rs)=>{
							setMessage(rs.message, 5000);
							reloadList();
						}).fail((rs)=>{
							setMessage("删除失败", 5000);
						});	
					},
					cancel: function() {}
				});
			}
			
		// 年度价格
		} else if (/yearprice/.test(url)) {
			var rowid = $("table#feeitemGrid").jqGrid("getGridParam","selrow");
			if ( rowid == null ) {
				setMessage("请选择一个项目", 5000);
			} else {
				var rowData = $("table#feeitemGrid").jqGrid('getRowData',rowid);
				$("section#main #dialog").load(url, () => {
					dialogArea = $("section#main #dialog");
					dialogArea.dialog({
						title: $(this).attr("title")+"-"+rowData.itemname,
						width: "80%",
						maxWidth: "845px",
						position: { my: "center", at: "top+20%", of: window  },
						close: function(event, ui) {
							doSomethingWhenDialogClose();
							dialogArea.dialog("destroy");
							dialogArea.html("");
							doSomethingWhenDialogClose = function () {};
						}
					});
				});
			}
		
		// 添加
		} else if (method == "add") {
			url_method = "add";
			$("section#main #dialog").load(url, () => {
				dialogArea = $("section#main #dialog");
				dialogArea.dialog({
					title: $(this).attr("title"),
					width: "80%",
					maxWidth: "845px",
					close: function(event, ui) {
						doSomethingWhenDialogClose();
						dialogArea.dialog("destroy");
						dialogArea.html("");
						doSomethingWhenDialogClose = function () {};
					}
				});
			});
		
		// 查看
		} else {
			if ( $("table#feeitemGrid").jqGrid("getGridParam","selrow") == null ) {
				setMessage("请选择一个项目", 5000);
			} else {
				url_method = "modify";
				$("section#main #dialog").load(url, () => {
					dialogArea = $("section#main #dialog");
					dialogArea.dialog({
						title: $(this).attr("title"),
						width: "80%",
						maxWidth: "845px",
						close: function(event, ui) {
							doSomethingWhenDialogClose();
							dialogArea.dialog("destroy");
							dialogArea.html("");
							doSomethingWhenDialogClose = function () {};
						}
					});
				});
			}
		}
	});
});
