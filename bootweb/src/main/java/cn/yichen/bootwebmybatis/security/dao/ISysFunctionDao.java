package cn.yichen.bootwebmybatis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.yichen.bootwebmybatis.security.model.SysFunctionModel;
import cn.yichen.bootwebmybatis.security.model.UserModel;

/**
 * 系统功能dao层接口
 * 
 * @author YiChen
 *
 */
@Mapper
public interface ISysFunctionDao {
	
	// 添加
	public void create(SysFunctionModel sysFuntionModel) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 更新
	public void update(SysFunctionModel sysFuntionModel) throws Exception;

	// 获取系统功能列表
	public List<SysFunctionModel> selectListByAll(SysFunctionModel sysFuntionModel) throws Exception;

	//根据no查询, 返回系统功能
	public SysFunctionModel selectListById(int no) throws Exception;
}
