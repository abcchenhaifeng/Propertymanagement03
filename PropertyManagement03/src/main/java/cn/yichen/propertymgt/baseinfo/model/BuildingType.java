package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月16日下午11:41:06
 * @author LiYi(李海宏)
 * @Description：描述建筑楼房的关系
 *
 */
@Alias("BuildingType")
public class BuildingType implements Serializable {
	
	//建筑物类型
    private Integer typeno;

    //建筑物名称
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