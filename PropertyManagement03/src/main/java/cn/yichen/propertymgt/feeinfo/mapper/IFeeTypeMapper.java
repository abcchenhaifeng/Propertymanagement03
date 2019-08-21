package cn.yichen.propertymgt.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.feeinfo.model.FeeType;

/**
 * 
 * @date: 2019年8月19日 上午12:15:19
 * @author: YiChen(李冠永)
 * @Description: 收费类型Mapper层接口
 *
 */
@Mapper
public interface IFeeTypeMapper {

	// 添加
	public void create(FeeType feeType) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 更新
	public void update(FeeType feeType) throws Exception;

	// 根据no查询
	public FeeType selectFeeTypeByNo(int no) throws Exception;

	// 根据no查询
	public FeeType selectFeeTypeByNoWithItem(int no) throws Exception;

	// 获取列表
	public List<FeeType> selectListByCriteria(@Param("feeType") FeeType feeType) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeType> selectListByCriteriaWithPage(@Param("feeType") FeeType feeType, 
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByCriteria(@Param("feeType") FeeType feeType) throws Exception;
	public int selectCountByCriteriaAndPage(@Param("feeType") FeeType feeType,  
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;
}
