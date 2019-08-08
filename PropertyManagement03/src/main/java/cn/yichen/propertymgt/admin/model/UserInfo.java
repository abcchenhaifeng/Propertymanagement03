package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 2019年8月7日23:29:35
 * @author YiChen(李冠永)
 * #系统操作员
 *
 */
@Alias("UserInfo")
public class UserInfo implements Serializable {
    private String userid;

    private String userpassword;

    private String username;

    private String userrole;

    private Integer age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joindate;

    private String status;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole == null ? null : userrole.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", userpassword=" + userpassword + ", username=" + username
				+ ", userrole=" + userrole + ", age=" + age + ", joindate=" + joindate + ", status=" + status + "]";
	}
}