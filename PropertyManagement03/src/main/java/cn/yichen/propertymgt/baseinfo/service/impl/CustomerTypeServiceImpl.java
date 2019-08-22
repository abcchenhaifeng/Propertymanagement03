package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import cn.yichen.propertymgt.baseinfo.mapper.ICustomerTypeMapper;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;
import cn.yichen.propertymgt.baseinfo.service.ICustomerTypeService;


@Service
@Transactional(rollbackFor = {Exception.class})
public class CustomerTypeServiceImpl implements ICustomerTypeService {

	
	@Autowired
	private ICustomerTypeMapper mapper;
	
	@Autowired
	private RestTemplate re = null;
	
//	@Value("${comliyidemo.url}")
//	private String url = null;
	
	@Override
	@Transactional(readOnly = true)
	public List<CustomerType> getListByAll() throws Exception {
		return mapper.selectListByAll();
		//return null;
//		System.out.println(url);
//		List<CustomerType> list=re.getForObject("http://localhost:8100/"+"customertype/list/all", List.class);
//		return list;
	
	}

}
