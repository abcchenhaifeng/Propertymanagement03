package cn.yichen.propertymgt.feeinfo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.ibatis.type.Alias;

/**
 * 2019年8月7日23:34:05
 * @author YiChen(李冠永)
 * #付款类型
 *
 */
@Alias("PayType")
public class PayType implements Serializable {
    private Integer typeno;

    private String typename;

    private Double payfee;

    private String payto;

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

    public Double getPayfee() {
        return payfee;
    }

    public void setPayfee(Double payfee) {
        this.payfee = payfee;
    }

    public String getPayto() {
        return payto;
    }

    public void setPayto(String payto) {
        this.payto = payto == null ? null : payto.trim();
    }

	@Override
	public String toString() {
		return "Paytype [typeno=" + typeno + ", typename=" + typename + ", payfee=" + payfee + ", payto=" + payto + "]";
	}
}