/**
 * 李海宏:楼宇管理
 * @returns
 */
$(function(){
	var host="http://localhost:8080/";
	var no= null;
	var typeno=null;
	//设置系统页面标题
	$("span#maintille").html("&emsp;楼宇类型信息管理");
	$.jgrid.defaults.styleUI="Bootstrap";
	//显示楼宇列表
	$("table#BuildingNoGrid").jqGrid({
		url: host+'buildType/list/condition/page',
		//url: host+'buildType/list/all/page',
		datatype: "json",
		colModel: [
			{ label: '楼宇类型号', name: 'typeno', width: 40,align:"center" },
			{ label: '类型简介', name: 'typename', width: 40,align:"center" }	
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
		      id: "typeno"},
		pager: "#BuildingNoGridPager",
		multiselect:false,
		onSelectRow:function(bno){
			no=bno;
		}
		
	});

	//取得楼宇类型号列表，填充类型下拉框
	$.getJSON(host+"buildType/list/all",function(typeList){
		if(typeList){
			$.each(typeList,function(index,typeno){
				$("select#TypeNoSelection").append("<option value='"+typeno.typeno+"'>"+typeno.typeno+"</option>");
			});
		}
	});
	

	//设置检索参数，更新jQGrid的列表显示
	function reloadBuildingNoList()
	{
		$("table#BuildingNoGrid").jqGrid('setGridParam',{postData:{typeno:typeno}}).trigger("reloadGrid");
		
	}
	

	//定义楼宇编号类型输入更改事件
	$("select#TypeNoSelection").off().on("change",function(){
		typeno=$("select#TypeNoSelection").val();
		reloadBuildingNoList();
	});

	
	//点击检索事件处理
	$("a#BuildingNoSearchButton").on("click",function(){
		
		typeno=$("select#TypeNoSelection").val();
		reloadBuildingNoList();
		
	});


	//===========================增加楼宇处理================================================
	$("a#BuildingNoAddLink").off().on("click",function(){
		$("div#BuildingNoDialog").load("buildingtype/add.html",function(){	
			//验证员工提交数据
			$("form#BuildingTypeAddForm").validate({
				  rules: {
					  typeno:{
				    	required: true,
				        }    
				  },	  
				  messages:{
					  typeno:{
					      required: "请输入楼宇类型号",
					    }
				 }
				  
			});
			//拦截增加提交表单
			$("form#BuildingTypeAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadBuildingNoList();//更新楼宇列表
				}
				$("div#BuildingNoDialog").dialog( "close" );
				$("div#BuildingNoDialog").dialog( "destroy" );
				$("div#BuildingNoDialog").html("");
				
			});
			$("div#BuildingNoDialog").dialog({
				title:"楼宇类型增加",
				width:950
			});
			//点击取消按钮，管理弹出窗口
			$("input[value='取消']").off().on("click",function(){
				$("div#BuildingNoDialog").dialog("close");
				$("div#BuildingNoDialog").dialog("destroy")
				$("div#BuildingNoDialog").html("");
			});
			
		});
	});
	
	//===============================修改楼宇处理===============================================================
	$("a#BuildingNoModifyLink").off().on("click",function(){
		if(no==null){	
			jqueryEject.Econfirm({
				title: '楼宇类型信息',
				message: '请选择要修改的楼宇类型号',
				define: function() {
				setMessage(message, 5000);
				},
				cancel: function() {}
			});
		}
		else{
			$("div#BuildingNoDialog").load("buildingtype/modify.html",function(){
				//取得指定的楼宇信息
				$.getJSON(host+"/buildType/get",{typeno:no},function(em){
					if(em){	
						$("input[name='typeno']").val(em.typeno);
						$("input[name='typename']").val(em.typename);
					}
				});
				//拦截修改提交表单
				$("form#BuildingNoModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						setMessage("添加成功", 5000);
						reloadBuildingNoList();//更新楼宇列表
					}
					
					$("div#BuildingNoDialog").dialog( "close" );
					$("div#BuildingNoDialog").dialog( "destroy" );
					$("div#BuildingNoDialog").html("");
					
				});
				$("div#BuildingNoDialog").dialog({
					title:"楼宇类型修改",
					width:800
				});
				//点击取消按钮，管理弹出窗口
				$("input[value='取消']").off().on("click",function(){
					$("div#BuildingNoDialog").dialog("close");
					$("div#BuildingNoDialog").dialog("destroy")
					$("div#BuildingNoDialog").html("");
				});
				
				
			});
		}
	});	
	
//	===============================删除楼宇处理==============================================================
	//点击删除按钮事件处理
	$("a#BuildingNoDeleteLink").off().on("click",function(event){
		
		if(no==null){
			jqueryEject.Econfirm({
			title: '删除',
			message: '请选择要删除的楼宇类型',
			define: function() {
				setMessage(message, 5000);
			},
			cancel: function() {}
		});
		}
		else {
                $.post(host+"buildType/delete",{typeno:no},function(result){
                	if(result.status=="OK"){
                		setMessage("删除成功", 5000);
                		reloadBuildingNoList();//更新楼宇列表
				}	
            });
		}
	});
});
	
	