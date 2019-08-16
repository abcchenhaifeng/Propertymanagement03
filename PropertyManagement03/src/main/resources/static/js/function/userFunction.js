/**
 * @date: 2019年8月14日23:29:11
 * @author: YiChen(李冠永)
 * @Description: 系统模块前端控制JS
 */

var selectRow_id = null;
var reloadList = null;
$(function() {
	var moduleNo = null;
	var moduleName = null;
	
	var selectRow_id_tmp = null;

	setBreadcrumbs(["系统参数","自定义类别管理"]);
	setMessage("类别列表", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#moduleGrid").jqGrid({
		url: rootAddress+'module/list/page',
		datatype: "json",
		colModel: [
			{ label: '类别号', name: 'no' },
			{ label: '类别名', name: 'name' },
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
		      id: "no"
		},
		pager: "#moduleGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_id = id;
			selectRow_id_tmp = id;
		}
	});
	
	// 点击检索事件处理
	$("button#SearchButton").on("click", function() {
		moduleNo = $("input#moduleNo").val();
		moduleName = $("input#moduleName").val();
		
		reloadList();
	});
	
	// 更新jQGrid的列表显示
	reloadList = function () {
		
		postData = { };
		if (moduleNo != "") postData.no = moduleNo;
		if (moduleName != "") postData.name = moduleName;
		
		$("table#moduleGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 添加、修改、删除
	$(".list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		
		url_method = $(this).attr("method");
		var url = $(this).attr("href");
		// 删除
		if(/module\/delete$/.test(url)) {
			if ( selectRow_id == null ) {
				setMessage("请选择一个类别", 5000);
				return;
			}
			$.get(rootAddress+"module/get/functions/count",{no:selectRow_id},function(result){
            	if(result > 0){
					setMessage("不能满足删除条件,若要删除,请清空该类别下的功能", 5000);
				} else {
					jqueryEject.Econfirm({
						title: '删除',
						message: '确认删除此类别么?',
						define: function() {
							$.post(rootAddress+url,{no:selectRow_id},function(result){
								setMessage(result.message, 5000);
								if(result.status=="OK") reloadList();
							});
						},
						cancel: function() {}
					});
				}
            });
            
        // 添加、修改
		} else {
			
			if ( url_method != "add" && selectRow_id == null ) {
				setMessage("请选择一个类别", 5000);
			} else {
				$("section#main #dialog").load(url, () => {
					selectRow_id = selectRow_id_tmp;
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
