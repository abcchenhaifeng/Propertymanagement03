package cn.yichen.propertymgt.admin.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
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
		UserInfo userInfo = new UserInfo();
		userInfo.setId("y");
		mapper.selectListByAll(userInfo);
	}

	@Test
	public void testSelectListByAllWithPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectListByAll1() {
		fail("Not yet implemented");
	}
	@Test
	public void testAddFunction() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFunctions() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectFunctionListByUser() {
		fail("Not yet implemented");
	}

}
