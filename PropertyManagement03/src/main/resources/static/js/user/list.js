/**
 * @date: 2019年8月11日 上午10:44:09
 * @author: YiChen(李冠永)
 * @Description: 系统操作员前端控制JS
 */

$(function() {
	var employeeId = null;
	var startJoinDate = null;
	var endJoinDate = null;
	var departmentNo = 0;
	var roleNo = 0;
	var sex = "";
	
	setMessage("用户列表", 5000);

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#userinfoGrid").jqGrid({
		url: rootAddress+'user/list',
		datatype: "json",
		colModel: [
			{ label: '账号', name: 'id' },
			{ label: '姓名', name: 'username' },
			{ label: '性别', name: 'sex' },
			{ label: '年龄', name: 'age', sorttype: 'integer'},
			{ label: '手机号码', name: 'mobile' },
			{ label: '状态', name: 'status' }
		],
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 10,
		rowList:[10,20,30],
		loadonce: true,
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"
		},
		pager: "#userinfoGridPager"
	});
	
	// 更新jQGrid的列表显示
	function reloadEmployeeList() {
		$("table#EmployeeGrid").jqGrid('setGridParam', {
			postData : {
				departmentNo : departmentNo,
				roleNo : roleNo,
				sex : sex,
				startJoinDate : startJoinDate,
				endJoinDate : endJoinDate
			}
		}).trigger("reloadGrid");

	}

	// 点击检索事件处理
	$("a#EmployeeSearchButton").on("click", function() {
		departmentNo = $("select#DepartmentSelection").val();
		roleNo = $("select#RoleSelection").val();
		sex = $("input[name='empsex']:checked").val();

		startJoinDate = $("input#startJoinDate").val();
		endJoinDate = $("input#endJoinDate").val();
		if (startJoinDate == "") {
			startJoinDate = null;
		}
		if (endJoinDate == "") {
			endJoinDate = null;
		}
		reloadEmployeeList();
	});

});