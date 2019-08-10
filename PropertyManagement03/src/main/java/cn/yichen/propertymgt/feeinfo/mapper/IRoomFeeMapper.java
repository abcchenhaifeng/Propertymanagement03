package cn.yichen.propertymgt.feeinfo.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.format.annotation.DateTimeFormat;

import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.feeinfo.model.RoomFee;

/**
 * 
 * @date:2019年8月10日下午9:53:36
 * @author LiYi(李海宏)
 * @Description：房间缴费Mapper(Dao)层接口
 *
 */
@Mapper
public interface IRoomFeeMapper {
    

	// 添加
	@Insert("insert into RoomFee(RoomFeeNo, FeeYEAR, FeeMonth, RoomNo,FeeItemNo, SPay, Apay, Derate,StartDate,EndDate,FeeStatus) values(#{roomfeeno}, #{feeyear}, #{feemonth}, #{roomno}, #{feeitemno}, #{spay}, #{apay},#{derate},#{startdate},#{enddate},#{feestatus})")
	public void create(RoomFee roomfee) throws Exception;

	// 删除
	@Delete("delete from RoomFee where RoomFeeNo = #{roomfeeno}")
	public void delete(String id) throws Exception;

	// 更新
	@Update("update RoomFee set  FeeYEAR = #{feeyear}, FeeMonth = #{feemonth}, RoomNo = #{roomno}, FeeItemNo = #{feeitemno}, SPay = #{spay},Apay = #{apay},Derate = #{derate},StartDate = #{startdate},EndDate = #{enddate},FeeStatus = #{feestatus} where RoomFeeNo = #{roomfeeno}")
	public void update(RoomFee roomfee) throws Exception;

	// 根据id查询, 返回用户
	public RoomFee selectRoomFeeById(String id) throws Exception;

	// 获取用户列表
	public List<RoomFee> selectListByAll(@Param("RoomFee") RoomFee roomfee) throws Exception;

	// 按条件获取用户列表(分页)
	public List<RoomFee> selectListByAllWithPage(@Param("roomfee") RoomFee roomfee, @Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByAll(@Param("RoomFee") RoomFee roomfee) throws Exception;
	
	// 根据id查询, 在返回客户类型的同时返回缴费信息
	public RoomFee selectRoomFeeByIdWithCustomerHome(String id) throws Exception;

}
