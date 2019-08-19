package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月18日下午11:32:07
 * @author LiYi(李海宏)
 * @Description：完善户型表的属性
 *
 */
@Alias("HouseType")
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