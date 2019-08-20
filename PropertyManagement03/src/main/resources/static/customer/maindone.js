/**
 * 李海宏
 * @returns
 */
$(function(){
	var areanname=null;
	var departmentcode=null;
	var roomno=null;
	var livedate=null;
	var roomstatus=null;
	var chstatus=null;
	var host="http://localhost:8080/";
	var CustomerId= null;
	//设置系统页面标题
	$("span#maintille").html("&emsp;迁入迁出信息管理");
	$.jgrid.defaults.styleUI="Bootstrap";
	//显示客户列表
	$("table#CustomerGrid").jqGrid({
		//url: host+'customer/list/allwithFK/page',
		url: host+'customer/list/conditionwithFk/page',
		datatype: "json",
		colModel: [
			{ label: '业主姓名', name: 'cname', width: 40,align:"center" },
			{ label: '小区名称', name: 'customerhome.roomno.building.area.name', width: 60,align:"center" },
			{ label: '小区位置', name: 'customerhome.roomno.building.area.address', width: 60,align:"center" },
			{ label: '楼栋号', name: 'customerhome.roomno.departmentcode', width: 40,align:"center" },
			{ label: '房间号', name: 'customerhome.roomno.roomno', width: 40,align:"center" },
			{ label: '入住时间', name: 'customerhome.livedate', width: 60,align:"center" },
			{ label: '电话', name: 'mobile', width: 60,align:"center" },
			{ label: '居住人口', name: 'customerhome.humancount', width:45,align:"center" },
			{ label: '入住状态', name: 'customerhome.roomno.roomstatus', width:45,align:"center" },
			{ label: '住宅类型', name: 'customerhome.roomno.roomtype', width:45,align:"center" },
			{ label: '迁居状态', name: 'customerhome.chstatus', width:45,align:"center" },
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
		      id: "customerNo"},
		pager: "#CustomerGridPager",
		multiselect:false,
		onSelectRow:function(cid){
			CustomerId=cid;
		}
		
	});

	//取得楼宇类型列表，填充类型下拉框
	$.getJSON(host+"room/type/all",function(List){
		
		if(List){
			$.each(List,function(index,res){
				$("select#departmentcode").append("<option value='"+res.departmentcode+"'>"+res.departmentcode+"</option>");
			});
		}
	});
	
	//取得入住类型列表，填充类型下拉框
	$.getJSON(host+"room/status/all",function(List){
		
		if(List){
			$.each(List,function(index,res){
				$("select#roomstatus").append("<option value='"+res.roomstatus+"'>"+res.roomstatus+"</option>");
			});
		}
	});
	
	//取得迁居类型列表，填充类型下拉框
	$.getJSON(host+"customerhome/livingstatus",function(List){
		
		if(List){
			$.each(List,function(index,res){
				$("select#chstatus").append("<option value='"+res.chstatus+"'>"+res.chstatus+"</option>");
			});
		}
	});
	

	//设置检索参数，更新jQGrid的列表显示
	function reloadCustomerList()
	{
		$("table#CustomerGrid").jqGrid('setGridParam',{postData:{areanname:areanname,departmentcode:departmentcode,roomno:roomno,livedate:livedate,roomstatus:roomstatus,chstatus:chstatus}}).trigger("reloadGrid");
		
	}
	
	//定义楼宇类型的更新事件的处理
	$("select#departmentcode").off().on("change",function(){
		departmentcode=$("select#departmentcode").val();
		alert(departmentcode);
		reloadCustomerList();
	});
	
	//定义入住类型的更新事件的处理
	$("select#roomstatus").off().on("change",function(){
		roomstatus=$("select#roomstatus").val();
		alert(roomstatus);
		reloadCustomerList();
	});
	
	
	//定义迁居类型的更新事件的处理
	$("select#chstatus").off().on("change",function(){
		chstatus=$("select#chstatus").val();
		alert(chstatus);
		reloadCustomerList();
	});
	
	//定义日期输入更改事件
	$("input#livedate").off().on("change",function(){
		livedate=$("input#livedate").val();
		reloadCustomerList();
	});

	//定义名称输入更改事件
	$("input[name='areanname']").off().on("change",function(){
		areanname=$("input[name='areanname']").val();
		reloadCustomerList();
	});
	
	//定义房号输入更改事件
	$("input[name='roomno']").off().on("change",function(){
		roomno=$("input[name='roomno']").val();
		reloadCustomerList();
	});
	
	
	//点击检索事件处理
	$("a#CustomerSearchButton").on("click",function(){
		
		areanname=$("input[name='areanname']").val();
		departmentcode=$("select#departmentcode").val();
		alert(departmentcode);
		roomno=$("input[name='roomno']").val();
		livedate=$("input#livedate").val();
		roomstatus=$("select#roomstatus").val();
		alert(roomstatus);
		chstatus=$("select#chstatus").val();
		if(livedate==""){
			livedate=null;
		}
		reloadCustomerList();
	});
	//===========================迁入处理================================================
	$("a#CustomerMoveIn").off().on("click",function(){
		$("div#CustomerDialog").load("customer/mainadd.html",function(){
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
			//拦截提交表单
			$("form#CustomerAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadCustomerList();//更新客户列表
				}
				$("div#CustomerDialog").dialog( "close" );
				$("div#CustomerDialog").dialog( "destroy" );
				$("div#CustomerDialog").html("");
				
			});
			$("div#CustomerDialog").dialog({
				title:"迁入客户信息成功",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#CustomerDialog").dialog("close");
				$("div#CustomerDialog").dialog("destroy")
				$("div#CustomerDialog").html("");
			});
			
		});
	});
	
	

	
	
	
	
	
	

	
	
	//===============================修改处理==============================================================
	//点击修改按钮事件处理
	$("a#CustomerModify").off().on("click",function(event){
		
		if(CustomerId==null){
			jqueryEject.Econfirm({
			title: '修改操作',
			message: '请选择要修改的客户',
			define: function() {
				setMessage(message, 5000);
			},
			cancel: function() {}
		});
		}
		else {
			$.getJSON(host+"customerhome/check",{customerno:CustomerId},function(data){
				if(data.status!="OK"){
					$.post(host+"customerhome/movein",{customerno:CustomerId},function(result){
	                	if(result.status=="OK"){
	                		setMessage("迁入成功", 5000);
	                		reloadCustomerList();//更新客户列表
						}	
	                });
				}
				else{
	            	$.post(host+"customerhome/moveout",{customerno:CustomerId},function(result){
	                	if(result.status=="OK"){
	                		setMessage("迁出成功", 5000);
	                		reloadCustomerList();//更新客户列表
						}	
	                });
			    }
			});		
		}         		
	});
});
	
	