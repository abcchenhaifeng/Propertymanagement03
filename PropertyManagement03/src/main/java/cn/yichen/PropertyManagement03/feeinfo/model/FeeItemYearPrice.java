package cn.yichen.PropertyManagement03.feeinfo.model;

import java.util.Date;

public class FeeItemYearPrice {
    
    private String feeyear;

    private Integer itemno;
	
	public String getFeeyear() {
		return feeyear;
	}

	public void setFeeyear(String feeyear) {
		this.feeyear = feeyear;
	}

	public Integer getItemno() {
		return itemno;
	}

	public void setItemno(Integer itemno) {
		this.itemno = itemno;
	}

	private Double unitprice;

    private Date startdate;

    private Date enddtae;

    private String pricedesc;

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddtae() {
        return enddtae;
    }

    public void setEnddtae(Date enddtae) {
        this.enddtae = enddtae;
    }

    public String getPricedesc() {
        return pricedesc;
    }

    public void setPricedesc(String pricedesc) {
        this.pricedesc = pricedesc == null ? null : pricedesc.trim();
    }

	@Override
	public String toString() {
		return "Feeitemyearprice [feeyear=" + feeyear + ", itemno=" + itemno + ", unitprice=" + unitprice
				+ ", startdate=" + startdate + ", enddtae=" + enddtae + ", pricedesc=" + pricedesc + "]";
	}
}