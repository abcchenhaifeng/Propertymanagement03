package cn.yichen.propertymgt.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransaction {

	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Test
	public void testTransactionManager() {
		
		System.out.println(transactionManager);
		System.out.println(transactionManager.getDataSource());
	}
}
