package cn.yichen.propertymgt.baseinfo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
@EnableWebMvc
@CrossOrigin
public class CustomerController {
	@Autowired
	private CustomerServiceImpl service;
	
	//取得所有部门列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Customer> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") Integer rows,@RequestParam(required = false,defaultValue = "1") Integer page) throws Exception{
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得部门列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		result.setList(service.getListByAllandTypeWithPage(rows,page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	
	//取得所有部门列表，有分页
	@GetMapping(value="/list/allwithFK/page")
	public ResultMessage<Customer> getListByAllandFKWithPage(@RequestParam(required = false,defaultValue ="0") Integer rows,@RequestParam(required = false,defaultValue = "0") Integer page) throws Exception{
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得客户迁入迁出列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		result.setList(service.getListByAllandFKWithPage(rows,page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	@GetMapping(value="/list/all")
	public List<Customer> getListByAllandType() throws Exception{
		
		return service.getListByAllandType();
	}
	
	@GetMapping(value="/list/allFK")
	public List<Customer> getListByAllandFk() throws Exception{
		
		return service.getListByAllandFk();
	}
	
	//按检索条件取得员工列表
	@GetMapping(value="/list/condition/page")
	public ResultMessage<Customer> getListByConditionWitPage(@RequestParam(required = false,defaultValue ="") String CustomerName,@RequestParam(required = false,defaultValue ="0") String typeno,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date feeStartDate,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date feeEndDate, @RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得客户列表分页成功");
		result.setCount(service.getCountByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate));
		result.setPageCount(service.getPageCountByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate, rows));
		result.setList(service.getListByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate, rows, page));
		result.setPage(page);	
		result.setRows(rows);	
		return result;
		}

//	//按检索条件取得员工列表
//	@GetMapping(value="/list/conditionwithFk/page")
//	public ResultMessage<Customer> getListByConditionAndFKkWithPage(@RequestParam(required = false,defaultValue ="") String CustomerName,@RequestParam(required = false,defaultValue ="0") String typeno,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date feeStartDate,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date feeEndDate, @RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
//		
//		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","取得客户列表分页成功");
//		result.setCount(service.getCountByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate));
//		result.setPageCount(service.getPageCountByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate, rows));
//		result.setList(service.getListByConditionandTypeWithPage(CustomerName, typeno, feeStartDate, feeEndDate, rows, page));
//		result.setPage(page);	
//		result.setRows(rows);	
//		return result;
//		}
	
	//增加客户
	@RequestMapping(value="/add")
	public ResultMessage<Customer> add(Customer customer) throws Exception {
		service.add(customer);
		return new ResultMessage<Customer>("OK","增加客户成功");
	}
	
	
	//取得指定的客户
	@GetMapping("/get")
	public Customer getByNo(int no) throws Exception{	
		return service.getCustomerById(no);
		
	}

	//修改客户
	@PostMapping("/modify")
	public ResultMessage<Customer> modify(Customer customer) throws Exception {
		service.modify(customer);
		return new ResultMessage<Customer>("OK","修改客户信息成功");
	}
	
	
	//删除客户
	@PostMapping("/delete")
	public ResultMessage<Customer> delete(Customer customer) throws Exception {
		service.delete(customer);
		return new ResultMessage<Customer>("OK","删除客户成功");
	}
	
	
	//检查此部门能否被删除
	@GetMapping(value="/checkDelete")
	public ResultMessage<Customer> checkForDelete(int no) throws Exception{
		ResultMessage<Customer> result=new ResultMessage<Customer>("OK","此客户信息可以删除");
		if(!service.checkCanDelete(no)) {
			result.setStatus("NO");
			result.setMessage("此客户不能删除");
		}
		return result;
	}
		
	//验证员工姓名是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查员工是否已经存在
		@GetMapping(value="/checkidexist")
		public boolean checkIdExist(String cname) throws Exception{
			return !service.checkIdExist(cname);
		}
}
