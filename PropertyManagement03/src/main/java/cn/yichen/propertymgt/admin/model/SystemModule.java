package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:29:26
 * @author YiChen(李冠永)
 * #系统模块
 *
 */
@Alias("SystemModule")
public class SystemModule implements Serializable {
	private Integer mno;

	private String mname;

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname == null ? null : mname.trim();
	}

	@Override
	public String toString() {
		return "Systemmodule [mno=" + mno + ", mname=" + mname + "]";
	}
}