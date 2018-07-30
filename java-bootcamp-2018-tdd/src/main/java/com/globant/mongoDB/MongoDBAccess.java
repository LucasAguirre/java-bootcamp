package com.globant.mongoDB;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

/**
 * 
 * MongoDBAccess create connections to mongoDB and make queries
 *
 */
public class MongoDBAccess {
	static final String DBNAME = "highschool";
	static final String COURSE = "Course";
	static final String TEACHER = "Teacher";
	static final String SCHEDULETIME = "ScheduleTime";
	static final String STUDENT = "Student";
	static final String STUDENTXCOURSE = "StudentXCourse";
	StudentXCourseDAO studentXCourseDAO;
	CourseDAO courseDAO;
	Datastore datastore;
	MongoClient mongo;
	Morphia morphia;

	/**
	 * establish a connection whit mongoDB server
	 */
	public void setUp() {
		mongo = new MongoClient("localhost", 27017);
		morphia = new Morphia();
		morphia.mapPackage("com.globant.mongoDB");
		datastore = morphia.createDatastore(mongo, DBNAME);
	}

	/**
	 * create a StudentXCourseDAO
	 */
	public void setUpStudentXCourseDAO() {
		studentXCourseDAO = new StudentXCourseDAO(morphia, mongo, DBNAME);
	}

	/**
	 * create a CourseDAO
	 */
	public void setUpCourseDAO() {
		courseDAO = new CourseDAO(morphia, mongo, DBNAME);
	}

	/**
	 * Fetch all students whose notes in a specific course were greater than 4.
	 * 
	 * @param course
	 *            the specific course to find
	 */
	public void findStudentThatPassedCourse(Integer course) {
		Query<StudentXCourse> query = datastore.createQuery(StudentXCourse.class);
		query.and(query.criteria("courseId").equal(course), query.criteria("finalNote").greaterThanOrEq(4));
		QueryResults<StudentXCourse> retrievedStudents = studentXCourseDAO.find(query);
		showStudentsForCourse(retrievedStudents, course, 4);
	}

	/**
	 * Fetch all students whose notes in any courses were greater than 4.
	 */
	public void findStudentThatPassedCourse() {
		Query<StudentXCourse> query = datastore.createQuery(StudentXCourse.class);
		query.criteria("finalNote").greaterThanOrEq(4);
		QueryResults<StudentXCourse> retrievedStudents = studentXCourseDAO.find(query);
		showStudentsForCourse(retrievedStudents, -1, 4);
	}

	/**
	 * Fetch all students whose notes in a specific course were greater than a
	 * specific note.
	 * 
	 * @param course
	 *            the specific course to find
	 * @param note
	 *            the specific note of overcome
	 */
	public void findStudentThatPassedCourse(Integer course, int note) {
		Query<StudentXCourse> query = datastore.createQuery(StudentXCourse.class);
		query.and(query.criteria("courseId").equal(course), query.criteria("finalNote").greaterThanOrEq(note));
		QueryResults<StudentXCourse> retrievedStudents = studentXCourseDAO.find(query);
		showStudentsForCourse(retrievedStudents, course, note);
	}

	/**
	 * show results of find students by course and note
	 * 
	 * @param retrievedStudents
	 * @param course
	 * @param note
	 */
	private void showStudentsForCourse(QueryResults<StudentXCourse> retrievedStudents, Integer course, Integer note) {
		if (course != -1) {
			System.out.println("Students whit final note greaterThan " + note);
		} else {
			System.out.println("Students of course number " + course + " whit final note greaterThan " + note);
		}
		for (StudentXCourse retrievedStudent : retrievedStudents) {
			System.out.print(retrievedStudent.getStudentId() + " - ");
		}
		System.out.println();
	}

	/**
	 * Fetch all courses ordered by name for a given teacher.
	 * 
	 * @param teacher
	 *            the teacher to find
	 */
	public void findCoursesOfTeacher(Integer teacher) {
		Query<Course> query = datastore.createQuery(Course.class);
		query.criteria("assignedTeacher").equal(teacher);
		query.order("name");
		QueryResults<Course> retrievedCourses = courseDAO.find(query);
		showCourseOfTeachers(retrievedCourses, teacher);
	}

	/**
	 * show the result of find course of a teacher
	 * 
	 * @param retrievedCourses
	 * @param teacher
	 */
	private void showCourseOfTeachers(QueryResults<Course> retrievedCourses, Integer teacher) {
		System.out.println("Courses for the theacher " + teacher);
		for (Course retrievedCourse : retrievedCourses) {
			System.out.println(retrievedCourse.getName());
		}
		System.out.println();
	}

}
