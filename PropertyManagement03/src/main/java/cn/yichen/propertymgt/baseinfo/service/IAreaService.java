package cn.yichen.propertymgt.baseinfo.service;

import java.util.List;

import cn.yichen.propertymgt.baseinfo.model.Area;

/**
 * 2019年8月8日15:06:06
 * @author YiChen(李冠永)
 * #小区Service层接口
 *
 */
public interface IAreaService {
	//添加
	public void add(Area area) throws Exception;
	//修改
	public void modify(Area area) throws Exception;
	//修改
	public void delete(Area area) throws Exception;
	//查询小区的信息
	public List<Area> getAreaListByAll() throws Exception;
	//取得指定小区的信息
	public Area getAreaByNo(int no) throws Exception;
	//取得所有小区列表,分页模式
	public List<Area> getListByAllWithPage(int rows,int page) throws Exception;
	//取得小区的个数
	public int getCountByAll() throws Exception;
	//取得小区页数
	public int getPagaCountByAll(int rows) throws Exception;
	//取得开发商列表
	public List<Area> getListByDeveloper() throws Exception;
}
