package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:29:26
 * 
 * @author YiChen(李冠永) 
 * @Description 系统模块
 */
@Alias("SystemModule")
public class SystemModule implements Serializable {
	private Integer no;

	private String name;

	private List<SystemFunction> functions;

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

	public List<SystemFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<SystemFunction> functions) {
		this.functions = functions;
	}

	@Override
	public String toString() {
		return "SystemModule [no=" + no + ", name=" + name + ", functions=" + functions + "]";
	}

}