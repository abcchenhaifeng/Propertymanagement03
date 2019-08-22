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
		$("input[type='submit']").val("提交");
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
		$("input[type='submit']").val("登录");
		$(".login-box-body #forget").css("display", "block");
		$(".login-box-body #login").css("display", "none");
		$(".login-box-body #box-msg").css("display", "none");
	});
	
	var method = null;
	var url = "";
	$("input[type='submit']").on("click", function(e){
		$(".login-box-body #box-msg a").text("处理中...");
					$(".login-box-body #box-msg").css("display", "block");
		method = $(this).val();
		url = $("form#box-form").attr("action")+"?"+new Date().getTime();
		$(this).css({
			"pointer-events":"none",
			"opacity":".6",
		});
		
		// 登录、忘记密码
		$("form#box-form").ajaxForm({
			url: url,
			success: function(rs) {
				if ( rs.status == "OK" ) {
					$("input[type='submit']").css({
						"pointer-events":"",
						"opacity":"",
					});
					if (method == "登录") {
						sessionStorage.setItem('u-key', rs.message);
						sessionStorage.setItem('user', JSON.stringify(rs.model));
						location.href = "index.html";
					} else {
						$(".login-box-body #login a").click();
						$(".login-box-body #box-msg a").text("提交成功, 请查看邮箱");
						$(".login-box-body #box-msg").css("display", "block");
					}
				}
			},
			error: function(rs) {
				$("input[type='submit']").css({
						"pointer-events":"",
						"opacity":"",
					});
				if (method == "登录") {
					$(".login-box-body #box-msg a").text("账号或密码错误");
				} else {
					$(".login-box-body #box-msg a").text("邮箱错误");
				}
				$(".login-box-body #box-msg").css("display", "block");
			}
		});
	});
});