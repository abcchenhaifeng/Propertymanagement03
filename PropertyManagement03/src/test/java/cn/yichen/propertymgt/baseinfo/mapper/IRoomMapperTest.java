package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

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
		Room roomno = new Room();
		roomno.setRoomno("103");
		roomno.setBuildingno("2");
		roomno.setDepartmentcode("aaa"); 
		roomno.setFloor("1"); 
		roomno.setRoomcode("384");
		roomno.setBuildingarea("4500.00"); 
		roomno.setFeearea("1900");
		roomno.setRoomstatus("空闲"); 
		roomno.setRoomtype("自建");
		 
		mapper.create(roomno);		
	}
	
	@Test
	public void testDelete(Room romm) throws Exception {
		mapper.delete("101");
	}
	
	@Test
	public void testUpdate() throws Exception {
		Room roomno = mapper.selectRoomById("103");
		roomno.setHousetypeno("3");
		mapper.update(roomno);	
	}
	
	@Test
	public void testSelectListByAll() throws Exception {
		List<Room> list = mapper.selectListByAll();
		System.out.println(list.size());
		for(Room ls:list)
		{
			System.out.println(ls);
		}
	}
	@Test
	public void testSelectListByAllWithPage() throws Exception{
		mapper.selectListByAllWithPage(1, 2);
	}
	
}