/**
 * @date 2019年8月15日00:19:30
 * @author YiChen(李冠永)
 * @Description 修改系统模块前端控制JS
 */

$(function() {
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#details").attr("action", rootAddress+"module/add");
		$("form#details input[name='no']").parent().remove();
		$("form#details button[type='submit']").text("添加");
	} else {
		$("form#details").attr("action", rootAddress+$("form#details").attr("action"));
		
		$.getJSON(rootAddress+"module/get", {no : selectRow_id}, function(data) {
			$("form#details input[name='no']").val(data.model.no);
			$("form#details input[name='name']").val(data.model.name);
		});
		
		selectRow_id = null;
	}
	
	$("form#details").ajaxForm((rs) => {
		if ( rs.status == "OK" ) {
			if ( typeof reloadList != "undefined" ) reloadList();
			closeDialog();
			setMessage(rs.message, 5000);
		}
	});
});
