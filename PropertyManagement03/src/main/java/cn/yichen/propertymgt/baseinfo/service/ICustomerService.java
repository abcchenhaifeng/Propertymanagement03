package cn.yichen.propertymgt.baseinfo.service;

import java.util.Date;
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
	public Customer getCustomerById(int id) throws Exception;
	
	//取得部门页数
	public int getPagaCountByAll(int rows) throws Exception;
	
	// 按条件获取客户列表(分页)
	//public List<Customer> getListByAllandHomeWithPage( int page, int rows) throws Exception;
	public List<Customer> getListByAllandType() throws Exception;
	
	// 按条件获取客户列表(分页)
	public List<Customer> getListByAllandTypeWithPage( int page, int rows) throws Exception;
	
	
	//根据综合检索条件取得客户列表，取得关联的客户类型，分页模式
	public List<Customer> getListByConditionandTypeWithPage(String CustomerName,String typeno,Date feeStartDate,Date feeEndDate,int rows,int page) throws Exception;
	//根据综合检索条件取得客户个数
	public int getCountByConditionandTypeWithPage(String CustomerName,String typeno,Date feeStartDate,Date feeEndDate) throws Exception;
	//根据综合检索条件取得客户显示的页数
	public int getPageCountByConditionandTypeWithPage(String CustomerName,String typeno,Date feeStartDate,Date feeEndDate,int rows) throws Exception;
	
	//根据综合检索条件取得客户列表，取得关联的客户类型，分页模式
	//areanname, departmentcode, roomno, livedate,roomstatus,chstatus
	public List<Customer> getListByConditionandFKWithPage(String areanname,String departmentcode,String roomno,Date livedate,String roomstatus,String chstatus,int rows,int page) throws Exception;
	//根据综合检索条件取得客户个数
	public int getCountByConditionandFKWithPage(String areanname,String departmentcode,String roomno,Date livedate,String roomstatus,String chstatus) throws Exception;
	//根据综合检索条件取得客户显示的页数
	public int getPageCountByConditionandFKWithPage(String areanname,String departmentcode,String roomno,Date livedate,String roomstatus,String chstatus,int rows) throws Exception;
	
	//验证员工姓名是否存在
	public  boolean checkIdExist(String cname) throws Exception;	
	
	//增加
	public void add(Customer customer) throws Exception;
	
	//修改
	public void modify(Customer customer) throws Exception;
	//删除
	public void delete(Customer customer) throws Exception;
	//检查部门能否被删除
	public boolean checkCanDelete(int no) throws Exception;
	
	//查看关联客户的小区、楼宇等信息
	public List<Customer> getListByAllandFk() throws Exception;
	
	// 按条件获取客户列表(分页)
	public List<Customer> getListByAllandFKWithPage( int page, int rows) throws Exception;

}
