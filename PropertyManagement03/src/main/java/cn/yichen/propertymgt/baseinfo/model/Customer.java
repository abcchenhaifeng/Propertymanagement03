package cn.yichen.propertymgt.baseinfo.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2019年8月7日23:30:32
 * @author YiChen(李冠永)
 * #客户
 *
 */
@Alias("Customer")
public class Customer implements Serializable {
    private Long customerId;

    private Long storeId;

    private String firstName;

    private String lastName;

    private String email;

    private Long addressId;

	private Boolean active;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }
    
    public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getCustomerId() {
		return customerId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", storeId=" + storeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", addressId=" + addressId + ", active=" + active
				+ ", createDate=" + createDate + ", lastUpdate=" + lastUpdate + "]";
	}
}