/**
 * @date 2019年8月18日00:25:02
 * @author YiChen(李冠永)
 * @Description 添加用户权限前端控制JS
 */

$(function() {
	
	var funcList = null;
	var addSelect = null;
	
	$("form#userAddFunction").attr("action", rootAddress+$("form#userAddFunction").attr("action"));
	$("form#userAddFunction input[name='id']").val(curr_id);
	$.getJSON(rootAddress+"function/list/not/user", {userid: curr_id}, function(data) {
		funcList = data.list;
		
		addSelect = $("form#userAddFunction select[name='funNo']");
		$.each(data.list, function(index, func) {
			addSelect.append('<option value="'+func.no+'">'+func.name+'</option>');
		});
	});
	
	$("form#userAddFunction").ajaxForm({
		success: (rs) => {
			if ( rs.status == "OK" ) {
				var funcObj = funcList[addSelect.prop("selectedIndex")];
				$("table#userFunctionDetailsGrid").jqGrid("addRowData", funcObj.no, funcObj);
				closeDialog(addDialogArea);
			}
			jqueryEject.Etoast(rs.message,1);
		},
		error: (rs) => {
			jqueryEject.Etoast("添加失败,已拥有该权限",1);
		}
	});
});
