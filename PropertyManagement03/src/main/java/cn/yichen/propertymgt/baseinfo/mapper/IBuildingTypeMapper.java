package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yichen.propertymgt.baseinfo.model.BuildingType;

/**
 * 
 * @data 2019年8月8日 下午3:42:46
 * @author 陈海锋
 * @Desccription:
 *
 */
@Mapper
public interface IBuildingTypeMapper {
	public void create(BuildingType buildingtype) throws Exception;
	public void updata(BuildingType buildingtype) throws Exception;
	public void delete(BuildingType buildingtype) throws Exception;
	
	public List<BuildingType> selectListByall() throws Exception;
	public List<BuildingType> selectListByallWithNestedSelect() throws Exception;
	public List<BuildingType> selectListByAllWithNestedResultMap() throws Exception;
	

}
