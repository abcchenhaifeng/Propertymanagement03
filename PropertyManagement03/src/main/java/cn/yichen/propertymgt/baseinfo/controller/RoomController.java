package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.yichen.propertymgt.baseinfo.model.Room;
import cn.yichen.propertymgt.baseinfo.service.IRoomService;
import cn.yichen.propertymgt.vo.ResultMessage;

/**
 * 
 * @data:2019年8月14日上午10:26:46
 * @author： 陈海锋
 * @Description:房间类控制层实现
 *
 */
@RestController
@RequestMapping("/room")
@EnableWebMvc
@CrossOrigin
public class RoomController {
	@Autowired
	private IRoomService roomService=null;
	
	//增加房间
	@RequestMapping("/add")
	public ResultMessage<Room> add(Room room) throws Exception{
		roomService.add(room);
		return new ResultMessage<Room>("OK","房间增加成功");	
	}
	
	//修改房间
	@RequestMapping("/modify")
	public ResultMessage<Room> modify(Room room) throws Exception{
		roomService.modify(room);
		return new ResultMessage<Room>("OK","房间修改成功");	
	}
	
	//删除房间
	@RequestMapping("/delete")
	public ResultMessage<Room> delete(Room room) throws Exception{
		roomService.delete(room);
		return new ResultMessage<Room>("OK","房间修改成功");	
	}
	
	//取得指定房间
	@RequestMapping("/get")
	public ResultMessage<Room> getByNo(int roomno) throws Exception{
		roomService.getByNo(roomno);
		return new ResultMessage<Room>("OK","房间修改成功");	
	}
	
	//取得所有房间列表，有分页
	@RequestMapping(value="/list/all/page")
	public ResultMessage<Room> getListByAllWithPage(@RequestParam(required = false,defaultValue = "10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<Room> result=new ResultMessage<Room>("OK","取得房间分页模式成功");
		result.setCount(roomService.getCountByAll(2));
		result.setPage(roomService.getpageCountByAll());
		result.setList(roomService.getListByAllWithPage(page, rows));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	//取得所有房间列表，无分页
	@RequestMapping(value="/list/all")
	public List<Room> getListByAll() throws Exception {
		return roomService.getListByAll();
	}

}
