package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;
import cn.yichen.propertymgt.baseinfo.model.Room;

/**
 * 
 * @date:2019年8月9日 上午10:11:48
 * @author LiYi(李海宏）
 * @description:客户房间类Mapper(Dao)层接口
 */

@Mapper
public interface ICustomerHomeMapper {

	// 添加
	public void create(CustomerHome chome) throws Exception;

	// 删除
	public void delete(CustomerHome chome) throws Exception;

	// 更新
	public void update(CustomerHome chome) throws Exception;

	// 根据id查询, 返回客户房间类型
	public CustomerHome selectCustomerHomeById(String id) throws Exception;
	
	// 获取客户房间列表
	public List<CustomerHome> selectListByAll() throws Exception;

	// 按条件获取客户房间列表(分页)
	public List<CustomerHome> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;

	// 按客户号查询房间信息
	public CustomerHome selectCustomerHomeByCustomerNo(int id) throws Exception;
	
	
	// 根据id查询, 在返回客户类型的同时返回缴费信息
	public CustomerHome selectCustomerHomeByIdWithRoomFee(int id) throws Exception;
	
	// 根据id查询, 在返回客户类型的同时返回房间信息
	public List<CustomerHome> selectListByAllWithRoom(int id) throws Exception;
	
	//取得所有房间列表,关联BuildingNo
	public List<CustomerHome> selectListByAllwithFK() throws Exception;
	
	//取得房间的个数
	public int selectCountByAll() throws Exception;
	//取得房间页数
	public int selectPageCountByAll(int rows) throws Exception;
	
	//取得迁居类型
	public List<CustomerHome> selectlivingStatus() throws Exception;
	
	//修改迁居类型为迁出
	public void modifyStatus(CustomerHome chome) throws Exception;
	
	//修改迁居类型为迁入
	public void updateStatus(CustomerHome chome) throws Exception;
	
	//检查指定序号，用于验证是否迁出
	public CustomerHome selectStatusByNO(int no) throws Exception;
	
}
