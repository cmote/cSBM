package wen.cmote.cSBM.springboot.model;

public class User {
	private Integer id;
    private String username;
    private String psw;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username == null ? null : username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw == null ? null : psw.trim();
	}

}
