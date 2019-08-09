package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:27:01
 * 
 * @author YiChen(李冠永) #系统功能
 * 
 */
@Alias("SystemFunction")
public class SystemFunction implements Serializable {
	private Integer no;

	private String name;

	private String url;

	private Integer levelno;

	private SystemModule module;

	private List<UserInfo> userInfos;

	public SystemModule getModule() {
		return module;
	}

	public void setModule(SystemModule module) {
		this.module = module;
	}

	public List<UserInfo> getUserInfos() {
		return userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getLevelno() {
		return levelno;
	}

	public void setLevelno(Integer levelno) {
		this.levelno = levelno;
	}

	@Override
	public String toString() {
		return "SystemFunction [no=" + no + ", name=" + name + ", url=" + url + ", levelno=" + levelno + ", module="
				+ module + ", userInfos=" + userInfos + "]";
	}
}