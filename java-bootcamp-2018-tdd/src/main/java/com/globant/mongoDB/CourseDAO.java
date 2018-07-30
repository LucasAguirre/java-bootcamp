package com.globant.mongoDB;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

/**
 * DAO for Course entity
 *
 */
public class CourseDAO extends BasicDAO<Course, String> {

	public CourseDAO(Morphia morphia, MongoClient mongo, String dbName) {
		super(mongo, morphia, dbName);
	}
}
