package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Student;

public class StudentDao {

	Properties prop = new Properties();

	public StudentDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> selectAllStudent(Connection conn) {

		ArrayList<Student> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("selectAllStudent");

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt("STU_NO"), rs.getString("STU_NAME"), rs.getString("STU_ID"),
						rs.getInt("STU_AGE"), rs.getString("GENDER"), rs.getString("PHONE"), rs.getInt("LECTURE_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}
	
	public ArrayList<Student> pasingStudentList(Connection conn, int page) {

		ArrayList<Student> list = new ArrayList<>();
		
		int start = 1 + (page-1) * 5;
		int end = 5 * page;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = prop.getProperty("pasingStudentList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Student(rs.getInt("STU_NO"), rs.getString("STU_NAME"), rs.getString("STU_ID"),
						rs.getInt("STU_AGE"), rs.getString("GENDER"), rs.getString("PHONE"), rs.getInt("LECTURE_NO")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public int getCount(Connection conn) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("getCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	
}
















