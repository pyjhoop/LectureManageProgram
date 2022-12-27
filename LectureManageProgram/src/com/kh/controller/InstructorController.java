package com.kh.controller;

import com.kh.model.service.InstructorService;
import com.kh.view.ManageView;

public class InstructorController {

	public void insertInstructor(String name, int salary, int lecNo, String resi) {

		int result = new InstructorService().insertInstructor(name, salary, lecNo, resi);

		if (result > 0) {
			new ManageView().displaySuccess("성공적으로 추가 되었습니다.");
		} else {
			new ManageView().displayFails("추가를 실패 하였습니다.");
		}

	}

	public void updateInstructor(int insNo) {
		int result = new InstructorService().updateInstructor(insNo);
		
		if (result > 0) {
			new ManageView().displaySuccess("성공적으로 퇴사처리 되었습니다.");
		} else {
			new ManageView().displayFails("퇴사처리를 실패하였습니다.");
		}
	}

}
