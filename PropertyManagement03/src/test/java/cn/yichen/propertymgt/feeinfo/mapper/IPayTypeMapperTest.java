package cn.yichen.propertymgt.feeinfo.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.feeinfo.model.PayType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPayTypeMapperTest {

	@Autowired
	private IPayTypeMapper mapper;

	@Test
	public void testCreate() throws Exception {
		PayType payType = new PayType();
		payType.setTypename("Create");
		mapper.create(payType);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete(1);
	}

	@Test
	public void testUpdate() throws Exception {
		PayType payType = new PayType();
		payType.setTypeno(2);
		payType.setTypename("Update");
		mapper.update(payType);
	}

	@Test
	public void testSelectFeeTypeByNo() throws Exception {
		mapper.selectByNo(2);
	}

	@Test
	public void testSelectListByCriteria() throws Exception {
		mapper.selectCountByCriteria(null);
	}

	@Test
	public void testSelectListByCriteriaWithPage() throws Exception {
		mapper.selectCountByCriteriaAndPage(null, 0, 5);
	}

	@Test
	public void testSelectCountByCriteria() throws Exception {
		mapper.selectCountByCriteria(null);
	}

	@Test
	public void testSelectCountByCriteriaAndPage() throws Exception {
		mapper.selectCountByCriteriaAndPage(null, 0, 1);
	}

}
