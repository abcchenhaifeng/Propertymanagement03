package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IHouseTypeMapper;
import cn.yichen.propertymgt.baseinfo.model.HouseType;
import cn.yichen.propertymgt.baseinfo.service.IHouseTypeService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class HouseTypeServiceImpl implements IHouseTypeService {

	@Autowired
	private IHouseTypeMapper mapper;
	
	@Override
	public void add(HouseType h) throws Exception {
		mapper.create(h);
	}

	@Override
	public void modify(HouseType h) throws Exception {
		mapper.update(h);
	}

	@Override
	public void delete(HouseType h) throws Exception {
		mapper.delete(h);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HouseType> getHouseTypeListByAll() throws Exception {
		return mapper.selectHouseTypeListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public HouseType getHouseTypeByNo(int no) throws Exception {
		return mapper.selectHouseTypeByNo(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HouseType> getListByAllWithPage(int rows, int page) throws Exception {
		return mapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return mapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int getPagaCountByAll(int rows) throws Exception {
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

}
