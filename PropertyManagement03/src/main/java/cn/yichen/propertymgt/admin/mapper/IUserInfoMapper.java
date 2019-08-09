package cn.yichen.propertymgt.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.admin.model.UserInfo;

/**
 * 2019年8月8日15:01:43
 * 
 * @author YiChen(李冠永) #系统操作员Mapper(Dao)接口
 *
 */
@Mapper
public interface IUserInfoMapper {

	// 添加
	@Insert("insert into UserInfo(USERID, UPASSWORD, UNAME, UserStatus, AGE, SEX, Mobible) values(#{id}, #{password}, #{username}, #{status}, #{age}, #{sex}, #{mobible})")
	public void create(UserInfo userInfo) throws Exception;

	// 删除
	@Delete("delete from UserInfo where USERID = #{id}")
	public void delete(String id) throws Exception;

	// 更新
	@Update("update UserInfo set UPASSWORD = #{password}, UNAME = #{username}, UserStatus = #{status}, AGE = #{age}, SEX = #{sex}, Mobible = #{mobible} where USERID = #{id}")
	public void update(UserInfo userInfo) throws Exception;

	// 根据id查询, 返回用户
	public UserInfo selectUserInfoById(String id) throws Exception;

	// 获取用户列表
	public List<UserInfo> selectListByAll(@Param("userInfo") UserInfo userInfo) throws Exception;

	// 按条件获取用户列表(分页)
	public List<UserInfo> selectListByAllWithPage(@Param("userInfo") UserInfo userInfo, @Param("start") int start,
			@Param("rows") int rows) throws Exception;

	// 获取个数
	public int selectCountByAll(@Param("userInfo") UserInfo userInfo) throws Exception;

	// 为用户增加功能
	// 每次增加一个功能
	@Insert("insert into SystemFunctionUser(USERID, FUNNO) values(#{id}, #{funNo})")
	public void addFunction(@Param("id") String id, @Param("funNo") int funNo) throws Exception;

	// 每次增加多个功能
	public void addFunctions(@Param("id") String id, @Param("funNos") int[] funNos) throws Exception;

	// 删除功能
	@Insert("delete from SystemFunctionUser where USERID = #{id} and FUNNO = #{funNo}")
	public void deleteFunction(@Param("id") String id, @Param("funNo") int funNo) throws Exception;
}
