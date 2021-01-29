package kr.or.ddit.ioc;

public class DbConfig {
	
	private String url;
	private String username;
	private String driverClassName;
	private String password;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DbConfig [url=" + url + ", username=" + username + ", driverClassName=" + driverClassName
				+ ", password=" + password + "]";
	}
	
	
}
