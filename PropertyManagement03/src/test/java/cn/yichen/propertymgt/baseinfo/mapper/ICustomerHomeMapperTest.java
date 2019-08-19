package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.CustomerHome;

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
		CustomerHome chome = mapper.selectCustomerHomeById("5");
		mapper.delete(chome);
		
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


}
