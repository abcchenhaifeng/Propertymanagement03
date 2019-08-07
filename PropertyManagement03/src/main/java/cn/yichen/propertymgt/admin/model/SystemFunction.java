package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:27:01
 * 
 * @author YiChen(李冠永)
 * #系统功能
 */
public class SystemFunction implements Serializable {
	private Integer funno;

	private Integer mno;

	private String funname;

	private String funurl;

	private Integer levelno;

	public Integer getFunno() {
		return funno;
	}

	public void setFunno(Integer funno) {
		this.funno = funno;
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getFunname() {
		return funname;
	}

	public void setFunname(String funname) {
		this.funname = funname == null ? null : funname.trim();
	}

	public String getFunurl() {
		return funurl;
	}

	public void setFunurl(String funurl) {
		this.funurl = funurl == null ? null : funurl.trim();
	}

	public Integer getLevelno() {
		return levelno;
	}

	public void setLevelno(Integer levelno) {
		this.levelno = levelno;
	}

	@Override
	public String toString() {
		return "Systemfunction [funno=" + funno + ", mno=" + mno + ", funname=" + funname + ", funurl=" + funurl
				+ ", levelno=" + levelno + "]";
	}
}