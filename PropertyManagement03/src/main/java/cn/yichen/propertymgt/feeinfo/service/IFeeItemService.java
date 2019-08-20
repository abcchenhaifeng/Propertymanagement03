package cn.yichen.propertymgt.feeinfo.service;

import java.util.List;

import cn.yichen.propertymgt.feeinfo.model.FeeItem;

/**
 * 
 * @date: 2019年8月19日 下午6:08:43
 * @author: YiChen(李冠永)
 * @Description: 收费项目Service层接口
 *
 */
public interface IFeeItemService {

	// 添加
	public void add(FeeItem feeItem) throws Exception;

	// 修改
	public void modify(FeeItem feeItem) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 按条件获取列表
	public List<FeeItem> getListByCriteria(FeeItem feeItem) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeItem> getListByCriteriaWithPage(FeeItem feeItem, int page, int rows)
			throws Exception;

	// 按no获取
	public FeeItem getByNo(int no) throws Exception;
	public FeeItem getByNoWithType(int no) throws Exception;

	// 获取个数
	public int getCountByCriteria(FeeItem feeItem) throws Exception;
}
