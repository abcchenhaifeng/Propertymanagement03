package cn.yichen.propertymgt.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.admin.mapper.ISystemModuleMapper;
import cn.yichen.propertymgt.admin.model.SystemModule;
import cn.yichen.propertymgt.admin.service.ISystemModuleService;

/**
 * 
 * @date: 2019年8月9日 下午9:28:18
 * @author: YiChen(李冠永)
 * @Description: 系统模块业务层接口实现
 *
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class SystemModuleServiceImpl implements ISystemModuleService {

	@Autowired
	private ISystemModuleMapper mapper;
	
	@Override
	public void add(SystemModule systemModule) throws Exception {
		mapper.create(systemModule);
	}

	@Override
	public void modify(SystemModule systemModule) throws Exception {
		mapper.update(systemModule);
	}

	@Override
	public void delete(int no) throws Exception {
		mapper.delete(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SystemModule> getListByAll(SystemModule systemModule) throws Exception {
		return mapper.selectListByAll(systemModule);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SystemModule> getListByAllWithPage(SystemModule systemModule, int page, int rows) throws Exception {
		return mapper.selectListByAllWithPage(systemModule, (page-1)*rows, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public SystemModule getModuleByNo(int no) throws Exception {
		return mapper.selectModuleByNoWithFunctions(no);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll(SystemModule systemModule) throws Exception {
		return mapper.selectCountByAll(systemModule);
	}

}
