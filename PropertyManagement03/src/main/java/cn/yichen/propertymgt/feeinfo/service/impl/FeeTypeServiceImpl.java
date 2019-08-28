package cn.yichen.propertymgt.feeinfo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.yichen.propertymgt.feeinfo.mapper.IFeeTypeMapper;
import cn.yichen.propertymgt.feeinfo.model.FeeType;
import cn.yichen.propertymgt.feeinfo.service.IFeeTypeService;
import cn.yichen.propertymgt.vo.ResultMessage;

@Service
@Transactional(rollbackFor = Exception.class)
public class FeeTypeServiceImpl implements IFeeTypeService {

	@Autowired
	private IFeeTypeMapper mapper;
	
	@Autowired
	private RestTemplate rest;
	
	@Override
	@HystrixCommand(fallbackMethod = "getListError")
	public ResultMessage<FeeType> listWhitApi(FeeType feeType) throws Exception {
		ResultMessage<FeeType> resultMessage = rest.getForObject("http://propertyfeemgtclient/feetype/list", ResultMessage.class);
		return resultMessage;
	}
	
	public ResultMessage<FeeType> getListError(FeeType feeType) throws Exception {
		return new ResultMessage<FeeType>("ERROR", "该服务出现错误, 请稍后再访问");
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getlistByPageError")
	public ResultMessage<FeeType> listByPageWhitApi(FeeType feeType) throws Exception {
		StringBuffer url = new StringBuffer("http://propertyfeemgtclient/feetype/list/page?"+new Date().getTime());
		Map<String, Object> params = new HashMap<>();
		
		if ( feeType != null ) {
			if (feeType.getTypeno() != null) { url.append("&typeno={typeno}"); params.put("typeno", feeType.getTypeno());}
			if (feeType.getTypename() != null) { url.append("&typename={typename}"); params.put("typename", feeType.getTypename());}
		}
		
		ResultMessage<FeeType> resultMessage = rest.getForObject(url.toString(), ResultMessage.class, params);
		return resultMessage;
	}
	
	public ResultMessage<FeeType> getlistByPageError(FeeType feeType) throws Exception {
		return new ResultMessage<FeeType>("ERROR", "该服务出现错误, 请稍后再访问");
	}
	
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
