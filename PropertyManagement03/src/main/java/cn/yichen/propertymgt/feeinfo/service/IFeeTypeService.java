package cn.yichen.propertymgt.feeinfo.service;

import java.util.List;

import cn.yichen.propertymgt.feeinfo.model.FeeType;

/**
 * 
 * @date: 2019年8月19日 上午12:10:51
 * @author: YiChen(李冠永)
 * @Description: 收费类型Service层接口
 *
 */
public interface IFeeTypeService {

	// 添加
	public void add(FeeType feeType) throws Exception;

	// 修改
	public void modify(FeeType feeType) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 按条件获取列表
	public List<FeeType> getListByCriteria(FeeType feeType) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeType> getListByCriteriaWithPage(FeeType feeType, int page, int rows)
			throws Exception;

	// 按no获取
	public FeeType getFeeTypeByNo(int no) throws Exception;
	public FeeType getFeeTypeByNoWithItem(int no) throws Exception;

	// 获取个数
	public int getCountByCriteria(FeeType feeType) throws Exception;
	public int getCountByCriteriaWithPage(FeeType feeType, int page, int rows) throws Exception;
}
