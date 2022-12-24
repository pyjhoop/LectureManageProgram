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
}
