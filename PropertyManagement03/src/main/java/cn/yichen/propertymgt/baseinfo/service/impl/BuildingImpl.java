package cn.yichen.propertymgt.baseinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IBuildingMapper;
import cn.yichen.propertymgt.baseinfo.model.Building;
import cn.yichen.propertymgt.baseinfo.service.IBuildingService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class BuildingImpl implements IBuildingService {
	
	@Autowired
	private IBuildingMapper mapper;
	
	@Override
	public void add(Building building) throws Exception {
		mapper.insert(building);

	}

	@Override
	public void modify(Building building) throws Exception {
		mapper.update(building);

	}

	@Override
	public void delete(Building building) throws Exception {
		mapper.delete(building);

	}

	@Override
	@Transactional(readOnly = true)
	public int selectCountByAll() throws Exception {
		return mapper.selectCountByAll();
	}

}
