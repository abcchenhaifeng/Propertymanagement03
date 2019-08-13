package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import cn.yichen.propertymgt.baseinfo.model.Room;

/**
 * 
 * @data:2019年8月12日下午9:24:12
 * @author： 陈海锋
 * @Description:房间类Mapper(Dao)层接口
 *
 */
@Mapper
public interface IRoomMapper {
	// 添加
	@Insert("insert into Room(ROOMNO,HouseTypeNo,BuildingNo,DepartmentCode,Floor,RoomCode,BuildingArea,FeeArea,RoomStatus,RoomType) values(#{roomno},#{housetypeNo},#{buildingno},#{departmentcode},#{floor},#{roomcode},#{buildingarea},#{feearea},#{roomstatus},#{roomtype})")
	public void create (Room room) throws Exception;
	
	//删除
	@Delete("delete from Room where ROOMNO = #{roomno}")
	public void delete (String id) throws Exception;
	
	//更新
	@Update("update Room set HouseTypeNo=#{housetypeno},BuildingNo=#{buildingno},DepartmentCode=#{departmentcode},Floor=#{floor},RoomCode={roomcode},BuildingArea=#{building},FeeArea=#{feearea},RoomStatus=#{roomstatus},RoomType=#{roomtype} where ROOMNO=#{roomno}")
	public void update () throws Exception;
	
	// 根据id查询, 返回客户
	public Room selectRoomById(String id) throws Exception;
	
	// 获取客户列表
	public List<Room> selectListByAll(Room room) throws Exception;
}
