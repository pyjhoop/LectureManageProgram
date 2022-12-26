package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.model.vo.Instructor;
import com.kh.model.vo.Lecture;
import com.kh.model.vo.Manager;

public class ManageDao {
	
	private Properties prop = new Properties();
	public ManageDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Instructor> selectAllInstructor(Connection conn, int num){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Instructor> list = new ArrayList<Instructor>();
		
		String sql = prop.getProperty("selectAllInstructor");
		int end = num*5;
		int start = end-4;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rset.getInt("NUM");
				list.add(new Instructor(rset.getInt("instructor_no"),
										rset.getString("instructor_name"),
										rset.getInt("salary"),
										rset.getInt("lecture_no"),
										rset.getString("resignation")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public ArrayList<Lecture> selectLectureByKeyword(Connection conn, String keyword){
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLectureByKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Lecture(rset.getInt("lecture_no"),
									 rset.getString("lecture_type"),
									 rset.getString("lecture_name"),
									 rset.getInt("lecture_price"),
									 rset.getString("coursetime"),
									 rset.getInt("discount")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertLecture(Connection conn, Lecture l) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLecture");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getLectureType());
			pstmt.setString(2, l.getLectureName());
			pstmt.setInt(3, l.getLecturePrice());
			pstmt.setString(4, l.getCourseTime());
			pstmt.setInt(5, l.getDiscount());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public Manager login(Connection conn, String id, String pwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Manager m = null;
		
		String sql = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Manager();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}
}
