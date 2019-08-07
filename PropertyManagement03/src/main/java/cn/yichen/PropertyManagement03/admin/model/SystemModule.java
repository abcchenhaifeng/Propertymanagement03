package cn.yichen.PropertyManagement03.admin.model;

public class SystemModule {
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