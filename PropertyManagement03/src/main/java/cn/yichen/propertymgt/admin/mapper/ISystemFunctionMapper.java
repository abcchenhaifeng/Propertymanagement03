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
 * @date: 2019年8月8日 下午6:19:05
 * @author: YiChen(李冠永)
 * @Description: 系统功能Mapper(Dao)接口
 *
 */
@Mapper
public interface ISystemFunctionMapper {

//	// 添加
//	@Insert("insert into UserInfo(USERID, UPASSWORD, UNAME, UserStatus, AGE, SEX, Mobible) values(#{id}, #{password}, #{username}, #{status}, #{age}, #{sex}, #{mobible})")
//	public void create(UserInfo userInfo) throws Exception;
//
//	// 删除
//	@Delete("delete from UserInfo where USERID = #{id}")
//	public void delete(String id) throws Exception;
//
//	// 更新
//	@Update("update userinfo set UPASSWORD = #{password}, UNAME = #{username}, UserStatus = #{status}, AGE = #{age}, SEX = #{sex}, Mobible = #{mobible} where USERID = #{id}")
//	public void update(UserInfo userInfo) throws Exception;

	// 根据id查询, 返回用户
	public SystemFunction selectFunctionByNo(String no) throws Exception;
	
//	// 获取用户列表
//	public List<UserInfo> selectListByAll(UserInfo userInfo) throws Exception;
//
//	// 按条件获取用户列表(分页)
//	public List<UserInfo> selectListByAllWithPage(@Param("userInfo") UserInfo userInfo, @Param("start") int start, @Param("rows") int rows) throws Exception;
//	
//	// 为用户增加功能
//	// 每次增加一个功能
//	public void addFunction(@Param("no") String no, @Param("funcNo") int funcNo) throws Exception;
//
//	// 每次增加多个功能
//	public void addFunctions(@Param("no") String no, @Param("funcNos")  int[] funcNos) throws Exception;
//
//	// 取得指定用户的功能列表
//	public List<UserInfo> selectFunctionListByUser() throws Exception;
}
