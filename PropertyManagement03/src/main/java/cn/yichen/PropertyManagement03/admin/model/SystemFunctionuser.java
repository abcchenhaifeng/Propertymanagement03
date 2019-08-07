package cn.yichen.PropertyManagement03.admin.model;

public class SystemFunctionuser {
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