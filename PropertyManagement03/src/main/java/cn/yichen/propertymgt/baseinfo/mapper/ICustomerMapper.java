package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.admin.model.SystemModule;
import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.baseinfo.model.Customer;

/**
 * 
 * @date:2019年8月8日下午8:42:25
 * @author LiYi(李海宏)
 * @Description：实现客户类Mapper(Dao)层接口
 *
 */
@Mapper
public interface ICustomerMapper {

	    // 添加
		@Insert("insert into Customer(CustomerNo, TypeNo, Cname, Contact, CardCode, Mobile, Tel,Fax,QQ,WeiXin,FeeStartDate,FeeEndDate,Cstatus,Password) values(#{customerNo}, #{typeNo}, #{cname},#{contact}, #{cardcode}, #{mobile}, #{telephone}, #{fax},#{qq},#{wechat},#{feeStartDate},#{feeEndDate},#{cstatus},#{password)")
		public void create(Customer customer) throws Exception;

		// 删除
		@Delete("delete from Customer where CustomerNo = #{customerNo}")
		public void delete(String id) throws Exception;

		// 更新
		@Update("update Customer set TypeNo=#{typeNo}, Cname=#{cname}, Contact=#{contact}, CardCode=#{cardcode}, Mobile=#{mobile}, Tel=#{telephone}, Fax=#{fax}, QQ=#{qq}, WeiXin=#{wechat}, FeeStartDate=#{feeStartDate},FeeEndDate=#{feeEndDate},Cstatus=#{cstatus},Password=#{password}where CustomerNo=#{customerNo}")
		public void update(Customer customer) throws Exception;

		// 根据id查询, 返回客户
		public Customer selectCustomerById(String id) throws Exception;
		
		// 获取客户列表
		public List<Customer> selectListByAll() throws Exception;

		// 按条件获取客户列表(分页)
		public List<Customer> selectListByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
		
		// 根据id查询, 在返回客户的同时返回客户类型
		public Customer selectCustomerByIdWithType(String id) throws Exception;
		
		// 根据id查询, 在返回客户的同时返回客户房间
		public Customer selectCustomerByIdWithHome(String id) throws Exception;
		
		// 获取个数
		public int selectCountByAll() throws Exception;
		
		// 按条件获取客户列表(分页)
		public List<Customer> selectCustomerByAllandHomeWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
}


