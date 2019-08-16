package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @data:2019年8月12日下午9:17:22
 * @author： 陈海锋
 * @Description:房间
 *
 */
@Alias("Room")
public class Room implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String roomno;				//房间编号

    private String housetypeno;			//房屋户型编号

    private String buildingno;			//楼宇编号

    private String departmentcode;		//单元

    private String floor;				//楼层

    private String roomcode;			//房间号

    private String buildingarea;		//使用面积

    private String feearea;				//缴费面积

    private String roomstatus;			//房间状态(空闲/入住)

    private String roomtype;			//房间类型(room 住宅House公建)

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getHousetypeno() {
        return housetypeno;
    }

    public void setHousetypeno(String housetypeno) {
        this.housetypeno = housetypeno;
    }

    public String getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno;
    }

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode == null ? null : departmentcode.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode == null ? null : roomcode.trim();
    }

    public String getBuildingarea() {
        return buildingarea;
    }

    public void setBuildingarea(String string) {
        this.buildingarea = string;
    }

    public String getFeearea() {
        return feearea;
    }

    public void setFeearea(String string) {
        this.feearea = string;
    }

    public String getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(String roomstatus) {
        this.roomstatus = roomstatus == null ? null : roomstatus.trim();
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype == null ? null : roomtype.trim();
    }

	@Override
	public String toString() {
		return "Room [roomno=" + roomno + ", housetypeno=" + housetypeno + ", buildingno=" + buildingno
				+ ", departmentcode=" + departmentcode + ", floor=" + floor + ", roomcode=" + roomcode
				+ ", buildingarea=" + buildingarea + ", feearea=" + feearea + ", roomstatus=" + roomstatus
				+ ", roomtype=" + roomtype + "]";
	}
}