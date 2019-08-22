package cn.yichen.propertymgt.baseinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yichen.propertymgt.baseinfo.mapper.IRoomMapper;
import cn.yichen.propertymgt.baseinfo.model.Room;
import cn.yichen.propertymgt.baseinfo.service.IRoomService;

/**
 * 
 * @data:2019年8月21日下午3:31:28
 * @author： 陈海锋
 * @Description:房间业务层实现类
 *
 */
@Service
@Transactional(rollbackFor ={Exception.class})
public class RoomServiceImpl implements IRoomService {

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
		mapper.delete(room);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAll() throws Exception {
		return mapper.selectRoomListByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithFK() throws Exception {
		return mapper.selectListByAllwithFK();
	}

	@Override
	@Transactional(readOnly = true)
	public Room getByRoomNo(int roomno) throws Exception {
		return mapper.selectRoomByNo(roomno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithPage(int rows, int page) throws Exception {
		return mapper.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	@Transactional(readOnly = true)
	public int getCountByAll() throws Exception {
		return mapper.selectCountByAll();
	}

	@Override
	@Transactional(readOnly = true)
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount=0;
		int count=this.getCountByAll();
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithHouseTypeNo() throws Exception {
		return mapper.selectListByAllWithHouseTypeNo();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByAllWithBuildingNo() throws Exception {
		return mapper.selectListByAllWithBuildingNo();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByHouseTypeNo(int housetypeno) throws Exception {
		return mapper.selectListByHouseTypeNo(housetypeno);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Room> getListByBuildingNo(int buildingno) throws Exception {
		return mapper.selectListByBuildingNo(buildingno);
	}

	@Override
	public List<Room> getBuildingNo() throws Exception {
		return mapper.selectbuildingtype();
	}

	@Override
	public List<Room> getlivingStatus() throws Exception {
		return mapper.selectlivingStatus();
	}
	
	@Override
	public List<Room> getListByConditionWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode,int rows,int page) throws Exception{
		return mapper.selectListByConditionWithPage(RoomNo, HouseTypeNo, DepartmentCode, rows*(page-1), rows);
	}
	
	@Override
	public int getCountByConditionandTypeWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode) throws Exception{
		return mapper.selectListByCondition(RoomNo, HouseTypeNo, DepartmentCode);
	}
	
	@Override
	public int getpageConditionWithPage(String RoomNo,String HouseTypeNo,String DepartmentCode,int rows) throws Exception{
		int pageCount=0;
		int count=this.getCountByConditionandTypeWithPage(RoomNo, HouseTypeNo, DepartmentCode);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		return pageCount ;
	}

	@Override
	public boolean checkRoomNoExist(String roomno) throws Exception {
		boolean result=false;
		if(mapper.selectCountByRoom(roomno)>0) {
			result=true;
		}
		return result;
	}
}
