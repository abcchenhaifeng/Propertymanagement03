package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    private Room roomno;       //房间号

    private LivingType livingtype;   //居住类型号
    
    private Customer customer;   //客户信息
    
    private RoomFee roomfee;    //缴费信

    

	@DateTimeFormat(pattern = "yyyy-MM-dd")     //入房日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date receivedate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")     //收房日期  
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date livedate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")    //缴费开始日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date feestartdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")    //缴费结束日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date feeenddate;

    private Integer humancount;               //居住人数

    private String chstatus;                  //客户状态

    public String getChno() {
        return chno;
    }

    public void setChno(String chno) {
        this.chno = chno;
    }

    

    public LivingType getLivingtype() {
		return livingtype;	
	}

	public void setLivingtype(LivingType livingtype) {
		this.livingtype = livingtype;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public RoomFee getRoomfee() {
		return roomfee;	
	}

	public void setRoomfee(RoomFee roomfee) {
		this.roomfee = roomfee;
	}

	public Room getRoomno() {
        return roomno;
    }

    public void setRoomno(Room roomno) {
        this.roomno = roomno;
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
		return "CustomerHome [chno=" + chno + ", roomno=" + roomno + ", livingtype=" + livingtype + ", customer="
				+ customer + ", roomfee=" + roomfee + ", receivedate=" + receivedate + ", livedate=" + livedate
				+ ", feestartdate=" + feestartdate + ", feeenddate=" + feeenddate + ", humancount=" + humancount
				+ ", chstatus=" + chstatus + "]";
	}
}