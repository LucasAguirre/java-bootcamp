package com.globant.sql;

import org.junit.Test;

public class MySQLAccessTest {
	private MySQLAccess dao = new MySQLAccess();

	private void setUp() throws Exception {
		dao.setUp();
	}

	private void close() {
		dao.close();
	}

	@Test
	public void testListStudentsByCourse() throws Exception {
		try {
			setUp();
			dao.searchStudentsByCourse("CouserOneName");
		} finally {
			close();
		}
	}

	@Test
	public void testPercentOfStudentsPassed() throws Exception {
		try {
			setUp();
			dao.percentOfStudentsPassed("CouserThreeName");
		} finally {
			close();
		}
	}

	@Test
	public void testScheduleofTeacher() throws Exception {
		try {
			setUp();
			dao.scheduleofTeacher("TeacherThreeLastName","TeacherThreeFirstName");
		} finally {
			close();
		}
	}

}
