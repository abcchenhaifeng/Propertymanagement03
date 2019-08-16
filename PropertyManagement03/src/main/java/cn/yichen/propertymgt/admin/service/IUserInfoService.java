package cn.yichen.propertymgt.admin.service;

import java.util.List;

import cn.yichen.propertymgt.admin.model.UserInfo;

/**
 * 
 * @date: 2019年8月9日 下午1:39:21
 * @author YiChen(李冠永)
 * @Description: 系统操作员业务层接口
 *
 */
public interface IUserInfoService {
	// 注册
	public void register(UserInfo userInfo) throws Exception;

	// 添加
	public void add(UserInfo userInfo) throws Exception;

	// 修改用户
	public void modify(UserInfo userInfo) throws Exception;

	// 修改密码
	public void changePassword(String id, String password) throws Exception;

	// 添加功能
	public void addFunction(String id, int funNo) throws Exception;

	// 添加功能
	public void addFunctions(String id, int[] funNos) throws Exception;

	// 移除功能
	public void deleteFunction(String id, int funNo) throws Exception;

	// 检验合法性
	public boolean validate(String id, String password) throws Exception;

	// 删除用户
	public void delete(String id) throws Exception;

	// 激活用户
	public void active(String id) throws Exception;

	// 冻结用户
	public void frozen(String id) throws Exception;

	// 终止用户
	// public void disable(String id) throws Exception;

	// 按条件获取用户列表
	public List<UserInfo> getListByCriteria(UserInfo userInfo, Integer startAge, Integer endAge) throws Exception;

	// 按条件获取用户列表(分页)
	public List<UserInfo> getListByCriteriaWithPage(UserInfo userInfo, int page, int rows, Integer startAge, Integer endAge) throws Exception;

	// 按ID获取用户
	public UserInfo getUserById(String id) throws Exception;
	public UserInfo getUserByIdWithoutOther(String id)  throws Exception;

	// 获取个数
	public int getCountByCriteria(UserInfo userInfo, Integer startAge, Integer endAge) throws Exception;

	public UserInfo getUserByIdWithFunction(String id) throws Exception;

}
