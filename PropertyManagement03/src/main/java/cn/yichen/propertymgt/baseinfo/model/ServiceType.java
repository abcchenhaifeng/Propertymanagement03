package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:32:57
 * @author YiChen(李冠永)
 * #服务类型
 *
 */
public class ServiceType implements Serializable {
    private Integer typeno;

    private String typename;

    private String typedesc;

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

    public String getTypedesc() {
        return typedesc;
    }

    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc == null ? null : typedesc.trim();
    }

	@Override
	public String toString() {
		return "ServiceType [typeno=" + typeno + ", typename=" + typename + ", typedesc=" + typedesc + "]";
	}
}