package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ManageService;
import com.kh.model.vo.Instructor;
import com.kh.model.vo.Lecture;
import com.kh.model.vo.Manager;
import com.kh.view.ManageView;

public class ManageController {

	public ArrayList<Instructor> selectAllInstructor(int num) {
		ArrayList<Instructor> list = new ArrayList<Instructor>();
		
		list = new ManageService().selectAllInstructor(num);
		
		
		return list;
	}
	
	
	public void selectLectureByKeyword(String keyword) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		
		list = new ManageService().selectLectureByKeyword(keyword);
		
		if(list.isEmpty()) {
			new ManageView().displayFail("조회된 결과가 없습니다.");
		}else {
			new ManageView().displayLecList(list);
		}
	}
	
	public void insertLecture(Lecture l) {
		int result = new ManageService().insertLecture(l);
		
		if(result>0) {
			new ManageView().displaySuccess("강의추가가 성공적으로 완료되었습니다.");
		}else {
			new ManageView().displayFail("강의추가가 실패했습니다.");
		}
	}
	
	public int login(String id, String pwd) {
		int num = 0;
		Manager m = new ManageService().login(id, pwd);
		if(m != null) {
			num = 1;
		}
		return num;
	}
}
