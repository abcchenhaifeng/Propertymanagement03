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
	public void add(Room room) throws Exception;
	public void modify(Room room) throws Exception;
	public void delete(Room room) throws Exception;
	//只取得模块列表，不取得关联的功能列表。
	public List<Room> getListByAll() throws Exception;
}
