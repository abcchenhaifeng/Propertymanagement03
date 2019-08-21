package cn.yichen.propertymgt.feeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.feeinfo.model.FeeItem;
import cn.yichen.propertymgt.feeinfo.service.IFeeItemService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date: 2019年8月19日 上午12:40:43
 * @author: YiChen(李冠永)
 * @Description: 收费类型控制层实现
 *
 */
@RestController
@RequestMapping("/feeitem")
public class FeeItemController {

	@Autowired
	private IFeeItemService service;
	
	@RequestMapping("/get")
	public ResultMessage<FeeItem> get(int no) throws Exception {
		ResultMessage<FeeItem> rs = new ResultMessage<>("OK", "取得收费项目");
		rs.setModel(service.getByNoWithType(no));
		return rs;
	}
	
	@RequestMapping("/list")
	public ResultMessage<FeeItem> list(FeeItem feeItem) throws Exception {
		ResultMessage<FeeItem> rs = new ResultMessage<>("OK", "取得收费项目列表");
		List<FeeItem> list = service.getListByCriteria(feeItem);
		rs.setList(list);
		rs.setCount(list.size());
		return rs;
	}
	
	@RequestMapping("/list/page")
	public ResultMessage<FeeItem> listWithPage(FeeItem feeItem,
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
		
		ResultMessage<FeeItem> rs = new ResultMessage<>("OK", "取得收费项目列表");
		rs.setList(service.getListByCriteriaWithPage(feeItem, page, rows));
		int count = service.getCountByCriteria(feeItem);
		rs.setCount(count);
		rs.setPage(page);
		rs.setRows(rows);
		rs.setPageCount(count % rows == 0 ? count/rows : count/rows + 1);
		return rs;
	}
	
	@RequestMapping("/add")
	public ResultMessage<FeeItem> add(FeeItem feeItem) throws Exception {
		service.add(feeItem);
		return new ResultMessage<>("OK", "添加成功");
	}
	
	@RequestMapping("/modify")
	public ResultMessage<FeeItem> modify(FeeItem feeItem) throws Exception {
		service.modify(feeItem);
		return new ResultMessage<>("OK", "修改成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<FeeItem> delete(int no) throws Exception {
		service.delete(no);
		return new ResultMessage<>("OK", "删除成功");
	}
}
