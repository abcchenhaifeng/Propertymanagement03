package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import cn.yichen.propertymgt.baseinfo.model.Building;
import cn.yichen.propertymgt.baseinfo.model.BuildingType;

/**
 * 
 * @date:2019年8月18日下午9:11:06
 * @author LiYi(李海宏)
 * @Description：完善楼宇类型代码
 *
 */
public interface IBuildingTypeService {
	//增加
	public void add(BuildingType typeno) throws Exception;
	//修改
	public void modify(BuildingType typeno) throws Exception;
	//删除
	public void delete(BuildingType typeno) throws Exception;
	//查询建筑类型的信息
	public List<BuildingType> getBuildTypeListByAll() throws Exception;
	//取得指定建筑类型的信息
	public BuildingType getBuildTypeByNo(int no) throws Exception;
	//取得所有建筑类型列表,分页模式
	public List<BuildingType> getListByAllWithPage(int rows,int page) throws Exception;
	//取得建筑类型的个数
	public int getCountByAll() throws Exception;
	//取得建筑类型页数
	public int getPageCountByAll(int rows) throws Exception;
	
	//根据综合检索条件取得楼宇列表
	public List<BuildingType> getListByConditionWithPage(int typeno,int rows,int page) throws Exception;
	
	//根据综合检索条件取得楼宇个数
	public int getCountByCondition(int typeno) throws Exception;
	
	//根据综合检索条件取得楼宇显示的页数
	public int getPageCountByConditionWithPage(int typeno,int rows) throws Exception;
	
}
