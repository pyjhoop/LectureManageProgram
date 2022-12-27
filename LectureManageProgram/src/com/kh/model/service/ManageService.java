package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.model.dao.ManageDao;

public class ManageService {

	public String login(String managerId, String managerPwd) {
		
		Connection conn = getConnection();
		
		String result = new ManageDao().login(conn, managerId, managerPwd);
		
		close(conn);
		
		return result;
	}
	
}
