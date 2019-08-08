package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2019年8月7日23:34:14
 * @author YiChen(李冠永)
 * #房间缴费
 *
 */
@Alias("RoomFee")
public class RoomFee implements Serializable {
    private Integer roomfeeno;

    private String feeyear;

    private String feemonth;

    private Integer roomno;

    private Integer feeitemno;

    private Double spay;

    private Double apay;

    private Double derate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enddate;

    private String feestatus;

    public Integer getRoomfeeno() {
        return roomfeeno;
    }

    public void setRoomfeeno(Integer roomfeeno) {
        this.roomfeeno = roomfeeno;
    }

    public String getFeeyear() {
        return feeyear;
    }

    public void setFeeyear(String feeyear) {
        this.feeyear = feeyear == null ? null : feeyear.trim();
    }

    public String getFeemonth() {
        return feemonth;
    }

    public void setFeemonth(String feemonth) {
        this.feemonth = feemonth == null ? null : feemonth.trim();
    }

    public Integer getRoomno() {
        return roomno;
    }

    public void setRoomno(Integer roomno) {
        this.roomno = roomno;
    }

    public Integer getFeeitemno() {
        return feeitemno;
    }

    public void setFeeitemno(Integer feeitemno) {
        this.feeitemno = feeitemno;
    }

    public Double getSpay() {
        return spay;
    }

    public void setSpay(Double spay) {
        this.spay = spay;
    }

    public Double getApay() {
        return apay;
    }

    public void setApay(Double apay) {
        this.apay = apay;
    }

    public Double getDerate() {
        return derate;
    }

    public void setDerate(Double derate) {
        this.derate = derate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getFeestatus() {
        return feestatus;
    }

    public void setFeestatus(String feestatus) {
        this.feestatus = feestatus == null ? null : feestatus.trim();
    }

	@Override
	public String toString() {
		return "Roomfee [roomfeeno=" + roomfeeno + ", feeyear=" + feeyear + ", feemonth=" + feemonth + ", roomno="
				+ roomno + ", feeitemno=" + feeitemno + ", spay=" + spay + ", apay=" + apay + ", derate=" + derate
				+ ", startdate=" + startdate + ", enddate=" + enddate + ", feestatus=" + feestatus + "]";
	}
}