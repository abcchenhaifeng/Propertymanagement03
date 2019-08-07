package cn.yichen.propertymgt.admin.model;

import java.io.Serializable;

/**
 * 2019年8月7日23:29:10
 * @author YiChen(李冠永)
 * #系统功能权限
 *
 */
public class SystemFunctionuser implements Serializable {
    private String userid;

    private Integer funno;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getFunno() {
        return funno;
    }

    public void setFunno(Integer funno) {
        this.funno = funno;
    }

	@Override
	public String toString() {
		return "Systemfunctionuser [userid=" + userid + ", funno=" + funno + "]";
	}
}