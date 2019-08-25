/**
 * 李海宏:楼宇管理
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
	//显示楼宇列表
	$("table#BuildingGrid").jqGrid({
		url: host+'building/list/condition/page',
		//url: host+'building/list/all/withareaandbuildtype',
		datatype: "json",
		colModel: [
			{ label: '楼号', name: 'code', width: 40,align:"center" },
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
	$.getJSON(host+"building/get/address",function(btypeList){
		if(btypeList){
			$.each(btypeList,function(index,btypeno){
				$("select#BuildingSelection").append("<option value='"+btypeno.address+"'>"+btypeno.address+"</option>");
			});
		}
	});
	
	//取得楼宇编号列表，填充类型下拉框
	$.getJSON(host+"building/get/bulingtypeno",function(btypeList){
		if(btypeList){
			$.each(btypeList,function(index,btypeno){
				$("select#BuildingNoSelection").append("<option value='"+btypeno.buildingtype.typeno+"'>"+btypeno.buildingtype.typeno+"</option>");
			});
		}
	});
	
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadBuildingList()
	{
		$("table#BuildingGrid").jqGrid('setGridParam',{postData:{areano:areano,baddress:baddress,buildingtypeno:buildingtypeno,minhouse:minhouse,maxhouse:maxhouse}}).trigger("reloadGrid");
		
	}
	

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


	//===========================增加楼宇处理================================================
	$("a#BuildingAddLink").off().on("click",function(){
		$("div#BuildingDialog").load("building/add.html",function(){	
			//验证员工提交数据
			$("form#BuildingAddForm").validate({
				  rules: {
					 code:{
				    	required: true,
				    	//remote: host+"customer/checkidexist"
				        },
//				     area.no:{
//					    required:true,
//				          },
				     address:{
				    	required:true,
				    	//mobile:true			    	
				         },
//				    buildingtype.typeno:{
//					    required:true,
//					  //card:true
//				            },
				    home:{
					    required:true, 
				             },
				    house:{
					   required:true,
				          }       
				  },
				  
				  messages:{
					  code:{
					      required: "请输入楼宇编码",
					     //remote:"该客户信息已经存进"
					    },
//					    area.no:{
//					       required: "请输入小区号"		   
//					    },	    	
					    address:{
							required: "请输入地址"  
			            },
//			            buildingtype.typeno:{
//			            	required: "请输入楼宇类型号"    
//		                },
		                home:{
							required: "请输入居民数",
							min:0
						},
						house:{
							required: "请输入公建数",
							min:0
						} 
				 }
				  
			});
			//拦截增加提交表单
			$("form#BuildingAddForm").ajaxForm(function(result){
				alert(result.status);
				if(result.status=="OK"){
					reloadBuildingList();//更新楼宇列表
				}
				$("div#BuildingDialog").dialog( "close" );
				$("div#BuildingDialog").dialog( "destroy" );
				$("div#BuildingDialog").html("");
				
			});
			$("div#BuildingDialog").dialog({
				title:"楼宇增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#BuildingDialog").dialog("close");
				$("div#BuildingDialog").dialog("destroy")
				$("div#BuildingDialog").html("");
			});
			
		});
	});
	
	
//	================================查看楼宇处理=============================================================
	$("a#BuildingViewLink").off().on("click",function(){
		if(buildingno==null){
			jqueryEject.Econfirm({
				title: '楼宇信息',
				message: '请选择要查看的楼宇',
				define: function() {
					setMessage(message, 5000);
				},
				cancel: function() {}
			});			
		}
		else{
			$("div#BuildingDialog").load("building/view.html",function(){
				//取得指定的楼宇信息
				$.getJSON(host+"/building/get",{no:buildingno},function(em){
					setMessage("查看详细", 5000);
					if(em){
						$("input[name='code']").val(em.code);
						$("input[name='area.no']").val(em.area.no);
						$("input[name='no']").val(em.no);
						$("input[name='address']").val(em.address);
						$("input[name='buildingtype.typeno']").val(em.buildingtype.typeno);
						$("input[name='direction']").val(em.direction);
						$("input[name='home']").val(em.home);
						$("input[name='house']").val(em.house);
					}
				});
				
				
				$("div#BuildingDialog").dialog({
					title:"楼宇详细",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='关闭']").off().on("click",function(){
					$("div#BuildingDialog").dialog("close");
					$("div#BuildingDialog").dialog("destroy")
					$("div#BuildingDialog").html("");
				});
			});
		}
	});
	//===============================修改楼宇处理===============================================================
	$("a#BuildingModifyLink").off().on("click",function(){
		alert(buildingno);
		if(buildingno==null){	
			jqueryEject.Econfirm({
				title: '楼宇信息',
				message: '请选择要修改的楼宇',
				define: function() {
				setMessage(message, 5000);
				},
				cancel: function() {}
			});
		}
		else{
			$("div#BuildingDialog").load("building/modify.html",function(){
				//取得指定的楼宇信息
				$.getJSON(host+"/building/get",{no:buildingno},function(em){
					if(em){	
						$("input[name='code']").val(em.code);
						$("input[name='no']").val(em.no);
						$("input[name='area.no']").val(em.area.no);
						$("input[name='address']").val(em.address);
						$("input[name='buildingtype.typeno']").val(em.buildingtype.typeno);
						$("input[name='direction']").val(em.direction);
						$("input[name='home']").val(em.home);
						$("input[name='house']").val(em.house);
					}
				});
				//拦截修改提交表单
				$("form#BuildingModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						setMessage("添加成功", 5000);
						reloadBuildingList();//更新楼宇列表
					}
					
					$("div#BuildingDialog").dialog( "close" );
					$("div#BuildingDialog").dialog( "destroy" );
					$("div#BuildingDialog").html("");
					
				});
				$("div#BuildingDialog").dialog({
					title:"楼宇修改",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#BuildingDialog").dialog("close");
					$("div#BuildingDialog").dialog("destroy")
					$("div#BuildingDialog").html("");
				});
				
				
			});
		}
	});	
	
	//===============================删除楼宇处理==============================================================
	//点击删除按钮事件处理
	$("a#BuildingDeleteLink").off().on("click",function(event){
		
		if(buildingno==null){
			jqueryEject.Econfirm({
			title: '删除',
			message: '请选择要删除的楼宇',
			define: function() {
				setMessage(message, 5000);
			},
			cancel: function() {}
		});
		}
		else {
                $.post(host+"building/delete",{no:buildingno},function(result){
                	if(result.status=="OK"){
                		setMessage("删除成功", 5000);
                		reloadBuildingList();//更新楼宇列表
					}
					
                });
		}
		
	});
});
	
	