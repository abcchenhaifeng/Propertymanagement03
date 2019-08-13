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
	public ResultMessage<Customer> getListByAllWitPage(@RequestParam(required = false,defaultValue ="3") Integer rows,@RequestParam(required = false,defaultValue = "2") Integer page) throws Exception{
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得部门列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		//result.setList(service.getListByAllWithPage(rows, page));
		result.setList(service.getListByAllandHomeWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	// 获取用户
	@GetMapping("/get")
	public Customer get(String id) throws Exception {
		return service.getCustomerById(id);
	}

	// 用户登录
	@PostMapping("/login")
	public ResultMessage<Customer> login(String id, String password, HttpSession httpSession) throws Exception {
		
		boolean validate = false;
		Customer customer = service.getCustomerById(id);
		if ( customer != null && customer.getPassword().equals(password) )
			validate =  true;
		
		httpSession.setAttribute("login_user", customer);
		
		return new ResultMessage<Customer>(validate ? "OK" : "ERROR", validate ? "用户登录成功" : "用户登录失败");
	}
	
	// 用户退出
	@PostMapping("/logout")
	public ResultMessage<Customer> logout(String id, HttpSession httpSession) throws Exception {
		
		httpSession.removeAttribute("login_user");
		return new ResultMessage<Customer>("OK",  "用户注销成功");
	}
	
}
