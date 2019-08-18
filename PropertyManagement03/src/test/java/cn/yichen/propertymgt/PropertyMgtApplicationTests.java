package cn.yichen.propertymgt;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyMgtApplicationTests {

	@Autowired
	private DataSource ds;
	
	@Test
	public void contextLoads() {
		System.out.println(ds.getClass());
		
		ComboPooledDataSource cpds = (ComboPooledDataSource) ds;
		System.out.println(cpds.getMaxPoolSize());
		System.out.println(cpds.getMinPoolSize());
		System.out.println(cpds.getInitialPoolSize());
	}

}
