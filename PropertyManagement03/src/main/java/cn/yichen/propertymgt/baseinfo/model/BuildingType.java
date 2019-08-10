package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;



/**
 * 2019年8月7日23:30:19
 * @author YiChen(李冠永)
 * #建筑类型
 *
 */
/**
 * 
 * @data:2019年8月8日下午9:49:42
 * @author： 陈海锋
 * @Description:
 *
 */
@Alias("BuildingType")
public class BuildingType implements Serializable {
	
	
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
		return "BuildingType [typeno=" + typeno + ", typename=" + typename + "]";
	}
	
	
	
	
}