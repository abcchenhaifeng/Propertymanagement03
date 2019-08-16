package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;


@Alias("Building")
public class Building implements Serializable {
    private String buildingno;

    private String areano;

    private String bcode;

    private String baddress;

    private Integer buildingtypeno;

    private String direction;

    private Long totalhome;

    private Long totalhouse;

    public String getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno;
    }

    public String getAreano() {
        return areano;
    }

    public void setAreano(String areano) {
        this.areano = areano;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode == null ? null : bcode.trim();
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress == null ? null : baddress.trim();
    }

    public Integer getBuildingtypeno() {
        return buildingtypeno;
    }

    public void setBuildingtypeno(Integer buildingtypeno) {
        this.buildingtypeno = buildingtypeno;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
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

	@Override
	public String toString() {
		return "Building [buildingno=" + buildingno + ", areano=" + areano + ", bcode=" + bcode + ", baddress="
				+ baddress + ", buildingtypeno=" + buildingtypeno + ", direction=" + direction + ", totalhome="
				+ totalhome + ", totalhouse=" + totalhouse + "]";
	}
}