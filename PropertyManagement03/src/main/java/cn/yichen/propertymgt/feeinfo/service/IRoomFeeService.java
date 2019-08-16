package cn.yichen.propertymgt.feeinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.yichen.propertymgt.feeinfo.model.RoomFee;

/**
 * 
 * @date:2019年8月10日下午9:55:51
 * @author LiYi(李海宏)
 * @Description：房间缴费Service层接口
 *
 */
public interface IRoomFeeService {

	// 添加
	public void add(RoomFee roomfee) throws Exception;

	// 修改
	public void modify(RoomFee systemModule) throws Exception;

	// 删除
	public void delete(int no) throws Exception;

	// 按条件获取列表
	public List<RoomFee> getListByAll(RoomFee systemModule) throws Exception;

	// 按条件获取列表(分页)
	public List<RoomFee> getListByAllWithPage(RoomFee systemModule, int page, int rows) throws Exception;

	// 按no获取
	public RoomFee getModuleByNo(int no) throws Exception;

	// 获取个数
	public int getCountByAll(RoomFee systemModule) throws Exception;
}
