package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.yichen.propertymgt.baseinfo.model.Room;

/**
 * 
 * @date:2019年8月18日下午7:57:53
 * @author LiYi(李海宏)
 * @Description：房间表dao接口
 *
 */
@Mapper
public interface IRoomMapper {
	//增加房间
	public void create(Room r) throws Exception;
	//修改房间
	public void update(Room r) throws Exception;
	//删除房间
	public void delete(Room r) throws Exception;
	//查询房间的信息
	public List<Room> selectRoomListByAll() throws Exception;
	//取得指定房间的信息
	public Room selectRoomByNo(int no) throws Exception;
	//取得所有房间列表,分页模式
	public List<Room> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得房间的个数
	public int selectCountByAll() throws Exception;
	//取得房间页数
	public int selectPageCountByAll(int rows) throws Exception;
	//取得所有房间列表,关联Building
	public List<Room> selectListByAllWithBuildingNo() throws Exception;
	//取得所有房间列表,关联HouseTypeNo
	public List<Room> selectListByAllWithHouseTypeNo() throws Exception;
	//根据类型编号取得此户型的房间
	public List<Room> selectListByHouseTypeNo(int housetypeno) throws Exception;
	//根据楼宇序号取得此序号的房间
	public List<Room> selectListByBuildingNo(int buildingno) throws Exception;
	//取得所有房间列表,关联BuildingNo
	public List<Room> selectListByAllwithFK() throws Exception;	
	//取得楼栋类型
	public List<Room> selectbuildingtype() throws Exception;
	//取得入住情况
	public List<Room> selectlivingStatus() throws Exception;
	
	//根据检索条件取得房间列表，无关联
	public List<Room> selectListByConditionWithPage(@Param("RoomNo") String RoomNo,@Param("HouseTypeNo") String HouseTypeNo,@Param("DepartmentCode") String DepartmentCode,@Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据检索条件取得房间的个数
	public int selectListByCondition(@Param("RoomNo") String RoomNo,@Param("HouseTypeNo") String HouseTypeNo,@Param("DepartmentCode") String DepartmentCode) throws Exception;
	//检查指定房间编号，用于验证房间是否存在
	public int selectCountByRoom(String roomno) throws Exception;
	
}
