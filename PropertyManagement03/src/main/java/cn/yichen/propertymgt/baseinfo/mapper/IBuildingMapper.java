package cn.yichen.propertymgt.baseinfo.mapper;

/**
 * 
 * @data 2019年8月16日 上午11:04:07
 * @author 陈海锋
 * @Desccription:楼宇表
 *
 */
public interface IBuildingMapper {
	//增加
	public void insert(IBuildingMapper building) throws Exception;
	
	//删除
	public void delete(IBuildingMapper building) throws Exception;
	
	//更新
	public void update(IBuildingMapper building) throws Exception;
}
