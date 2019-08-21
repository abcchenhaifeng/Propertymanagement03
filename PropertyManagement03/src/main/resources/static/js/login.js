/**
 * @date 2019年8月21日 上午8:50:25
 * @author YiChen(李冠永)
 * @Description 登录前端控制JS
 */

$(() => {
	
	$("form#box-form").attr("action", rootAddress+"user/login");
	
	// 忘记密码页面
	$(".login-box-body #forget a").on("click", function(e){
		e.preventDefault();
		
		$("form#box-form").attr("action", rootAddress+"user/forget");
		$(".login-box-body #email").css("display", "block");
		$(".login-box-body #password").css("display", "none");
		$(".login-box-body p#box-header").text("忘记密码");
		$("button[type='submit']").text("提交");
		$(".login-box-body #forget").css("display", "none");
		$(".login-box-body #login").css("display", "block");
		$(".login-box-body #box-msg").css("display", "none");
	});
	
	// 返回登录页面
	$(".login-box-body #login a").on("click", function(e){
		e.preventDefault();
		
		$("form#box-form").attr("action", rootAddress+"user/login");
		$(".login-box-body #email").css("display", "none");
		$(".login-box-body #password").css("display", "block");
		$(".login-box-body p#box-header").text("登录");
		$("button[type='submit']").text("登录");
		$(".login-box-body #forget").css("display", "block");
		$(".login-box-body #login").css("display", "none");
		$(".login-box-body #box-msg").css("display", "none");
	});
	
	var method = null;
	$("button[type='submit']").on("click", function(e){
		$(".login-box-body #box-msg a").text("处理中...");
					$(".login-box-body #box-msg").css("display", "block");
		method = $(this).text();
		$(this).attr("disabled", "disabled");
	});
	
	// 登录、忘记密码
	$("form#box-form").ajaxForm({
		success: (rs) => {
			if ( rs.status == "OK" ) {
				$("button[type='submit']").removeAttr("disabled");
				if (method == "登录") {
					sessionStorage.setItem('u-key', rs.message);
					location.href = "index.html";
				} else {
					$(".login-box-body #box-msg a").text("提交成功, 请查看邮箱");
					$(".login-box-body #box-msg").css("display", "block");
					$(".login-box-body #login a").click();
				}
			}
		},
		error: (rs) => {
			$("button[type='submit']").removeAttr("disabled");
			if (method == "登录") {
				$(".login-box-body #box-msg a").text("账号或密码错误");
			} else {
				$(".login-box-body #box-msg a").text("邮箱错误");
			}
			$(".login-box-body #box-msg").css("display", "block");
		}
	});
});