/**
 * @date 2019年8月21日 上午8:50:25
 * @author YiChen(李冠永)
 * @Description 登录前端控制JS
 */

$(() => {
	
	// 忘记密码页面
	$(".login-box-body #forget a").on("click", function(e){
		e.preventDefault();
		
		$(".login-box-body #email").css("display", "block");
		$(".login-box-body #password").css("display", "none");
		$(".login-box-body p#box-header").text("忘记密码");
		$("button[type='submit']").text("提交");
		$(".login-box-body #forget").css("display", "none");
		$(".login-box-body #login").css("display", "block");
	});
	
	// 返回登录页面
	$(".login-box-body #login a").on("click", function(e){
		e.preventDefault();
		
		$(".login-box-body #email").css("display", "none");
		$(".login-box-body #password").css("display", "block");
		$(".login-box-body p#box-header").text("登录");
		$("button[type='submit']").text("登录");
		$(".login-box-body #forget").css("display", "block");
		$(".login-box-body #login").css("display", "none");
	});
	
	var method = null;
	$("button[type='submit']").on("click", function(e){
		method = $(this).text();
		alert(method);
	});
	
	// 登录、忘记密码
	$("form#box-form").ajaxForm({
		success: (rs) => {
			if ( rs.status == "OK" ) {
				if (method == "登录") {
					sessionStorage.setItem('u-key', rs.message);
					location.href = "index.html";
				} else {
					
				}
			}
			jqueryEject.Etoast(rs.message,1);
		},
		error: (rs) => {
			jqueryEject.Etoast("添加失败,已拥有该权限",1);
		}
	});
});