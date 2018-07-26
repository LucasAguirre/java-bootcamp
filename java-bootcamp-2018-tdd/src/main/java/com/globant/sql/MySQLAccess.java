package com.globant.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * Connect and make queries to DB
 *
 */
public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	/**
	 * Create a connection to the DB
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		try {
			// load the MySQL driver
			Class.forName("com.mysql.jdbc.Driver");
			// connect to DB highschool
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/highschool?" + "user=sqluser&password=sqluserpw");
			statement = connect.createStatement();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * close resultSet, statement and connections
	 */
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * List students and teachers for a given course
	 * 
	 * @throws Exception
	 */
	public void searchStudentsByCourse(String givenCourse) throws Exception {
		// make the queyr
		resultSet = statement.executeQuery(
				"SELECT c.name AS CourseName, t.lastName AS TeacherlastName , t.firstName AS TeacherfirstName, s.lastName AS StudentlastName, s.firstName AS StudentfirstName"
						+ " FROM Course c " + "	INNER JOIN Teacher t ON c.assignedTeacher=t.id"
						+ "	INNER JOIN StudentXCourse sc ON c.id=sc.courseId"
						+ "	INNER JOIN Student s ON s.registration_number = sc.studentId" + " WHERE c.name ='"
						+ givenCourse + "'" + " ORDER BY c.name, s.lastName ASC");
		listStudentsByCourse();
	}

	/**
	 * if a course is not specified, search all courses
	 * 
	 * @throws Exception
	 */
	public void searchStudentsByCourse() throws Exception {

		// make the queyr
		resultSet = statement.executeQuery(
				"SELECT c.name AS CourseName, t.lastName AS TeacherlastName , t.firstName AS TeacherfirstName, s.lastName AS StudentlastName, s.firstName AS StudentfirstName"
						+ " FROM Course c " + "	INNER JOIN Teacher t ON c.assignedTeacher=t.id"
						+ "	INNER JOIN StudentXCourse sc ON c.id=sc.courseId"
						+ "	INNER JOIN Student s ON s.registration_number = sc.studentId"
						+ " ORDER BY c.name, s.lastName ASC");
		listStudentsByCourse();

	}

	/**
	 * show the results of StudentsByCourse
	 * 
	 * @throws Exception
	 */
	private void listStudentsByCourse() throws Exception {
		System.out.println("List of students by course:");
		String course = "";
		String teacherLastName = "";
		String teacherFirstName = "";
		while (resultSet.next()) {
			String currentCourseName = resultSet.getString("CourseName");
			String currentTeacherlastName = resultSet.getString("TeacherlastName");
			String currentTeacherfirstName = resultSet.getString("TeacherfirstName");
			if (!course.equals(currentCourseName)) {
				course = currentCourseName;
				teacherFirstName = currentTeacherfirstName;
				teacherLastName = currentTeacherlastName;
				System.out.println();
				System.out.println("Course: " + course);
				System.out.println("Teacher: " + teacherLastName + ", " + teacherFirstName);
				System.out.println("Students:");
			}
			String currentStudentlastName = resultSet.getString("StudentlastName");
			String currentStudentfirstName = resultSet.getString("StudentfirstName");
			System.out.println("	" + currentStudentlastName + ", " + currentStudentfirstName);
		}
		System.out.println("**********************************");
	}

	/**
	 * Percentage of students that passed a given course
	 * 
	 * @throws Exception
	 */
	public void percentOfStudentsPassed(String givenCourse) throws Exception {
		resultSet = statement.executeQuery("SELECT c.name AS CourseName, count(*)*100/sq.Total AS Percentage"
				+ " FROM StudentXCourse sc" + "	INNER JOIN Course c ON c.id=sc.courseId"
				+ " INNER JOIN (SELECT count(*) AS Total, s.courseId" + " FROM StudentXCourse s"
				+ " GROUP BY s.courseId)sq ON sq.courseId=sc.courseId" + " WHERE sc.finalNote>7" + " AND c.name = '"
				+ givenCourse + "' GROUP BY sc.courseId;");
		showPercentOfStudents();
	}

	/**
	 * if a course is not specified, search all courses
	 * 
	 * @throws Exception
	 */
	public void percentOfStudentsPassed() throws Exception {
		resultSet = statement.executeQuery("SELECT c.name AS CourseName, count(*)*100/sq.Total AS Percentage"
				+ " FROM StudentXCourse sc" + "	INNER JOIN Course c ON c.id=sc.courseId"
				+ " INNER JOIN (SELECT count(*) AS Total, s.courseId" + " FROM StudentXCourse s"
				+ " GROUP BY s.courseId)sq ON sq.courseId=sc.courseId" + " WHERE sc.finalNote>7"
				+ " GROUP BY sc.courseId;");
		showPercentOfStudents();
	}

	/**
	 * show the results of search percent of Students that passed a course
	 * 
	 * @throws Exception
	 */
	private void showPercentOfStudents() throws Exception {
		System.out.println("percentage of students that passed each course");
		while (resultSet.next()) {
			String courseName = resultSet.getString("CourseName");
			String percentage = resultSet.getString("Percentage");
			double failed = 1 - Double.parseDouble(percentage);
			System.out.println("Course: " + courseName + ", Passed:" + percentage + ", Failed:" + failed);
		}
		System.out.println("**********************************");
	}

	/**
	 * timeline of a Teacher for each course that he is assigned
	 * 
	 * @throws Exception
	 */
	public void scheduleofTeacher(String givenLastName, String givenFirstName) throws Exception {
		resultSet = statement.executeQuery(
				"SELECT t.lastName AS TeacherlastName , t.firstName AS TeacherfirstName, st.dayOfWeek, st.startHour, st.finishHour,  c.name AS CourseName"
						+ " FROM ScheduleTime st" + " INNER JOIN Course c ON st.courseId=c.id"
						+ "	INNER JOIN  Teacher t ON c.assignedTeacher=t.id"
						+ " WHERE t.lastName='" + givenLastName + "' AND t.firstName = '" + givenFirstName + "'"
						+ " ORDER BY t.id, st.dayOfWeek;");
		showScheduleOfTeacher();

	}

	/**
	 * if a course is not specified, search all courses
	 * 
	 * @throws Exception
	 */
	public void scheduleofTeacher() throws Exception {
		resultSet = statement.executeQuery(
				"SELECT t.lastName AS TeacherlastName , t.firstName AS TeacherfirstName, st.dayOfWeek, st.startHour, st.finishHour,  c.name AS CourseName"
						+ " FROM ScheduleTime st" + " INNER JOIN Course c ON st.courseId=c.id"
						+ "	INNER JOIN  Teacher t ON c.assignedTeacher=t.id" + " ORDER BY t.id, st.dayOfWeek;");
		showScheduleOfTeacher();

	}

	private void showScheduleOfTeacher() throws Exception {
		String teacherLastName = "";
		String teacherFirstName = "";
		while (resultSet.next()) {
			String currentTeacherlastName = resultSet.getString("TeacherlastName");
			String currentTeacherfirstName = resultSet.getString("TeacherfirstName");
			if (!currentTeacherlastName.equals(teacherLastName)) {
				teacherFirstName = currentTeacherfirstName;
				teacherLastName = currentTeacherlastName;
				System.out.println();
				System.out.println("Teacher: " + teacherLastName + ", " + teacherFirstName);
				System.out.println("Schedule:");
			}
			String currentDayOfWeek = resultSet.getString("dayOfWeek");
			String currentStartHour = resultSet.getString("startHour");
			String currentFinishHour = resultSet.getString("finishHour");
			String currentCourseName = resultSet.getString("CourseName");
			System.out.println("	" + currentDayOfWeek + " " + currentStartHour + " - " + currentFinishHour + ": "
					+ currentCourseName);
		}
		System.out.println("**********************************");
	}

}