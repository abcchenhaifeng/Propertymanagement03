package cn.yichen.propertymgt.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.admin.model.SystemModule;
import cn.yichen.propertymgt.admin.service.impl.SystemModuleServiceImpl;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date: 2019年8月9日 下午9:50:31
 * @author: YiChen(李冠永)
 * @Description: 系统模块控制层实现
 *
 */
@RestController
@RequestMapping("/module")
public class SystemModuleController {

	@Autowired
	private SystemModuleServiceImpl service;

	// [按条件]取得列表
	@GetMapping("/list")
	public ResultMessage<SystemModule> list(SystemModule systemModule) throws Exception {

		ResultMessage<SystemModule> result = new ResultMessage<SystemModule>("OK", "取得系统模块列表");
		result.setCount(service.getCountByAll(systemModule));
		result.setList(service.getListByAll(systemModule));

		return result;
	}

	// [按条件]取得列表,有分页
	@GetMapping("/list/page")
	public ResultMessage<SystemModule> listByPage(SystemModule systemModule,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {

		ResultMessage<SystemModule> result = new ResultMessage<SystemModule>("OK",
				"取得系统模块列表page: " + page + " -- rows: " + rows);

		int count = service.getCountByAll(systemModule);
		int pageCount = (count % rows == 0 && count > rows ? count / rows : count / rows + 1);

		result.setCount(count);
		result.setPageCount(pageCount);
		result.setList(service.getListByAllWithPage(systemModule, page, rows));
		result.setPage(page);
		result.setRows(rows);

		return result;
	}

	// 获取
	@GetMapping("/get")
	public SystemModule get(int no) throws Exception {
		return service.getModuleByNo(no);
	}

	// 增加
	@PostMapping("/add")
	public ResultMessage<SystemModule> add(SystemModule systemModule) throws Exception {
		service.add(systemModule);
		return new ResultMessage<SystemModule>("OK", "增加系统模块成功");
	}

	// 修改
	@PostMapping("/modify")
	public ResultMessage<SystemModule> modify(SystemModule systemModule) throws Exception {
		service.modify(systemModule);
		return new ResultMessage<SystemModule>("OK", "修改系统模块成功");
	}

	// 删除
	@PostMapping("/delete")
	public ResultMessage<SystemModule> delete(int no) throws Exception {
		service.delete(no);
		return new ResultMessage<SystemModule>("OK", "删除系统模块成功");
	}
}
