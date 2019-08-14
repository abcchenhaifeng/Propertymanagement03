package cn.yichen.propertymgt.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.admin.mapper.IUserInfoMapper;
import cn.yichen.propertymgt.admin.model.UserInfo;
import cn.yichen.propertymgt.admin.service.IUserInfoService;

/**
 * 
 * @date: 2019年8月9日 下午1:38:50
 * @author YiChen(李冠永)
 * @Description: 系统操作员业务层实现
 *
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoMapper mapper;
	
	@Override
	public void register(UserInfo userInfo) throws Exception {
		userInfo.setStatus("N");
		mapper.create(userInfo);
		
		// Do Something...
	}
	
	@Override
	public void add(UserInfo userInfo) throws Exception {
		mapper.create(userInfo);
	}

	@Override
	public void modify(UserInfo userInfo) throws Exception {
		mapper.update(userInfo);
	}

	@Override
	public void changePassword(String id, String password) throws Exception {
		UserInfo userInfo = mapper.selectUserInfoByIdWithoutOther(id);
		userInfo.setPassword(password);
		mapper.update(userInfo);
	}

	@Override
	public boolean validate(String id, String password) throws Exception {
		UserInfo userInfo = mapper.selectUserInfoByIdWithoutOther(id);
		if ( userInfo != null && userInfo.getPassword().equals(password) )
			return true;
		return false;
	}

	@Override
	public void delete(String id) throws Exception {
		mapper.delete(id);
	}

	@Override
	public void active(String id) throws Exception {
		UserInfo userInfo = mapper.selectUserInfoByIdWithoutOther(id);
		if ( !userInfo.getStatus().equals("Y") ) {
			userInfo.setStatus("Y");
			mapper.update(userInfo);
		}
	}

	@Override
	public void frozen(String id) throws Exception {
		UserInfo userInfo = mapper.selectUserInfoByIdWithoutOther(id);
		if ( !userInfo.getStatus().equals("N") ) {
			userInfo.setStatus("N");
			mapper.update(userInfo);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserInfo> getListByAll(UserInfo userInfo, Integer startAge, Integer endAge) throws Exception {
		return mapper.selectListByAll(userInfo, startAge, endAge);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserInfo> getListByAllWithPage(UserInfo userInfo, int page, int rows, Integer startAge, Integer endAge) throws Exception {
		return mapper.selectListByAllWithPage(userInfo, (page-1)*rows, rows, startAge, endAge);
	}

	@Override
	@Transactional(readOnly = true)
	public UserInfo getUserById(String id) throws Exception {
		return mapper.selectUserInfoById(id);
	}
	
	@Override
	public UserInfo getUserByIdWithoutOther(String id) throws Exception {
		return mapper.selectUserInfoByIdWithoutOther(id);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll(UserInfo userInfo, Integer startAge, Integer endAge) throws Exception {
		return mapper.selectCountByAll(userInfo, startAge, endAge);
	}

	@Override
	public void addFunction(String id, int funNo) throws Exception {
		mapper.addFunction(id, funNo);
	}
	
	@Override
	public void addFunctions(String id, int[] funNos) throws Exception {
		mapper.addFunctions(id, funNos);
	}

	@Override
	public void deleteFunction(String id, int funNo) throws Exception {
		mapper.deleteFunction(id, funNo);
	}

}
