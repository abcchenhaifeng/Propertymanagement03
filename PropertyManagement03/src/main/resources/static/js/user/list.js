/**
 * @date: 2019年8月11日 上午10:44:09
 * @author: YiChen(李冠永)
 * @Description: 系统操作员前端控制JS
 */

var selectRow_id = null;
var reloadList = null;
$(function() {
	var userid = "";
	var startAge = "";
	var endAge = "";
	var username = "";
	var sex = "";
	var mobible = "";
	var status = "";
	
	var userinfoGrid = null;
	
	var selectRow_id_tmp = null;
	
	setBreadcrumbs(["系统参数","登录账号管理"])
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
			{ label: '手机号码', name: 'mobible' },
			{ label: '状态', name: 'status', editoptions:{value:"Y:已激活;N:冻结"} }
		],
		viewrecords: true, 
		autowidth: true,
		height: 365,
		rowNum: 10,
		rowList:[10,20,30],
		loadonce: true,
		sortable: true,
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"
		},
		pager: "#userinfoGridPager",
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
		sex = $("select#sex").val();
		mobible = $("input#tel").val();
		status = $("select#status").val();
		startAge = $("input#startAge").val();
		endAge = $("input#endAge").val();
		
		reloadList();
	});
	
	// 更新jQGrid的列表显示
	reloadList = function() {
		
		var postData = { };
		if (userid != "") postData.id = userid;
		if (username != "") postData.username = username;
		if (sex != "") postData.sex = sex;
		if (mobible != "") postData.mobible = mobible;
		if (status != "") postData.status = status;
		if (startAge != "") postData.startAge = startAge;
		if (endAge != "") postData.endAge = endAge;
		
		$("table#userinfoGrid").jqGrid("clearGridData").jqGrid('setGridParam', {
			page: 1,
			search: true,
			datatype: "json",
			postData : postData
		}, true).trigger("reloadGrid", {fromServer: true});
	}

	// 激活、冻结、详情
	$(".list-box a.list-link").on("click", function(e) {
		var url = $(this).attr("href");
		// 激活、冻结
		if(/user\/(active)|(frozen)$/.test(url)) {
			$.post(rootAddress+url,{id:selectRow_id},function(result){
            	if(result.status=="OK"){
					reloadList(); 
				}
				setMessage(result.message, 5000);
				
				selectRow_id_tmp = selectRow_id =null;
            });
            
        //  详情
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

		e.preventDefault();
	});
});
