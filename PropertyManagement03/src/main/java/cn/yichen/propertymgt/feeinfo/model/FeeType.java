package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:33:35
 * @author YiChen(李冠永)
 * #收费类型
 *
 */
public class FeeType implements Serializable {
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
		return "Feetype [typeno=" + typeno + ", typename=" + typename + "]";
	}
}