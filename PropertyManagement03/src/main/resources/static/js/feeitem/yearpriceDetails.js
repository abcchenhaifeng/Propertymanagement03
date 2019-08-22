/**
 * @date 2019年8月22日23:27:08
 * @author YiChen(李冠永)
 * @Description 收费类型年度价格详情前端控制JS
 */

$(function() {
	
	$("form#yearpriceDetails input[name='feeItem.itemno']").val(curr_id);
	
	// 判断调用的方法
	if ( typeof url_method != 'undefined' && url_method == "add" ) {
		$("form#yearpriceDetails").attr("action", rootAddress+"feeitem/year/price/add");
		$("form#yearpriceDetails button[type='submit']").text("添加");
		
	} else {
		$("form#yearpriceDetails").attr("action", rootAddress+$("form#yearpriceDetails").attr("action"));
		$.getJSON(rootAddress+"feeitem/year/price/get", {itemno : curr_id, feeyear: selectRow_feeyear}, function(data) {
			$("form#yearpriceDetails #no").val(data.model.feeyear);
			$("form#yearpriceDetails #no").attr("readonly", "readonly");
			$("form#yearpriceDetails input[name='unitprice']").val(data.model.unitprice);
			$("form#yearpriceDetails input[name='startdate']").val(data.model.startdate);
			$("form#yearpriceDetails input[name='enddtae']").val(data.model.enddtae);
			$("form#yearpriceDetails textarea[name='pricedesc']").val(data.model.pricedesc);
			
		});
	}
	
	$("form#yearpriceDetails").ajaxForm({
		success: (rs) => {
			if ( rs.status == "OK" ) {
				reloadYearPriceList();
				closeDialog(addDialogArea);
				jqueryEject.Etoast(rs.message,1);
			}
		},
		error: (rs) => {
			jqueryEject.Etoast("操作失败",1);
		}
	});
});
