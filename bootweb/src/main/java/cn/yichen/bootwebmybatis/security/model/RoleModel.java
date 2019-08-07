package cn.yichen.bootwebmybatis.security.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Role")
public class RoleModel implements Serializable {

	private Integer no;
	private String name;
	// 角色关联的用户列表
	private List<UserModel> users;
	// 角色关联的模块列表
	private List<SysModelModel> modules;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}

	public List<SysModelModel> getModules() {
		return modules;
	}

	public void setModules(List<SysModelModel> modules) {
		this.modules = modules;
	}

	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleModel(Integer no, String name, List<UserModel> users, List<SysModelModel> modules) {
		super();
		this.no = no;
		this.name = name;
		this.users = users;
		this.modules = modules;
	}

	@Override
	public String toString() {
		return "RoleModel [no=" + no + ", name=" + name + ", users=" + users + ", modules=" + modules + "]";
	}
}
