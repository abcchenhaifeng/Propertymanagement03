/**
 * @date 2019年8月11日 下午2:06:48
 * @author YiChen(李冠永)
 * @Description 收费类型详情前端控制JS
 */

$(function() {
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#details").attr("action", rootAddress+"feetype/add");
		$("form#details #no-box").css("display", "none");
		$("form#details #no").removeAttr("name");
		$("form#details button[type='submit']").text("添加");
	} else {
		$("form#details").attr("action", rootAddress+$("form#details").attr("action"));
		$("form#details #no").prop("name", "typeno");
		$("form#details #no-box").css("display", "");
		$.getJSON(rootAddress+"feetype/get", {no : selectRow_id}, function(data) {
			$("form#details #no").val(data.model.typeno);
			$("form#details #no").attr("readonly", "readonly");
			$("form#details input[name='typename']").val(data.model.typename);
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
