package cn.yichen.propertymgt.baseinfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.service.impl.CustomerServiceImpl;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date:2019年8月12日 上午10:53:29
 * @author LiYi(李海宏）
 * @description:客户类控制层实现
 * 
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl service;

	/*
	// [按条件]取得用户列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Customer> list(
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {

		
		 ResultMessage<Customer> result = new ResultMessage<Customer>("OK",
		 "取得用户列表page: " + page + " -- rows: " + rows);
		 
		 int count = service.getCountByAll(); 
		 int pageCount = (count%rows==0
		 && count>rows ? count/rows : count/rows+1);
		 
		 result.setCount(count); 
		 result.setPageCount(pageCount);
		 result.setList(service.getListByAllWithPage(page, rows));
		 result.setPage(page); 
		 result.setRows(rows);
		  
		 return result;

		
	}
*/

	
	//取得所有部门列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Customer> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") Integer rows,@RequestParam(required = false,defaultValue = "1") Integer page) throws Exception{
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得部门列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		//result.setList(service.getListByAllWithPage(rows, page));
		//result.setList(service.getListByAllandHomeWithPage(rows, page));
		result.setList(service.getListByAllandTypeWithPage(rows,page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	// 获取用户
	@GetMapping("/get")
	public Customer get(String id) throws Exception {
		return service.getCustomerById(id);
	}
	
	
	//增加部门
	@RequestMapping("/add")
	public ResultMessage<Customer> add(Customer customer) throws Exception {
		service.add(customer);
		return new ResultMessage<Customer>("OK","增加部门成功");
	}
	
	/*
	//修改部门
	@PostMapping("/modify")
	public ResultMessage<Customer> modify(Customer customer) throws Exception {
		service.modify(customer);
		return new ResultMessage<Customer>("OK","修改部门成功");
	}
	//删除部门
	@PostMapping("/delete")
	public ResultMessage<Customer> delete(Customer customer) throws Exception {
		service.delete(customer);
		return new ResultMessage<Customer>("OK","删除部门成功");
	}
	//取得指定的部门
	@GetMapping("/get")
	public ResultMessage<Customer> getByNo(int no) throws Exception{
		
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得部门成功");
		result.setModel(service.getByNo(no));
		return result;
		
	}
	*/
}
