package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.StudentDao;
import com.kh.model.vo.Student;

public class StudentService {

	public ArrayList<Student> selectAllStudent() {
		
		Connection conn = getConnection();
		
		ArrayList<Student> list = new StudentDao().selectAllStudent(conn);
		
		close(conn);
		
		return list;
	}
	
	
	public ArrayList<Student> pasingStudentList(int page){
		
		Connection conn = getConnection();
		
		ArrayList<Student> list = new StudentDao().pasingStudentList(conn, page);
		
		close(conn);
		
		return list;
	}


	public int getCount() {
		
		Connection conn = getConnection();
		
		int result = new StudentDao().getCount(conn);
		
		close(conn);
		
		return result;
	}
}
