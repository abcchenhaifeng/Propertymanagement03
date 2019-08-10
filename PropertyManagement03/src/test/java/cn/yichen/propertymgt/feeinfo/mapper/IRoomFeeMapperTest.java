package cn.yichen.propertymgt.feeinfo.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.yichen.propertymgt.feeinfo.model.RoomFee;



@RunWith(SpringRunner.class)
@SpringBootTest
public class IRoomFeeMapperTest {

	@Autowired
	private IRoomFeeMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		RoomFee roomFee = new RoomFee();
		roomFee.setRoomfeeno(7);
		mapper.create(roomFee);
	}

	@Test
	public void testDelete() throws Exception {
		mapper.delete("7");
	}

	@Test
	public void testUpdate() throws Exception {
		RoomFee feeById = mapper.selectRoomFeeById("1");
		feeById.setSpay(3620.25);
		feeById.setApay(3500.25);
		mapper.update(feeById);
	}

	@Test
	public void testSelectRoomFeeById() throws Exception {
		RoomFee feeById = mapper.selectRoomFeeById("1");
		System.out.println(feeById);
	}

	@Test
	public void testSelectListByAll() throws Exception {
		List<RoomFee> list = mapper.selectListByAll(new RoomFee());
		//System.out.println(list);
		for (RoomFee roomFee : list) {
			System.out.println(roomFee);
		}
	}

	@Test
	public void testSelectListByAllWithPage() throws Exception {
		List<RoomFee> list = mapper.selectListByAllWithPage(new RoomFee(), 2, 2);
		//System.out.println(list);
		for (RoomFee roomFee : list) {
			System.out.println(roomFee);
		}
	}

	@Test
	public void testSelectCountByAll() throws Exception {
		int i = mapper.selectCountByAll(new RoomFee());
		System.out.println(i);
	}

	
	@Test
	public void testSelectRoomFeeByIdWithCustomerHome() throws Exception {
		RoomFee feeById = mapper.selectRoomFeeByIdWithCustomerHome("688");
		System.out.println(feeById);
	}
}
