package kr.or.ddit.model;

public class UserVo {
	
	private String userid;
	private String usernm;
	
	public UserVo() {}//扁夯积己磊 积己 
	
	public UserVo(String userid, String usernm) {
		setUserid(userid);
		setUsernm(usernm);
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", usernm=" + usernm + "]";
	}
	
	
}
