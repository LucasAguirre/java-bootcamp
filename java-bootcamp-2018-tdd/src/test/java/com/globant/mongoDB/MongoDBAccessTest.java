package com.globant.mongoDB;

import org.junit.Test;

public class MongoDBAccessTest {
	MongoDBAccess mongo = new MongoDBAccess();

	@Test
	public final void testFindStudents() {
		// Fetch all students whose notes in a specific course were greater than 4.
		mongo.setUp();
		mongo.setUpStudentXCourseDAO();
		mongo.findStudentThatPassedCourse(3, 4);
	}

	@Test
	public final void testFindCourses() {
		// Fetch all courses ordered by name for a given teacher.
		mongo.setUp();
		mongo.setUpCourseDAO();
		mongo.findCoursesOfTeacher(2);
	}
}
