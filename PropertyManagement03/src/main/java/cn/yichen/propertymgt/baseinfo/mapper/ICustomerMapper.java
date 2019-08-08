package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.baseinfo.model.Customer;

/**
 * 
 * @date:2019年8月8日下午8:42:25
 * @author LiYi(李海宏)
 * @Description：实现客户Mapper(Dao)层接口
 *
 */
@Mapper
public interface ICustomerMapper {

	    // 添加
		@Insert("insert into Customer(CustomerNo, TypeNo, Cname, Contact, CardCode, Mobile, Tel,Fax,QQ,WeiXin,FeeStartDate,FeeEndDate,Cstatus) values(#{customerNo}, #{typeNo}, #{cname},#{contact}, #{cardcode}, #{mobile}, #{telephone}, #{fax},#{qq},#{wechat},#{feeStartDate},#{feeEndDate},#{cstatus})")
		public void create(Customer customer) throws Exception;

		// 删除
		@Delete("delete from Customer where CustomerNo = #{customerNo}")
		public void delete(String id) throws Exception;

		// 更新
		@Update("update Customer set TypeNo=#{typeNo}, Cname=#{cname}, Contact=#{contact}, CardCode=#{cardcode}, Mobile=#{mobile}, Tel=#{telephone}, Fax=#{fax}, QQ=#{qq}, WeiXin=#{wechat}, FeeStartDate=#{feeStartDate},FeeEndDate=#{feeEndDate},Cstatus=#{cstatus} where CustomerNo=#{customerNo}")
		public void update(Customer customer) throws Exception;

		// 根据id查询, 返回客户
		public Customer selectCustomerById(String id) throws Exception;
		
		// 获取客户列表
		public List<Customer> selectListByAll(Customer customer) throws Exception;

		// 按条件获取客户列表(分页)
		public List<Customer> selectListByAllWithPage(@Param("customer") Customer customer, @Param("start") int start, @Param("rows") int rows) throws Exception;
	
}
