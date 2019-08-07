package cn.yichen.PropertyManagement03.baseinfo.model;

public class Area {
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
}