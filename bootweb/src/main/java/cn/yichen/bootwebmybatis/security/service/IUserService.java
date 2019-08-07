package cn.yichen.bootwebmybatis.security.service;

import java.util.List;

import cn.yichen.bootwebmybatis.security.model.UserModel;

/**
 * 用户业务接口
 * 
 * @author Administrator
 *
 */
public interface IUserService {

	// 注册
	public void register(UserModel userModel) throws Exception;

	// 修改用户
	public void modify(UserModel userModel) throws Exception;
	
	// 修改密码
	public void changePassword(String id, String password) throws Exception;
	
	// 修改角色
	public void changeRole(String id, String role) throws Exception;
	
	// 检验合法性
	public boolean validate(String id, String password) throws Exception;
	
	// 删除用户
	public void delete(String id) throws Exception;

	// 激活用户
	public void active(String id) throws Exception;

	// 冻结用户
	public void frozen(String id) throws Exception;
	
	// 终止用户
	public void disable(String id) throws Exception;
	
	// 按条件获取用户列表
	public List<UserModel> getListByAll(UserModel userModel) throws Exception;
	
	// 按条件获取用户列表(分页)
	public List<UserModel> getListByAllWithPage(UserModel userModel, int page, int rows) throws Exception;
	
	// 按ID获取用户
	public UserModel getUserById(String id) throws Exception;
}
