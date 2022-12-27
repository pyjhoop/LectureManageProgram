package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.model.dao.InstructorDao;

public class InstructorService {

	public int insertInstructor(String name, int salary, int lecNo, String resi) {

		Connection conn = getConnection();

		int result = new InstructorDao().insertInstructor(conn, name, salary, lecNo, resi);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;

	}

	public int updateInstructor(int insNo) {
		Connection conn = getConnection();
		
		int result = new InstructorDao().updateInstructor(conn, insNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}



















