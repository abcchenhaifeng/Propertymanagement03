package cn.yichen.bootwebmybatis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.yichen.bootwebmybatis.security.model.RoleModel;
import cn.yichen.bootwebmybatis.security.model.UserModel;

/**
 * 用户dao层接口
 * 
 * @author YiChen
 *
 */
@Mapper
public interface IUserDao {
	
	// 添加
//	@Insert("insert into userinfo(USERID, UserPASSWORD, UserNAME, UserROLE, age, joindate, status) values(#{id}, #{password}, #{username}, #{role}, #{age}, #{joinDate}, 'N')")
	public void create(UserModel userModel) throws Exception;

	// 删除
//	@Delete("delete from userinfo where USERID = #{id}")
	public void delete(String id) throws Exception;

	// 更新
//	@Update("update userinfo set UserPASSWORD = #{password}, UserNAME = #{username}, UserROLE = #{role}, age = #{age}, joindate = #{joinDate}, status = #{status} where USERID = #{id}")
	public void update(UserModel userModel) throws Exception;

	// 获取用户列表
	public List<UserModel> selectListByAll(UserModel userModel) throws Exception;

	/*
	 * 按条件获取用户列表(分页)
	 * 多条件查询时需要添加@Param注解到参数前
	 */
	public List<UserModel> selectListByAllWithPage(@Param("userModel") UserModel userModel, @Param("start") int start, @Param("rows") int rows) throws Exception;
	
	//根据id查询, 返回用户
//	@Select("select USERID, UserPASSWORD, UserNAME, UserROLE, age, joindate, status \r\n" + 
//			"        from userinfo \r\n" + 
//			"        where status != 'DISABLE' and USERID = #{id}")
//	@ResultMap("UserModelMap")
	UserModel selectListById(String id) throws Exception;
	
	//为用户增加角色
	//每次增加一个角色
	public void addRole(@Param("id") String id, @Param("roleNo") int roleNo) throws Exception;
	//每次增加多个角色
	public void addRoles(@Param("id") String id, @Param("roleNoList")  int[] roleNoList) throws Exception;
	
	//取得指定用户的角色列表
	public List<RoleModel> selectRoleListByUser() throws Exception;
	//判断指定的用户是否有指定的角色,取得用户和角色关联的个数
	public int selectCountByUserAndRoles(@Param("id") String id, @Param("roleNo") int roleNo) throws Exception;
}
