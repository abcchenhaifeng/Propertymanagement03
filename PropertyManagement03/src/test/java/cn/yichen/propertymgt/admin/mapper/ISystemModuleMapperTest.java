package cn.yichen.propertymgt.admin.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.admin.model.SystemModule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ISystemModuleMapperTest {

	@Autowired
	private ISystemModuleMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		
		SystemModule systemModule = new SystemModule();
		systemModule.setNo(100);
		systemModule.setName("test");
		mapper.create(systemModule);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete(100);
	}

	@Test
	public void testUpdate() throws Exception {
		SystemModule systemModule = mapper.selectModuleByNo(100);
		systemModule.setName("update");
		mapper.update(systemModule);
	}

	@Test
	public void testSelectModuleByNo() throws Exception {
		mapper.selectModuleByNo(1);
	}

	@Test
	public void testSelectModuleByNoWithFunctions() throws Exception {
		SystemModule systemModule = mapper.selectModuleByNoWithFunctions(1);
		System.out.println(systemModule);
	}

	@Test
	public void testSelectListByAll() throws Exception {
		mapper.selectListByAll(null);
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		mapper.selectListByAllWithPage(null, 1, 2);
	}

}
