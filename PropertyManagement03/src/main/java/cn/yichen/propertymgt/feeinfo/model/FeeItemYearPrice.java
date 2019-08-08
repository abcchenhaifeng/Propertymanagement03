package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2019年8月7日23:33:24
 * @author YiChen(李冠永)
 * #收费项目年度价格
 *
 */
@Alias("FeeItemYearPrice")
public class FeeItemYearPrice implements Serializable {
    
    private String feeyear;

    private Integer itemno;
    
	private Double unitprice;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddtae;

    private String pricedesc;
	
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