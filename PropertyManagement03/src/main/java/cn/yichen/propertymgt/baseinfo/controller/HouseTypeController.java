package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.yichen.propertymgt.baseinfo.model.HouseType;
import cn.yichen.propertymgt.baseinfo.service.IHouseTypeService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date:2019年8月18日下午8:17:24
 * @author LiYi(李海宏)
 * @Description：完善户型表的控制层代码
 *
 */

@RestController
@RequestMapping("/housetype")
@EnableWebMvc
@CrossOrigin
public class HouseTypeController {

	@Autowired
	private IHouseTypeService service;
	
	//增加户型
	@GetMapping(value="/add")
	public ResultMessage<HouseType> add(HouseType h) throws Exception {
		service.add(h);
		return new ResultMessage<HouseType>("OK","增加户型成功");
	}
	//修改户型
	@GetMapping(value="/modify")
	public ResultMessage<HouseType> update(HouseType h) throws Exception {
		service.modify(h);
		return new ResultMessage<HouseType>("OK","修改户型成功");
	}
	//删除户型
	@GetMapping(value="/delete")
	public ResultMessage<HouseType> delete(HouseType h) throws Exception {
		service.delete(h);
		return new ResultMessage<HouseType>("OK","删除户型成功");
	}

	//取得指定的户型
	@GetMapping("/get")
	public ResultMessage<HouseType> getByNo(int no) throws Exception{
		ResultMessage<HouseType> result=new ResultMessage<HouseType>("OK","取得户型成功");
		result.setModel(service.getHouseTypeByNo(no));
		return result;
	}
	
	
	//取得所有户型列表，有分页
	@GetMapping(value="/list/all/page")
	public ResultMessage<HouseType> getListByAllWitPage(
			@RequestParam(required = false,defaultValue ="10") int rows,
			@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<HouseType> result=new ResultMessage<HouseType>("OK","取得户型列表分页模式成功");
		result.setCount(service.getCountByAll());
		result.setPageCount(service.getPagaCountByAll(rows));
		result.setList(service.getListByAllWithPage(rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//取得所有户型列表
	@GetMapping(value="/list/all")
	public List<HouseType> getHouseTypeListByAll() throws Exception{
		return service.getHouseTypeListByAll();
	}
	
}
