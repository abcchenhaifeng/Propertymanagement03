package cn.yichen.propertymgt.baseinfo.service;

import java.math.BigDecimal;
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
	//根据综合检索条件取得小区列表
	public List<Area> getListByConditionWithPage(String name,String developer,Double minbuildingarea,Double maxbuildingarea,
			Long minhome,Long maxhome,Long minhouse,Long maxhouse, int rows,int page) throws Exception;
	
	//根据综合检索条件取得小区个数
	public int getCountByCondition(String name,String developer,Double minbuildingarea,Double maxbuildingarea,Long minhome,
			Long maxhome,Long minhouse,Long maxhouse) throws Exception;
	
	//根据综合检索条件取得小区显示的页数
	public int getPageCountByConditionWithPage(String name,String developer,Double minbuildingarea,Double maxbuildingarea,
			Long minhome,Long maxhome,Long minhouse,Long maxhouse,int rows) throws Exception;


}
