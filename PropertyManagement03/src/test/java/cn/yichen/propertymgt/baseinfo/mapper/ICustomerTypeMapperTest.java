package cn.yichen.propertymgt.baseinfo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.CustomerType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICustomerTypeMapperTest {

	@Autowired
	private ICustomerTypeMapper mapper;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() throws Exception {
		CustomerType ctype = new CustomerType();
		ctype.setTypeno(4);
		mapper.create(ctype);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete("4");
	}

	@Test
	public void testUpdate() throws Exception {
		CustomerType ctype = mapper.selectCustomerTypeById("3");
		ctype.setTypename("物业人员");
		mapper.update(ctype);
	}

	@Test
	public void testSelectCustomerTypeById() throws Exception {
		CustomerType ctype = mapper.selectCustomerTypeById("1");
		System.out.println(ctype);
	}

	@Test
	public void testSelectListByAll() throws Exception {
		CustomerType ctype = new CustomerType();
		List<CustomerType> list = mapper.selectListByAll(ctype);
		for(CustomerType ls:list)
		{
			System.out.println(ls);
		}
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		CustomerType ctype = new CustomerType();
		List<CustomerType> list = mapper.selectListByAllWithPage(ctype, 1, 1);
		for(CustomerType ls:list)
		{
			System.out.println(ls);
		}
	}

}
