
$(function(){
	var remote="http://localhost:8080/";
	//var remote="http://localhost/";
	var rows=10;
	var page=1;
	var pageCount=0;
	var RoomNo=0; //选择的客户编号
	
	//嵌入列表页面
	function getListInfo(){
		//设置系统页面标题
		$("span#mainpagetille").html("房产管理");
		//取得客户列表，分页模式
		
		//调用后台取得客户列表REST API
		$.getJSON(remote+"room/list/all/page",{rows:rows,page:page},function(data){
			//显示个数和页数
			$("span#count").html(data.count);
			$("span#pagecount").html(data.page+"/"+data.pageCount);
			pageCount=data.pageCount;
			//显示列表
			$("table#RoomTable tbody").html("");
			for(var i=0;i<data.list.length;i++){
				var tr="<tr id='"+data.list[i].roomno+"'>" +
				        "<td>"+data.list[i].roomno+"</td>" +
				        "<td>"+data.list[i].housetypeno+"</td>" +
						"<td>"+data.list[i].buildingno+"</td>" +
						"<td>"+data.list[i].departmentcode+"</td>" +
						"<td>"+data.list[i].floor+"</td>" +
						"<td>"+data.list[i].roomcode+"</td>" +
						"<td>"+data.list[i].buildingarea+"</td>" +
						"<td>"+data.list[i].feearea+"</td>" +
						"<td>"+data.list[i].roomstatus+"</td>" +
						"<td>"+data.list[i].roomtype+"</td>" +
				        "</td></tr>";
				$("table#RoomTable tbody").append(tr);
			}
			//定义表格行的点击时间，取得选择的房间编号
			$("table#RoomTable tbody tr").on("click",function(){
				RoomNo=$(this).attr("id");
				
				$("table#RoomTable tbody tr").css("background-color","#FFFFFF");
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
	var dialogArea = null;
	//点击增加链接处理，嵌入add.html
	$("a#RoomAddLink").off().on("click",function(event){
				
		$("div#RoomDialogArea").load("room/add.html",function(){
			dialogArea = $("div#RoomDialogArea");
			dialogArea.dialog({
				title:"增加房间信息",
				width:600
			});
			
			$("form#RoomAddForm").ajaxForm(function(result){
				
				if(result.status=="OK"){
					
					getListInfo(); 
					alert("1230");
				}
				//alert(result.message);
				BootstrapDialog.alert(result.message);
				BootstrapDialog.show({
		            title: '客户操作信息',
		            message:result.message
		        });
				dialogArea.dialog( "close" );
				dialogArea.dialog( "destroy" );
				dialogArea.html("");
				
			});
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$( "div#RoomDialogArea" ).dialog( "close" );
				$( "div#RoomDialogArea" ).dialog( "destroy" );
				$("div#RoomDialogArea").html("");
			});
		});
		
	});
	
	//点击修改按钮事件处理
	$("a#RoomModifyLink").off().on("click",function(event){
		if(RoomNo==0){
			BootstrapDialog.show({
	            title: '客户操作信息',
	            message:"请选择要修改的客户"
	        });
		}
		else {
			$("div#RoomDialogArea").load("room/modify.html",function(){
				//取得选择的部门
				$.getJSON("room/get",{no:RoomNo},function(data){
					if(data.status=="OK"){
						$("input[name='no']").val(RoomNo);
						$("input[name='cname']").val(data.model.cname);
						$("input[name='contact']").val(data.model.contact);
						$("input[name='cardcode']").val(data.model.cardcode);
						$("input[name='mobile']").val(data.model.mobile);
						$("input[name='feeStartDate']").val(data.model.feeStartDate);
						$("input[name='feeEndDate']").val(data.model.feeEndDate);
						$("input[name='cstatus']").val(data.model.cstatus);						
					}
				});
				
				$("div#RoomDialogArea").dialog({
					title:"客户修改",
					width:600
				});
				//拦截表单提交
				$("form#RoomModifyForm").ajaxForm(function(result){
					
					if(result.status=="OK"){
						getListInfo(); 
					}
					//alert(result.message);
					//BootstrapDialog.alert(result.message);
					BootstrapDialog.show({
			            title: '客户操作信息',
			            message:result.message
			        });
					$("div#RoomDialogArea").dialog( "close" );
					$("div#RoomDialogArea").dialog( "destroy" );
					$("div#RoomDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#RoomDialogArea").dialog( "close" );
					$("div#RoomDialogArea").dialog( "destroy" );
					$("div#RoomDialogArea").html("");
				});
			});
			
		}
		
		
	});
	
	//点击删除按钮事件处理
	$("a#RoomDelteLink").off().on("click",function(event){
		//alert("OK");
		alert(RoomNo);
		if(RoomNo==0){
			BootstrapDialog.show({
	            title: '客户操作信息',
	            message:"请选择要删除的客户"
	        });
		}
		else {
			//先检查此部门能否被删除
			$.getJSON("room/checkDelete",{no:RoomNo},function(data){
				if(data.status!="OK"){
					alert(RoomNo+"!!!");
					BootstrapDialog.show({
			            title: '客户操作信息',
			            message:data.message
			        });
				}
				else{
					BootstrapDialog.confirm('确认删除此客户么?', function(result){
			            if(result) {
			                $.post("room/delete",{no:RoomNo},function(result){
			                	if(result.status=="OK"){
									getListInfo(); 
								}
								BootstrapDialog.show({
						            title: '客户操作信息',
						            message:result.message
						        });
			                });
			            }
			        });
				}
			});
			
		}
		
	});
	/**
	//点击查看详细按钮事件处理
	$("a#CustomerViewLink").off().on("click",function(event){
		
		if(CustomerNo==0){
			BootstrapDialog.show({
	            title: '客户操作信息',
	            message:"请选择要查看的客户"
	        });
		}
		else{
			$("div#CustomerDialogArea").load("customer/view.html",function(){
				//取得选择的部门
				$.getJSON("customer/get",{no:CustomerNo},function(data){
					if(data.status=="OK"){
						$("span#CustomerName").html(data.model.cname);
						$("span#CustomerContact").html(data.model.contact);
						$("span#CustomerCardcode").html(data.model.cardcode);
						$("span#CustomerMobile").html(data.model.mobile);
						$("span#CustomerFeeStartDate").html(data.model.feeStartDate);
						$("span#CustomerFeeEndDate").html(data.model.feeEndDate);
						$("span#CustomerCstatus").html(data.model.cstatus);

					}
				});
				//弹出Dialog
				$("div#CustomerDialogArea" ).dialog({
					title:"客户详细",
					width:600
				});
				//点击取消按钮处理
				$("input[value='返回']").on("click",function(){
					$( "div#CustomerDialogArea" ).dialog( "close" );
					$( "div#CustomerDialogArea" ).dialog( "destroy" );
					$("div#CustomerDialogArea").html("");
				});
			});
			
		}
	});
	**/
});