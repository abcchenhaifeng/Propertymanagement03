package cn.yichen.propertymgt.admin.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
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
	public void testSelectFunctionByNo() throws Exception {
		SystemFunction systemFunction = mapper.selectFunctionByNo("7");
		System.out.println(systemFunction);
	}

}
