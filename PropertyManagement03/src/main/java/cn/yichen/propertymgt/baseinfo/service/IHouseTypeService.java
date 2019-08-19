package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import cn.yichen.propertymgt.baseinfo.model.HouseType;

/**
 * 
 * @date:2019年8月18日下午11:39:27
 * @author LiYi(李海宏)
 * @Description：完善户型表的dao接口
 *
 */
public interface IHouseTypeService {
	//添加
	public void add(HouseType h) throws Exception;
	//修改
	public void modify(HouseType h) throws Exception;
	//修改
	public void delete(HouseType h) throws Exception;
	//查询户型的信息
	public List<HouseType> getHouseTypeListByAll() throws Exception;
	//取得指定户型的信息
	public HouseType getHouseTypeByNo(int no) throws Exception;
	//取得所有户型列表,分页模式
	public List<HouseType> getListByAllWithPage(int rows,int page) throws Exception;
	//取得户型的个数
	public int getCountByAll() throws Exception;
	//取得户型页数
	public int getPagaCountByAll(int rows) throws Exception;
}
