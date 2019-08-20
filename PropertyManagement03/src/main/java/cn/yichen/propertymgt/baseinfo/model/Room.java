package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月19日上午12:08:21
 * @author LiYi(李海宏)
 * @Description：完善房间表的Model属性
 *
 */
@Alias("Room")
public class Room implements Serializable {
    

	private String roomno;				//房间编号
	
    private HouseType housetype;			//房屋户型编号

    private Building building;			//楼宇编号
   
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

	public HouseType getHousetype() {
		return housetype;
	}

	public void setHousetype(HouseType housetype) {
		this.housetype = housetype;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
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
		this.departmentcode = departmentcode;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String getBuildingarea() {
		return buildingarea;
	}

	public void setBuildingarea(String buildingarea) {
		this.buildingarea = buildingarea;
	}

	public String getFeearea() {
		return feearea;
	}

	public void setFeearea(String feearea) {
		this.feearea = feearea;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	@Override
	public String toString() {
		return "Room [roomno=" + roomno + ", housetype=" + housetype + ", building=" + building + ", departmentcode="
				+ departmentcode + ", floor=" + floor + ", roomcode=" + roomcode + ", buildingarea=" + buildingarea
				+ ", feearea=" + feearea + ", roomstatus=" + roomstatus + ", roomtype=" + roomtype + "]";
	}

   
}