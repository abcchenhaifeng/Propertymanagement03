package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.BuildingType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IBuildingTypeMapperTest {

	
	@Autowired
	private IBuildingTypeMapper mapper;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() throws Exception {
		BuildingType BuildingType = new BuildingType();
		BuildingType.setTypename("威武型");
        mapper.create(BuildingType);
	}

	@Test
	public void testUpdate() throws Exception {
		BuildingType BuildingType = mapper.selectBuildingTypeById("5");
		BuildingType.setTypename("简易型");
		mapper.update(BuildingType);
	}
	
	//测试删除
	@Test
	public void testDelete() throws Exception {
		mapper.delete("9");
	}

	@Test
	public void testSelectListByAll() throws Exception {
	List<BuildingType> list = mapper.selectListByAll();
	for (BuildingType buildingType : list) {
		System.out.println(buildingType);
	}
	}

}
