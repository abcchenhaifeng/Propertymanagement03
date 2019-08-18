package cn.yichen.propertymgt.baseinfo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.Building;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IBuildingMapperTest {
	@Autowired
	private IBuildingMapper mapper;
	
	@Test
	public void testInsert() throws Exception{
		Building building =new Building();
		building.setBuildingno("3");
		mapper.insert(building);
		
	}
	@Test
	public void testUpdate() throws Exception{
		Building building =mapper.selectByNo(2);
		building.setAreano("3");
		mapper.update(building);
		
	}
	@Test
	public void testDelete() throws  Exception{
		
	}

}
