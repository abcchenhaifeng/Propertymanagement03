package cn.yichen.propertymgt.feeinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.feeinfo.mapper.IFeeItemYearPriceMapper;
import cn.yichen.propertymgt.feeinfo.model.FeeItemYearPrice;
import cn.yichen.propertymgt.feeinfo.service.IFeeItemYearPriceService;

/**
 * 
 * @date: 2019年8月21日 下午11:33:56
 * @author: YiChen(李冠永)
 * @Description: 收费项目年度价格Service层实现
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeeItemYearPriceServiceImpl implements IFeeItemYearPriceService {

	@Autowired
	private IFeeItemYearPriceMapper mapper;
	
	@Override
	public void add(FeeItemYearPrice feeItemYearPrice) throws Exception {
		mapper.create(feeItemYearPrice);
	}

	@Override
	public void modify(FeeItemYearPrice feeItemYearPrice) throws Exception {
		mapper.update(feeItemYearPrice);
	}

	@Override
	public void delete(String feeyear, int itemno) throws Exception {
		mapper.delete(feeyear, itemno);
	}

	@Override
	public List<FeeItemYearPrice> getListByCriteria(FeeItemYearPrice feeItemYearPrice) throws Exception {
		return mapper.selectListByCriteria(feeItemYearPrice);
	}

	@Override
	public List<FeeItemYearPrice> getListByCriteriaWithPage(FeeItemYearPrice feeItemYearPrice, int page, int rows)
			throws Exception {
		return mapper.selectListByCriteriaWithPage(feeItemYearPrice, (page-1)*rows, rows);
	}

	@Override
	public FeeItemYearPrice getByNo(String feeyear, int itemno) throws Exception {
		return mapper.selectByNo(feeyear, itemno);
	}

	@Override
	public int getCountByCriteria(FeeItemYearPrice feeItemYearPrice) throws Exception {
		return mapper.selectCountByCriteria(feeItemYearPrice);
	}

	@Override
	public int getCountByCriteriaWithPage(FeeItemYearPrice feeItemYearPrice, int page, int rows) throws Exception {
		return mapper.selectCountByCriteriaAndPage(feeItemYearPrice, (page-1)*rows, rows);
	}

}
