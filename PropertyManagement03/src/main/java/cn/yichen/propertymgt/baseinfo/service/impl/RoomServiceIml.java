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
		mapper.create(room);

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
	public List<Room> getListByAll() throws Exception {
		return mapper.selectListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithPage(int page, int rows) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectListByAllWithPage( rows*(page-1), rows); 
	}

	@Autowired
	@Transactional(readOnly = true)
	public Room getRoomById(String id) throws Exception {
		return mapper.selectRoomById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return mapper.selectCountByAll(0);
	}
	
	//获取房间的个数
	@Override
	@Transactional(readOnly = true)
	public int getpageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count= this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows/1;
		}
		return pageCount;
	}

	@Override
	public Room getByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
