package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.ICustomerHomeMapper;
import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.baseinfo.service.ICustomerHomeService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class CustomerHomeServiceImpl implements ICustomerHomeService {

	@Autowired
	private ICustomerHomeMapper mapper;
	
	@Override
	public void add(CustomerHome ch) throws Exception {
		mapper.create(ch);
	}

	@Override
	public void modify(CustomerHome ch) throws Exception {
		mapper.update(ch);
	}

	@Override
	public void delete(CustomerHome ch) throws Exception {
		mapper.delete(ch);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerHome> getListByAll() throws Exception {
		return mapper.selectListByAll();
		}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerHome> getListByAllWithFK() throws Exception {
		return mapper.selectListByAllwithFK();
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerHome getCustomerHomeByNo(int CustomerHomeno) throws Exception {
		return mapper.selectCustomerHomeByCustomerNo(CustomerHomeno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CustomerHome> getListByAllWithPage(int rows, int page) throws Exception {
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

//	@Override
//	public List<CustomerHome> getLivingStatus() throws Exception {
//		return mapper.selectlivingStatus();
//	}
//
//	@Override
//	public void modifyStatus(CustomerHome ch) throws Exception {
//		mapper.modifyStatus(ch);
//	}
//
//	@Override
//	public boolean checkCanModify(int no) throws Exception {
//		boolean result=false;
//		if(!(mapper.selectStatusByNO(no).getChstatus()).equals("迁出")) {
//			result=true;
//			System.out.println("迁入！");
//		}
//		return result;
//	}
//
//	@Override
//	public void updateStatus(CustomerHome ch) throws Exception {
//		mapper.updateStatus(ch);
//	}

	

}
