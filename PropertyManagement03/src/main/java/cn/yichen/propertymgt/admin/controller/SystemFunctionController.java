package cn.yichen.propertymgt.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.admin.model.SystemFunction;
import cn.yichen.propertymgt.admin.service.impl.SystemFunctionServiceImpl;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date: 2019年8月9日 下午9:33:33
 * @author: YiChen(李冠永)
 * @Description: 系统功能控制层实现
 *
 */
@RestController
@RequestMapping("/function")
public class SystemFunctionController {

	@Autowired
	private SystemFunctionServiceImpl service;

	// [按条件]取得列表
	@GetMapping("/list")
	public ResultMessage<SystemFunction> list(SystemFunction systemFunction) throws Exception {

		ResultMessage<SystemFunction> result = new ResultMessage<SystemFunction>("OK", "取得系统功能列表");
		List<SystemFunction> list = service.getListByCriteria(systemFunction);
		result.setCount(list.size());
		result.setList(list);

		return result;
	}

	// [按条件]取得列表,有分页
	@GetMapping("/list/page")
	public ResultMessage<SystemFunction> listByPage(SystemFunction systemFunction,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {

		ResultMessage<SystemFunction> result = new ResultMessage<SystemFunction>("OK",
				"取得系统功能列表page: " + page + " -- rows: " + rows);

		int count = service.getCountByCriteria(systemFunction);
		int pageCount = (count % rows == 0 && count >= rows ? count / rows : count / rows + 1);

		result.setCount(count);
		result.setPageCount(pageCount);
		result.setList(service.getListByCriteriaWithPage(systemFunction, page, rows));
		result.setPage(page);
		result.setRows(rows);

		return result;
	}

	// 获取
	@GetMapping("/get")
	public ResultMessage<SystemFunction> get(int no) throws Exception {
		ResultMessage<SystemFunction> result = new ResultMessage<SystemFunction>("OK", "获取系统功能详情");
		result.setModel(service.getFunctionByNo(no));

		return result;
	}

	// 增加
	@PostMapping("/add")
	public ResultMessage<SystemFunction> add(SystemFunction systemFunction) throws Exception {
		service.add(systemFunction);
		return new ResultMessage<SystemFunction>("OK", "增加系统功能成功");
	}

	// 修改
	@PostMapping("/modify")
	public ResultMessage<SystemFunction> modify(SystemFunction systemFunction) throws Exception {
		service.modify(systemFunction);
		return new ResultMessage<SystemFunction>("OK", "修改系统功能成功");
	}

	// 删除
	@PostMapping("/delete")
	public ResultMessage<SystemFunction> delete(int no) throws Exception {
		service.delete(no);
		return new ResultMessage<SystemFunction>("OK", "删除系统功能成功");
	}
}
