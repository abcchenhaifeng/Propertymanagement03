package cn.yichen.propertymgt.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.EnableCaching;

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
	public void create(UserInfo userInfo) throws Exception;

	// 删除
	public void delete(String id) throws Exception;

	// 更新
	public void update(UserInfo userInfo) throws Exception;

	// 根据id查询,返回用户
	public UserInfo selectUserInfoById(String id) throws Exception;
	public UserInfo selectUserInfoByIdWithoutOther(String id) throws Exception;
	
	// 获取用户列表
	public List<UserInfo> selectListByAll(@Param("userInfo") UserInfo userInfo, @Param("startAge")Integer startAge, @Param("endAge")Integer endAge) throws Exception;

	// 按条件获取用户列表(分页)
	public List<UserInfo> selectListByAllWithPage(@Param("userInfo") UserInfo userInfo, @Param("start") int start,
			@Param("rows") int rows, @Param("startAge")Integer startAge, @Param("endAge")Integer endAge) throws Exception;

	// 获取个数
	public int selectCountByAll(@Param("userInfo") UserInfo userInfo, @Param("startAge")Integer startAge, @Param("endAge")Integer endAge) throws Exception;

	// 为用户增加功能
	// 每次增加一个功能
	public void addFunction(@Param("id") String id, @Param("funNo") int funNo) throws Exception;

	// 每次增加多个功能
	public void addFunctions(@Param("id") String id, @Param("funNos") int[] funNos) throws Exception;

	// 删除功能
	public void deleteFunction(@Param("id") String id, @Param("funNo") int funNo) throws Exception;

}
