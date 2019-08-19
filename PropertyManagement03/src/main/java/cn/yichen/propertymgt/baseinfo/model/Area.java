package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月16日下午11:59:47
 * @author LiYi(李海宏)
 * @Description：描述小区表的属性
 *
 */
@Alias("Area")
public class Area implements Serializable {
    private Integer no;      //小区编号

    private String name;     //小区名称

    private String address;     //小区地址

    private String developer;    //开发商

    private Double buildingarea;    //总建筑面积

    private Double usearea;        //总使用面积

    private Double parkarea;       //车位面积

    private Long home;             //总居民数

    private Long house;            //总公建数

    private Long park;             //车位数

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Double getBuildingarea() {
		return buildingarea;
	}

	public void setBuildingarea(Double buildingarea) {
		this.buildingarea = buildingarea;
	}

	public Double getUsearea() {
		return usearea;
	}

	public void setUsearea(Double usearea) {
		this.usearea = usearea;
	}

	public Double getParkarea() {
		return parkarea;
	}

	public void setParkarea(Double parkarea) {
		this.parkarea = parkarea;
	}

	public Long getHome() {
		return home;
	}

	public void setHome(Long home) {
		this.home = home;
	}

	public Long getHouse() {
		return house;
	}

	public void setHouse(Long house) {
		this.house = house;
	}

	public Long getPark() {
		return park;
	}

	public void setPark(Long park) {
		this.park = park;
	}

	@Override
	public String toString() {
		return "Area [no=" + no + ", name=" + name + ", address=" + address + ", developer=" + developer
				+ ", buildingarea=" + buildingarea + ", usearea=" + usearea + ", parkarea=" + parkarea + ", home="
				+ home + ", house=" + house + ", park=" + park + "]";
	}

   
}