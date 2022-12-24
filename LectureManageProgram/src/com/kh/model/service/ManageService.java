package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.model.dao.ManageDao;
import com.kh.model.vo.Instructor;

public class ManageService {
	
	public ArrayList<Instructor> selectAllInstructor(int num){
		Connection conn = getConnection();
		
		ArrayList<Instructor> list = new ManageDao().selectAllInstructor(conn,num);
		
		close(conn);
		return list;
	}
}
