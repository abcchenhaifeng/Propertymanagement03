/**
 * @date: 2019年8月22日00:24:56
 * @author: YiChen(李冠永)
 * @Description: 收费类型前端控制JS
 */

var selectRow_id = null;
var reloadList = null;
$(function() {
	var typeno = "";
	var typename = "";
	
	setBreadcrumbs(["收费管理","基本收费项目设置","收费类型列表"]);
	setMessage("收费类型列表", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#feetypeGrid").jqGrid({
		url: rootAddress+'feetype/list/page',
		datatype: "json",
		colModel: [
			{ label: '类型编号', name: 'typeno' },
			{ label: '类型名称', name: 'typename' }
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
		      id: "typeno"
		},
		pager: "#feetypeGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_id = id;
		}
	});
	
	// 点击检索事件处理
	$("button#SearchButton").on("click", function() {
		typeno = $("input#typeno").val();
		typename = $("input#typename").val();
		
		reloadList();
	});
	
	// 更新jQGrid的列表显示
	reloadList = function () {
		
		postData = { };
		if (typeno != "") postData.typeno = typeno;
		if (typename != "") postData.typename = typename;
		
		$("table#feetypeGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 添加、修改、删除
	$(".list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		var url = $(this).attr("href");
		var method = $(this).attr("method");
		
		// 删除
		if ( /delete/.test(url) ) {
			if ( selectRow_id == null ) {
				setMessage("请选择一个类型", 5000);
			} else {
				jqueryEject.Econfirm({
					title: '删除',
					message: '确认删除此类型么?',
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
		
		// 修改
		} else {
			if ( selectRow_id == null ) {
				setMessage("请选择一个类型", 5000);
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
