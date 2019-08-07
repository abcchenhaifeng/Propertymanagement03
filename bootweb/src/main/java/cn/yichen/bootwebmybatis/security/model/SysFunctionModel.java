package cn.yichen.bootwebmybatis.security.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("SysFunction")
public class SysFunctionModel implements Serializable {

	private Integer no;
	private SysModelModel sysModel;
	private String name;
	private String url;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public SysModelModel getSysModel() {
		return sysModel;
	}

	public void setSysModel(SysModelModel sysModel) {
		this.sysModel = sysModel;
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

	public SysFunctionModel(Integer no, SysModelModel sysModel, String name, String url) {
		super();
		this.no = no;
		this.sysModel = sysModel;
		this.name = name;
		this.url = url;
	}

	public SysFunctionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SysFunctionModel [no=" + no + ", sysModel=" + sysModel + ", name=" + name + ", url=" + url + "]";
	}
}
