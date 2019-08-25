package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.Building;
import cn.yichen.propertymgt.baseinfo.model.BuildingType;

/**
 * 
 * @date:2019年8月18日下午8:55:40
 * @author LiYi(李海宏)
 * @Description：完善楼宇类型代码
 *
 */
@Mapper
public interface IBuildingTypeMapper {
	//添加
	public void create(BuildingType typeno) throws Exception;
	//更新
	public void update(BuildingType typeno) throws Exception;
	//删除
	public void delete(BuildingType typeno) throws Exception;
	//通过指定id取得楼宇信息
	public BuildingType selectBuildingTypeByNo(int no) throws Exception;
	//取得楼宇列表
	public List<BuildingType> selectListByAll() throws Exception;
	//取得所有类型列表,分页模式
	public List<BuildingType> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得类型个数
	public int selectCountByAll() throws Exception;
	
	//根据综合检索条件取得楼宇类型列表
	public List<BuildingType> selectListByConditionWithPage(
			@Param("typeno") int typeno,@Param("start") int start,@Param("rows") int rows) throws Exception;
	
	//根据综合检索条件取得不同楼宇类型个数
	public int selectCountByCondition(int typeno) throws Exception;

}
