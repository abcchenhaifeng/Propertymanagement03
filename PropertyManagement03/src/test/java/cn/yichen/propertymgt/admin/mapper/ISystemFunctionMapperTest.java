package cn.yichen.propertymgt.admin.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.admin.model.SystemFunction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ISystemFunctionMapperTest {

	@Autowired
	private ISystemFunctionMapper mapper;

	@Test
	public void testCreate() throws Exception {
		SystemFunction systemFunction = new SystemFunction();
		systemFunction.setNo(9);
		systemFunction.setName("test");
		mapper.create(systemFunction);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete(9);
	}

	@Test
	public void testUpdate() throws Exception {
		SystemFunction systemFunction = mapper.selectFunctionByNo(9);
		systemFunction.setName("Update");
		mapper.update(systemFunction);
	}

	@Test
	public void testSelectFunctionByNo() throws Exception {
		SystemFunction systemFunction = mapper.selectFunctionByNo(7);
		System.out.println(systemFunction);
	}

	@Test
	public void testSelectFunctionByNoWithModule() throws Exception {
		SystemFunction systemFunction = mapper.selectFunctionByNoWithModule(7);
		System.out.println(systemFunction);
	}

	@Test
	public void testSelectListByAll() throws Exception {
		mapper.selectListByCriteria(null);
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		mapper.selectListByCriteriaWithPage(null, 1, 2);
	}

}
