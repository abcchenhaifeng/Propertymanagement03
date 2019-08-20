package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.baseinfo.service.ICustomerHomeService;
import cn.yichen.propertymgt.baseinfo.service.ICustomerHomeService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date:2019年8月9日 下午1:39:47
 * @author LiYi(李海宏）
 * @description:
 */

@RestController
@RequestMapping("/customerhome")
public class CustomerHomeController {

	@Autowired
	private ICustomerHomeService Service=null;
	
	//增加房间
	@GetMapping("/add")
	public ResultMessage<CustomerHome> add(CustomerHome ch) throws Exception {
		Service.add(ch);
		return new ResultMessage<CustomerHome>("OK","增加房间成功");
	}
	//修改房间
	@GetMapping("/modify")
	public ResultMessage<CustomerHome> modify(CustomerHome ch) throws Exception {
		Service.modify(ch);
		return new ResultMessage<CustomerHome>("OK","修改房间成功");
	}
	
	//修改房间
	@PostMapping("/moveout")
	public ResultMessage<CustomerHome> modifystatus(CustomerHome ch) throws Exception {
		Service.modifyStatus(ch);
		return new ResultMessage<CustomerHome>("OK","修改迁居状态为迁出成功");
	}
	
	@PostMapping("/movein")
	public ResultMessage<CustomerHome> updatestatus(CustomerHome ch) throws Exception {
		Service.updateStatus(ch);
		return new ResultMessage<CustomerHome>("OK","修改迁居状态为迁入成功");
	}
		
	//检查此客户能否迁出
	@GetMapping(value="/check")
	public ResultMessage<CustomerHome> check(CustomerHome ch) throws Exception{
		ResultMessage<CustomerHome> result=new ResultMessage<CustomerHome>("OK","此客户当前状态可以迁出");
//		if(!service.checkCanDelete(no)) {
//			result.setStatus("NO");
//			result.setMessage("此客户不能删除");
//		}
		if(!Service.checkCanModify(ch))
		{
			result.setStatus("NO");
			result.setMessage("此客户不能迁出");
		}
		return result;
	}
	
	
	//删除房间
	@GetMapping("/delete")
	public ResultMessage<CustomerHome> delete(CustomerHome ch) throws Exception {
		Service.delete(ch);
		return new ResultMessage<CustomerHome>("OK","删除房间成功");
	}
	//取得指定的房间
	@GetMapping("/get")
	public CustomerHome getByCustomerNo(int CustomerHomeno) throws Exception{
		return Service.getCustomerHomeByNo(CustomerHomeno);
	}
	//取得所有房间列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<CustomerHome> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<CustomerHome> result=new ResultMessage<CustomerHome>("OK","取得房间列表分页模式成功");
		result.setCount(Service.getCountByAll());
		result.setPageCount(Service.getPageCountByAll(rows));
		result.setList(Service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有房间列表，无分页
	@GetMapping(value="/list/all")
	public List<CustomerHome> getListByAll() throws Exception{
		return Service.getListByAll();
	}
	
	//取得所有房间列表,有外键，无分页
	@GetMapping(value="/list/allfk")
	public List<CustomerHome> getListByAllWithFK() throws Exception{
		return Service.getListByAllWithFK();
	}
	
	//取得所有房间列表,有外键，无分页
	@GetMapping(value="/livingstatus")
	public List<CustomerHome> getlivingstatus() throws Exception{
		return Service.getLivingStatus();
	}
	
}
