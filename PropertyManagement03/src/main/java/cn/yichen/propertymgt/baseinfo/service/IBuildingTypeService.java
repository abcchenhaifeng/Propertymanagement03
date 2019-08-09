package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import cn.yichen.propertymgt.baseinfo.model.BuildingType;

/**
 * 
 * @data:2019年8月8日下午10:00:12
 * @author： 陈海锋
 * @Description:
 *
 */
public interface IBuildingTypeService {
	public void add(BuildingType typeno) throws Exception;
	public void modify(BuildingType typeno) throws Exception;
	public void delete(BuildingType typeno) throws Exception;
	//只取得模块列表，不取得关联的功能列表。
	public List<BuildingType> getListByAll() throws Exception;
	
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式select方式
	public List<BuildingType> getselectListByAllWithFunctionsByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> getselectListByAllWithFunctionsByNestedResultMap() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式select方式
	public List<BuildingType> getListByAllWithRolesByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的角色属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> getListByAllWithRolesByNestedResultMap() throws Exception;
	
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式select方式
	public List<BuildingType> getListByAllWithFunctionsAndRolesFunctionByNestedSelect() throws Exception;
	//取得模块列表，并取得关联的功能和角色属性列表，使用内嵌式ResultMap方式
	public List<BuildingType> getListByAllWithFunctionsAndRolesFunctionsByNestedResultMap() throws Exception;
	
	public BuildingType getByNo(int no) throws Exception;
	//取得所有模块的个数
	public int getCountByAll() throws Exception;
	//取得指定角色的模块列表
	public List<BuildingType> getListByRole(int roleNo) throws Exception;
	//验证指定角色是否有此模块权限: 参数：模块编号，角色编号
	public boolean checkAccessForRole(int buildingtypeno,int typeno) throws Exception;
}
