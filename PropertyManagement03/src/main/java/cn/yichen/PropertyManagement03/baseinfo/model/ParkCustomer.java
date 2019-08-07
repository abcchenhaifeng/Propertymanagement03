package cn.yichen.PropertyManagement03.baseinfo.model;

import java.util.Date;

public class ParkCustomer {
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
}