package cn.yichen.bootwebmybatis.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.bootwebmybatis.security.dao.IUserDao;
import cn.yichen.bootwebmybatis.security.model.UserModel;
import cn.yichen.bootwebmybatis.security.service.IUserService;

@Service("UserService")
@Transactional(rollbackFor = {Exception.class})	// 开启事务
public class UserServiceImpl implements IUserService {

	@Autowired()
	@Qualifier("IUserDao")
	private IUserDao userDao;

	@Override
	public void register(UserModel userModel) throws Exception {
		userDao.create(userModel);
	}

	public IUserDao getDao() {
		return userDao;
	}

	@Override
	public void modify(UserModel userModel) throws Exception {
		userDao.update(userModel);
	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		UserModel userModel = userDao.selectListById(id);
		userModel.setPassword(password);
		userDao.update(userModel);
	}

	@Override
	public void changeRole(String id, String role) throws Exception {
		UserModel userModel = userDao.selectListById(id);
		userModel.setRole(role);
		userDao.update(userModel);
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		boolean val = false;
		
		UserModel userModel = userDao.selectListById(id);
		if ( userModel != null ) {
			if ( password.equals(userModel.getPassword()) ) {
				val = true;
			}
		}
		
		return val;
	}

	@Override
	public void delete(String id) throws Exception {
		userDao.delete(id);
	}

	@Override
	public void active(String id) throws Exception {
		UserModel userModel = userDao.selectListById(id);
		userModel.setStatus("Y");
		userDao.update(userModel);
	}
	
	@Override
	public void frozen(String id) throws Exception {
		UserModel userModel = userDao.selectListById(id);
		userModel.setStatus("N");
		userDao.update(userModel);
	}

	@Override
	public void disable(String id) throws Exception {
		UserModel userModel = userDao.selectListById(id);
		userModel.setStatus("DISABLE");
		userDao.update(userModel);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserModel> getListByAll(UserModel userModel) throws Exception {
		List<UserModel> list = userDao.selectListByAll(userModel);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public UserModel getUserById(String id) throws Exception {
		System.out.println(userDao);
		UserModel userModel = userDao.selectListById(id);
		return userModel;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserModel> getListByAllWithPage(UserModel userModel, int page, int rows) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
