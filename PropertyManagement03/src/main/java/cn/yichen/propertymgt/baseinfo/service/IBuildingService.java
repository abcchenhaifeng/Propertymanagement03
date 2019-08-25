package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.model.Building;

public interface IBuildingService {
	//增加
	public void add(Building building) throws Exception;
	//修改
	public void modify(Building building) throws Exception;
	//删除
	public void delete(Building building) throws Exception;
	//查询楼宇的信息
	public List<Building> getListByAll() throws Exception;
	//查询楼宇的信息,关联Area
	public List<Building> getListByAllWithArea() throws Exception;
	//查询楼宇的信息,关联BuildingType
	public List<Building> getListByAllWithBuildType() throws Exception;
	//查询楼宇的信息,关联Area和BuildingType
	public List<Building> getListByAllWithAreaAndBuildType() throws Exception;

	//取得所有楼宇列表,关联Area和BuildingType.分页模式
	public List<Building> getListByAllWithAreaAndBuildTypeWithPage(int rows,int page) throws Exception;
	//取得指定楼宇的楼宇列表,参数:areaNo 
	public List<Building> getListByArea(int areaNo) throws Exception;
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<Building> getListByBuildType(int buildTypeNo) throws Exception;
	//取得指定楼宇的信息
	public Building getByNo(int no) throws Exception;
	//取得所有楼宇列表,分页模式
	public List<Building> getListByAllWithPage(int rows,int page) throws Exception;
	//取得楼宇的个数
	public int getCountByAll() throws Exception;
	//取得楼宇页数
	public int getPageCountByAll(int rows) throws Exception;
	
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<Building> getListOnlyWithAddress() throws Exception;
	
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<Building> getListOnlyWithBuildingType() throws Exception;
	
	
	//根据综合检索条件取得楼宇列表
	public List<Building> getListByConditionWithPage(int areano,String baddress,int buildingtypeno,int minhouse,int maxhouse,int rows,int page) throws Exception;
	
	//根据综合检索条件取得楼宇个数
	public int getCountByCondition(int areano,String baddress,int buildingtypeno,int minhouse,int maxhouse) throws Exception;
	
	//根据综合检索条件取得楼宇显示的页数
	public int getPageCountByConditionWithPage(int areano,String baddress,int buildingtypeno,int minhouse,int maxhouse,int rows) throws Exception;
}

