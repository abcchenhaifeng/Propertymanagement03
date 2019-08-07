package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:31:35
 * @author YiChen(李冠永)
 * #居住类型
 *
 */
public class LivingType implements Serializable {
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
		return "LivingType [typeno=" + typeno + ", typename=" + typename + "]";
	}
}