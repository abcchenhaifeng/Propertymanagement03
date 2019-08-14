/**
 * 李海宏
 * @returns
 */
$(function(){
	var CustomerName=null;
	var feeStartDate=null;
	var feeEndDate=null;
	var typeno=0;
	var host="http://localhost:8080/";
	var CustomerId= null;
	//设置系统页面标题
	$("span#maintille").html("&emsp;客户信息管理");
	
	//显示客户列表
	$("table#CustomerGrid").jqGrid({
		url: host+'customer/list/condition/page',
		//url: host+'customer/list/all/page',
		datatype: "json",
		colModel: [
			{ label: '序号', name: 'customerNo', width: 40,align:"center"},
			{ label: '姓名', name: 'cname', width: 40,align:"center" },
			{ label: '联系人', name: 'contact', width: 40,align:"center" },
			{ label: '类别', name: 'ctypeno.typeno', width: 40,align:"center" },
			{ label: '类型', name: 'ctypeno.typename', width: 40,align:"center" },
			{ label: '电话', name: 'mobile', width: 100,align:"center" },
			{ label: '开始日期', name: 'feeStartDate', width: 100,align:"center"},
			{ label: '截至日期', name: 'feeEndDate', width: 100,align:"center" },
			{ label: '激活状态', name: 'cstatus', width:40,align:"center" }   
		],
		caption:"信息列表",
		viewrecords: true, 
		autowidth: true,
		height: 400,
		rowNum: 20,
		rowList:[10,20,30],
		jsonReader : { 
		      root: "list", 
		      page: "page", 
		      total: "pageCount", 
		      records: "count", 
		      repeatitems: true, 
		      id: "id"},
		pager: "#CustomerGridPager",
		multiselect:false,
		onSelectRow:function(cid){
			CustomerId=cid;
		}
		
	});

	//取得类型列表，填充类型下拉框
	$.getJSON(host+"customertype/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,ctypeno){
				$("select#typeno").append("<option value='"+ctypeno.typeno+"'>"+ctypeno.typename+"</option>");
			});
		}
	});
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadCustomerList()
	{
		$("table#CustomerGrid").jqGrid('setGridParam',{postData:{CustomerName:CustomerName,typeno:typeno,feeStartDate:feeStartDate,feeEndDate:feeEndDate}}).trigger("reloadGrid");
		
	}
	
	//点击检索事件处理
	$("a#CustomerSearchButton").on("click",function(){
		typeno=$("select#typeno").val();
		alert(typeno);
		CustomerName=$("input[name='CustomerName']").val();
		//alert(CustomerName);
		feeStartDate=$("input#feeStartDate").val();
		alert(feeStartDate);
		feeEndDate=$("input#feeEndDate").val();
		if(feeStartDate==""){
			feeStartDate=null;
		}
		if(feeEndDate==""){
			feeEndDate=null;
		}
		reloadCustomerList();
	});
	//===========================增加员工处理================================================
	$("a#CustomerAddLink").off().on("click",function(){
		var dialogArea = null;
		$("div#CustomerDialog").load("customer/mainadd.html",function(){
			//取得客户类型列表，生成客户类型选择下拉框
//			$.getJSON(host+"customertype/list/all",function(typeList){
//				if(typeList){
//					$.each(typeList,function(index,ctypeno){
//						$("div#TypeSelection").append("<input type='checkbox' name='Customertypes' value='"+ctypeno.typeno+"' />"+ctypeno.typename);
//					});
//				}
//			});
			dialogArea=$("div#CustomerDialog");
//			//验证员工提交数据
			$("form#CustomerAddForm").validate({
				  rules: {
				  cname:{
				    	required: true
				        }
				  },
				  messages:{
					cname:{
					      required: "请输入姓名",
					      remote:"该客户信息已经存进"
					    }
				 }
			});
			
			//拦截增加提交表单
			$("form#CustomerAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadCustomerList();//更新员工列表
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '客户操作信息',
		            message:result.message
		        });
				dialogArea.dialog( "close" );
				dialogArea.dialog( "destroy" );
				dialogArea.html("");
				
			});
			$("div#CustomerDialog").dialog({
				title:"客户增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				dialogArea.dialog("close");
				dialogArea.dialog("destroy")
				dialogArea.html("");
			});
			
		});
	});
	
	
	//================================查看员工处理=============================================================
	$("a#CustomerViewLink").off().on("click",function(){
		if(CustomerId==null){
			BootstrapDialog.show({
	            title: '员工操作信息',
	            message:"请选择要查看的员工",
	            buttons: [{
	                label: '确定',
	                action: function(dialog) {
	                    dialog.close();
	                }
	            }]
	        });
		}
		else{
			$("div#CustomerDialog").load("customer/mainview.html",function(){
				//取得指定的员工信息
				$.getJSON(host+"/customer/get",{no:CustomerId},function(em){
					if(em){
						$("span#cname").html(em.cname);
						$("span#contact").html(em.contact);
						$("span#cardcode").html(em.cardcode);
						$("span#mobile").html(em.mobile);
						$("span#feeStartDate").html(em.feeStartDate);
						$("span#feeEndDate").html(em.feeEndDate);
						$("span#cstatus").html(em.cstatus);
	
					}
				});
				
				
				$("div#CustomerDialog").dialog({
					title:"客户详细",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#CustomerDialog").dialog("close");
					$("div#CustomerDialog").dialog("destroy")
					$("div#CustomerDialog").html("");
				});
				
				
			});
		}
		
		
		
	});
	
});
	
	