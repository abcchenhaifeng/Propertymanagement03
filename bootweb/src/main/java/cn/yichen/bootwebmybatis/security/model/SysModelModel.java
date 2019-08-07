package cn.yichen.bootwebmybatis.security.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("SysModel")
public class SysModelModel implements Serializable {

	private Integer no;

	@Override
	public String toString() {
		return "SysModelModel [no=" + no + ", name=" + name + ", sysFunction=" + sysFunction + "]";
	}

	public SysModelModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SysModelModel(Integer no, String name, List<SysFunctionModel> sysFunction) {
		super();
		this.no = no;
		this.name = name;
		this.sysFunction = sysFunction;
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

	public List<SysFunctionModel> getSysFunction() {
		return sysFunction;
	}

	public void setSysFunction(List<SysFunctionModel> sysFunction) {
		this.sysFunction = sysFunction;
	}

	private String name;
	private List<SysFunctionModel> sysFunction;
}
