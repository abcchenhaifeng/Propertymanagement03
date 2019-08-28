package cn.yichen.propertymgt.utils;

import java.util.List;

/**
 * 
 * @date 2019年8月27日15:25:33
 * @author YiChen(李冠永)
 * @Description 基本Service层接口
 *
 */
public interface IBaseService <T> {

	// 添加
	public void add(T obj) throws Exception;

	// 修改
	public void modify(T obj) throws Exception;

	// 删除
	public void delete(String keyword) throws Exception;

	// 按条件获取列表
	public List<T> getListByCriteria(T obj) throws Exception;

	// 按条件获取列表(分页)
	public List<T> getListByCriteriaWithPage(T obj, int page, int rows) throws Exception;

	// 按keyword获取
	public T get(String keyword) throws Exception;

	// 获取个数
	public int getCountByCriteria(T obj) throws Exception;
	public int getCountByCriteriaWithPage(T obj, int page, int rows) throws Exception;
}
