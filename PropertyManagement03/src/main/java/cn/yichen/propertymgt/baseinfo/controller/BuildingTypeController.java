package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.baseinfo.model.BuildingType;
import cn.yichen.propertymgt.baseinfo.service.IBuildingTypeService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date:2019年8月18日下午9:15:00
 * @author LiYi(李海宏)
 * @Description：完善楼宇类型控制层代码
 *
 */
@RestController
@RequestMapping(value="/buildType")
public class BuildingTypeController {
	@Autowired
	private IBuildingTypeService service;
	
	//增加建筑类型
	@GetMapping(value="/add")
	public ResultMessage<BuildingType> add(BuildingType buildType) throws Exception {
		service.add(buildType);
		return new ResultMessage<BuildingType>("OK","增加建筑类型成功");
	}
	//修改建筑类型
	@GetMapping(value="/modify")
	public ResultMessage<BuildingType> update(BuildingType buildType) throws Exception {
		service.modify(buildType);
		return new ResultMessage<BuildingType>("OK","修改建筑类型成功");
	}
	//删除建筑类型
	@GetMapping(value="/delete")
	public  ResultMessage<BuildingType> delete(BuildingType buildType) throws Exception {
		service.delete(buildType);
		return new ResultMessage<BuildingType>("OK","删除建筑类型成功");
	}
	//取得所有建筑类型列表
	@GetMapping(value="/list/all")
	public List<BuildingType> getBuildTypeListByAll() throws Exception{
		return service.getBuildTypeListByAll();
	}
	//取得所有建筑类型列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<BuildingType> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<BuildingType> result=new ResultMessage<BuildingType>("OK","取得建筑类型列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPageCountByAll(rows));
		result.setList(service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	//取得指定建筑类型的信息
	@GetMapping("/get")
	public BuildingType getBuildTypeByNo(int typeno) throws Exception{
		return service.getBuildTypeByNo(typeno);
	}
}
