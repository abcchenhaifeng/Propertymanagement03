package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;

/**
 * 
 * @date:2019年8月8日下午9:28:41
 * @author LiYi(李海宏)
 * @Description：客户类型业务层接口
 *
 */
public interface ICustomerTypeService {

	
	// 按条件获取客户列表
	public List<CustomerType> getListByAll() throws Exception;

}
