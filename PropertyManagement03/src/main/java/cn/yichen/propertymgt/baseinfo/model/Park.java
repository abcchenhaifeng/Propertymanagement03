package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:32:03
 * @author YiChen(李冠永)
 * #车位
 *
 */
@Alias("Park")
public class Park implements Serializable {
    private Integer parkno;

    private Integer typeno;

    private String parkcode;

    private Integer buildingno;

    private String location;

    private Double area;

    private String parkstatus;

    private Double rentprice;

    private String rentunit;

    private String feestatus;

    public Integer getParkno() {
        return parkno;
    }

    public void setParkno(Integer parkno) {
        this.parkno = parkno;
    }

    public Integer getTypeno() {
        return typeno;
    }

    public void setTypeno(Integer typeno) {
        this.typeno = typeno;
    }

    public String getParkcode() {
        return parkcode;
    }

    public void setParkcode(String parkcode) {
        this.parkcode = parkcode == null ? null : parkcode.trim();
    }

    public Integer getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(Integer buildingno) {
        this.buildingno = buildingno;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getParkstatus() {
        return parkstatus;
    }

    public void setParkstatus(String parkstatus) {
        this.parkstatus = parkstatus == null ? null : parkstatus.trim();
    }

    public Double getRentprice() {
        return rentprice;
    }

    public void setRentprice(Double rentprice) {
        this.rentprice = rentprice;
    }

    public String getRentunit() {
        return rentunit;
    }

    public void setRentunit(String rentunit) {
        this.rentunit = rentunit == null ? null : rentunit.trim();
    }

    public String getFeestatus() {
        return feestatus;
    }

    public void setFeestatus(String feestatus) {
        this.feestatus = feestatus == null ? null : feestatus.trim();
    }

	@Override
	public String toString() {
		return "Park [parkno=" + parkno + ", typeno=" + typeno + ", parkcode=" + parkcode + ", buildingno=" + buildingno
				+ ", location=" + location + ", area=" + area + ", parkstatus=" + parkstatus + ", rentprice="
				+ rentprice + ", rentunit=" + rentunit + ", feestatus=" + feestatus + "]";
	}
}