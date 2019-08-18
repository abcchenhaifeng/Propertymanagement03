package cn.yichen.propertymgt.baseinfo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import cn.yichen.propertymgt.baseinfo.model.Building;

/**
 * 
 * @data:2019年8月16日下午2:44:24
 * @author： 陈海锋
 * @Description:
 *
 */
@Mapper
public interface IBuildingMapper {
	//增加
	public void insert(Building building) throws Exception;
	
	//删除
	public void delete(Building building) throws Exception;
	
	//更新
	public void update(Building building) throws Exception;
	
	//取得楼宇的序号
	public int selectCountByAll() throws Exception;

	public Building selectByNo(int buildingno)throws Exception;

	
}
