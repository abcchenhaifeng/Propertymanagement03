package cn.yichen.propertymgt.baseinfo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.Customer;
import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.baseinfo.model.CustomerType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICustomerHomeMapperTest {

	@Autowired
	private ICustomerHomeMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		CustomerHome chome = new CustomerHome();
		chome.setChno("8");
		chome.setCustomerno("3");
		mapper.create(chome);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete("8");
		
	}

	@Test
	public void testUpdate() throws Exception {
		CustomerHome chome = mapper.selectCustomerHomeById("5");
		chome.setHumancount(1);
		mapper.update(chome);
	}

	@Test
	public void testSelectCustomerHomeById() throws Exception {
		CustomerHome chome = mapper.selectCustomerHomeById("2");
		System.out.println(chome);
	}

	@Test
	public void testSelectListByAll() throws Exception {
		List<CustomerHome> list = mapper.selectListByAll(new CustomerHome());
		System.out.println(list.size());
		for (CustomerHome customerHome : list) {
			System.out.println(customerHome);
		}
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		CustomerHome chome = new CustomerHome();
		List<CustomerHome> list = mapper.selectListByAllWithPage(chome, 2, 2);
		System.out.println(list.size());
		for (CustomerHome customerHome : list) {
			System.out.println(customerHome);
		}
	}

	@Test
	public void testSelectCustomerHomeByCustomerNo() throws Exception {
		CustomerHome chome = mapper.selectCustomerHomeByCustomerNo("1");
		System.out.println(chome);
		/*
		 * List<Customer> list = chome.getCustomer(); for (Customer customer : list) {
		 * System.out.println(customer); }
		 */
		
	}
	
	@Test
	public void testSelectCustomerHomeByIdWithRoomFee() throws Exception {
		CustomerHome chome = mapper.selectCustomerHomeByIdWithRoomFee("688");
		System.out.println(chome);
	}
}
