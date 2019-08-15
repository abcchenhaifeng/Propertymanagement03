package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	@Insert("insert into Room(ROOMNO,HouseTypeNo,BuildingNo,DepartmentCode,Floor,RoomCode,BuildingArea,FeeArea,RoomStatus,RoomType) values(#{roomno},#{housetypeno},#{buildingno},#{departmentcode},#{floor},#{roomcode},#{buildingarea},#{feearea},#{roomstatus},#{roomtype})")
	public void create (Room room) throws Exception;
	
	//删除
	@Delete("delete from Room where ROOMNO = #{roomno}")
	public void delete(String id) throws Exception;
	
	//更新
	@Update("update Room set HouseTypeNo=#{housetypeno},BuildingNo=#{buildingno},DepartmentCode=#{departmentcode},Floor=#{floor},RoomCode=#{roomcode},BuildingArea=#{buildingarea},FeeArea=#{feearea},RoomStatus=#{roomstatus},RoomType=#{roomtype} where ROOMNO=#{roomno}")
	public void update (Room room) throws Exception;
	
	// 根据id查询, 返回房间
	public Room selectRoomById(String id) throws Exception;
	
	// 根据id查询, 返回房间功能
	public Room selectRoomByIdWithFunctions(String id);
	
	//取得房间的单个对象，同时取得关联的对象
	public Room selectByNo(int roomno) throws Exception;
	
	// 获取房间列表
	public List<Room> selectListByAll()throws Exception;

	//按照楼宇编号来查询楼宇的信息
	public Room selectRomByBuildingNo(String id) throws Exception;
	
	//按条件获取房间列表（分页）
	public List<Room> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	
	//取房间的页数
	public int selectCountByAll(int rows) throws Exception;

	
}
