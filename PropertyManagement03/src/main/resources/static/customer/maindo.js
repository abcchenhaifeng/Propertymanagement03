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
	//设置系统页面标题
	$("span#maintille").html("&emsp;客户信息管理");
	//设置日期的格式和选择
	
	//显示员工列表
	$("table#CustomerGrid").jqGrid({
		url: host+'customer/list/condition/page',
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
//	$("table#CustomerGrid label").attr("text-align","center");
//	//取得部门列表，填充部门下拉框
//	$.getJSON(host+"department/list/all",function(departmentList){
//		if(departmentList){
//			$.each(departmentList,function(index,dm){
//				$("select#DepartmentSelection").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
//			});
//		}
//	});
//	//取得类型列表，填充类型下拉框
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
	
//	//定义部门下拉框的更新事件的处理
//	$("select#DepartmentSelection").off().on("change",function(){
//		departmentNo=$("select#DepartmentSelection").val();
//		reloadCustomerList();
//	});
//	
	//定义类型单选按钮更改事件
//	$("input[name='typeno']").off().on("change",function(){
//		typeno=$("input[name='typeno']:checked").val();
//		reloadCustomerList();
//	});
	
	//点击检索事件处理
	$("a#CustomerSearchButton").on("click",function(){
		//departmentNo=$("select#DepartmentSelection").val();
		typeno=$("select#typeno").val();
		//alert(typeno);
		CustomerName=$("input[name='CustomerName']").val();
		//typeno=$("input[name='typeno']:checked").val();
		feeStartDate=$("input#feeStartDate").val();
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
	/*$("a#CustomerAddLink").off().on("click",function(){
		$("div#CustomerDialog").load("Customer/add.html",function(){
			//取得部门列表，并填充部门下拉框
			
			//取得角色列表，生成角色选择下拉框
			
			//验证员工提交数据
			$("form#CustomerAddForm").validate({
				  rules: {
				    id: {
				      required: true,
				      remote: host+"Customer/checkidexist"
				      
				    },
				    name:{
				    	required: true
				    },
				    age:{
				    	number: true,
				    	min:18,
				    	max:60,
				    	range: [18, 60]
				    },
				    mail:{
				    	required:true,
				    	email: true
				    },
				    mobile:{
				    	required:true,
				    	mobile:true
				    	
				    }
				  },
				  messages:{
					id: {
					      required: "账号为空",
					      remote:"账号已经存在"
					    },
					name:{
					    	required:"部门名称为空"
					},
					age:{
						number: "年龄必须是数值",
				    	range:"年龄需要在18和60之间"
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
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#DepartmentDialogArea" ).dialog( "close" );
				$("div#DepartmentDialogArea" ).dialog( "destroy" );
				$("div#DepartmentDialogArea").html("");
				
			});
			
			
			$("div#CustomerDialog").dialog({
				title:"员工增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#CustomerDialog").dialog("close");
				$("div#CustomerDialog").dialog("destroy")
				$("div#CustomerDialog").html("");
			});
			
			
		});
		
	});*/
	
	//===============================修改员工处理===============================================================
	
	
	
	//===============================删除员工处理==============================================================
	
	
	
	//================================查看员工处理=============================================================
//	$("a#CustomerViewLink").off().on("click",function(){
//		if(CustomerId==null){
//			BootstrapDialog.show({
//	            title: '员工操作信息',
//	            message:"请选择要查看的员工",
//	            buttons: [{
//	                label: '确定',
//	                action: function(dialog) {
//	                    dialog.close();
//	                }
//	            }]
//	        });
//		}
//		else{
//			$("div#CustomerDialog").load("Customer/view.html",function(){
//				//取得指定的员工信息
//				$.getJSON(host+"/Customer/get",{id:CustomerId},function(em){
//					if(em){
//						$("span#CustomerId").html(CustomerId);
//						$("span#CustomerName").html(em.name);
//						$("span#CustomerSex").html(em.sex);
//						$("span#departmentName").html(em.department.name);
//						if(em.roles){
//							$.each(em.roles,function(index,roleModel){
//								$("span#roles").append(roleModel.name+"  ");
//							});
//						}
//					}
//				});
//				
//				
//				$("div#CustomerDialog").dialog({
//					title:"员工详细",
//					width:800
//				});
//				//点击取消按钮，管理弹出窗口
//				$("input[value='关闭']").off().on("click",function(){
//					$("div#CustomerDialog").dialog("close");
//					$("div#CustomerDialog").dialog("destroy")
//					$("div#CustomerDialog").html("");
//				});
//				
//				
//			});
//		}
//		
//		
//		
//	});
	
	
	
	
});