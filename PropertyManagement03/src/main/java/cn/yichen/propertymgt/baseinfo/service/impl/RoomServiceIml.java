package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IRoomMapper;
import cn.yichen.propertymgt.baseinfo.model.Room;
import cn.yichen.propertymgt.baseinfo.service.IRoomService;

@Service
@Transactional(rollbackFor = {Exception.class})
public class RoomServiceIml implements IRoomService {
	
	@Autowired
	private IRoomMapper mapper;
	
	@Override
	public void add(Room room) throws Exception {
		mapper.insert(room);

	}

	@Override
	public void modify(Room room) throws Exception {
		mapper.update(room);

	}

	@Override
	public void delete(Room room) throws Exception {
		mapper.delete("101");

	}

	@Override
	public Room getByNo(int no) throws Exception {
		return mapper.selectByNo(101);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAll() throws Exception {
		return mapper.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Room getRomByBuildingNo(String id) throws Exception {
		return mapper.selectRomByBuildingNo("101");
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithPage(int page, int rows) throws Exception {
		return mapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll(int rows) throws Exception {
		return mapper.selectCountByAll(rows);
	}

	@Override
	@Transactional(readOnly = true)
	public Room getRoomById(String id) throws Exception {
		return mapper.selectRoomById("2");
	}

	@Override
	@Transactional(readOnly = true)
	public int getpageCountByAll() throws Exception {
		return mapper.selectCountByAll(5);
	}

}
