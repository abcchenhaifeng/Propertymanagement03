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

		Customer customer = mapper.selectCustomerById("6");
		System.out.println(customer);
		
	}
	
	//测试创建操作
	@Test
	public void testCreate() throws Exception {
		Customer customer = new Customer();
		customer.setCustomerNo("7");
		customer.setCname("李天霸");
		mapper.create(customer);
	}

	//测试更新操作
	@Test
	public void testUpdate() throws Exception {
		Customer customer =  mapper.selectCustomerById("7");
		customer.setCname("李元霸");
		mapper.update(customer);
	}

	//测试选择所有
	@Test
	public void testSelectListByAll() throws Exception {
		Customer customer = new Customer();
		List<Customer> list = mapper.selectListByAll(customer);
		for (Customer ls : list) {
			System.out.print(ls);
		}
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception{
		Customer customer = new Customer();
		
	}


}
