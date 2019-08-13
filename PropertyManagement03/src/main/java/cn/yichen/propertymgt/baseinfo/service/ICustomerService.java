package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;


import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.baseinfo.model.Customer;

/**
 * 
 * @date:2019年8月8日下午9:28:41
 * @author LiYi(李海宏)
 * @Description：客户业务层接口
 *
 */
public interface ICustomerService {

	
	// 按条件获取客户列表
	public List<Customer> getListByAll() throws Exception;

	// 按条件获取客户列表(分页)
	public List<Customer> getListByAllWithPage( int page, int rows) throws Exception;
	
	// 获取个数
	public int getCountByAll() throws Exception;
	
	// 按ID获取用户
	public Customer getCustomerById(String id) throws Exception;
	
	//取得部门页数
	public int getPagaCountByAll(int rows) throws Exception;
	
	// 按条件获取客户列表(分页)
	//public List<Customer> getListByAllandHomeWithPage( int page, int rows) throws Exception;
	
	
	// 按条件获取客户列表(分页)
	public List<Customer> getListByAllandTypeWithPage( int page, int rows) throws Exception;
	
	//增加
	public void add(Customer department) throws Exception;

}
