/**
 * @date 2019年8月9日 下午2:17:56
 * @author YiChen(李冠永)
 * @Description 首页前端控制JS
 */

// .menu_column a.link中的method属性
var url_method = null;

// ajax请求的根地址
var rootAddress = "http://localhost/";

// 登录的用户
var login_user = {
	id : "yichen",
	name : ""
};

$(() => {

	$(".menu_column a.link").on("click", function(e) {
		url_method = $(this).attr("method");
		var url = $(this).attr("href");
		if(/(list)|(main).html$/.test(url)) {
			$("section#main #container").load(url);
		} else {
			$("section#main #dialog").load(url, () => {
				var dialogArea = $("section#main #dialog");
				dialogArea.dialog({
					title: $(this).attr("title"),
					width: "80%",
					close: function(event, ui) {
						dialogArea.dialog("destroy");
						dialogArea.html("");
					}
				});
			});
		}

		e.preventDefault();
	});
});

let default_alert_info;
$(function() {

	default_alert_info = $("#alert_info").text();

	$(".footer #date_year").text(new Date().getFullYear());

	setMessage("今天是： " + new Date().toLocaleDateString(), 5000);

	$(".tablesorter").tablesorter();
	$('.column').equalHeight();

	// When page loads...
	$(".tab_content").hide(); // Hide all content
	$("ul.tabs li:first").addClass("active").show(); // Activate first tab
	$(".tab_content:first").show(); // Show first tab content

	// On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); // Remove any "active" class
		$(this).addClass("active"); // Add "active" class to selected tab
		$(".tab_content").hide(); // Hide all tab content

		var activeTab = $(this).find("a").attr("href"); // Find the href
		// attribute value to
		// identify the active
		// tab + content
		$(activeTab).fadeIn(); // Fade in the active ID content
		return false;
	});

});

function closeDialog() {
	var dialogArea = $("section#main #dialog");
	dialogArea.dialog("destroy");
	dialogArea.html("");
}

function setMessage(text, timeout, flag) {
	showMessage($("#alert_info"), text, timeout, flag);
}

function showMessage(e, text, timeout, flag) {

	if(flag || sessionStorage.getItem(e) === '' ||
		sessionStorage.getItem(e) === null) {

		if(flag)
			sessionStorage.setItem(e, text);

		$(e).stop().fadeTo(200, 0).html(text).fadeTo(200, 1);
		if(timeout === null)
			timeout = 5000;
		defaultMessage(e, timeout);
	}
}

function defaultMessage(e, timeout) {
	if(timeout === null)
		timeout = 5000;
	window.setTimeout(function() {
		sessionStorage.removeItem(e)
		$(e).stop().fadeTo(200, 0).html(default_alert_info).fadeTo(200, 1);
	}, timeout);
}