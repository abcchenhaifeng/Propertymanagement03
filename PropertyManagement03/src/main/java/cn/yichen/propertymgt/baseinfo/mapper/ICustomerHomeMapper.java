package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.CustomerHome;

/**
 * 
 * @date:2019年8月9日 上午10:11:48
 * @author LiYi(李海宏）
 * @description:客户房间类Mapper(Dao)层接口
 */

@Mapper
public interface ICustomerHomeMapper {

	 // 添加
	@Insert("insert into CustomerHome(CHNO, CustomerNo, RoomNo, LivingTypeNo, ReceiveDate, LiveDate, FeeStartDate,FeeEndDate,HumanCount,CHStatus) values(#{chno}, #{customerno}, #{roomno},#{livingtypeno}, #{receivedate}, #{livedate}, #{feestartdate}, #{feeenddate},#{humancount},#{chstatus})")
	public void create(CustomerHome chome) throws Exception;

	// 删除
	@Delete("delete from CustomerHome where CHNO = #{chno}")
	public void delete(String id) throws Exception;

	// 更新
	@Update("update CustomerHome set CustomerNo=#{customerno}, RoomNo=#{roomno}, LivingTypeNo=#{livingtypeno}, ReceiveDate=#{receivedate}, LiveDate=#{livedate},FeeStartDate=#{feestartdate},FeeEndDate=#{feeenddate},HumanCount=#{humancount},CHStatus=#{chstatus} where CHNO=#{chno}")
	public void update(CustomerHome chome) throws Exception;

	// 根据id查询, 返回客户
	public CustomerHome selectCustomerHomeById(String id) throws Exception;
	
	// 获取客户列表
	public List<CustomerHome> selectListByAll(CustomerHome chome) throws Exception;

	// 按条件获取客户列表(分页)
	public List<CustomerHome> selectListByAllWithPage(@Param("chome") CustomerHome chome, @Param("start") int start, @Param("rows") int rows) throws Exception;

	
	
}
