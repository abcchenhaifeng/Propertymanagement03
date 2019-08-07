package cn.yichen.PropertyManagement03.feeinfo.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:33:13
 * @author YiChen(李冠永)
 * #收费项目
 *
 */
public class FeeItem implements Serializable {
    private Integer itemno;

    private String itemcode;

    private String itemname;

    private String itemunit;

    private Integer feetypeno;

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
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemunit() {
        return itemunit;
    }

    public void setItemunit(String itemunit) {
        this.itemunit = itemunit == null ? null : itemunit.trim();
    }

    public Integer getFeetypeno() {
        return feetypeno;
    }

    public void setFeetypeno(Integer feetypeno) {
        this.feetypeno = feetypeno;
    }

    public String getFeepaymethod() {
        return feepaymethod;
    }

    public void setFeepaymethod(String feepaymethod) {
        this.feepaymethod = feepaymethod == null ? null : feepaymethod.trim();
    }

    public String getFeecycle() {
        return feecycle;
    }

    public void setFeecycle(String feecycle) {
        this.feecycle = feecycle == null ? null : feecycle.trim();
    }

    public String getItemstatus() {
        return itemstatus;
    }

    public void setItemstatus(String itemstatus) {
        this.itemstatus = itemstatus == null ? null : itemstatus.trim();
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc == null ? null : itemdesc.trim();
    }

	@Override
	public String toString() {
		return "Feeitem [itemno=" + itemno + ", itemcode=" + itemcode + ", itemname=" + itemname + ", itemunit="
				+ itemunit + ", feetypeno=" + feetypeno + ", feepaymethod=" + feepaymethod + ", feecycle=" + feecycle
				+ ", itemstatus=" + itemstatus + ", itemdesc=" + itemdesc + "]";
	}
}