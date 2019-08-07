package cn.yichen.bootwebmybatis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.yichen.bootwebmybatis.security.model.SysFunctionModel;
import cn.yichen.bootwebmybatis.security.model.SysModelModel;

/**
 * 系统功能dao层接口
 * 
 * @author YiChen
 *
 */
@Mapper
public interface ISysModelDao {
	
	// 添加
//	@Insert("insert into systemmodule(MNO, MName) values(#{no}, #{name})")
	public void create(SysModelModel sysModelModel) throws Exception;

	// 删除
//	@Delete("delete from systemmodule where MNO = #{no}")
	public void delete(int id) throws Exception;

	// 更新
//	@Update("update systemmodule set MName = #{name} where MNO = #{no}")
	public void update(SysModelModel sysModelModel) throws Exception;

	// 获取系统功能列表
	public List<SysModelModel> selectListByAll(SysModelModel sysModelModel) throws Exception;

	//根据no查询, 返回系统功能
//	@Select("select MNO, MName from systemmodule where MNO = #{no}")
//	@ResultMap("sysModuleModelMap")
	public SysModelModel selectListById(int id) throws Exception;
}
