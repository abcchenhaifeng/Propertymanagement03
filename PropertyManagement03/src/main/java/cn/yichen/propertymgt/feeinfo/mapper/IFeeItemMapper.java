package cn.yichen.propertymgt.feeinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.feeinfo.model.FeeItem;

/**
 * 
 * @date 2019年8月19日 下午3:55:16
 * @author YiChen(李冠永)
 * @Description 收费项目Mapper层接口
 *
 */
@Mapper
public interface IFeeItemMapper {

	// 添加
	public void create(FeeItem FeeItem) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 更新
	public void update(FeeItem FeeItem) throws Exception;

	// 根据no查询
	public FeeItem selectByNo(int no) throws Exception;

	// 根据no查询
	public FeeItem selectByNoWithType(int no) throws Exception;

	// 获取列表
	public List<FeeItem> selectListByCriteria(@Param("feeItem") FeeItem feeItem) throws Exception;

	// 按条件获取列表(分页)
	public List<FeeItem> selectListByCriteriaWithPage(@Param("feeItem") FeeItem feeItem, @Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByCriteria(@Param("feeItem") FeeItem feeItem) throws Exception;
}
