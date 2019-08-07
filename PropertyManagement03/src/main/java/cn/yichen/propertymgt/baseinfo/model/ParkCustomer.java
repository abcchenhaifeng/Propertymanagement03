package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 2019年8月7日23:32:18
 * @author YiChen(李冠永)
 * #车位客户
 *
 */
public class ParkCustomer implements Serializable {
    private Integer pcno;

    private Integer parkno;

    private Integer customerno;

    private String carcode;

    private Date startdate;

    private Date enddate;

    private String pcstatus;

    public Integer getPcno() {
        return pcno;
    }

    public void setPcno(Integer pcno) {
        this.pcno = pcno;
    }

    public Integer getParkno() {
        return parkno;
    }

    public void setParkno(Integer parkno) {
        this.parkno = parkno;
    }

    public Integer getCustomerno() {
        return customerno;
    }

    public void setCustomerno(Integer customerno) {
        this.customerno = customerno;
    }

    public String getCarcode() {
        return carcode;
    }

    public void setCarcode(String carcode) {
        this.carcode = carcode == null ? null : carcode.trim();
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

    public String getPcstatus() {
        return pcstatus;
    }

    public void setPcstatus(String pcstatus) {
        this.pcstatus = pcstatus == null ? null : pcstatus.trim();
    }

	@Override
	public String toString() {
		return "ParkCustomer [pcno=" + pcno + ", parkno=" + parkno + ", customerno=" + customerno + ", carcode="
				+ carcode + ", startdate=" + startdate + ", enddate=" + enddate + ", pcstatus=" + pcstatus + "]";
	}
}