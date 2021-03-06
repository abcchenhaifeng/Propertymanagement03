package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.Date;
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
		public void create(Customer customer) throws Exception;

		// 删除
		public void delete(Customer customer) throws Exception;

		// 更新
		public void update(Customer customer) throws Exception;

		// 根据id查询, 返回客户
		public Customer selectCustomerById(int id) throws Exception;
		
		// 获取客户列表
		public List<Customer> selectListByAll() throws Exception;

		// 按条件获取客户列表(分页)
		public List<Customer> selectListByAllWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
		
		// 根据id查询, 在返回客户的同时返回客户类型
		public Customer selectCustomerByIdWithType(int id) throws Exception;
		
		// 根据id查询, 在返回客户的同时返回客户房间
		public Customer selectCustomerByIdWithHome(String id) throws Exception;
		
		// 根据id查询, 在返回客户的同时返回客户类型
		public List<Customer> selectCustomerByAllWithType() throws Exception;
		
		// 根据id查询, 在分页返回客户的同时返回客户类型
		public List<Customer> selectCustomerByAllAndTypeWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
		
		// 获取个数
		public int selectCountByAll() throws Exception;
		
		
		//根据综合检索条件取得客户列表，取得关联的客户类型
		public List<Customer> selectListByConditionandTypeWithPage(@Param("CustomerName") String CustomerName,@Param("typeno") String typeno,@Param("feeStartDate") Date feeStartDate,@Param("feeEndDate") Date feeEndDate, @Param("start") int start,@Param("rows") int rows) throws Exception;
		//根据综合检索条件取得客户个数
		public int selectCountByCondition(@Param("CustomerName") String CustomerName,@Param("typeno") String typeno,@Param("feeStartDate") Date feeStartDate,@Param("feeEndDate") Date feeEndDate) throws Exception;
		//检查指定的员工姓名，用于验证员工是否存在
		public int selectCountByName(String cname) throws Exception;
		
		
		public List<Customer> selectCustomerByAllAndFk() throws Exception;
		
		// 根据id查询, 在分页返回客户的同时返回客户类型
		public List<Customer> selectCustomerByAllAndFkWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
		// 按条件获取客户列表(分页)
		//public List<Customer> selectCustomerByAllandHomeWithPage(@Param("start") int start, @Param("rows") int rows) throws Exception;
		
		//根据综合检索条件取得客户列表，取得关联的客户类型
		//areanname, departmentcode, roomno, livedate,roomstatus,chstatus
		public List<Customer> selectListByConditionandFKWithPage(@Param("areanname") String areanname,@Param("departmentcode") String departmentcode,@Param("roomno") String roomno,@Param("livedate") Date livedate,@Param("roomstatus") String roomstatus,@Param("chstatus") String chstatus,@Param("start") int start,@Param("rows") int rows) throws Exception;
		//根据综合检索条件取得客户个数
		public int selectCountByConditionWithFK(@Param("areanname") String areanname,@Param("departmentcode") String departmentcode,@Param("roomno") String roomno,@Param("livedate") Date livedate,@Param("roomstatus") String roomstatus,@Param("chstatus") String chstatus) throws Exception;
}



