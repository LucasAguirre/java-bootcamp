package com.globant.mongoDB;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import com.mongodb.MongoClient;

/**
 * DAO for StudentXCourse entity
 * 
 *
 */
public class StudentXCourseDAO extends BasicDAO<StudentXCourse, String> {

	public StudentXCourseDAO(Morphia morphia, MongoClient mongo, String dbName) {
		super(mongo, morphia, dbName);
	}

}
