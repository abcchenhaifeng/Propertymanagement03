package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.BuildingType;

/**
 * 
 * @data 2019年8月8日 下午3:42:46
 * @author 陈海锋
 * @Desccription:实现客户类Mapper(Dao)层接口
 *
 */
@Mapper
public interface IBuildingTypeMapper {
	//添加
	@Insert("insert into BuildingType(TYPENO,TYPENAME) values(#{typeno},#{typename})")
	public void create(BuildingType typeno) throws Exception;
	//更新
	@Update("updata BuildingType set TYPENO=#{typeno},TYPENAME=#{typename} where TYPENO=#{typeno}")
	public void update(BuildingType typeno) throws Exception;
	//删除
	@Delete("delete from BuildingType where TYPENO = #{typeno}")
	public void delete(String id) throws Exception;
	
	public BuildingType selectBuildingTypeById(String id) throws Exception;
	
	//只取得模块列表，不取得关联的功能列表。
	public List<BuildingType> selectListByAll(BuildingType typeno) throws Exception;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式select方式
	public List<BuildingType> selectListByAllWithFunctionsByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> selectListByAllWithRolesByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> selectListByAllWithRolesByNestedResultMap() throws Exception;
	
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式select方式
	public List<BuildingType> selectListByAllWithFunctionsAndRolesFunctionByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> selectListByAllWithFunctionsAndRolesFunctionsByNestedResultMap() throws Exception;
	
	//只取得模块列表，取得关联的功能列表。	
	public List<BuildingType> selectListByAllWithFunctions() throws Exception;
	//
	public BuildingType selectByNo(int no) throws Exception;
	public BuildingType selectByNoWithFunctions(int no) throws Exception;
	//取得所有模块的个数
	public int selectCountByAll() throws Exception;
	//取得指定角色的模块列表
	

}
