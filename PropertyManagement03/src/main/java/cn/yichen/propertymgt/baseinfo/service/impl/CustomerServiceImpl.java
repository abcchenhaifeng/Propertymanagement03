package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.baseinfo.mapper.ICustomerMapper;
import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.service.ICustomerService;

/**
 * 
 * @date:2019年8月12日 上午10:28:35
 * @author LiYi(李海宏）
 * @description:客户业务层实现类
 */

@Service
@Transactional(rollbackFor = {Exception.class})
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerMapper mapper;

	@Override
	public void changePassword(String id, String password) throws Exception {
		Customer customer = mapper.selectCustomerById(id);
		customer.setPassword(password);
		mapper.update(customer);
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		Customer customer = mapper.selectCustomerById(id);
		if ( customer != null && customer.getPassword().equals(password) )
			return true;
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getListByAll(Customer customer) throws Exception {
		return mapper.selectListByAll(customer);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getListByAllWithPage(Customer customer, int page, int rows) throws Exception {
		return mapper.selectListByAllWithPage(customer, page, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll(Customer customer) throws Exception {
		return mapper.selectCountByAll(customer);
	}

	@Override
	@Transactional(readOnly = true)
	public Customer getCustomerById(String id) throws Exception {
		return mapper.selectCustomerById(id);
	}
	
	

	
}
