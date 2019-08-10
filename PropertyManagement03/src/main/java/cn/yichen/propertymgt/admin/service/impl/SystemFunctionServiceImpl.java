package cn.yichen.propertymgt.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.admin.mapper.ISystemFunctionMapper;
import cn.yichen.propertymgt.admin.model.SystemFunction;
import cn.yichen.propertymgt.admin.service.ISystemFunctionService;

/**
 * 
 * @date: 2019年8月9日 下午9:29:01
 * @author: YiChen(李冠永)
 * @Description: 系统功能业务层接口实现
 *
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class SystemFunctionServiceImpl implements ISystemFunctionService {

	@Autowired
	private ISystemFunctionMapper mapper;
	
	@Override
	public void add(SystemFunction systemFunction) throws Exception {
		mapper.create(systemFunction);
	}

	@Override
	public void modify(SystemFunction systemFunction) throws Exception {
		mapper.update(systemFunction);
	}

	@Override
	public void modifyModule(int no, int mno) throws Exception {
		SystemFunction systemFunction = mapper.selectFunctionByNo(no);
		systemFunction.getModule().setNo(mno);
		mapper.update(systemFunction);
	}

	@Override
	public void delete(int no) throws Exception {
		mapper.delete(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SystemFunction> getListByAll(SystemFunction systemFunction) throws Exception {
		return mapper.selectListByAll(systemFunction);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SystemFunction> getListByAllWithPage(SystemFunction systemFunction, int page, int rows)
			throws Exception {
		return mapper.selectListByAllWithPage(systemFunction, (page-1)*rows, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public SystemFunction getFunctionByNo(int no) throws Exception {
		return mapper.selectFunctionByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll(SystemFunction systemFunction) throws Exception {
		return mapper.selectCountByAll(systemFunction);
	}

}
