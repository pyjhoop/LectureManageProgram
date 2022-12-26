package com.kh.model.vo;

public class Instructor extends Site {
	private int instructorNo;
	private String instructorName;
	private int salary;
	private int lectureNo;
	private String resignation;

	public Instructor() {}
	
	public Instructor(int instructorNo, String instructorName, int salary, int lectureNo, String resignation) {
		this.instructorNo = instructorNo;
		this.instructorName = instructorName;
		this.salary = salary;
		this.lectureNo = lectureNo;
		this.resignation = resignation;
	}

	public int getInstructorNo() {
		return instructorNo;
	}

	public void setInstructorNo(int instructorNo) {
		this.instructorNo = instructorNo;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getResignation() {
		return resignation;
	}

	public void setResignation(String resignation) {
		this.resignation = resignation;
	}

	@Override
	public String toString() {
		return "강사 번호 : " + instructorNo + ", 이름 : " + instructorName + ", 월급 : " + salary
				+ ", 강의 번호 : " + lectureNo + ", 입/퇴사 여부 : " + resignation;
	}
	
	
	
	
}
