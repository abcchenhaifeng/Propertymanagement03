package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.ICustomerTypeMapper;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;
import cn.yichen.propertymgt.baseinfo.service.ICustomerTypeService;


@Service
@Transactional(rollbackFor = {Exception.class})
public class CustomerTypeServiceImpl implements ICustomerTypeService {

	
	@Autowired
	private ICustomerTypeMapper mapper;
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerType> getListByAll() throws Exception {
		return mapper.selectListByAll();
	
	}

}
