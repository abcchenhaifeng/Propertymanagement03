/**
 * @date: 2019年8月16日15:45:13
 * @author: YiChen(李冠永)
 * @Description: 系统功能前端控制JS
 */

var addDialogArea = null;
var selectRow_feeyear = null;
var reloadYearPriceList = null;
var curr_id = selectRow_id;
$(function() {
	var feeyear = "";
	var unitprice = "";
	var startdate = "";
	var enddtae = "";
	
	setBreadcrumbs(["收费管理","基本收费项目设置","收费项目列表","年度价格"]);
	setMessage("年度价格", 5000);

	var postData =  { };
	postData["feeItem.itemno"] = curr_id;

	// 显示列表
	$.jgrid.defaults.styleUI = 'Bootstrap';
	$("table#feeyearGrid").jqGrid({
		url: rootAddress+'feeitem/year/price/list/page',
		postData : postData,
		datatype: "json",
		colModel: [
			{ label: '收费年度', name: 'feeyear' },
			{ label: '单    价', name: 'unitprice' },
			{ label: '开始日期', name: 'startdate' },
			{ label: '结束日期', name: 'enddtae' },
			{ label: '价格描述', name: 'pricedesc' }
		],
		viewrecords: true, 
		autowidth: true,
		height: 365,
		rowNum: 10,
		rowList:[10,20,30],
		loadonce: true,
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "feeyear"
		},
		pager: "#feeyearGridPager",
		multiselect:false,
		onSelectRow:function(id){
			selectRow_feeyear = id;
		}
	});
	
	// 加载类别
	$.getJSON(rootAddress+"module/list", (rs)=>{
		$.each(rs.list, (index, module)=>{
			$('select#module').append('<option value="'+module.no+'">'+module.name+'</option>');
		});
	});
	
	// 点击检索事件处理
	$("button#DetailsSearchButton").on("click", function() {
		feeyear = $("input#feeyear").val();
		unitprice = $("input#unitprice").val();
		startdate = $("input#startdate").val();
		enddtae = $("input#enddtae").val();
		
		reloadYearPriceList();
	});
	
	// 更新jQGrid的列表显示
	reloadYearPriceList = function () {
		
		postData = { };
		postData["feeItem.itemno"] = curr_id;
		if (feeyear != "") postData.feeyear = feeyear;
		if (unitprice != "") postData.unitprice = unitprice;
		if (startdate != "") postData.startdate = startdate;
		if (enddtae != "") postData.enddtae = enddtae;
		
		$("table#feeyearGrid").jqGrid('clearGridData').jqGrid('setGridParam', {
			datatype: "json",
			page: 1,
			postData : postData
		}, true).trigger("reloadGrid");
	}
	
	// 添加、详情、删除
	$(".yearprice-list-box a.list-link").on("click", function(e) {
		e.preventDefault();
		var url = $(this).attr("href");
		url_method = $(this).attr("method");
		
		// 添加
		if ( /yearpriceDetails.html/.test(url) ) {
			
			$(".yearprice-list-box #feeyear-add-dialog").load(url, () => {

				addDialogArea = $(".yearprice-list-box #feeyear-add-dialog");
				addDialogArea.dialog({
					title: $(this).attr("title"),
					modal: true,
					width: "80%",
					maxWidth: "845px",
					close: function(event, ui) {
						doSomethingWhenDialogClose();
						addDialogArea.dialog("destroy");
						addDialogArea.html("");
						doSomethingWhenDialogClose = function () {};
					}
				});
			});
			
		// 删除
		} else {
			if ( selectRow_feeyear == null ) {
				jqueryEject.Etoast('请选择一个功能',1);
			} else {
				jqueryEject.Econfirm({
					title: '删除',
					message: '确认删除此项目么?',
					define: function() {
						$.post(rootAddress+"feeitem/year/price/delete", {itemno: curr_id, feeyear: selectRow_feeyear}, (rs)=>{
							$("table#feeyearGrid").jqGrid("delRowData", selectRow_feeyear);
							jqueryEject.Etoast(rs.message,1);
							selectRow_feeyear = null
						}).fail(function() {
						    jqueryEject.Etoast("删除失败",1);
						});
					},
					cancel: function() {}
				});
			}
		}
	});
});
