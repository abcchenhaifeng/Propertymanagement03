package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.CustomerHome;
import cn.yichen.propertymgt.baseinfo.model.Room;

/**
 * 
 * @date:2019年8月19日 下午3:26:46
 * @author LiYi(李海宏）
 * @description:完善客户客户房间表的业务接口
 */

public interface ICustomerHomeService {

	//增加
	public void add(CustomerHome ch) throws Exception;
	//修改
	public void modify(CustomerHome ch) throws Exception;
	//删除
	public void delete(CustomerHome ch) throws Exception;
	//取得所有客户房间列表
	public List<CustomerHome> getListByAll() throws Exception;
	//取得所有客户房间包含信息
	public List<CustomerHome> getListByAllWithFK() throws Exception;
	//取得客户房间单个对象，
	public CustomerHome getCustomerHomeByNo(int CustomerHomeno) throws Exception;
	//取得所有客户房间列表,分页模式
	public List<CustomerHome> getListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得客户房间的个数
	public int getCountByAll() throws Exception;
	//取得客户房间页数
	public int getPageCountByAll(int rows) throws Exception;
//	//取得迁居类型
//	public List<CustomerHome> getLivingStatus(int no) throws Exception;
//	//修改迁居类型为迁出
//	public void modifyStatus(CustomerHome ch) throws Exception;
//	//修改迁居类型为迁入
//	public void updateStatus(CustomerHome ch) throws Exception;
//	//验证迁居类型
//	public boolean checkCanModify(int no) throws Exception;
}
