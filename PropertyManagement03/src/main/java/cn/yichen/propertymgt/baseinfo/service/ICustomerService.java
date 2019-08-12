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

	// 修改密码
	public void changePassword(String id, String password) throws Exception;

	// 检验合法性
	public boolean validate(String id, String password) throws Exception;

	
	// 按条件获取客户列表
	public List<Customer> getListByAll(Customer customer) throws Exception;

	// 按条件获取客户列表(分页)
	public List<Customer> getListByAllWithPage(Customer customer, int page, int rows) throws Exception;
	
	// 获取个数
	public int getCountByAll(Customer customer) throws Exception;
	
	// 按ID获取用户
	public Customer getCustomerById(String id) throws Exception;
}
