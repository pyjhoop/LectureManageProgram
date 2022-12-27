package com.kh.model.vo;

public class All extends Instructor {
	private String lectureName;
	private int lecturePrice;
	

	public All(int instructorNo, String instructorName, int salary,int lectureNo,String resignation,String lectureName,int lecturePrice) {
		super(instructorNo,instructorName,salary,lectureNo, resignation);
		this.lectureName = lectureName;
		this.lecturePrice = lecturePrice;
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

	@Override
	public String toString() {
		return super.toString()+", 이름" + lectureName
				+ ", 가격" + lecturePrice;
	};
}
