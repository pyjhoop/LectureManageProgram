package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Student;

import static com.kh.common.JDBCTemplate.*;

public class ManageDao {

	Properties prop = new Properties();
	
	public ManageDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertLecture(Connection conn, String type, String lecName, int price, String courseTime,
			int resultPrice) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLecture");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, type);
			pstmt.setString(2, lecName);
			pstmt.setInt(3, price);
			pstmt.setString(4, courseTime);
			pstmt.setInt(5, resultPrice);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public String login(Connection conn, String managerId, String managerPwd) {
		
		String result = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, managerId);
			pstmt.setString(2, managerPwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("MANAGER_NAME");
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










