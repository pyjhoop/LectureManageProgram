package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ManageService;
import com.kh.model.vo.Instructor;
import com.kh.view.ManageView;

public class ManageController {

	public ArrayList<Instructor> selectAllInstructor(int num) {
		ArrayList<Instructor> list = new ArrayList<Instructor>();
		
		list = new ManageService().selectAllInstructor(num);
		
		
		return list;
	}
}
