package com.kh.controller;

import com.kh.model.service.ManageService;
import com.kh.view.ManageView;

public class ManageController {

	public void login(String managerId, String managerPwd) {
		
		String result = new ManageService().login(managerId, managerPwd);
		
		if (result != null) {
			new ManageView().displaySuccess(result + "님 어서오세요");
			new ManageView().mainPage();
		} else {
			new ManageView().displayFails("아이디 또는 비밀번호를 확인해주세요.");
		}
	}

}
