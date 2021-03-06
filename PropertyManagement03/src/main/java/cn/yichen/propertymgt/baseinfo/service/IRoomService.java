package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.Room;
/**
 * 
 * @data:2019年8月22日下午8:25:50
 * @author： 陈海锋
 * @Description:
 *
 */
public interface IRoomService {
	//增加
	public void add(Room room) throws Exception;
	//修改
	public void modify(Room room) throws Exception;
	//删除
	public void delete(Room room) throws Exception;
	//取得所有房间列表
	public List<Room> getListByAll() throws Exception;
	
	public List<Room> getListByAllWithFK() throws Exception;
	
	//取得房间单个对象，
	public Room getByRoomNo(int roomno) throws Exception;
	//取得所有房间列表,分页模式
	public List<Room> getListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得房间的个数
	public int getCountByAll() throws Exception;
	//取得房间页数
	public int getPageCountByAll(int rows) throws Exception;
	//取得所有房间列表,关联HouseTypeNo
	public List<Room> getListByAllWithHouseTypeNo() throws Exception;
	//取得所有房间列表,关联BuildingNo
	public List<Room> getListByAllWithBuildingNo() throws Exception;
	//根据类型编号取得此户型的房间
	public List<Room> getListByHouseTypeNo(int housetypeno) throws Exception;
	//根据楼宇序号取得此序号的房间
	public List<Room> getListByBuildingNo(int buildingno) throws Exception;
	//获取当前房间的楼栋号
	public List<Room> getBuildingNo() throws Exception;
	//获得当前房间的入住情况
	public List<Room> getlivingStatus() throws Exception;
	
	//根据检索条件取得房间列表，无关联
	public List<Room> getListByConditionWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode,int rows,int page) throws Exception;
	////根据综合检索条件取得房间个数
	public int getCountByConditionandTypeWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode) throws Exception;
	//根据检索的条件取得房间个数
	public int getpageConditionWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode,int rows) throws Exception; 
	
	//验证房间是否存在
	public boolean checkRoomNoExist(String roomno) throws Exception;
}
