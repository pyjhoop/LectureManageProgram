package com.kh.model.vo;

public class Lecture {
	private int lectureNo;
	private String lectureType;
	private String lectureName;
	private int lecturePrice;
	private String courseTime;
	private int discount;

	public Lecture() {};
	
	public Lecture(int lectureNo, String lectureType, String lectureName, int lecturePrice, String courseTime,
			int discount) {
		this.lectureNo = lectureNo;
		this.lectureType = lectureType;
		this.lectureName = lectureName;
		this.lecturePrice = lecturePrice;
		this.courseTime = courseTime;
		this.discount = discount;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getLectureType() {
		return lectureType;
	}

	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public int getLecturePrice() {
		return lecturePrice;
	}

	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "강의 번호 : " + lectureNo + ", 타입 : " + lectureType + ", 이름" + lectureName
				+ ", 가격" + lecturePrice + ", 수강시간" + courseTime + ", 할인금" + discount;
	}
	
	
	
	
	
}
