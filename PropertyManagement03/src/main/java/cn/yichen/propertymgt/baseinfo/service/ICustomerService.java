package cn.yichen.propertymgt.baseinfo.service;

import cn.yichen.propertymgt.baseinfo.model.Customer;

/**
 * 
 * @date:2019年8月8日下午9:28:41
 * @author LiYi(李海宏)
 * @Description：客户业务层接口
 *
 */
public interface ICustomerService {

	//注册用户
	public void register(Customer customer) throws Exception;
	
	//修改用户
	public void modify(Customer customer) throws Exception;
}
