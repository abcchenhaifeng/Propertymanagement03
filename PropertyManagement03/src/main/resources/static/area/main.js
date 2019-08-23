/**
 * 李海宏:小区管理代码
 * @returns
 */
$(function(){
	var areano=0;
	var name=null;
	var developer=null;
	var minbuildingarea=null;
	var maxbuildingarea=null;
	var minhome=0;
	var maxhome=0;
	var minhouse=0;
	var maxhouse=0;
	var host="http://localhost:8080/";
	var AreaId= null;
	//设置系统页面标题
	$("span#maintille").html("&emsp;小区管理");
	$.jgrid.defaults.styleUI="Bootstrap";
	//显示小区列表
	$("table#AreaGrid").jqGrid({
		//url: host+'area/list/condition/page',
		url: host+'area/list/condition/page',
		datatype: "json",
		colModel: [
			{ label: '小区名称', name: 'name', width: 60 },
			{ label: '小区地址', name: 'address', width: 80 },
			{ label: '开发商', name: 'developer', width: 60 },
			{ label: '总建筑面积', name: 'buildingarea', width: 50 },
			{ label: '总使用面积', name: 'usearea', width: 50},
			{ label: '车位面积', name: 'parkarea', width: 50 },
			{ label: '总居民数', name: 'home', width: 50 },  
			{ label: '总公建数', name: 'house', width: 50 },
			{ label: '车位数', name: 'park', width: 50 } 
		],
		caption:"小区列表",
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
		pager: "#AreaGridPager",
		multiselect:false,
		onSelectRow:function(ano){
			areano=ano;
		}
		
	});

	//取得小区列表，填充小区下拉框
	$.getJSON(host+"area/list/all",function(areaList){
		if(areaList){
			$.each(areaList,function(index,am){
				$("select#AreaSelection").append("<option value='"+am.name+"'>"+am.name+"</option>");
			});
		}
	});
	
	//取得开发商列表，填充开发商下拉框
	$.getJSON(host+"area/list/all",function(developerList){
		if(developerList){
			$.each(developerList,function(index,dm){
				$("select#DeveloperSelection").append("<option value='"+dm.developer+"'>"+dm.developer+"</option>");
			});
		}
	});
	
	//设置检索参数，更新jQGrid的列表显示
	function reloadAreaList()
	{
		$("table#AreaGrid").jqGrid('setGridParam',{postData:{name:name,
			developer:developer,minbuildingarea:minbuildingarea,
			maxbuildingarea:maxbuildingarea,minhome:minhome,
			maxhome:maxhome,minhouse:minhouse,maxhouse:maxhouse}}).trigger("reloadGrid");	
	}
	
	//点击检索事件处理
	$("a#AreaSearchButton").on("click",function(){
		name=$("select#AreaSelection").val();
		developer=$("select#DeveloperSelection").val();
		minbuildingarea=$("input#minbuildingarea").val();
		maxbuildingarea=$("input#maxbuildingarea").val();
		minhome=$("input#minhome").val();
		maxhome=$("input#maxhome").val();
		minhouse=$("input#minhouse").val();
		maxhouse=$("input#maxhouse").val();
		
		reloadAreaList();
	});
	
	//点击重置事件处理
	$("a#AreaResetButton").on("click",function(){
		$("select#AreaSelection").val("");
		$("select#DeveloperSelection").val("");
		$("input#minbuildingarea").val("");
		$("input#maxbuildingarea").val("");
		$("input#minhome").val("");
		$("input#maxhome").val("");
		$("input#minhouse").val("");
		$("input#maxhouse").val("");
		areano=0;
		name=null;
		developer=null;
		minbuildingarea=null;
		maxbuildingarea=null;
		minhome=0;
		maxhome=0;
		minhouse=0;
		maxhouse=0;
		
		reloadAreaList();
	});
	
	//定义小区下拉框的更新事件的处理
	$("select#AreaSelection").off().on("change",function(){
		name=$("select#AreaSelection").val();
		reloadAreaList();
	});
	
	
	//定义开发商下拉框的更新事件的处理
	$("select#DeveloperSelection").off().on("change",function(){
		developer=$("select#DeveloperSelection").val();
		reloadAreaList();
	});
	//定义总建筑面积的更新事件的处理
	$("input#minbuildingarea").off().on("change",function(){
		minbuildingarea=$("input#minbuildingarea").val();
		reloadAreaList();
	});
	$("input#maxbuildingarea").off().on("change",function(){
		maxbuildingarea=$("input#maxbuildingarea").val();
		reloadAreaList();
	});
	//定义总居民数的更新事件的处理
	$("input#minhome").off().on("change",function(){
		minhome=$("input#minhome").val();
		reloadAreaList();
	});
	$("input#maxhome").off().on("change",function(){
		maxhome=$("input#maxhome").val();
		reloadAreaList();
	});
	//定义总公建数的更新事件的处理
	$("input#minhouse").off().on("change",function(){
		minhouse=$("input#minhouse").val();
		reloadAreaList();
	});
	$("input#maxhouse").off().on("change",function(){
		maxhouse=$("input#maxhouse").val();
		reloadAreaList();
	});
	
	//===========================增加小区处理================================================
	$("a#AreaAddLink").off().on("click",function(){
		$("div#AreaDialogArea").load("area/add.html",function(){
			//验证提交数据
			$("form#AreaAddForm").validate({
				rules: {
					name: {
						required: true
					},
					address: {
						required: true
					},
					developer: {
						required: true
					},
					buildingarea: {
						required: true,
						min:0
					},
					usearea: {
						required: true,
						min:0
					},
					
					parkarea: {
						required: true,
						min:0
					},
					home: {
						required: true
					},
					house: {
						required: true
					},
					park: {
						required: true
					}
				},
				message:{
					name: {
						required: "小区名称为空"
					},
					address: {
						required: "小区地址为空"
					},
					developer: {
						required: "开发商为空"
					},
					buildingarea: {
						number: "总建筑面积必须是数值",
				    	range: "大于0"
					},
					usearea: {
						number: "总使用面积必须是数值",
				    	range: "小于总建筑面积"
					},
					
					parkarea: {
						number: "车位面积必须是数值",
				    	range: "小于总建筑面积"
					},
					home: {
						number: "总居民数必须是数值",
				    	range: "大于等于0"
					},
					house: {
						number: "总公建数必须是数值",
				    	range: "大于等于0"
					},
					park: {
						number: "车位数必须是数值",
				    	range: "大于等于0"
					}
				}
			});
			//增加小区的弹窗
			$("div#AreaDialogArea").dialog({
				title:"增加小区",
				width:900
			});
			
			//拦截增加提交表单
			$("form#AreaAddForm").ajaxForm(function(result){
				if(result.status=="OK"){
					reloadAreaList(); //更新小区列表
					setMessage("添加成功", 5000);
				}
				
				$("div#AreaDialogArea" ).dialog( "close" );
				$("div#AreaDialogArea" ).dialog( "destroy" );
				$("div#AreaDialogArea").html("");
				
			});
			
			//点击取消按钮处理
			$("input[value='取消']").on("click",function(){
				$("div#AreaDialogArea" ).dialog( "close" );
				$("div#AreaDialogArea" ).dialog( "destroy" );
				$("div#AreaDialogArea").html("");
			});
		});
	});
	
	//================================查看小区处理====================================

	$("a#AreaViewLink").off().on("click",function(){
		
		if(areano==0){
			jqueryEject.Econfirm({
				title: '查看信息',
				message: '请选择要查看的客户',
				define: function() {
					setMessage(message, 5000);
				},
				cancel: function() {}
			});
		}
		else{
			$("div#AreaDialogArea").load("area/view.html",function(){
				//alert(areano);
				//取得选择的小区
				$.getJSON(host+"area/get",{no:areano},function(area){
					setMessage("查看详细", 5000);
					if(area){
						$("input[name='no']").val(areano);
						$("input[name='name']").val(area.model.name);
						$("input[name='address']").val(area.model.address);
						$("input[name='developer']").val(area.model.developer);
						$("input[name='buildingarea']").val(area.model.buildingarea);
						$("input[name='usearea']").val(area.model.usearea);
						$("input[name='parkarea']").val(area.model.parkarea);
						$("input[name='home']").val(area.model.home);
						$("input[name='house']").val(area.model.house);
						$("input[name='park']").val(area.model.park);
							
					}
				});
				//弹出Dialog
				$("div#AreaDialogArea" ).dialog({
					title:"小区详细",
					width:800
				});
				//点击取消按钮处理
				$("input[value='关闭']").on("click",function(){
					$("div#AreaDialogArea" ).dialog( "close" );
					$("div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
				});

			});
			
		}
	});
	
	//===============================修改小区处理=============================
	$("a#AreaModifyLink").off().on("click",function(){
		
		if(areano==0){
			jqueryEject.Econfirm({
				title: '修改小区信息',
				message: '请选择要修改的小区',
				define: function() {
					setMessage(message, 5000);
				},
				cancel: function() {}
			});		
		}
		else{
			$("div#AreaDialogArea").load("area/modify.html",function(){
				
				//取得选择的小区
				$.getJSON(host+"area/get",{no:areano},function(area){
					//alert(areano);
					if(area){
						$("input[name='no']").val(areano);
						$("input[name='name']").val(area.model.name);
						$("input[name='address']").val(area.model.address);
						$("input[name='developer']").val(area.model.developer);
						$("input[name='buildingarea']").val(area.model.buildingarea);
						$("input[name='usearea']").val(area.model.usearea);
						$("input[name='parkarea']").val(area.model.parkarea);
						$("input[name='home']").val(area.model.home);
						$("input[name='house']").val(area.model.house);
						$("input[name='park']").val(area.model.park);
						
					}
				});
				//弹出Dialog
				$("div#AreaDialogArea" ).dialog({
					title:"小区修改",
					width:800
				});
				$("form#AreaModifyForm").ajaxForm(function(result){
					if(result.status=="OK"){
						reloadAreaList(); //更新小区列表
						setMessage("修改成功", 5000);
					}
					
					$("div#AreaDialogArea" ).dialog( "close" );
					$("div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
					
				});
				
				
				//点击取消按钮处理
				$("input[value='取消']").on("click",function(){
					$("div#AreaDialogArea" ).dialog( "close" );
					$("div#AreaDialogArea" ).dialog( "destroy" );
					$("div#AreaDialogArea").html("");
				});

			});
			
		}
	});

	//===============================删除小区处理=====================================

	$("a#AreaDeleteLink").off().on("click",function(){
		
		if(areano==0){
			jqueryEject.Econfirm({
				title: '删除小区信息',
				message: '请选择要删除的小区',
				define: function() {
					setMessage(message, 5000);
				},
				cancel: function() {}
			});		
		}
		else {
	            $.post(host+"area/delete",{no:areano},function(result){
	            	if(result.status=="OK"){
	            		reloadAreaList(); //更新小区列表
					}
	            });			
		}
	});

});
	
	