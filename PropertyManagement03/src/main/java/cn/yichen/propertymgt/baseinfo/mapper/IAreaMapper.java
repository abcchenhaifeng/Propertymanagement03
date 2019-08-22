package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.Area;

/**
 * 
 * @date:2019年8月18日下午7:57:53
 * @author LiYi(李海宏)
 * @Description：小区dao接口
 *
 */
@Mapper
public interface IAreaMapper {
	//增加小区
	public void create(Area area) throws Exception;
	//修改小区
	public void update(Area area) throws Exception;
	//删除小区
	public void delete(Area area) throws Exception;
	//查询小区的信息
	public List<Area> selectAreaListByAll() throws Exception;
	//取得指定小区的信息
	public Area selectAreaByNo(int no) throws Exception;
	//取得所有小区列表,分页模式
	public List<Area> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得小区的个数
	public int selectCountByAll() throws Exception;
	//根据综合检索条件取得小区列表
	public List<Area> selectListByConditionWithPage(
			@Param("name") String name,@Param("developer") String developer,
			@Param("minbuildingarea") Double minbuildingarea,@Param("maxbuildingarea") Double maxbuildingarea,
			@Param("minhome") Long minhome,@Param("maxhome") Long maxhome,
			@Param("minhouse") Long minhouse,@Param("maxhouse") Long maxhouse, 
			@Param("start") int start,@Param("rows") int rows) throws Exception;
	//根据综合检索条件取得小区个数
	public int selectCountByCondition(
			@Param("name") String name,@Param("developer") String developer,
			@Param("minbuildingarea") Double minbuildingarea,@Param("maxbuildingarea") Double maxbuildingarea,
			@Param("minhome") Long minhome,@Param("maxhome") Long maxhome,
			@Param("minhouse") Long minhouse,@Param("maxhouse") Long maxhouse) throws Exception;
}
