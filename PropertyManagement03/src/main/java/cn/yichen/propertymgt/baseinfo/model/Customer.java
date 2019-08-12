package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @date:2019年8月8日下午8:58:25
 * @author LiYi(李海宏)
 * @Description：根据字段值与属性的关系进行更改
 *
 */
@Alias("Customer")
public class Customer implements Serializable {
	private String customerNo; // 客户序号

	private String typeNo; // 客户类型序号

	private String cname; // 客户名称

	private String contact; // 联系人姓名

	private String cardcode; // 身份证号码

	private String mobile; // 手机号

	private String telephone; // 电话

	private String fax; // 传真

	private String qq; // qq

	private String wechat; // 微信
	
	private String cstatus; // 客户状态
	
	private String password;  //登陆密码

	private CustomerType customertype; // 多对一，一个客户只能对应一种客户类型

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date feeStartDate; // 收费开始日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date feeEndDate; // 收费截止日期

	public CustomerType getCtypeno() {
		return customertype;
	}

	public void setCtypeno(CustomerType customertype) {
		this.customertype = customertype;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Date getFeeStartDate() {
		return feeStartDate;
	}

	public void setFeeStartDate(Date feeStartDate) {
		this.feeStartDate = feeStartDate;
	}

	public Date getFeeEndDate() {
		return feeEndDate;
	}

	public void setFeeEndDate(Date feeEndDate) {
		this.feeEndDate = feeEndDate;
	}

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerType getCustomertype() {
		return customertype;
	}

	public void setCustomertype(CustomerType customertype) {
		this.customertype = customertype;
	}

	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", typeNo=" + typeNo + ", cname=" + cname + ", contact=" + contact
				+ ", cardcode=" + cardcode + ", mobile=" + mobile + ", telephone=" + telephone + ", fax=" + fax
				+ ", qq=" + qq + ", wechat=" + wechat + ", cstatus=" + cstatus + ", password=" + password
				+ ", customertype=" + customertype + ", feeStartDate=" + feeStartDate + ", feeEndDate=" + feeEndDate
				+ "]";
	}
	
	
	

}