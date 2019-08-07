package cn.yichen.PropertyManagement03.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 2019年8月7日23:30:52
 * @author YiChen(李冠永)
 * #客户房间
 *
 */
public class CustomerHome implements Serializable {
    private Integer chno;

    private Integer customerno;

    private Integer roomno;

    private Integer livingtypeno;

    private Date receivedate;

    private Date livedate;

    private Date feestartdate;

    private Date feeenddate;

    private Short humancount;

    private String chstatus;

    public Integer getChno() {
        return chno;
    }

    public void setChno(Integer chno) {
        this.chno = chno;
    }

    public Integer getCustomerno() {
        return customerno;
    }

    public void setCustomerno(Integer customerno) {
        this.customerno = customerno;
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public Integer getLivingtypeno() {
        return livingtypeno;
    }

    public void setLivingtypeno(Integer livingtypeno) {
        this.livingtypeno = livingtypeno;
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Date getLivedate() {
        return livedate;
    }

    public void setLivedate(Date livedate) {
        this.livedate = livedate;
    }

    public Date getFeestartdate() {
        return feestartdate;
    }

    public void setFeestartdate(Date feestartdate) {
        this.feestartdate = feestartdate;
    }

    public Date getFeeenddate() {
        return feeenddate;
    }

    public void setFeeenddate(Date feeenddate) {
        this.feeenddate = feeenddate;
    }

    public Short getHumancount() {
        return humancount;
    }

    public void setHumancount(Short humancount) {
        this.humancount = humancount;
    }

    public String getChstatus() {
        return chstatus;
    }

    public void setChstatus(String chstatus) {
        this.chstatus = chstatus == null ? null : chstatus.trim();
    }

	@Override
	public String toString() {
		return "CustomerHome [chno=" + chno + ", customerno=" + customerno + ", roomno=" + roomno + ", livingtypeno="
				+ livingtypeno + ", receivedate=" + receivedate + ", livedate=" + livedate + ", feestartdate="
				+ feestartdate + ", feeenddate=" + feeenddate + ", humancount=" + humancount + ", chstatus=" + chstatus
				+ "]";
	}
}