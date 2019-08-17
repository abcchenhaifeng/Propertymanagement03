/**
 * @date: 2019年8月16日14:00:09
 * @author: YiChen(李冠永)
 * @Description: 系统模块前端控制JS
 */

var selectRow_id = null;
var reloadList = null;
$(function() {
	var userid = null;
	var username = null;
	
	var selectRow_id_tmp = null;

	setBreadcrumbs(["系统参数","系统权限管理","用户权限管理"]);
	setMessage("用户权限管理", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#userfunctionGrid").jqGrid({
		url: rootAddress+'user/list',
		postData : {status: "Y"},
		datatype: "json",
		colModel: [
			{ label: '账号', name: 'id' },
			{ label: '姓名', name: 'username' },
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
		      id: "id"
		},
		pager: "#userfunctionGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_id = id;
			selectRow_id_tmp = id;
		}
	});
	
	// 点击检索事件处理
	$("button#SearchButton").on("click", function() {
		userid = $("input#userid").val();
		username = $("input#username").val();
		
		reloadList();
	});
	
	// 更新jQGrid的列表显示
	reloadList = function () {
		
		postData = {status: "Y"};
		if (userid != "") postData.id = userid;
		if (username != "") postData.username = username;
		
		$("table#userfunctionGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 查看权限
	$(".list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		
		var url = $(this).attr("href");
			
		if ( selectRow_id == null ) {
			setMessage("请选择一个类别", 5000);
		} else {
			$("section#main #dialog").load(url, () => {
				selectRow_id = selectRow_id_tmp;
				dialogArea = $("section#main #dialog");
				dialogArea.dialog({
					title: $(this).attr("title"),
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
	});
});
