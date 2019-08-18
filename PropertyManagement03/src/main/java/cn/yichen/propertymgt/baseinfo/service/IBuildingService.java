package cn.yichen.propertymgt.baseinfo.service;

import cn.yichen.propertymgt.baseinfo.model.Building;

/**
 * 
 * @data:2019年8月16日下午2:44:41
 * @author： 陈海锋
 * @Description:
 *
 */
public interface IBuildingService {
	//增加
	public void add(Building building) throws Exception;
	//修改
	public void modify(Building building) throws Exception;
	//删除
	public void delete(Building building) throws Exception;
	//取得房间序号
	public int selectCountByAll() throws Exception;
	
}
