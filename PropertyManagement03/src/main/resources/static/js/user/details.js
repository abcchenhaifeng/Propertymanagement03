/**
 * @date 2019年8月11日 下午2:06:48
 * @author YiChen(李冠永)
 * @Description 系统操作员详情前端控制JS
 */

$(function() {
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#details").attr("action", "user/add");
		$("form#details button[type='submit']").text("添加");
	} else {
		$.getJSON(rootAddress+"user/get", {id : login_user.id}, function(data) {
			$("form#details input[name='status']").val(data.model.status);
		});
	}
	
});
