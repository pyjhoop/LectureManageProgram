package com.kh.model.vo;

public class Manager{
	private int managerNo;
	private String managerName;
	private String managerId;
	private String managerPwd;

	public Manager() {}
	
	public Manager(int managerNo, String managerName, String managerId, String managerPwd) {
		this.managerNo = managerNo;
		this.managerName = managerName;
		this.managerId = managerId;
		this.managerPwd = managerPwd;
	}

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	@Override
	public String toString() {
		return "매니저 번호 : " + managerNo + ", 이름 : " + managerName + ", 아이디 : " + managerId
				+ ", 비밀번호" + managerPwd;
	}
	
	
	
	
}
