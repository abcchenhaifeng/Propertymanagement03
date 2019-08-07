package cn.yichen.PropertyManagement03.feeinfo.model;

import java.math.BigDecimal;

public class PayType {
    private Integer typeno;

    private String typename;

    private BigDecimal payfee;

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

    public BigDecimal getPayfee() {
        return payfee;
    }

    public void setPayfee(BigDecimal payfee) {
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