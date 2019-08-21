package cn.yichen.propertymgt.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.admin.service.impl.UserInfoServiceImpl;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date 2019年8月9日 下午2:51:57
 * @author YiChen(李冠永)
 * @Description 系统操作员控制层实现
 *
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl service;
	
	@Autowired
	@Qualifier("u-key")
	private ThreadLocal<String> threadlocal_ukey;

	// [按条件]取得用户列表,有分页
	@GetMapping("/list")
	public ResultMessage<UserInfo> list(UserInfo userInfo, Integer startAge, Integer endAge,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {

		ResultMessage<UserInfo> result = new ResultMessage<UserInfo>("OK", "取得用户列表page: " + page + " -- rows: " + rows);
			
		int count = service.getCountByCriteria(userInfo, startAge, endAge);
		int pageCount = (count%rows==0 && count>=rows ? count/rows : count/rows+1);
		
		result.setCount(count);
		result.setPageCount(pageCount);
		result.setList(service.getListByCriteriaWithPage(userInfo, page, rows, startAge, endAge));
		result.setPage(page);
		result.setRows(rows);

		return result;
	}
	
	// 获取用户
	@GetMapping("/get")
	public ResultMessage<UserInfo> get(String id, 
			@RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
		ResultMessage<UserInfo> result = new ResultMessage<UserInfo>("OK", "取得用户详情");
		
		UserInfo userInfo = service.getUserByIdWithoutOther(id);
		int count = 0;
		int pageCount = 0;
		if ( userInfo != null ) {
			count = userInfo.getFunctions() == null ? 0 : userInfo.getFunctions().size();
			pageCount = (count%rows==0 && count>=rows ? count/rows : count/rows+1);
		}
		
		result.setCount(count);
		result.setPageCount(pageCount);
		result.setModel(userInfo);
		result.setRows(rows);
		
		return result;
	}
	
	// 获取用户
	@GetMapping("/get/function")
	public ResultMessage<UserInfo> getWithFunction(String id) throws Exception {
		ResultMessage<UserInfo> result = new ResultMessage<UserInfo>("OK", "取得用户详情");
		result.setModel(service.getUserByIdWithFunction(id));
		return result;
	}

	// 增加用户
	@PostMapping("/add")
	public ResultMessage<UserInfo> add(UserInfo userInfo) throws Exception {
		service.add(userInfo);
		return new ResultMessage<UserInfo>("OK", "增加用户成功");
	}

	// 修改用户
	@PostMapping("/modify")
	public ResultMessage<UserInfo> modify(UserInfo userInfo) throws Exception {
		service.modify(userInfo);
		return new ResultMessage<UserInfo>("OK", "修改用户成功");
	}

	// 冻结用户
	@PostMapping("/frozen")
	public ResultMessage<UserInfo> frozen(String id) throws Exception {
		service.frozen(id);
		return new ResultMessage<UserInfo>("OK", "冻结用户成功");
	}
	
	// 激活用户
	@PostMapping("/active")
	public ResultMessage<UserInfo> active(String id) throws Exception {
		service.active(id);
		return new ResultMessage<UserInfo>("OK", "激活用户成功");
	}
	
	// 用户登录
	@PostMapping("/login")
	public ResultMessage<UserInfo> login(String id, String password) throws Exception {
		
		System.out.println("login");
		System.out.println(threadlocal_ukey);
		
		boolean validate = false;
		UserInfo userInfo = service.getUserById(id);
		if ( userInfo != null && userInfo.getPassword().equals(password) )
			validate =  true;
		
		if ( !validate ) throw new Exception("登录失败"); 
		
		String ukey = "k-uuu5556yyyc";
		threadlocal_ukey.set(ukey);
		
		return new ResultMessage<UserInfo>("OK", ukey);
	}
	
	// 用户退出
	@PostMapping("/logout")
	public ResultMessage<UserInfo> logout(String id, HttpSession httpSession) throws Exception {
		
		httpSession.removeAttribute("login_user");
		return new ResultMessage<UserInfo>("OK",  "用户注销成功");
	}
	
	// 添加功能
	@PostMapping("/add/function")
	public ResultMessage<UserInfo> addFunction(String id, int funNo) throws Exception {
		service.addFunction(id, funNo);
		return new ResultMessage<UserInfo>("OK",  "添加功能成功");
	}
	
	// 批量添加功能
	@PostMapping("/add/functions")
	public ResultMessage<UserInfo> addFunctions(String id, int[] funNos) throws Exception {
		service.addFunctions(id, funNos);
		return new ResultMessage<UserInfo>("OK",  "批量添加功能成功");
	}
	
	// 删除功能
	@PostMapping("/delete/function")
	public ResultMessage<UserInfo> deleteFunction(String id, int funNo) throws Exception {
		service.deleteFunction(id, funNo);
		return new ResultMessage<UserInfo>("OK",  "删除功能成功");
	}
}
