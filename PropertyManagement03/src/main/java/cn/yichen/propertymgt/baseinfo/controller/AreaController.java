package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.yichen.propertymgt.baseinfo.mapper.IAreaMapper;
import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.service.IAreaService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date:2019年8月18日下午8:17:24
 * @author LiYi(李海宏)
 * @Description：完善小区表的控制层代码
 *
 */

@RestController
@RequestMapping("/area")
@EnableWebMvc
@CrossOrigin
public class AreaController {

	@Autowired
	private IAreaService service;
	
	//增加小区
	@GetMapping(value="/add")
	public ResultMessage<Area> add(Area area) throws Exception {
		service.add(area);
		return new ResultMessage<Area>("OK","增加小区成功");
	}
	//修改小区
	@GetMapping(value="/modify")
	public ResultMessage<Area> update(Area Area) throws Exception {
		service.modify(Area);
		return new ResultMessage<Area>("OK","修改小区成功");
	}
	//删除小区
	@GetMapping(value="/delete")
	public ResultMessage<Area> delete(Area Area) throws Exception {
		service.delete(Area);
		return new ResultMessage<Area>("OK","删除小区成功");
	}

	//取得指定的小区
	@GetMapping("/get")
	public ResultMessage<Area> getByNo(int no) throws Exception{
		ResultMessage<Area> result=new ResultMessage<Area>("OK","取得小区成功");
		result.setModel(service.getAreaByNo(no));
		return result;
	}
	//取得开发商列表
	@GetMapping("/list/developer")
	public List<Area> getListByDeveloper() throws Exception {
		return service.getListByDeveloper();
	}
	
	//取得所有小区列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<Area> getListByAllWitPage(
			@RequestParam(required = false,defaultValue ="10") int rows,
			@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Area> result=new ResultMessage<Area>("OK","取得小区列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		result.setList(service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有小区列表
	@GetMapping(value="/list/all")
	public List<Area> getAreaListByAll() throws Exception{
		return service.getAreaListByAll();
	}
	
}
