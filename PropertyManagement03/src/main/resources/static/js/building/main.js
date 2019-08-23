/**
 * 李海宏
 * @returns
 */
$(function(){
	var areano=0;
	var baddress=null;
	var buildingtypeno=0;
	var minhouse=0;
	var maxhouse=0;
	var host="http://localhost:8080/";
	var buildingno= null;
	//设置系统页面标题
	$("span#maintille").html("&emsp;楼宇信息管理");
	$.jgrid.defaults.styleUI="Bootstrap";
	//显示客户列表
	$("table#BuildingGrid").jqGrid({
		url: host+'building/list/condition/page',
		//url: host+'building/list/all/withareaandbuildtype',
		datatype: "json",
		colModel: [
			{ label: '楼号', name: 'no', width: 40,align:"center" },
			{ label: '小区号', name: 'area.no', width: 40,align:"center" },
			{ label: '楼宇地址', name: 'address', width: 80,align:"center" },
			{ label: '建筑物类型编号', name: 'buildingtype.typeno', width: 100,align:"center" },
			{ label: '楼宇朝向', name: 'direction', width: 100,align:"center"},
			{ label: '居民数', name: 'home', width: 100,align:"center" },
			{ label: '公建数', name: 'house', width:40,align:"center" }   
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
		      id: "no"},
		pager: "#BuildingGridPager",
		multiselect:false,
		onSelectRow:function(bno){
			buildingno=bno;
		}
		
	});

	//取得小区类型列表，填充类型下拉框
	$.getJSON(host+"area/list/all",function(atypeList){
		if(atypeList){
			$.each(atypeList,function(index,atypeno){
				$("select#AreaSelection").append("<option value='"+atypeno.no+"'>"+atypeno.no+"."+atypeno.name+"</option>");
			});
		}
	});
	
	//取得楼宇地址类型列表，填充类型下拉框
	$.getJSON(host+"building/list/all/withareaandbuildtype",function(btypeList){
		if(btypeList){
			$.each(btypeList,function(index,btypeno){
				$("select#BuildingSelection").append("<option value='"+btypeno.address+"'>"+btypeno.address+"</option>");
			});
		}
	});
	
	//取得楼宇编号列表，填充类型下拉框
	$.getJSON(host+"building/list/all/withareaandbuildtype",function(btypeList){
		if(btypeList){
			$.each(btypeList,function(index,btypeno){
				$("select#BuildingNoSelection").append("<option value='"+btypeno.no+"'>"+btypeno.no+"</option>");
			});
		}
	});
	
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadBuildingList()
	{
		$("table#BuildingGrid").jqGrid('setGridParam',{postData:{areano:areano,baddress:baddress,buildingtypeno:buildingtypeno,minhouse:minhouse,maxhouse:maxhouse}}).trigger("reloadGrid");
		
	}
	
//	//定义类型的更新事件的处理
//	$("select#typeno").off().on("change",function(){
//		typeno=$("select#typeno").val();
//		
//		CustomerName=$("input[name='CustomerName']").val();
//		
//		feeStartDate=$("input#feeStartDate").val();
//
//		feeEndDate=$("input#feeEndDate").val();
//		
//		if(CustomerName==""){
//			CustomerName=null;
//		}
//		
//		if(feeStartDate==""){
//			feeStartDate=null;
//		}
//		if(feeEndDate==""){
//			feeEndDate=null;
//		}
//		reloadCustomerList();
//	});
//	
	//定义小区类型输入更改事件
	$("select#AreaSelection").off().on("change",function(){
		areano=$("select#AreaSelection").val();
		reloadBuildingList();
	});

	//定义楼宇地址类型输入更改事件
	$("select#BuildingSelection").off().on("change",function(){
		baddress=$("select#BuildingSelection").val();
		reloadBuildingList();
	});

	//定义楼宇编号类型输入更改事件
	$("select#BuildingNoSelection").off().on("change",function(){
		buildingtypeno=$("select#BuildingNoSelection").val();
		reloadBuildingList();
	});
	
	//点击检索事件处理
	$("a#BuildingSearchButton").on("click",function(){
		
		areano=$("select#AreaSelection").val();
		buildingtypeno=$("select#BuildingNoSelection").val();
		baddress=$("select#BuildingSelection").val();
		feeEndDate=$("input#feeEndDate").val();
		minhouse=$("input#minhouse").val();
		maxhouse=$("input#maxhouse").val();
		reloadBuildingList();
		
	});


//	//===========================增加员工处理================================================
//	$("a#CustomerAddLink").off().on("click",function(){
//		$("div#CustomerDialog").load("customer/add.html",function(){
//			//验证员工提交数据
//			$("form#CustomerAddForm").validate({
//				  rules: {
//				  cname:{
//				    	required: true,
//				    	remote: host+"customer/checkidexist"
//				        },
//				  contact:{
//					  required:true,
//				          },
//				  mobile:{
//				    	required:true,
//				    	mobile:true			    	
//				         },
//				  cardcode:{
//					  required:true,
//					  card:true
//				            },
//				  feeStartDate:{
//					  required:true,
//				                },
//				  feeEndDate:{
//					  required:true, 
//				             },
//				  cstatus:{
//					  required:true,
//				          }       
//				  },
//				  
//				  messages:{
//					cname:{
//					      required: "请输入姓名",
//					      remote:"该客户信息已经存进"
//					    },
//					    contact:{
//					       required: "请输入联系人姓名"		   
//					    },	    
//						
//						cardcode:{
//							required: "请输入身份证号码"  
//			            },
//			            feeStartDate:{
//			            	required: "请输入收费开始日期"    
//		                },
//						feeEndDate:{
//							required: "请输入收费截止日期"  	  
//						},
//						cstatus:{
//							required: "请输入当前客户状态"    
//						} 
//				 }
//				  
//			});
//			
//			//拦截增加提交表单
//			$("form#CustomerAddForm").ajaxForm(function(result){
//				if(result.status=="OK"){
//					reloadCustomerList();//更新员工列表
//				}
//				$("div#CustomerDialog").dialog( "close" );
//				$("div#CustomerDialog").dialog( "destroy" );
//				$("div#CustomerDialog").html("");
//				
//			});
//			$("div#CustomerDialog").dialog({
//				title:"客户增加",
//				width:950
//			});
//			//点击取消按钮，管理弹出窗口
//			$("input[value='取消']").off().on("click",function(){
//				$("div#CustomerDialog").dialog("close");
//				$("div#CustomerDialog").dialog("destroy")
//				$("div#CustomerDialog").html("");
//			});
//			
//		});
//	});
//	
//	
//	//================================查看员工处理=============================================================
//	$("a#CustomerViewLink").off().on("click",function(){
//		if(CustomerId==null){
//			jqueryEject.Econfirm({
//				title: '客户信息',
//				message: '请选择要查看的客户',
//				define: function() {
//					setMessage(message, 5000);
//				},
//				cancel: function() {}
//			});			
//		}
//		else{
//			$("div#CustomerDialog").load("customer/view.html",function(){
//				//取得指定的员工信息
//				$.getJSON(host+"/customer/get",{no:CustomerId},function(em){
//					setMessage("查看详细", 5000);
//					if(em){
//						$("input#id").val(em.customerNo);
//						$("input#cname").val(em.cname);
//						$("input#contact").val(em.contact);
//						$("input#cardcode").val(em.cardcode);
//						$("input#mobile").val(em.mobile);
//						$("input#feeStartDate").val(em.feeStartDate);
//						$("input#feeEndDate").val(em.feeEndDate);
//						$("input#cstatus").val(em.cstatus);
//	
//					}
//				});
//				
//				
//				$("div#CustomerDialog").dialog({
//					title:"客户详细",
//					width:800
//				});
//				//点击取消按钮，管理弹出窗口
//				$("input[value='关闭']").off().on("click",function(){
//					$("div#CustomerDialog").dialog("close");
//					$("div#CustomerDialog").dialog("destroy")
//					$("div#CustomerDialog").html("");
//				});
//			});
//		}
//	});
//	//===============================修改员工处理===============================================================
//	$("a#CustomerModifyLink").off().on("click",function(){
//		if(CustomerId==null){	
//			jqueryEject.Econfirm({
//				title: '客户信息',
//				message: '请选择要修改的客户',
//				define: function() {
//				setMessage(message, 5000);
//				},
//				cancel: function() {}
//			});
//		}
//		else{
//			$("div#CustomerDialog").load("customer/modify.html",function(){
//				//取得指定的员工信息
//				$.getJSON(host+"/customer/get",{no:CustomerId},function(em){
//					if(em){
//						
//						$("input[name='customertype.typeno']").val(em.customertype.typeno);
//						$("input[name='cname']").val(em.cname);
//						$("input[name='contact']").val(em.contact);
//						$("input[name='cardcode']").val(em.cardcode);
//						$("input[name='mobile']").val(em.mobile);
//						$("input[name='feeStartDate']").val(em.feeStartDate);
//						$("input[name='feeEndDate']").val(em.feeEndDate);
//						$("select[name='cstatus']").val(em.cstatus);
//						$("input[name='customerNo']").val(CustomerId);
//	
//					}
//				});
//				//拦截修改提交表单
//				$("form#CustomerModifyForm").ajaxForm(function(result){
//					if(result.status=="OK"){
//						setMessage("添加成功", 5000);
//						reloadCustomerList();//更新客户列表
//					}
//					
//					$("div#CustomerDialog").dialog( "close" );
//					$("div#CustomerDialog").dialog( "destroy" );
//					$("div#CustomerDialog").html("");
//					
//				});
//				$("div#CustomerDialog").dialog({
//					title:"客户修改",
//					width:800
//				});
//				//点击取消按钮，管理弹出窗口
//				$("input[value='取消']").off().on("click",function(){
//					$("div#CustomerDialog").dialog("close");
//					$("div#CustomerDialog").dialog("destroy")
//					$("div#CustomerDialog").html("");
//				});
//				
//				
//			});
//		}
//	});	
//	
//	//===============================删除员工处理==============================================================
//	//点击删除按钮事件处理
//	$("a#CustomerDeleteLink").off().on("click",function(event){
//		
//		if(CustomerId==null){
//			jqueryEject.Econfirm({
//			title: '删除',
//			message: '请选择要删除的客户',
//			define: function() {
//				setMessage(message, 5000);
//			},
//			cancel: function() {}
//		});
//		}
//		else {
//                $.post(host+"customer/delete",{customerNo:CustomerId},function(result){
//                	if(result.status=="OK"){
//                		setMessage("删除成功", 5000);
//                		reloadCustomerList();//更新客户列表
//					}
//					
//                });
//		}
//		
//	});
});
	
	