package cn.yichen.bootwebmybatis.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.yichen.bootwebmybatis.security.model.RoleModel;

//角色DAO接口
@Mapper
public interface IRoleDao {
	//增加角色
	public void create(RoleModel role) throws Exception;
	//修改角色
	public void update(RoleModel role) throws Exception;
	//删除角色
	public void delete(RoleModel role) throws Exception;
	//取得所有角色列表
	public List<RoleModel> selectListByAll() throws Exception;
	//取得指定的角色
	public RoleModel selectRoleByNo(int no) throws Exception;
	//取得所有角色的个数
	public int selectCountByAll() throws Exception;
}
