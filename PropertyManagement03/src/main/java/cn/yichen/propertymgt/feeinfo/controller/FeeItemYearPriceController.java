package cn.yichen.propertymgt.feeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.yichen.propertymgt.feeinfo.model.FeeItemYearPrice;
import cn.yichen.propertymgt.feeinfo.service.IFeeItemYearPriceService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @date: 2019年8月21日 下午11:33:29
 * @author: YiChen(李冠永)
 * @Description: 收费项目年度价格控制层实现
 *
 */
@RestController
@RequestMapping("/feeitem/year/price")
public class FeeItemYearPriceController {

	@Autowired
	private IFeeItemYearPriceService service;
	
	@RequestMapping("/get")
	public ResultMessage<FeeItemYearPrice> get(String feeyear, int itemno) throws Exception {
		ResultMessage<FeeItemYearPrice> rs = new ResultMessage<>("OK", "取得收费项目年度价格");
		rs.setModel(service.getByNo(feeyear, itemno));
		return rs;
	}
	
	@RequestMapping("/list")
	public ResultMessage<FeeItemYearPrice> list(FeeItemYearPrice feeItemYearPrice) throws Exception {
		ResultMessage<FeeItemYearPrice> rs = new ResultMessage<>("OK", "取得收费项目年度价格列表");
		List<FeeItemYearPrice> list = service.getListByCriteria(feeItemYearPrice);
		rs.setList(list);
		rs.setCount(list.size());
		return rs;
	}
	
	@RequestMapping("/list/page")
	public ResultMessage<FeeItemYearPrice> listWithPage(FeeItemYearPrice feeItemYearPrice,
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int rows) throws Exception {
		
		ResultMessage<FeeItemYearPrice> rs = new ResultMessage<>("OK", "取得收费项目年度价格列表");
		rs.setList(service.getListByCriteriaWithPage(feeItemYearPrice, page, rows));
		int count = service.getCountByCriteria(feeItemYearPrice);
		rs.setCount(count);
		rs.setPage(page);
		rs.setRows(rows);
		rs.setPageCount(count % rows == 0 ? count/rows : count/rows + 1);
		return rs;
	}
	
	@RequestMapping("/add")
	public ResultMessage<FeeItemYearPrice> add(FeeItemYearPrice feeItemYearPrice) throws Exception {
		service.add(feeItemYearPrice);
		return new ResultMessage<>("OK", "添加成功");
	}
	
	@RequestMapping("/modify")
	public ResultMessage<FeeItemYearPrice> modify(FeeItemYearPrice feeItemYearPrice) throws Exception {
		service.modify(feeItemYearPrice);
		return new ResultMessage<>("OK", "修改成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<FeeItemYearPrice> delete(String feeyear, int itemno) throws Exception {
		service.delete(feeyear, itemno);
		return new ResultMessage<>("OK", "删除成功");
	}
}
