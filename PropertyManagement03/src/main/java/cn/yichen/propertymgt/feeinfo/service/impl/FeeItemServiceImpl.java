package cn.yichen.propertymgt.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.feeinfo.mapper.IFeeItemMapper;
import cn.yichen.propertymgt.feeinfo.model.FeeItem;
import cn.yichen.propertymgt.feeinfo.service.IFeeItemService;

@Service
@Transactional(rollbackFor = Exception.class)
public class FeeItemServiceImpl implements IFeeItemService {

	@Autowired
	private IFeeItemMapper mapper;
	
	@Override
	public void add(FeeItem feeItem) throws Exception {
		mapper.create(feeItem);
	}

	@Override
	public void modify(FeeItem feeItem) throws Exception {
		mapper.update(feeItem);
	}

	@Override
	public void delete(int no) throws Exception {
		mapper.delete(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FeeItem> getListByCriteria(FeeItem feeItem) throws Exception {
		return mapper.selectListByCriteria(feeItem);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FeeItem> getListByCriteriaWithPage(FeeItem feeItem, int page, int rows) throws Exception {
		return mapper.selectListByCriteriaWithPage(feeItem, (page-1)*rows, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public FeeItem getByNo(int no) throws Exception {
		return mapper.selectByNo(no);
	}
	
	@Override
	@Transactional(readOnly = true)
	public FeeItem getByNoWithType(int no) throws Exception {
		return mapper.selectByNoWithType(no);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByCriteria(FeeItem feeItem) throws Exception {
		return mapper.selectCountByCriteria(feeItem);
	}

}
