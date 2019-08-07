package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:31:18
 * @author YiChen(李冠永)
 * #户型
 *
 */
public class HouseType implements Serializable {
    private Integer typeno;

    private String typename;

    public Integer getTypeno() {
        return typeno;
    }

    public void setTypeno(Integer typeno) {
        this.typeno = typeno;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

	@Override
	public String toString() {
		return "HouseType [typeno=" + typeno + ", typename=" + typename + "]";
	}
}