package com.kh.model.vo;

public class Student {
	private int stuNo;
	private String stuName;
	private String stuId;
	private int stuAge;
	private String gender;
	private String phone;
	private int lectureNo;

	public Student() {}
	
	public Student(int stuNo, String stuName, String stuId, int stuAge, String gender, String phone, int lectureNo) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuId = stuId;
		this.stuAge = stuAge;
		this.gender = gender;
		this.phone = phone;
		this.lectureNo = lectureNo;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	@Override
	public String toString() {
		return "학생 번호 : " + stuNo + ", 이름 : " + stuName + ", 아이디 : " + stuId + ", 나이 : " + stuAge
				+ ", 성별 : " + gender + ", 전화번호 : " + phone + ", 강의 번호 : " + lectureNo;
	}
	
	
	
	
	
}
