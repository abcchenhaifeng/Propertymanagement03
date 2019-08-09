package cn.yichen.propertymgt.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	// [按条件]取得用户列表，有分页
	@GetMapping("/list")
	public ResultMessage<UserInfo> list(UserInfo userInfo,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {

		ResultMessage<UserInfo> result = new ResultMessage<UserInfo>("OK", "取得用户列表page: " + page + " -- rows: " + rows);
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		result.setList(service.getListByAllWithPage(userInfo, page, rows));
		result.setPage(page);
		result.setRows(rows);

		return result;
	}

	// 取得用户
	@GetMapping("/get")
	public UserInfo get(String id) throws Exception {
		return service.getUserById(id);
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
}
