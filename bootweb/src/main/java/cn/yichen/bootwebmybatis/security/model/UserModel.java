package cn.yichen.bootwebmybatis.security.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户model
 * 
 * @author YiChen(ychenli)
 *
 */
@Alias("User")
public class UserModel implements Serializable {

	private String id;
	private String password;
	private String username;
	private String role;
	private Integer age;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate;
	private String status;
	private List<RoleModel> roles;
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", password=" + password + ", username=" + username + ", role=" + role + ", age="
				+ age + ", joinDate=" + joinDate + ", status=" + status + ", roles=" + roles + "]";
	}

	public UserModel(String id, String password, String username, String role, Integer age, Date joinDate,
			String status, List<RoleModel> roles) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.role = role;
		this.age = age;
		this.joinDate = joinDate;
		this.status = status;
		this.roles = roles;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
}
