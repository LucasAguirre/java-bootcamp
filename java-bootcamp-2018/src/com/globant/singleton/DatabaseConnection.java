package com.globant.Singleton;

public class DatabaseConnection {

	private DbConnection db;
	static DatabaseConnection obj = new DatabaseConnection();

	private DatabaseConnection() {
		db = new DbConnection();
	}

	public static DatabaseConnection getInstance() {
		return obj;
	}

	public boolean connect() {

		return db.connect();
	}
}