package cn.yichen.propertymgt.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.feeinfo.model.FeeItemYearPrice;

/**
 * 
 * @date: 2019年8月21日 下午10:29:55
 * @author: YiChen(李冠永)
 * @Description: 收费年度价格Mapper层接口
 *
 */
@Mapper
public interface IFeeItemYearPriceMapper {

	// 添加
	public void create(FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 删除
	public void delete(String feeyear, int itemno) throws Exception;

	// 更新
	public void update(FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 根据no查询
	public FeeItemYearPrice selectByNo(String feeyear, int itemno) throws Exception;

	// 获取列表
	public List<FeeItemYearPrice> selectListByCriteria(@Param("feeItemYearPrice") FeeItemYearPrice feeItemYearPrice) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeItemYearPrice> selectListByCriteriaWithPage(@Param("feeItemYearPrice") FeeItemYearPrice feeItemYearPrice, 
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByCriteria(@Param("feeItemYearPrice") FeeItemYearPrice feeItemYearPrice) throws Exception;
	public int selectCountByCriteriaAndPage(@Param("feeItemYearPrice") FeeItemYearPrice feeItemYearPrice,  
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;
}
