package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @date: 2019年8月19日 上午12:02:42
 * @author: YiChen(李冠永)
 * @Description: 收费项目年度价格
 *
 */
@Alias("FeeItemYearPrice")
public class FeeItemYearPrice implements Serializable {

	private String feeyear;

	private FeeItem feeItem;

	private Double unitprice;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date startdate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date enddtae;

	private String pricedesc;

	public String getFeeyear() {
		return feeyear;
	}

	public void setFeeyear(String feeyear) {
		this.feeyear = feeyear;
	}

	public FeeItem getFeeItem() {
		return feeItem;
	}

	public void setFeeItem(FeeItem feeItem) {
		this.feeItem = feeItem;
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
		this.pricedesc = pricedesc;
	}

	@Override
	public String toString() {
		return "FeeItemYearPrice [feeyear=" + feeyear + ", feeItem=" + feeItem + ", unitprice=" + unitprice
				+ ", startdate=" + startdate + ", enddtae=" + enddtae + ", pricedesc=" + pricedesc + "]";
	}

}