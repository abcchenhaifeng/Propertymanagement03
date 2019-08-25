package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IBuildingTypeMapper;
import cn.yichen.propertymgt.baseinfo.model.BuildingType;
import cn.yichen.propertymgt.baseinfo.service.IBuildingTypeService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class BuildingTypeImpl implements IBuildingTypeService {

	@Autowired
	private IBuildingTypeMapper mapper;
	
	@Override
	public void add(BuildingType typeno) throws Exception {
		mapper.create(typeno);
	}

	@Override
	public void modify(BuildingType typeno) throws Exception {
		mapper.update(typeno);
	}

	@Override
	public void delete(BuildingType typeno) throws Exception {
		mapper.delete(typeno);
	}


	@Override
	@Transactional(readOnly = true)
	public List<BuildingType> getBuildTypeListByAll() throws Exception {
		return mapper.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public BuildingType getBuildTypeByNo(int typeno) throws Exception {
		return mapper.selectBuildingTypeByNo(typeno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BuildingType> getListByAllWithPage(int rows, int page) throws Exception {
		return mapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return mapper.selectCountByAll();
	}


	@Override
	@Transactional(readOnly = true)
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	public List<BuildingType> getListByConditionWithPage(int typeno, int rows, int page) throws Exception {
		return mapper.selectListByConditionWithPage(typeno, rows*(page-1), rows);
	}

	@Override
	public int getCountByCondition(int typeno) throws Exception {
		return mapper.selectCountByCondition(typeno);
	}

	@Override
	public int getPageCountByConditionWithPage(int typeno, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(typeno);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
