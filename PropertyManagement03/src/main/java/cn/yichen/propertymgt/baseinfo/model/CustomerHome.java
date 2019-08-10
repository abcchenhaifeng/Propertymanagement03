package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import cn.yichen.propertymgt.feeinfo.model.RoomFee;

/**
 * 
 * @date:2019年8月9日 上午9:37:53
 * @author LiYi(李海宏）
 * @description:对客户房间表进行检查并调整字段类型
 */
@Alias("CustomerHome")
public class CustomerHome implements Serializable {
    private String chno;      //客户房间号                 

    private String customerno;   //客户号

    private String roomno;       //房间号

    private String livingtypeno;   //居住类型号
    
    private List<Customer> customer;   //客户信息
    
    private List<RoomFee> roomfee;    //缴费信息

    public List<RoomFee> getRoomfee() {
		return roomfee;
	}

	public void setRoomfee(List<RoomFee> roomfee) {
		this.roomfee = roomfee;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")     //入房日期
    private Date receivedate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")     //收房日期  
    private Date livedate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")    //缴费开始日期
    private Date feestartdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")    //缴费结束日期
    private Date feeenddate;

    private Integer humancount;               //居住人数

    private String chstatus;                  //客户状态

    public String getChno() {
        return chno;
    }

    public void setChno(String chno) {
        this.chno = chno;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getLivingtypeno() {
        return livingtypeno;
    }

    public void setLivingtypeno(String livingtypeno) {
        this.livingtypeno = livingtypeno;
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Date getLivedate() {
        return livedate;
    }

    public void setLivedate(Date livedate) {
        this.livedate = livedate;
    }

    public Date getFeestartdate() {
        return feestartdate;
    }

    public void setFeestartdate(Date feestartdate) {
        this.feestartdate = feestartdate;
    }

    public Date getFeeenddate() {
        return feeenddate;
    }

    public void setFeeenddate(Date feeenddate) {
        this.feeenddate = feeenddate;
    }

    public Integer getHumancount() {
        return humancount;
    }

    public void setHumancount(Integer humancount) {
        this.humancount = humancount;
    }

    public String getChstatus() {
        return chstatus;
    }

    public void setChstatus(String chstatus) {
        this.chstatus = chstatus == null ? null : chstatus.trim();
    }

	@Override
	public String toString() {
		return "CustomerHome [chno=" + chno + ", customerno=" + customerno + ", roomno=" + roomno + ", livingtypeno="
				+ livingtypeno + ", customer=" + customer + ", roomfee=" + roomfee + ", receivedate=" + receivedate
				+ ", livedate=" + livedate + ", feestartdate=" + feestartdate + ", feeenddate=" + feeenddate
				+ ", humancount=" + humancount + ", chstatus=" + chstatus + "]";
	}

	

	
}