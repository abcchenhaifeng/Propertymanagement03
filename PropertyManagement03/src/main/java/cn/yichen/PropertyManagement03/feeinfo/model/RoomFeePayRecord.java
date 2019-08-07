package cn.yichen.PropertyManagement03.feeinfo.model;

import java.util.Date;

public class RoomFeePayRecord {
    private Integer payno;

    private Integer roomfeeno;

    private Integer paytypeno;

    private Double payamount;

    private Date paydate;

    private String payperson;

    private String mobile;

    private String invoicecode;

    private String paynotecode;

    private String paydesc;

    public Integer getPayno() {
        return payno;
    }

    public void setPayno(Integer payno) {
        this.payno = payno;
    }

    public Integer getRoomfeeno() {
        return roomfeeno;
    }

    public void setRoomfeeno(Integer roomfeeno) {
        this.roomfeeno = roomfeeno;
    }

    public Integer getPaytypeno() {
        return paytypeno;
    }

    public void setPaytypeno(Integer paytypeno) {
        this.paytypeno = paytypeno;
    }

    public Double getPayamount() {
        return payamount;
    }

    public void setPayamount(Double payamount) {
        this.payamount = payamount;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public String getPayperson() {
        return payperson;
    }

    public void setPayperson(String payperson) {
        this.payperson = payperson == null ? null : payperson.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode == null ? null : invoicecode.trim();
    }

    public String getPaynotecode() {
        return paynotecode;
    }

    public void setPaynotecode(String paynotecode) {
        this.paynotecode = paynotecode == null ? null : paynotecode.trim();
    }

    public String getPaydesc() {
        return paydesc;
    }

    public void setPaydesc(String paydesc) {
        this.paydesc = paydesc == null ? null : paydesc.trim();
    }

	@Override
	public String toString() {
		return "Roomfeepayrecord [payno=" + payno + ", roomfeeno=" + roomfeeno + ", paytypeno=" + paytypeno
				+ ", payamount=" + payamount + ", paydate=" + paydate + ", payperson=" + payperson + ", mobile="
				+ mobile + ", invoicecode=" + invoicecode + ", paynotecode=" + paynotecode + ", paydesc=" + paydesc
				+ "]";
	}
}