package cn.yichen.propertymgt.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date 2019年8月27日15:26:06
 * @author YiChen(李冠永)
 * @Description 基本控制层接口
 *
 */
public class BaseController <T> {

	@Autowired
	private IBaseService<T> service;
	
	@RequestMapping("/get")
	public ResultMessage<T> get(String keyword) throws Exception {
		ResultMessage<T> rs = new ResultMessage<>("OK", "获取成功");
		rs.setModel(service.get(keyword));
		return rs;
	}
	
	@RequestMapping("/list")
	public ResultMessage<T> list(T obj) throws Exception {
		ResultMessage<T> rs = new ResultMessage<>("OK", "取得列表");
		List<T> list = service.getListByCriteria(obj);
		rs.setList(list);
		rs.setCount(list.size());
		return rs;
	}
	
	@RequestMapping("/list/page")
	public ResultMessage<T> listWithPage(T obj,
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
		
		ResultMessage<T> rs = new ResultMessage<>("OK", "取得列表");
		rs.setList(service.getListByCriteriaWithPage(obj, page, rows));
		int count = service.getCountByCriteria(obj);
		rs.setCount(count);
		rs.setPage(page);
		rs.setRows(rows);
		rs.setPageCount(count % rows == 0 ? count/rows : count/rows + 1);
		
		return rs;
	}
	
	@RequestMapping("/add")
	public ResultMessage<T> add(T obj) throws Exception {
		service.add(obj);
		return new ResultMessage<>("OK", "添加成功");
	}
	
	@RequestMapping("/modify")
	public ResultMessage<T> modify(T obj) throws Exception {
		service.modify(obj);
		return new ResultMessage<>("OK", "修改成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<T> delete(String keyword) throws Exception {
		service.delete(keyword);
		return new ResultMessage<>("OK", "删除成功");
	}
}
