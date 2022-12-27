package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InstructorDao {

	Properties prop = new Properties();

	public InstructorDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertInstructor(Connection conn, String name, int salary, int lecNo, String resi) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertInstructor");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setInt(2, salary);
			pstmt.setInt(3, lecNo);
			pstmt.setString(4, resi);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateInstructor(Connection conn, int insNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateInstructor");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, insNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
