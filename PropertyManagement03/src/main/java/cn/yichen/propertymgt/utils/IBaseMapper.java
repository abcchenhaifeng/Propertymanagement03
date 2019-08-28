package cn.yichen.propertymgt.utils;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IBaseMapper <T> {

	// 添加
	public void create(T obj) throws Exception;

	// 删除
	public void delete(String keyword) throws Exception;

	// 更新
	public void update(T obj) throws Exception;

	// 根据no查询
	public T selectByNo(String keyword) throws Exception;

	// 获取列表
	public List<T> selectListByCriteria(@Param("obj") T obj) throws Exception;

	// 按条件获取列表(分页)
	public List<T> selectListByCriteriaWithPage(@Param("obj") T obj, 
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByCriteria(@Param("obj") T obj) throws Exception;
	public int selectCountByCriteriaAndPage(@Param("obj") T obj,  
			@Param("start") int start,
			@Param("rows") int rows) throws Exception;
}
