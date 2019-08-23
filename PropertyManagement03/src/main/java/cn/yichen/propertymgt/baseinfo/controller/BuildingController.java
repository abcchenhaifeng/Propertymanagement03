package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.model.Building;
import cn.yichen.propertymgt.baseinfo.service.IBuildingService;
import cn.yichen.propertymgt.vo.ResultMessage;


/**
 * 
 * @date:2019年8月18日下午9:55:12
 * @author LiYi(李海宏)
 * @Description：完善楼宇表控制层代码
 *
 */
@RestController
@RequestMapping(value="/building")
public class BuildingController {

	@Autowired
	private IBuildingService service;
	
	//增加楼宇
	@PostMapping(value="/add")
	public ResultMessage<Building> add(Building building) throws Exception {
		service.add(building);
		return new ResultMessage<Building>("OK","增加楼宇成功");
	}
	//修改楼宇
	@PostMapping(value="/modify")
	public ResultMessage<Building> update(Building building) throws Exception {
		service.modify(building);
		return new ResultMessage<Building>("OK","修改楼宇成功");
	}
	//删除楼宇
	@PostMapping(value="/delete")
	public ResultMessage<Building> delete(Building building) throws Exception {
		service.delete(building);
		return new ResultMessage<Building>("OK","删除楼宇成功");
	}
	
	//取得所有楼宇列表
	@GetMapping(value="/list/all")
	public List<Building> getListByAll() throws Exception{
		return service.getListByAll();
	}
	//取得所有楼宇列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Building> getListByAllWitPage(@RequestParam(required = false,defaultValue ="2") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Building> result=new ResultMessage<Building>("OK","取得楼宇列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPageCountByAll(rows));
		result.setList(service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	//查询楼宇的信息,关联Area
	@GetMapping(value="/list/all/witharea")
	public List<Building> getListByAllWithArea() throws Exception {
		return service.getListByAllWithArea();
	}
	
	//查询楼宇的信息,关联BuildingType
	@GetMapping(value="/list/all/withbuildtype")
	public List<Building> getListByAllWithBuildType() throws Exception{
		return service.getListByAllWithBuildType();
	}
	
	//查询楼宇的信息,关联Area和BuildingType
	@GetMapping(value="/list/all/withareaandbuildtype")
	public List<Building> getListByAllWithAreaAndBuildType() throws Exception {
		return service.getListByAllWithAreaAndBuildType();
	}
	
	//取得所有楼宇列表,关联Area和BuildingType.分页模式
	@GetMapping(value="/list/all/withareaandbuildtypewithpage")
	public ResultMessage<Building> getListByAllWithAreaAndBuildTypeWithPage(@RequestParam(required = false,defaultValue ="5") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Building> result=new ResultMessage<Building>("OK","取得楼宇列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPageCountByAll(rows));
		result.setList(service.getListByAllWithAreaAndBuildTypeWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得指定小区的楼宇列表,参数:areaNo 
	@GetMapping(value="/list/area")
	public List<Building> getListByArea(int areaNo) throws Exception {
		return service.getListByArea(areaNo);
	}
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	@GetMapping(value="/list/buildtype")
	public List<Building> getListByBuildType(int buildTypeNo) throws Exception {
		return service.getListByBuildType(buildTypeNo);
	}
		
	//取得指定楼宇的信息
	@GetMapping("/get")
	public Building getByNo(int no) throws Exception{
		return service.getByNo(no);
	}
//	
//	@Param("areano") int areano,@Param("baddress") String baddress,
//	@Param("buildingtypeno") int buildingtypeno,@Param("minhouse") int minhouse,@Param("maxhouse") int maxhouse, 
//	@Param("start") int start,@Param("rows") int rows
	//按检索条件取得小区列表
	@GetMapping(value="/list/condition/page")
	public ResultMessage<Building> getListByConditionWithPage(
			@RequestParam(required = false,defaultValue ="0") int areano,@RequestParam(required = false,defaultValue ="") String baddress,
			@RequestParam(required = false,defaultValue ="0") int buildingtypeno,@RequestParam(required = false,defaultValue ="0") int minhouse,@RequestParam(required = false,defaultValue ="0") int maxhouse, 
			@RequestParam(required = false,defaultValue ="0") int rows,@RequestParam(required = false,defaultValue ="0") int page) throws Exception {
	
		ResultMessage<Building> result=new ResultMessage<Building>("OK","取得楼宇列表分页成功");
		result.setCount(service.getCountByCondition(areano, baddress, buildingtypeno, minhouse, maxhouse));
		result.setPageCount(service.getPageCountByConditionWithPage(areano, baddress, buildingtypeno, minhouse, maxhouse, rows));
		result.setList(service.getListByConditionWithPage(areano, baddress, buildingtypeno, minhouse, maxhouse, rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
}
