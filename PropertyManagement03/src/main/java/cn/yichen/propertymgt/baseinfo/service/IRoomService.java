package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;
import cn.yichen.propertymgt.baseinfo.model.Room;

/**
 * 
 * @data:2019年8月12日下午10:14:17
 * @author： 陈海锋
 * @Description:房间表Service层接口
 *
 */
public interface IRoomService {
	
	//添加
	public void add(Room room) throws Exception;
	
	// 修改
	public void modify(Room room) throws Exception;
	
	// 删除
	public void delete(Room room) throws Exception;
	
	//取得房间的单个对象，同时取得关联的列表
	public Room getByNo(int no) throws Exception;
	
	//只取得模块列表，不取得关联的功能列表。
	public List<Room> getListByAll() throws Exception;
	
	//按照楼宇编号来查询楼宇的信息
	public Room getRomByBuildingNo(String id) throws Exception;
	
	// 按条件获取列表(分页)
	public List<Room> getListByAllWithPage(int page, int rows) throws Exception;
	
	//获取房间个数
	public int getCountByAll(int rows) throws Exception;
	
	// 按id获取
	public Room getRoomById(String id) throws Exception;
	
	//取房间的页数
	public int getpageCountByAll() throws Exception;
	
	
}
