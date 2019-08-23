package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IBuildingMapper;
import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.model.Building;
import cn.yichen.propertymgt.baseinfo.service.IBuildingService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class BuildingServiceImpl implements IBuildingService {

	@Autowired
	private IBuildingMapper mapper;
	
	@Override
	public void add(Building building) throws Exception {
		mapper.create(building);
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
	public List<Building> getListByAll() throws Exception {
		return mapper.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByAllWithArea() throws Exception {
		return mapper.selectListByAllWithArea();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByAllWithBuildType() throws Exception {
		return mapper.selectListByAllWithBuildType();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByAllWithAreaAndBuildType() throws Exception {
		return mapper.selectListByAllWithAreaAndBuildType();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByAllWithAreaAndBuildTypeWithPage(int rows, int page) throws Exception {
		return mapper.selectListByAllWithAreaAndBuildTypeWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByArea(int areaNo) throws Exception {
		return mapper.selectListByArea(areaNo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByBuildType(int buildTypeNo) throws Exception {
		return mapper.selectListByBuildType(buildTypeNo);
	}

	@Override
	@Transactional(readOnly = true)
	public Building getByNo(int no) throws Exception {
		return mapper.selectByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Building> getListByAllWithPage(int rows, int page) throws Exception {
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
	public List<Building> getListByConditionWithPage(int areano, String baddress, int buildingtypeno, int minhouse,int maxhouse, int rows, int page) throws Exception {
		return mapper.selectListByConditionWithPage(areano, baddress, buildingtypeno, minhouse, maxhouse, rows*(page-1), rows);
	}

	@Override
	public int getCountByCondition(int areano, String baddress, int buildingtypeno, int minhouse, int maxhouse)
			throws Exception {
		return mapper.selectCountByCondition(areano, baddress, buildingtypeno, minhouse, maxhouse);
	}

	@Override
	public int getPageCountByConditionWithPage(int areano, String baddress, int buildingtypeno, int minhouse,
			int maxhouse, int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(areano, baddress, buildingtypeno, minhouse, maxhouse);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

}
