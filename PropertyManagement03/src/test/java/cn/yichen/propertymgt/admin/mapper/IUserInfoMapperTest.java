package cn.yichen.propertymgt.admin.mapper;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.admin.model.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserInfoMapperTest {

	@Autowired
	private IUserInfoMapper mapper;

	@Test
	public void testCreate() throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo.setId("test");
		userInfo.setUsername("test");
		mapper.create(userInfo);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete("test");
	}

	@Test
	public void testUpdate() throws Exception {
		UserInfo userInfo = mapper.selectUserInfoById("lhh");
		userInfo.setUsername("骚男");
		mapper.update(userInfo);
	}

	@Test
	public void testSelectUserInfoById() throws Exception {
		UserInfo userInfo = mapper.selectUserInfoById("yichen");
		System.out.println(userInfo);
	}

	
	@Test 
	 public void testSelectListByAll() throws Exception { 
		 UserInfo userInfo= new UserInfo(); 
		 userInfo.setId("y"); 
		 mapper.selectListByCriteria(userInfo, null, null); 
      }

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		mapper.selectListByCriteriaWithPage(null, 1, 2, null, null);
	}

	
	 @Test public void testAddFunction() throws Exception { 
		 mapper.addFunction("yichen", 8); 
     }
	 

	@Test
	public void testAddFunctions() throws Exception {
		int[] funNos = {1, 2, 3, 4};
		mapper.addFunctions("yichen", funNos);
	}
	
	@Test
	public void testSelectCountByAll() throws Exception {
		mapper.selectCountByCriteria(null, null, null);
	}
	
	@Test
	public void testDeleteFunction() throws Exception {
		mapper.deleteFunction("yichen", 9);
	}

}
