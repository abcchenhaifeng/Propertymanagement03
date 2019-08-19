package cn.yichen.propertymgt.baseinfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.yichen.propertymgt.baseinfo.model.HouseType;

/**
 * 
 * @date:2019年8月18日下午7:57:53
 * @author LiYi(李海宏)
 * @Description：户型dao接口
 *
 */
@Mapper
public interface IHouseTypeMapper {
	//增加户型
	public void create(HouseType h) throws Exception;
	//修改户型
	public void update(HouseType h) throws Exception;
	//删除户型
	public void delete(HouseType h) throws Exception;
	//查询户型的信息
	public List<HouseType> selectHouseTypeListByAll() throws Exception;
	//取得指定户型的信息
	public HouseType selectHouseTypeByNo(int no) throws Exception;
	//取得所有户型列表,分页模式
	public List<HouseType> selectListByAllWithPage(@Param("start") int start,@Param("rows") int rows) throws Exception;
	//取得户型的个数
	public int selectCountByAll() throws Exception;
}
