package cn.yichen.propertymgt.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.admin.model.SystemFunction;

/**
 * 
 * @date: 2019年8月8日23:37:34
 * @author: YiChen(李冠永)
 * @Description: 系统功能Mapper(Dao)接口
 *
 */
@Mapper
public interface ISystemFunctionMapper {

	// 添加
	public void create(SystemFunction systemFunction) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 更新
	public void update(SystemFunction systemFunction) throws Exception;

	// 根据id查询, 返回功能
	public SystemFunction selectFunctionByNo(int no) throws Exception;

	// 根据id查询, 返回功能
	public SystemFunction selectFunctionByNoWithModule(int no) throws Exception;

	// 获取功能列表
	public List<SystemFunction> selectListByAll(@Param("systemFunction") SystemFunction systemFunction)
			throws Exception;

	// 按条件获取功能列表(分页)
	public List<SystemFunction> selectListByAllWithPage(@Param("systemFunction") SystemFunction systemFunction,
			@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByAll(@Param("systemFunction") SystemFunction systemFunction) throws Exception;
}
