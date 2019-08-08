package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:31:06
 * @author YiChen(李冠永)
 * #客户类型
 *
 */
@Alias("CustomerType")
public class CustomerType implements Serializable {
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
		return "CustomerType [typeno=" + typeno + ", typename=" + typename + "]";
	}
}