package cn.yichen.propertymgt.baseinfo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICustomerMapperTest {

	@Autowired
	private ICustomerMapper mapper;


	//测试删除操作
	@Test
	public void testDelete() throws Exception {
		mapper.delete("6");
	}
	
	//测试按客户编号查询
	@Test
	public void testSelectCustomerById() throws Exception {

		Customer customer = mapper.selectCustomerById("1");
		System.out.println(customer);
		
	}
	
	//测试创建操作
	@Test
	public void testCreate() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerNo("8");
		customer.setCname("李元天霸");
		mapper.create(customer);
	}

	//测试更新操作
	@Test
	public void testUpdate() throws Exception {
		Customer customer =  mapper.selectCustomerById("7");
		customer.setCname("李元天霸");
		mapper.update(customer);
	}

	//测试选择所有
	@Test
	public void testSelectListByAll() throws Exception {
		List<Customer> list = mapper.selectListByAll();
		System.out.println(list.size());
		for(Customer ls:list)
		{
			System.out.println(ls);
		}
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception{
		Customer customer = new Customer();
		List<Customer> list = mapper.selectListByAllWithPage( 2, 2);
		System.out.println(list.size());
		for(Customer ls:list)
		{
			System.out.println(ls);
		}
	}
	
	@Test
	public void testSelectCustomerByIdWithType() throws Exception {
		Customer customer = mapper.selectCustomerByIdWithType("2");
		System.out.println(customer);
	}


	@Test
	public void testSelectCountByAll() throws Exception {
		int i = mapper.selectCountByAll();
		System.out.println(i);
	}
	
	@Test
	public void testSelectCustomerByIdandHomeWithPage() throws Exception {
		List<Customer> list = mapper.selectCustomerByAllandHomeWithPage(2, 2);
		System.out.println(list.size());
		for(Customer ls:list)
		{
			System.out.println(ls);
		}
	}
	
	
}
