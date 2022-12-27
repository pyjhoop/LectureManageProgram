package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.model.dao.ManageDao;
import com.kh.model.vo.All;
import com.kh.model.vo.Instructor;
import com.kh.model.vo.Lecture;
import com.kh.model.vo.Manager;

public class ManageService {
	
	public ArrayList<Instructor> selectAllInstructor(int num){
		Connection conn = getConnection();
		
		ArrayList<Instructor> list = new ManageDao().selectAllInstructor(conn,num);
		
		close(conn);
		return list;
	}
	
	public ArrayList<Lecture> selectLectureByKeyword(String keyword){
		Connection conn = getConnection();
		
		ArrayList<Lecture> list = new ManageDao().selectLectureByKeyword(conn, keyword);
		
		close(conn);
		
		return list;
	}
	
	public int insertLecture(Lecture l) {
		Connection conn = getConnection();
		
		int result = new ManageDao().insertLecture(conn, l);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Manager login(String id, String pwd) {
		Connection conn = getConnection();
		
		Manager m = new ManageDao().login(conn, id, pwd);
		close(conn);
		return m;
	}
	
	//================인호=============================
	public ArrayList<All> selectAll(){
		Connection conn = getConnection();
		ArrayList<All> list = new ManageDao().selectAll(conn);
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<Instructor> selectName(String name){
		Connection conn = getConnection();
		ArrayList<Instructor> list = new ManageDao().selectName(conn,name);
		close(conn);
		
		return list;
			
		
	}
	
	public int delecteLecture(int lNo) {
		Connection conn = getConnection();
		int result = new ManageDao().deleteLecture(conn, lNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	
}
