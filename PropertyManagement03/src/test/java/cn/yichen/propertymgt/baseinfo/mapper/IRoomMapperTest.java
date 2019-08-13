package cn.yichen.propertymgt.baseinfo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.baseinfo.model.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IRoomMapperTest {
	@Autowired
	private IRoomMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		Room room = new Room();
		room.setHousetypeno("4");
		room.setBuildingno("2");
		mapper.create(room);		
	}
	
	@Test
	public void testDelete() throws Exception {
		mapper.delete("101");
		
	}

}
