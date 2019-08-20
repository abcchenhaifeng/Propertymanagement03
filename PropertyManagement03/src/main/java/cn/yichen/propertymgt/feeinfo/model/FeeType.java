package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 
 * @date: 2019年8月19日 上午12:01:29
 * @author: YiChen(李冠永)
 * @Description: 收费类型
 *
 */
@Alias("FeeType")
public class FeeType implements Serializable {

	private Integer typeno;
	
	private String typename;
	
	private List<FeeItem> feeItems;

	public List<FeeItem> getFeeItems() {
		return feeItems;
	}

	public void setFeeItems(List<FeeItem> feeItems) {
		this.feeItems = feeItems;
	}

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
		return "FeeType [typeno=" + typeno + ", typename=" + typename + ", feeItems=" + feeItems + "]";
	}
}