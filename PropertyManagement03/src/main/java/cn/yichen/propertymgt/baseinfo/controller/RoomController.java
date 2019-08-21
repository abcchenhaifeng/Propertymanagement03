package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.yichen.propertymgt.baseinfo.model.Room;
import cn.yichen.propertymgt.baseinfo.service.IRoomService;
import cn.yichen.propertymgt.vo.ResultMessage;
/**
 * 
 * @data:2019年8月20日上午9:50:31
 * @author： 陈海锋
 * @Description:房间档案控制层代码
 *
 */

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private IRoomService Service=null;
	
	//增加房间
	@GetMapping("/add")
	public ResultMessage<Room> add(Room room) throws Exception {
		Service.add(room);
		return new ResultMessage<Room>("OK","增加房间成功");
	}
	//修改房间
	@GetMapping("/modify")
	public ResultMessage<Room> modify(Room room) throws Exception {
		Service.modify(room);
		return new ResultMessage<Room>("OK","修改房间成功");
	}
	//删除房间
	@GetMapping("/delete")
	public ResultMessage<Room> delete(Room room) throws Exception {
		Service.delete(room);
		return new ResultMessage<Room>("OK","删除房间成功");
	}
	//取得指定的房间
	@GetMapping("/get")
	public Room getByCustomerNo(int roomno) throws Exception{
		return Service.getByRoomNo(roomno);
	}
	//取得所有房间列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Room> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Room> result=new ResultMessage<Room>("OK","取得房间列表分页模式成功");
		result.setCount(Service.getCountByAll());
		result.setPageCount(Service.getPageCountByAll(rows));
		result.setList(Service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有房间列表，无分页
	@GetMapping(value="/list/all")
	public List<Room> getListByAll() throws Exception{
		return Service.getListByAll();
	}
	
	//取得所有房间所属楼栋，无分页
	@GetMapping(value="/type/all")
	public List<Room> getBuildingtype() throws Exception{
		return Service.getBuildingNo();
	}
	
	//取得所有房间所属楼栋，无分页
	@GetMapping(value="/status/all")
	public List<Room> getLivingStatus() throws Exception{
		return Service.getlivingStatus();
	}
	
	//取得所有房间列表,有外键，无分页
	@GetMapping(value="/list/allfk")
	public List<Room> getListByAllWithFK() throws Exception{
		return Service.getListByAllWithFK();
	}
	
	//取得所有房间列表,关联TypeNo
	@GetMapping("/get/housetypeno")
	public List<Room> getListByAllWithHouseTypeNo() throws Exception{
		return Service.getListByAllWithHouseTypeNo();
	}
	
	//取得所有房间列表,关联BuildingNo
	@GetMapping("/get/buildingno")
	public List<Room> getListByAllWithBuildingNo() throws Exception{
		return Service.getListByAllWithBuildingNo();
	}
	
	//根据类型编号取得此户型的房间
	@GetMapping("/get/byhousetypeno")
	public List<Room> getListByHouseTypeNo(int housetypeno) throws Exception{
		return Service.getListByHouseTypeNo(housetypeno);
	}
	
	//根据楼宇序号取得此序号的房间
	@GetMapping("/get/bybuildingno")
	public List<Room> getListByBuildingNo(int buildingno) throws Exception{
		return Service.getListByBuildingNo(buildingno);
	}
	
	//根据检索条件取得需要的房间列表，无关联
	@GetMapping(value="/list/condition/page")
	public ResultMessage<Room> getListByConditionWithPag(@RequestParam(required = false,defaultValue ="0") String RoomNo,@RequestParam(required = false,defaultValue ="0") String HouseTypeNo,@RequestParam(required = false,defaultValue ="0") String DepartmentCode,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Room> result = new ResultMessage<Room>("OK","取得房间列表分页成功");
		result.setCount(Service.getCountByConditionandTypeWithPage(RoomNo, HouseTypeNo, DepartmentCode));
		result.setPage(Service.getpageConditionWithPage(RoomNo, HouseTypeNo, DepartmentCode, rows));
		result.setList(Service.getListByConditionWithPage(RoomNo, HouseTypeNo, DepartmentCode, rows, page));
		result.setPage(page);
		result.setRows(rows);
		return result;
	}
}
