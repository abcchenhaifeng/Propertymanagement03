package cn.yichen.propertymgt.feeinfo.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.feeinfo.model.FeeItem;
import cn.yichen.propertymgt.feeinfo.model.FeeItemYearPrice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IFeeItemYearPriceMapperTest {

	@Autowired
	private IFeeItemYearPriceMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		FeeItemYearPrice feeItemYearPrice = new FeeItemYearPrice();
		feeItemYearPrice.setFeeyear("2019");
		FeeItem feeItem = new FeeItem();
		feeItem.setItemno(2);
		feeItemYearPrice.setFeeItem(feeItem);
		mapper.create(feeItemYearPrice);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete("2019", 1);
	}

	@Test
	public void testUpdate() throws Exception {
		FeeItemYearPrice feeItemYearPrice = mapper.selectByNo("2019", 2);
		feeItemYearPrice.setUnitprice(2000.);
		mapper.update(feeItemYearPrice);
	}

	@Test
	public void testSelectFeeTypeByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectListByCriteria() throws Exception {
		mapper.selectListByCriteria(null);
	}

	@Test
	public void testSelectListByCriteriaWithPage() throws Exception {
		mapper.selectListByCriteriaWithPage(null, 0, 2);
	}

	@Test
	public void testSelectCountByCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCountByCriteriaAndPage() throws Exception {
		mapper.selectCountByCriteriaAndPage(null, 0, 2);
	}

}
