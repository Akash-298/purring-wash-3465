package allbeenclasses;

public class EmpProblemClassbeen {
	private String name;
	private String en_role;
	private int cid;
	private String cname;
	private String  c_status;
	private String c_role;
	public EmpProblemClassbeen(String name, String en_role, int cid, String cname, String c_status, String c_role) {
		super();
		this.name = name;
		this.en_role = en_role;
		this.cid = cid;
		this.cname = cname;
		this.c_status = c_status;
		this.c_role = c_role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEn_role() {
		return en_role;
	}
	public void setEn_role(String en_role) {
		this.en_role = en_role;
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
	@Override
	public String toString() {
		return "| name: " + name + ", en_role: " + en_role + ", cid: " + cid + ", cname: " + cname
				+ ", c_status: " + c_status + ", c_role: " + c_role + " |";
	}
	
	

}
