package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.Area;
import cn.yichen.propertymgt.baseinfo.model.Building;


/**
 * 
 * @date:2019年8月18日下午9:36:29
 * @author LiYi(李海宏)
 * @Description：完善楼宇表dao层接口
 *
 */
@Mapper
public interface IBuildingMapper {
	//增加
	public void create(Building building) throws Exception;
	//删除
	public void delete(Building building) throws Exception;	
	//更新
	public void update(Building building) throws Exception;
	//取得所有楼宇列表
	public List<Building> selectListByAll() throws Exception;
	//取得所有楼宇列表,关联Area,分页模式
	public List<Building> selectListByAllWithArea() throws Exception;
	//取得所有楼宇列表,关联BuildingType,分页模式
	public List<Building> selectListByAllWithBuildType() throws Exception;
	//取得所有楼宇列表,关联Area和BuildingType
	public List<Building> selectListByAllWithAreaAndBuildType() throws Exception;
	//取得所有楼宇列表,关联Area和BuildingType,分页模式
	public List<Building> selectListByAllWithAreaAndBuildTypeWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;

	//取得指定楼宇的楼宇列表,参数:areaNo 
	public List<Building> selectListByArea(int areaNo) throws Exception;
	//取得指定建筑类型的楼宇列表,参数:buildTypeNo 
	public List<Building> selectListByBuildType(int buildTypeNo) throws Exception;
	//取得指定楼宇的信息
	public Building selectByNo(int no) throws Exception;
	//取得所有楼宇列表,分页模式
	public List<Building> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得楼宇的个数
	public int selectCountByAll() throws Exception;
	//根据综合检索条件取得楼宇列表
	public List<Building> selectListByConditionWithPage(
			@Param("areano") int areano,@Param("baddress") String baddress,
			@Param("buildingtypeno") int buildingtypeno,@Param("minhouse") int minhouse,@Param("maxhouse") int maxhouse, 
			@Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得不同楼宇个数
	public int selectCountByCondition(
			@Param("areano") int areano,@Param("baddress") String baddress,
			@Param("buildingtypeno") int buildingtypeno,@Param("minhouse") int minhouse,@Param("maxhouse") int maxhouse
			) throws Exception;
}
