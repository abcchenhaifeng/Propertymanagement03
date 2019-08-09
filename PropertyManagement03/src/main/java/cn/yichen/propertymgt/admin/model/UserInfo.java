package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2019年8月7日23:29:35
 * 
 * @author YiChen(李冠永) #系统操作员
 *
 */
@Alias("UserInfo")
public class UserInfo implements Serializable {
	private String id;

	private String password;

	private String username;

	private String status;

	private Integer age;

	private String sex;

	private String mobible;

	private List<SystemFunction> functions;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobible() {
		return mobible;
	}

	public void setMobible(String mobible) {
		this.mobible = mobible;
	}

	public List<SystemFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<SystemFunction> functions) {
		this.functions = functions;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", username=" + username + ", status=" + status
				+ ", age=" + age + ", sex=" + sex + ", mobible=" + mobible + ", functions=" + functions + "]";
	}

}