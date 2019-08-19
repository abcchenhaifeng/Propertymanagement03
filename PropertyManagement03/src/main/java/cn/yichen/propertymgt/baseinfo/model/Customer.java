package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @date:2019年8月8日下午8:58:25
 * @author LiYi(李海宏)
 * @Description：根据字段值与属性的关系进行更改
 *
 */
@Alias("Customer")
public class Customer implements Serializable {
	private int customerNo; // 客户序号

	private String cname; // 客户名称

	private String contact; // 联系人姓名

	private String cardcode; // 身份证号码

	private String mobile; // 手机号
	
	private String cstatus; // 客户状态

	private CustomerType customertype; // 多对一，一个客户只能对应一种客户类型
	
	private CustomerHome customerhome; //一对一，一个客户只能对应一个客户房间

	public CustomerHome getCustomerhome() {
		return customerhome;
	}

	public void setCustomerhone(CustomerHome customerhome) {
		this.customerhome = customerhome;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date feeStartDate; // 收费开始日期

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date feeEndDate; // 收费截止日期

	public CustomerType getCtypeno() {
		return customertype;
	}

	public void setCtypeno(CustomerType customertype) {
		this.customertype = customertype;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
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



	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", cname=" + cname + ", contact=" + contact + ", cardcode="
				+ cardcode + ", mobile=" + mobile + ", cstatus=" + cstatus + ", customertype="
				+ customertype + ", customerhome=" + customerhome + ", feeStartDate=" + feeStartDate + ", feeEndDate="
				+ feeEndDate + "]";
	}
	
}