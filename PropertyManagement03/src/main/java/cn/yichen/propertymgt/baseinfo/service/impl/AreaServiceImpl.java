package cn.yichen.propertymgt.baseinfo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IAreaMapper;
import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.service.IAreaService;

/**
 * 
 * @date:2019年8月18日下午8:16:14
 * @author LiYi(李海宏)
 * @Description：实现小区表业务层代码
 *
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private IAreaMapper mapper;
	
	@Override
	public void add(Area area) throws Exception {
		mapper.create(area);
	}

	@Override
	public void modify(Area area) throws Exception {
		mapper.update(area);
	}

	@Override
	public void delete(Area area) throws Exception {
		mapper.delete(area);
	}

	@Override
	public List<Area> getAreaListByAll() throws Exception {
//		List<Area> list = mapper.selectAreaListByAll();
//		for (Area area : list) {
//			System.out.println(area);
//		}
		return mapper.selectAreaListByAll();
	}

	@Override
	public Area getAreaByNo(int no) throws Exception {
		return mapper.selectAreaByNo(no);
	}

	@Override
	public List<Area> getListByAllWithPage(int rows, int page) throws Exception {
		return mapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public int getCountByAll() throws Exception {
		return mapper.selectCountByAll();
	}

	@Override
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

	@Override
	public List<Area> getListByConditionWithPage(String name, String developer, Double minbuildingarea,
			Double maxbuildingarea, Long minhome, Long maxhome, Long minhouse, Long maxhouse, int rows, int page)
			throws Exception {
//		if(name!=null&&name.trim().length()>0) {
//			name="%"+name+"%";
//		}
//		if(developer!=null&&developer.trim().length()>0) {
//			developer="%"+developer+"%";
//		}
		return mapper.selectListByConditionWithPage(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse, rows*(page-1), rows);
	}

	@Override
	public int getCountByCondition(String name, String developer, Double minbuildingarea, Double maxbuildingarea,
			Long minhome, Long maxhome, Long minhouse, Long maxhouse) throws Exception {
		return mapper.selectCountByCondition(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse);
	}

	@Override
	public int getPageCountByConditionWithPage(String name, String developer, Double minbuildingarea,
			Double maxbuildingarea, Long minhome, Long maxhome, Long minhouse, Long maxhouse, int rows)
			throws Exception {
		int pageCount=0;
		int count=this.getCountByCondition(name, developer, minbuildingarea, maxbuildingarea, minhome, maxhome, minhouse, maxhouse);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}


//	@Override
//	public List<Area> getListByDeveloper() throws Exception {
//		return mapper.selectListByDeveloper();
//	}


}
