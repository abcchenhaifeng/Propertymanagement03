/**
 * 陈海锋
 * @returns
 */
$(function(){
	var RoomNo=0;
	var HouseTypeNo=0;
	var DepartmentCode=null;
	var host="http://localhost:8080/";
	var roomno=0;
	//设置系统页面标题
	$("span#maintille").html("&emsp;房间档案");
	$.jgrid.defaults.styleUI="Bootstrap";
	//显示客户列表
	$("table#RoomGrid").jqGrid({
		url: host+'room/list/condition/page',
		datatype: "json",
		colModel: [ 
			{ label: '房间编号', name: 'roomno', width: 40,align:"center" },
			{ label: '房屋户型编号', name: 'housetype.typeno', width: 40,align:"center" },
			{ label: '房屋户型类别', name: 'housetype.typename', width: 40,align:"center" },
			{ label: '楼宇编号', name: 'buildingno', width: 40,align:"center" },
			{ label: '单元', name: 'departmentcode', width: 100,align:"center" },
			{ label: '楼层', name: 'floor', width: 100,align:"center"},
			{ label: '使用面积', name: 'buildingarea', width: 100,align:"center" },
			{ label: '缴费面积', name: 'feearea', width:40,align:"center" },
			{ label: '房间状态', name: 'roomstatus', width:40,align:"center" },
			{ label: '房间类型', name: 'roomtype', width:40,align:"center" },	
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
		      id: "roomno"},
		pager: "#RoomGridPager",
		multiselect:false,
		onSelectRow:function(cid){
			RoomId=cid;
		}
		
	});
	//取得类型列表，填充类型下拉框
	$.getJSON(host+"building/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,housetype){
				$("input[name='RoomNo']").append("<option value='"+housetype.typeno+"'>"+housetype.typename+"</option>");
			});
		}
	});
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadRoomList()
	{
		$("table#RoomGrid").jqGrid('setGridParam',{postData:{RoomNo:RoomNo,HouseTypeNo:HouseTypeNo,DepartmentCode:DepartmentCode}}).trigger("reloadGrid");
		
	}
	
	//定义类型的更新事件的处理
	$("input[name='RoomNo']").off().on("change",function(){
		
		RoomNo=$("input[name='RoomNo']").val();
		
		HouseTypeNo=$("input[name='HouseTypeNo']").val();

		DepartmentCode=$("input[name='DepartmentCode']").val();
		
		if(HouseTypeNo==""){
			HouseTypeNo=null;
		}
		if(DepartmentCode==""){
			DepartmentCode=null;
		}
		reloadRoomList();
	});
	
	//定义房间输入更改事件
	$("input[name='RoomNo']").off().on("change",function(){
		RoomNo=$("input[name='RoomNo']").val();
		reloadRoomList();
	});

	//点击检索事件处理
	$("a#RoomSearchButton").on("click",function(){
		RoomNo=$("input[name='RoomNo']").val();
		HouseTypeNo=$("input[name='HouseTypeNo']").val();
		DepartmentCode=$("input[name='DepartmentCode']").val();
		if(HouseTypeNo==""){
			HouseTypeNo=null;
		}
		if(DepartmentCode==""){
			DepartmentCode=null;
		}
		reloadRoomList();
	});
	
	//===========================增加房间处理================================================
	$("a#RoomAddLink").off().on("click",function(){
		$("div#RoomDialog").load("estate/add.html",function(){
			//验证房间提交数据
			$("form#RoomAddForm").validate({
				  rules: {
				  rooomno:{
				    	required: true,
				    	remote: host+"room/checkidexist"
				        },
				  housetypeno:{
					  required:true,
				          },
				  buildingno:{
				    	required:true,
				    	buildingno:true			    	
				         },
				  departmentcode:{
					  required:true,
					  departmentcode:true
				            },
				  floor:{
					  required:true,
				                },
				  roomcode:{
					  required:true, 
				             }
				  },
				  
				  messages:{
					rooomno:{
					      required: "请输入房间编号",
					    },
					    housetypeno:{
					       required: "请输入房屋户型编号"		   
					    },	    
						
						buildingno:{
							required: "请输入楼宇编号"  
			            },
			            departmentcode:{
			            	required: "请输入单元"    
		                },
						floor:{
							required: "请输入楼层"  	  
						},
						roomcode:{
							required: "请输入房间号"    
						} 
				}
				  
			});
			
			//拦截增加提交表单
			$("form#RoomAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadRoomList();//更新房间列表
				}
				$("div#RoomDialog").dialog( "close" );
				$("div#RoomDialog").dialog( "destroy" );
				$("div#RoomDialog").html("");
				
			});
			$("div#RoomDialog").dialog({
				title:"房间增加",
				width:950
			});
			
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#RoomDialog").dialog("close");
				$("div#RoomDialog").dialog("destroy")
				$("div#RoomDialog").html("");
			});
			
		});
	});
	//===============================修改房间处理===============================================================
	$("a#RoomModifyLink").off().on("click",function(){
		if(RoomId==null){	
			jqueryEject.Econfirm({
				title: '客户信息',
				message: '请选择要修改的客户',
				define: function() {
				setMessage(message, 5000);
				},
				cancel: function() {}
			});
		}
		else{
			$("div#RoomDialog").load("estate/mainmodify.html",function(){
				//取得指定的房间信息
				$.getJSON(host+"/room/get",{no:RoomId},function(em){
					if(em){
						$("input[name='RoomNo']").val(em.RoomNo);
						$("input[name=housetypeno']").val(em.housetypeno);
						$("input[name='buildingno']").val(em.buildingno);
						$("input[name='departmentcode']").val(em.departmentcode);
						$("input[name='floor']").val(em.floor);
	
					}
				});
				//拦截修改提交表单
				$("form#RoomModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						setMessage("添加成功", 5000);
						reloadRoomList();//更新客户列表
					}
					
					$("div#RoomDialog").dialog( "close" );
					$("div#RoomDialog").dialog( "destroy" );
					$("div#RoomDialog").html("");
					
				});
				$("div#RoomDialog").dialog({
					title:"客户修改",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#RoomDialog").dialog("close");
					$("div#RoomDialog").dialog("destroy")
					$("div#RoomDialog").html("");
				});
				
				
			});
		}
	});	
	
	//===============================删除房间处理==============================================================
	//点击删除按钮事件处理
	$("a#RoomDeleteLink").off().on("click",function(event){
		
		if(RoomId==null){
			jqueryEject.Econfirm({
			title: '删除',
			message: '请选择要删除的客户',
			define: function() {
				setMessage(message, 5000);
			},
			cancel: function() {}
		});
		}
		else {
                $.post(host+"room/delete",{roomno:RoomId},function(result){
                	if(result.status=="OK"){
                		setMessage("删除成功", 5000);
                		reloadRoomList();//更新客户列表
					}
					
                });
		}
		
	});
});
	
	