package allbeenclasses;

public class ProblemsBeen {
	@Override
	public String toString() {
		return "| cid: " + cid + ", cname: " + cname + ", c_status: " + c_status + ", c_role: " + c_role + "|";
	}
	private int cid;
	private String cname;
	private String c_status;
	private String c_role;
	public ProblemsBeen(String cname, String c_status, String c_role) {
		this.cname = cname;
		this.c_status = c_status;
		this.c_role = c_role;
	}
	public ProblemsBeen(int cid, String cname, String c_status, String c_role) {
		this.cid = cid;
		this.cname = cname;
		this.c_status = c_status;
		this.c_role = c_role;
	}
	public ProblemsBeen() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public String getC_role() {
		return c_role;
	}
	public void setC_role(String c_role) {
		this.c_role = c_role;
	}

}
