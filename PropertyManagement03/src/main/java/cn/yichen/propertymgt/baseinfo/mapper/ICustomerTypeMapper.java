package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;
/**
 * 
 * @date:2019年8月9日 下午1:32:32
 * @author LiYi(李海宏）
 * @description：实现客户类型Dao层的接口
 */

@Mapper
public interface ICustomerTypeMapper {

	 // 添加
	//@Insert("insert into CustomerType(TYPENO, TYPENAME) values(#{typeno}, #{typename})")
	public void create(CustomerType ctype) throws Exception;

	// 删除
	//@Delete("delete from CustomerType where TYPENO = #{typeno}")
	public void delete(String id) throws Exception;

	// 更新
	//@Update("update CustomerType set TYPENAME=#{typename} where TYPENO=#{typeno}")
	public void update(CustomerType ctype) throws Exception;

	// 根据id查询, 返回客户类型
	public CustomerType selectCustomerTypeById(String id) throws Exception;
	
	// 获取客户类型列表
	public List<CustomerType> selectListByAll() throws Exception;

	// 按条件获取客户类型列表(分页)
	public List<CustomerType> selectListByAllWithPage(@Param("ctype") CustomerType ctype, @Param("start") int start, @Param("rows") int rows) throws Exception;

	// 根据id查询, 在返回客户类型的同时返回客户信息
	public CustomerType selectCustomerTypeByIdWithinfo(String id) throws Exception;

	
}
