/**
 * @date: 2019年8月16日15:45:13
 * @author: YiChen(李冠永)
 * @Description: 系统功能前端控制JS
 */

var addDialogArea = null;
var selectRow_funno = null;
var curr_id = selectRow_id;
$(function() {
	var functionNo = null;
	var functionName = null;
	var module = { };
	module.no = null;
	var levelNo = null;
	
	setBreadcrumbs(["系统参数","系统权限管理","用户权限管理","查看权限"]);
	setMessage("查看权限", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#userFunctionDetailsGrid").jqGrid({
		url: rootAddress+'function/user/list/page',
		postData : {userid: curr_id},
		datatype: "json",
		colModel: [
			{ label: '权限号', name: 'no' },
			{ label: '权限名', name: 'name' },
			{ label: '所属类别', name: 'module.name' },
			{ label: '权限等级', name: 'levelno' }
		],
		viewrecords: true, 
		autowidth: true,
		height: 365,
		rowNum: 10,
		rowList:[10,20,30],
		loadonce: true,
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "no"
		},
		pager: "#userFunctionDetailsGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_funno = id;
		}
	});
	
	// 加载类别
	$.getJSON(rootAddress+"module/list", (rs)=>{
		$.each(rs.list, (index, module)=>{
			$('select#module').append('<option value="'+module.no+'">'+module.name+'</option>');
		});
	});
	
	// 点击检索事件处理
	$("button#DetailsSearchButton").on("click", function() {
		functionNo = $("input#functionNo").val();
		functionName = $("input#functionName").val();
		module.no = $("select#module").val();
		levelNo = $("input#levelNo").val();
		
		reloadFunctionList();
	});
	
	// 更新jQGrid的列表显示
	function reloadFunctionList () {
		
		postData = { userid: curr_id };
		if (functionNo != "") postData.no = functionNo;
		if (functionName != "") postData.name = functionName;
		if (module.no != "") postData['module.no'] = module.no;
		if (levelNo != "") postData.levelno = levelNo;
		
		$("table#userFunctionDetailsGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 添加、删除
	$(".function-list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		var url = $(this).attr("href");

		if ( /function\/userAddFunction.html/.test(url) ) {
			
			$(".function-list-box #user-add-dialog").load(url, () => {

				addDialogArea = $(".function-list-box #user-add-dialog");
				addDialogArea.dialog({
					title: $(this).attr("title"),
					modal: true,
					width: "80%",
					maxWidth: "845px",
					close: function(event, ui) {
						doSomethingWhenDialogClose();
						addDialogArea.dialog("destroy");
						addDialogArea.html("");
						doSomethingWhenDialogClose = function () {};
					}
				});
			});
		} else {
			if ( selectRow_funno == null ) {
				jqueryEject.Etoast('请选择一个功能',1);
			} else {
				
			}
		}
	});
});
