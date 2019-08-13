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
	@Transactional(readOnly = true)
	public List<Customer> getListByAll() throws Exception {
		return mapper.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getListByAllWithPage(int page, int rows) throws Exception {
		return mapper.selectListByAllWithPage( rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll( ) throws Exception {
		return mapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer getCustomerById(String id) throws Exception {
		return mapper.selectCustomerById(id);
	}

	//取得部门页数
	@Override
	@Transactional(readOnly = true)
	public int getPagaCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<Customer> getListByAllandTypeWithPage(int rows, int page) throws Exception {
		return mapper.selectCustomerByAllAndTypeWithPage(rows*(page-1), rows);
	}

	@Override
	public void add(Customer customer) throws Exception {
		//增加
		mapper.create(customer);
		
	}

//	@Override
//	@Transactional(readOnly = true)
//	public List<Customer> getListByAllandHomeWithPage(int page, int rows) throws Exception {
//		return mapper.selectCustomerByAllandHomeWithPage(rows*(page-1), rows);
//	}


	
}
