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
    private Integer areano;

    private String areaname;

    private String aaddress;

    private String developer;

    private Double totalbuidingarea;

    private Double totalusearea;

    private Double totalpackarea;

    private Long totalhome;

    private Long totalhouse;

    private Long totalpack;

    public Integer getAreano() {
        return areano;
    }

    public void setAreano(Integer areano) {
        this.areano = areano;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress == null ? null : aaddress.trim();
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public Double getTotalbuidingarea() {
        return totalbuidingarea;
    }

    public void setTotalbuidingarea(Double totalbuidingarea) {
        this.totalbuidingarea = totalbuidingarea;
    }

    public Double getTotalusearea() {
        return totalusearea;
    }

    public void setTotalusearea(Double totalusearea) {
        this.totalusearea = totalusearea;
    }

    public Double getTotalpackarea() {
        return totalpackarea;
    }

    public void setTotalpackarea(Double totalpackarea) {
        this.totalpackarea = totalpackarea;
    }

    public Long getTotalhome() {
        return totalhome;
    }

    public void setTotalhome(Long totalhome) {
        this.totalhome = totalhome;
    }

    public Long getTotalhouse() {
        return totalhouse;
    }

    public void setTotalhouse(Long totalhouse) {
        this.totalhouse = totalhouse;
    }

    public Long getTotalpack() {
        return totalpack;
    }

    public void setTotalpack(Long totalpack) {
        this.totalpack = totalpack;
    }

	@Override
	public String toString() {
		return "Area [areano=" + areano + ", areaname=" + areaname + ", aaddress=" + aaddress + ", developer="
				+ developer + ", totalbuidingarea=" + totalbuidingarea + ", totalusearea=" + totalusearea
				+ ", totalpackarea=" + totalpackarea + ", totalhome=" + totalhome + ", totalhouse=" + totalhouse
				+ ", totalpack=" + totalpack + "]";
	}
}