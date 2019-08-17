/**
 * @date 2019年8月18日00:25:02
 * @author YiChen(李冠永)
 * @Description 添加用户权限前端控制JS
 */

$(function() {
	
	$("form#userAddFunction").attr("action", rootAddress+$("form#userAddFunction").attr("action"));
	$("form#userAddFunction input[name='id']").val(curr_id);
	$.getJSON(rootAddress+"function/list", function(data) {
		
		var addSelect = $("form#userAddFunction select[name='funNo']");
		$.each(data.list, function(index, func) {
			addSelect.append('<option value="'+func.no+'">'+func.name+'</option>');
		});
	});
	
	$("form#userAddFunction").ajaxForm((rs) => {
		alert("afaf");
		if ( rs.status == "OK" ) {
			if ( typeof reloadFunctionList != "undefined" ) reloadFunctionList();
			closeDialog(addDialogArea);
		}
		jqueryEject.Etoast(rs.message,1);
	});
});
