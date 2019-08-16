/**
 * @date 2019年8月16日09:34:02
 * @author YiChen(李冠永)
 * @Description 修改权限模块前端控制JS
 */

$(function() {
	
	$("form#details").attr("action", rootAddress+$("form#details").attr("action"));
	$.getJSON(rootAddress+"function/get", {no : selectRow_id}, function(data) {
		$("form#details input[name='no']").val(data.model.no);
		$("form#details input[name='name']").val(data.model.name);
		$("form#details input[name='levelno']").val(data.model.levelno);
		
		// 加载类别
		$.getJSON(rootAddress+"module/list", (rs)=>{
			var selected = "";
			$.each(rs.list, (index, module)=>{
				if (module.no == data.model.module.no) selected="selected='selected'";
				$('form#details select#module').append('<option '+selected+' value="'+module.no+'">'+module.name+'</option>');
				selected = "";
			});
			
		});
	});
	
	selectRow_id = null;
	
	$("form#details").ajaxForm((rs) => {
		if ( rs.status == "OK" ) {
			if ( typeof reloadList != "undefined" ) reloadList();
			closeDialog();
			setMessage(rs.message, 5000);
		}
	});
});
