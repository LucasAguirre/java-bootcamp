package com.globant.singleton;

public class DatabaseConnection {

	static DatabaseConnection obj = null;
	  private DatabaseConnection() {}

	  public static DatabaseConnection getInstance() {
	        if (obj == null) {
	            synchronized(DatabaseConnection.class) {
	                if (obj == null) {
	                	obj = new DatabaseConnection();
	                }
	            }
	        }
	        return obj;
	    }

	public boolean connect() {

		return DbConnection.connect();
	}
}