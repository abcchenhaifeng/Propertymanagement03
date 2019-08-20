package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date: 2019年8月19日 上午12:02:54
 * @author: YiChen(李冠永)
 * @Description: 收费项目
 *
 */
@Alias("FeeItem")
public class FeeItem implements Serializable {
	private Integer itemno;

	private String itemcode;

	private String itemname;

	private String itemunit;

	private FeeType feetype;

	private String feepaymethod;

	private String feecycle;

	private String itemstatus;

	private String itemdesc;

	public Integer getItemno() {
		return itemno;
	}

	public void setItemno(Integer itemno) {
		this.itemno = itemno;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemunit() {
		return itemunit;
	}

	public void setItemunit(String itemunit) {
		this.itemunit = itemunit;
	}

	public FeeType getFeetype() {
		return feetype;
	}

	public void setFeetype(FeeType feetype) {
		this.feetype = feetype;
	}

	public String getFeepaymethod() {
		return feepaymethod;
	}

	public void setFeepaymethod(String feepaymethod) {
		this.feepaymethod = feepaymethod;
	}

	public String getFeecycle() {
		return feecycle;
	}

	public void setFeecycle(String feecycle) {
		this.feecycle = feecycle;
	}

	public String getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(String itemstatus) {
		this.itemstatus = itemstatus;
	}

	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	@Override
	public String toString() {
		return "FeeItem [itemno=" + itemno + ", itemcode=" + itemcode + ", itemname=" + itemname + ", itemunit="
				+ itemunit + ", feetype=" + feetype + ", feepaymethod=" + feepaymethod + ", feecycle=" + feecycle
				+ ", itemstatus=" + itemstatus + ", itemdesc=" + itemdesc + "]";
	}

}