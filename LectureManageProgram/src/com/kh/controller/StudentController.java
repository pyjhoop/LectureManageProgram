package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.StudentService;
import com.kh.model.vo.Student;
import com.kh.view.ManageView;

public class StudentController {

	public void selectAllStudent() {

		ArrayList<Student> list = new StudentService().selectAllStudent();

		if (list.isEmpty()) {
			new ManageView().displayFails("조회한 결과가 없습니다.");
		} else {
			new ManageView().displayList(list);
		}
	}
	
	public ArrayList<Student> pasingStudentList(int page) {
		
		ArrayList<Student> list = new StudentService().pasingStudentList(page);
		
		return list;
	}

	public int getCount() {
		
		int result = new StudentService().getCount();
		
		return result;
	}
}
