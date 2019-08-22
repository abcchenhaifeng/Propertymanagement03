/**
 * @date 2019年8月11日 下午2:06:48
 * @author YiChen(李冠永)
 * @Description 收费类型详情前端控制JS
 */

$(function() {
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#details").attr("action", rootAddress+"feeitem/add");
		$("form#details #no-box").css("display", "none");
		$("form#details #no").removeAttr("name");
		$("form#details button[type='submit']").text("添加");
	} else {
		$("form#details").attr("action", rootAddress+$("form#details").attr("action"));
		$("form#details #no").prop("name", "typeno");
		$("form#details #no-box").css("display", "");
		$.getJSON(rootAddress+"feeitem/get", {no : selectRow_id}, function(data) {
			$("form#details #no").val(data.model.itemno);
			$("form#details #no").attr("readonly", "readonly");
			$("form#details input[name='itemcode']").val(data.model.itemcode);
			$("form#details input[name='itemname']").val(data.model.itemname);
			$("form#details select[name='feepaymethod']").val(data.model.feepaymethod);
			$("form#details select[name='feecycle']").val(data.model.feecycle);
			$("form#details select[name='itemstatus']").val(data.model.itemstatus);
			$("form#details select[name='itemunit']").val(data.model.itemunit);
			$("form#details textarea[name='itemdesc']").val(data.model.itemdesc);
			
			// 加载收费类型
			$.getJSON(rootAddress+"feetype/list", function(rs){
				var selected = null;
				$.each(rs.list, (index, module)=>{
					$("select[name='feetype.typeno']").append('<option value="'+module.typeno+'">'+module.typename+'</option>');
				});
				
				$("form#details select[name='feetype.typeno']").val(data.model.typename);
			});
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
