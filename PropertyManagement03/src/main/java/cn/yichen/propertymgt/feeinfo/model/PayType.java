package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date 2019年8月27日 下午2:33:07
 * @author YiChen(李冠永)
 * @Description 付款类型
 *
 */
@Alias("PayType")
public class PayType implements Serializable {
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
		this.typename = typename;
	}

	@Override
	public String toString() {
		return "PayType [typeno=" + typeno + ", typename=" + typename + "]";
	}

}