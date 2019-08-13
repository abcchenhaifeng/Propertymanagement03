
$(function(){
	//var remote="http://localhost:8080/";
	var remote="http://localhost/";
	var rows=2;
	var page=2;
	var pageCount=0;
	var CustomerNo=0; //选择的客户编号
	
	//嵌入列表页面
	function getListInfo(){
		//设置系统页面标题
		$("span#mainpagetille").html("客户信息管理");
		//取得客户列表，分页模式
		
		//调用后台取得客户列表REST API
		$.getJSON(remote+"customer/list/all/page",{rows:rows,page:page},function(data){
			//显示个数和页数
			$("span#count").html(data.count);
			$("span#pagecount").html(data.page+"/"+data.pageCount);
			pageCount=data.pageCount;
			//显示列表
			$("table#CustomerTable tbody").html("");
			for(var i=0;i<data.list.length;i++){
				var tr="<tr id='"+data.list[i].no+"'>" +
				        "<td>"+data.list[i].customerNo+"</td>" +
				        "<td>"+data.list[i].ctypeno.typeno+"</td>" +
						"<td>"+data.list[i].cname+"</td>" +
						"<td>"+data.list[i].contact+"</td>" +
						"<td>"+data.list[i].mobile+"</td>" +
						"<td>"+data.list[i].feeStartDate+"</td>" +
						"<td>"+data.list[i].feeEndDate+"</td>" +
						"<td>"+data.list[i].cstatus+"</td>" +
				        "</td></tr>";
				$("table#CustomerTable tbody").append(tr);
			}
			//定义表格行的点击时间，取得选择的客户编号
			$("table#CustomerTable tbody tr").on("click",function(){
				CustomerNo=$(this).attr("id");
				$("table#CustomerTable tbody tr").css("background-color","#FFFFFF");
				$(this).css("background-color","#CDCD9A");
			});
	 });
		
	}	
	//定义分页导航链接处理事件
	$("div#page_nav a").on("click",function(event){
			  var action=$(this).attr("href");
			  event.preventDefault();
			  switch(action){
			  	case "top":
			  		page=1;
			  		getListInfo();
			  		break;
			  	case "pre":
			  		if(page>1){
			  			page=page-1;
			  			getListInfo();
			  		}
			  		break;
			  	case "next":
			  		if(page<pageCount){
			  			page=page+1;
			  			getListInfo();
			  		}
			  		break;
			  	case "last":
			  		page=pageCount;
			  		getListInfo();
			  		break;
			  }
		
	});
	
	//初始调用取得分页列表数据
	getListInfo();

	//点击增加链接处理，嵌入add.html
	$("a#CustomerAddLink").off().on("click",function(event){
				
		$("div#CustomerDialogArea").load("customer/add.html",function(){
			$("div#CustomerDialogArea" ).dialog({
				title:"增加部门",
				width:600
			});
			
			$("form#CustomerAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					getListInfo(); 
				}
				//alert(result.message);
				//BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '部门操作信息',
		            message:result.message
		        });
				$("div#CustomerDialogArea" ).dialog( "close" );
				$("div#CustomerDialogArea" ).dialog( "destroy" );
				$("div#CustomerDialogArea").html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#CustomerDialogArea" ).dialog( "close" );
				$( "div#CustomerDialogArea" ).dialog( "destroy" );
				$("div#CustomerDialogArea").html("");
			});
		});
		
	});
	/*
	//点击修改按钮事件处理
	$("a#DepartmentModifyLink").off().on("click",function(event){
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要修改的部门"
	        });
		}
		else {
			$("div#DepartmentDialogArea").load("department/modify.html",function(){
				//取得选择的部门
				$.getJSON("department/get",{no:departmentNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(departmentNo);
						$("input[name='code']").val(data.model.code);
						$("input[name='name']").val(data.model.name);
						
					}
				});
				
				$("div#DepartmentDialogArea" ).dialog({
					title:"部门修改",
					width:600
				});
				//拦截表单提交
				$("form#DepartmentModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						getListInfo(); 
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
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$( "div#DepartmentDialogArea" ).dialog( "close" );
					$( "div#DepartmentDialogArea" ).dialog( "destroy" );
					$("div#DepartmentDialogArea").html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#DepartmentDelteLink").off().on("click",function(event){
		
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要删除的部门"
	        });
		}
		else {
			//先检查此部门能否被删除
			$.getJSON("department/checkDelete",{no:departmentNo},function(data){
				if(data.status!="OK"){
					BootstrapDialog.show({
			            title: '部门操作信息',
			            message:data.message
			        });
				}
				else{
					BootstrapDialog.confirm('确认删除此部门么?', function(result){
			            if(result) {
			                $.post("department/delete",{no:departmentNo},function(result){
			                	if(result.status=="OK"){
									getListInfo(); 
								}
								BootstrapDialog.show({
						            title: '部门操作信息',
						            message:result.message
						        });
			                });
			            }
			        });
				}
			});
			
		}
		
	});
	//点击查看详细按钮事件处理
	$("a#DepartmentViewLink").off().on("click",function(event){
		
		if(departmentNo==0){
			BootstrapDialog.show({
	            title: '部门操作信息',
	            message:"请选择要查看的部门"
	        });
		}
		else{
			$("div#DepartmentDialogArea").load("department/view.html",function(){
				//取得选择的部门
				$.getJSON("department/get",{no:departmentNo},function(data){
					if(data.status=="OK"){
						$("span#departmentCode").html(data.model.code);
						$("span#departmentName").html(data.model.name);
						
					}
				});
				//弹出Dialog
				$("div#DepartmentDialogArea" ).dialog({
					title:"部门详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#DepartmentDialogArea" ).dialog( "close" );
					$( "div#DepartmentDialogArea" ).dialog( "destroy" );
					$("div#DepartmentDialogArea").html("");
				});
			});
			
		}
	});
	*/
});