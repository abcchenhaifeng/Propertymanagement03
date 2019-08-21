package cn.yichen.propertymgt.feeinfo.service;

import java.util.List;

import cn.yichen.propertymgt.feeinfo.model.FeeItemYearPrice;

/**
 * 
 * @date: 2019年8月21日 下午11:26:58
 * @author: YiChen(李冠永)
 * @Description: 收费项目年度价格Service层接口
 *
 */
public interface IFeeItemYearPriceService {

	// 添加
	public void add(FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 修改
	public void modify(FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 删除
	public void delete(String feeyear, int itemno) throws Exception;

	// 按条件获取列表
	public List<FeeItemYearPrice> getListByCriteria(FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeItemYearPrice> getListByCriteriaWithPage(FeeItemYearPrice feeItemYearPrice, int page, int rows)
			throws Exception;

	// 按no获取
	public FeeItemYearPrice getByNo(String feeyear, int itemno) throws Exception;

	// 获取个数
	public int getCountByCriteria(FeeItemYearPrice feeItemYearPrice) throws Exception;
	public int getCountByCriteriaWithPage(FeeItemYearPrice feeItemYearPrice, int page, int rows) throws Exception;
}
