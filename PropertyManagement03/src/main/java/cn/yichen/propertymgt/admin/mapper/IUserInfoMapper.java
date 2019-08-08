package cn.yichen.propertymgt.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.admin.model.UserInfo;

/**
 * 2019年8月8日15:01:43
 * @author YiChen(李冠永)
 * #系统操作员Mapper(Dao)接口
 *
 */
@Mapper
public interface IUserInfoMapper {

	// 添加
	@Insert("insert into userinfo(USERID, UPASSWORD, UNAME, UserStatus) values(#{id}, #{password}, #{username}, #{role}, #{age}, #{joinDate}, 'N')")
	public void create(UserInfo userInfo) throws Exception;

	// 删除
//	@Delete("delete from userinfo where USERID = #{id}")
	public void delete(String id) throws Exception;

	// 更新
//	@Update("update userinfo set UserPASSWORD = #{password}, UserNAME = #{username}, UserROLE = #{role}, age = #{age}, joindate = #{joinDate}, status = #{status} where USERID = #{id}")
	public void update(UserInfo userInfo) throws Exception;

	// 获取用户列表
	public List<UserInfo> selectListByAll(UserInfo userInfo) throws Exception;

	// 按条件获取用户列表(分页)
	public List<UserInfo> selectListByAllWithPage(@Param("userInfo") UserInfo userInfo, @Param("start") int start, @Param("rows") int rows) throws Exception;
	
	// 根据id查询, 返回用户
	UserInfo selectListById(String id) throws Exception;
	
	// 为用户增加功能
	// 每次增加一个功能
	public void addFunction(@Param("no") String no, @Param("funcNo") int funcNo) throws Exception;
	// 每次增加多个功能
	public void addFunctions(@Param("no") String no, @Param("funcNos")  int[] funcNos) throws Exception;
	
	// 取得指定用户的功能列表
	public List<UserInfo> selectFunctionListByUser() throws Exception;
}
