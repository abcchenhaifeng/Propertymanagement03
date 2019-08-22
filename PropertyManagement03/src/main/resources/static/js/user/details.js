/**
 * @date 2019年8月11日 下午2:06:48
 * @author YiChen(李冠永)
 * @Description 系统操作员详情前端控制JS
 */

$(function() {
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#details").attr("action", rootAddress+"user/add");
		$("form#details button[type='submit']").text("添加");
	} else {
		$("form#details").attr("action", rootAddress+$("form#details").attr("action"));
		
		var curr_user_id = (url_method == "my_details" ? login_user.id : selectRow_id);
		
		$.getJSON(rootAddress+"user/get", {id : curr_user_id}, function(data) {
			$("form#details input[name='status']").val(data.model.status);
			$("form#details input[name='id']").val(data.model.id);
			$("form#details input[name='id']").attr("readonly", "readonly");
			$("form#details input[name='username']").val(data.model.username);
			$("form#details input[name='password']").val(data.model.password);
			$("form#details select[name='sex'] option[value='"+data.model.sex+"']").attr("selected", "selected"); 
			$("form#details input[name='age']").val(data.model.age);
			$("form#details input[name='mobible']").val(data.model.mobible);
		});
	}
	
	$("form#details").ajaxForm((rs) => {
		if ( rs.status == "OK" ) {
			if ( typeof reloadList != "undefined" ) reloadList();
			closeDialog();
			setMessage(rs.message, 5000);
		}
	});
});
