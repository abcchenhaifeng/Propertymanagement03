package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.Date;
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
	public Customer getCustomerById(int id) throws Exception {
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

	@Override
	public void modify(Customer customer) throws Exception {
		mapper.update(customer);
		
	}

	@Override
	public void delete(Customer customer) throws Exception {
		mapper.delete(customer);
		
	}

	@Override
	public boolean checkCanDelete(int no) throws Exception {
		boolean result=true;
//		if(mapper.selectCountByCondition(no,"", "", "", "")>0) {
//			result=false;
//		}
		
		return result;
	}

	@Override
	public List<Customer> getListByAllandType() throws Exception {
		return mapper.selectCustomerByAllWithType();
	}

	
//	@Override
//	public List<EmployeeModel> getListByConditionWithDepartmentWithoutRolesWithPage(int departmentNo, int roleNo,
//			String sex, Date startJoinDate, Date endJoinDate, int rows, int page) throws Exception {
//		
//		return employeeMapper.selectListByConditionWithDepartmentNoAndRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate, rows*(page-1), rows);
//	}

	
	
	
	
	@Override
	public List<Customer> getListByConditionandTypeWithPage(String CustomerName, String typeno, Date feeStartDate,
			Date feeEndDate, int rows, int page) throws Exception {
		return mapper.selectListByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate,rows*(page-1), rows);
	}

//	@Override
//	public int getPageCountByConditionWithDepartmentNoAndRolesWithPage(int departmentNo, int roleNo, String sex,
//			Date startJoinDate, Date endJoinDate, int rows) throws Exception {
//		int pageCount=0;
//		int count=this.getCountByConditionWithDepartmentNoAndRolesWithPage(departmentNo, roleNo, sex, startJoinDate, endJoinDate);
//		if(count%rows==0) {
//			pageCount=count/rows;
//		}
//		else {
//			pageCount=count/rows+1;
//		}
//		return pageCount;
//	}	
	
	
	@Override
	public int getPageCountByConditionandTypeWithPage(String CustomerName, String typeno, Date feeStartDate,
			Date feeEndDate, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}
	
//	@Override
//	public int getCountByConditionWithDepartmentNoAndRolesWithPage(int departmentNo, int roleNo,
//			String sex, Date startJoinDate, Date endJoinDate) throws Exception {
//		
//		return employeeMapper.selectCountByCondition(departmentNo, roleNo, sex, startJoinDate, endJoinDate);
//	}
	@Override
	public int getCountByConditionandTypeWithPage(String CustomerName, String typeno, Date feeStartDate, Date feeEndDate)
			throws Exception {
		return mapper.selectCountByCondition(CustomerName, typeno, feeStartDate, feeEndDate);
	}
	
	
	}



	
//	@Override
//	@Transactional(readOnly = true)
//	public List<Customer> getListByAllandHomeWithPage(int page, int rows) throws Exception {
//		return mapper.selectCustomerByAllandHomeWithPage(rows*(page-1), rows);
//	}


