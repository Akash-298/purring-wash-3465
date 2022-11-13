package allbeenclasses;

public class EngenersBeen {
	@Override
	public String toString() {
		return "| enid: " + enid + ", engNaame: " + engNaame + ", engUsername: " + engUsername + ", password:  "
				+ password + ", en_role:  " + en_role + "|";
	}
	private int enid;
	private String engNaame;
	private String engUsername;
	private String password;
	private String en_role;
	public EngenersBeen(int enid, String engNaame,String engUsername, String password, String en_role) {
		this.enid = enid;
		this.engNaame = engNaame;
		this.password = password;
		this.engUsername=engUsername;
		this.en_role = en_role;
	}
	public EngenersBeen(String engNaame,String engUsername, String password, String en_role) {
		this.engNaame = engNaame;
		this.engUsername=engUsername;
		this.password = password;
		this.en_role = en_role;
	}
	public EngenersBeen() {
		
	}
	public int getRoll() {
		return enid;
	}
	public void setRoll(int roll) {
		this.enid = roll;
	}
	public String getEngNaame() {
		return engNaame;
	}
	public void setEngNaame(String engNaame) {
		this.engNaame = engNaame;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return en_role;
	}
	public void setRole(String role) {
		this.en_role = role;
	}
	public int getEid() {
		return enid;
	}
	public void setEid(int eid) {
		this.enid = eid;
	}
	public String getEngUsername() {
		return engUsername;
	}
	public void setEngUsername(String engUsername) {
		this.engUsername = engUsername;
	}
	

}
