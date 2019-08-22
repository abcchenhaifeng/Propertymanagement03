package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date:2019年8月9日 下午1:28:22
 * @author LiYi(李海宏）
 * @description:针对客户类型表进行增删改查基本操作，为后期多表操作做铺垫
 */
@Alias("CustomerType")
public class CustomerType implements Serializable {
    private Integer typeno;     //客户类型编号

    private String typename;    //客户类型名称
    

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