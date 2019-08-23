package cn.yichen.propertymgt.feeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.feeinfo.model.FeeType;
import cn.yichen.propertymgt.feeinfo.service.IFeeTypeService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date: 2019年8月19日 上午12:40:43
 * @author: YiChen(李冠永)
 * @Description: 收费类型控制层实现
 *
 */
@RestController
@RequestMapping("/feetype")
public class FeeTypeController {

	@Autowired
	private IFeeTypeService service;
	
	@RequestMapping("/get")
	public ResultMessage<FeeType> get(int no) throws Exception {
		ResultMessage<FeeType> rs = new ResultMessage<>("OK", "取得收费类型");
		rs.setModel(service.getFeeTypeByNo(no));
		return rs;
	}
	
	@RequestMapping("/list")
	public ResultMessage<FeeType> list(FeeType feeType) throws Exception {
//		ResultMessage<FeeType> rs = new ResultMessage<>("OK", "取得收费类型列表");
//		List<FeeType> list = service.getListByCriteria(feeType);
//		rs.setList(list);
//		rs.setCount(list.size());
		return service.listWhitApi(feeType);
	}
	
	@RequestMapping("/list/page")
	public ResultMessage<FeeType> listWithPage(FeeType feeType,
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
		
//		ResultMessage<FeeType> rs = new ResultMessage<>("OK", "取得收费类型列表");
//		rs.setList(service.getListByCriteriaWithPage(feeType, page, rows));
//		int count = service.getCountByCriteria(feeType);
//		rs.setCount(count);
//		rs.setPage(page);
//		rs.setRows(rows);
//		rs.setPageCount(count % rows == 0 ? count/rows : count/rows + 1);
		
		return service.listByPageWhitApi(feeType);
	}
	
	@RequestMapping("/add")
	public ResultMessage<FeeType> add(FeeType feeType) throws Exception {
		service.add(feeType);
		return new ResultMessage<>("OK", "添加成功");
	}
	
	@RequestMapping("/modify")
	public ResultMessage<FeeType> modify(FeeType feeType) throws Exception {
		service.modify(feeType);
		return new ResultMessage<>("OK", "修改成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<FeeType> delete(int no) throws Exception {
		service.delete(no);
		return new ResultMessage<>("OK", "删除成功");
	}
}
