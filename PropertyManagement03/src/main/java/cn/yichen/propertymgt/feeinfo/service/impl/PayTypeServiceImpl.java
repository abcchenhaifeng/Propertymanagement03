package cn.yichen.propertymgt.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.feeinfo.mapper.IPayTypeMapper;
import cn.yichen.propertymgt.feeinfo.model.PayType;
import cn.yichen.propertymgt.feeinfo.service.IPayTypeService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class PayTypeServiceImpl implements IPayTypeService {

	@Autowired
	private IPayTypeMapper mapper;
	
	@Override
	public void add(PayType payType) throws Exception {
		mapper.create(payType);
	}

	@Override
	public void modify(PayType payType) throws Exception {
		mapper.update(payType);
	}
	
	@Override
	public void delete(String keyword) throws Exception {
		mapper.delete(Integer.parseInt(keyword));
	}

	@Override
	public PayType get(String keyword) throws Exception {
		return mapper.selectByNo(Integer.parseInt(keyword));
	}

	@Override
	public List<PayType> getListByCriteria(PayType payType) throws Exception {
		return mapper.selectListByCriteria(payType);
	}

	@Override
	public List<PayType> getListByCriteriaWithPage(PayType payType, int page, int rows) throws Exception {
		return mapper.selectListByCriteriaWithPage(payType, (page-1)*rows, rows);
	}

	@Override
	public int getCountByCriteria(PayType payType) throws Exception {
		return mapper.selectCountByCriteria(payType);
	}

	@Override
	public int getCountByCriteriaWithPage(PayType payType, int page, int rows) throws Exception {
		return mapper.selectCountByCriteriaAndPage(payType, (page-1)*rows, rows);
	}

}
