package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月18日下午9:34:32
 * @author LiYi(李海宏)
 * @Description：完善楼宇Model层代码
 *
 */

@Alias("Building")
public class Building implements Serializable {
	
	private int no=0; //序号
	private Area area=null; //小区序号
	private String code=null; //楼号
	private String address=null; //楼宇地址
	private BuildingType buildingtype=null; //楼宇结构编号
	private String direction=null;  //楼宇朝向
	private int home=0; //居民数
	private int house=0; //公建数
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BuildingType getBuildingtype() {
		return buildingtype;
	}
	public void setBuildingtype(BuildingType buildingtype) {
		this.buildingtype = buildingtype;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getHome() {
		return home;
	}
	public void setHome(int home) {
		this.home = home;
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
		this.house = house;
	}
	@Override
	public String toString() {
		return "Building [no=" + no + ", area=" + area + ", code=" + code + ", address=" + address + ", buildingtype="
				+ buildingtype + ", direction=" + direction + ", home=" + home + ", house=" + house + "]";
	}
   
	
}