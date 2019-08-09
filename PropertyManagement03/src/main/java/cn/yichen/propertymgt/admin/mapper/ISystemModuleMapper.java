package cn.yichen.propertymgt.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.admin.model.SystemModule;

/**
 * 
 * @date: 2019年8月8日23:38:30
 * @author: YiChen(李冠永)
 * @Description: 系统模块Mapper(Dao)接口
 *
 */
@Mapper
public interface ISystemModuleMapper {

	// 添加
	@Insert("insert into SystemModule(MNO, MNAME) values(#{no}, #{name})")
	public void create(SystemModule systemModule) throws Exception;

	// 删除
	@Delete("delete from SystemModule where MNO = #{no}")
	public void delete(int no) throws Exception;

	// 更新
	@Update("update SystemModule set MNAME = #{name} where MNO = #{no}")
	public void update(SystemModule systemModule) throws Exception;

	// 根据id查询, 返回功能
	public SystemModule selectModuleByNo(int no) throws Exception;

	// 根据id查询, 返回功能
	public SystemModule selectModuleByNoWithFunctions(int no) throws Exception;

	// 获取功能列表
	public List<SystemModule> selectListByAll(@Param("systemModule") SystemModule systemModule) throws Exception;

	// 按条件获取功能列表(分页)
	public List<SystemModule> selectListByAllWithPage(@Param("systemModule") SystemModule systemModule,
			@Param("start") int start, @Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByAll(@Param("systemModule") SystemModule systemModule) throws Exception;
}
