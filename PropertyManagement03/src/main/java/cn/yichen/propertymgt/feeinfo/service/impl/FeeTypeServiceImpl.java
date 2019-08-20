package cn.yichen.propertymgt.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.feeinfo.mapper.IFeeTypeMapper;
import cn.yichen.propertymgt.feeinfo.model.FeeType;
import cn.yichen.propertymgt.feeinfo.service.IFeeTypeService;

@Service
@Transactional(rollbackFor = Exception.class)
public class FeeTypeServiceImpl implements IFeeTypeService {

	@Autowired
	private IFeeTypeMapper mapper;
	
	@Override
	public void add(FeeType feeType) throws Exception {
		mapper.create(feeType);
	}

	@Override
	public void modify(FeeType feeType) throws Exception {
		mapper.update(feeType);
	}

	@Override
	public void delete(int no) throws Exception {
		mapper.delete(no);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FeeType> getListByCriteria(FeeType feeType) throws Exception {
		return mapper.selectListByCriteria(feeType);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FeeType> getListByCriteriaWithPage(FeeType feeType, int page, int rows) throws Exception {
		return mapper.selectListByCriteriaWithPage(feeType, (page-1)*rows, rows);
	}

	@Override
	@Transactional(readOnly = true)
	public FeeType getFeeTypeByNo(int no) throws Exception {
		return mapper.selectFeeTypeByNo(no);
	}
	
	@Override
	@Transactional(readOnly = true)
	public FeeType getFeeTypeByNoWithItem(int no) throws Exception {
		return mapper.selectFeeTypeByNoWithItem(no);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByCriteria(FeeType feeType) throws Exception {
		return mapper.selectCountByCriteria(feeType);
	}

	@Override
	public int getCountByCriteriaWithPage(FeeType feeType, int page, int rows) throws Exception {
		return mapper.selectCountByCriteriaAndPage(feeType, (page-1)*rows, rows);
	}

}
