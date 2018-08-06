package com.globant.dbConnection;

/**
 * singleton pattern for Connection to SQL server
 *
 */
public class SQLSingleton {

	static SQLConnection sql = null;

	/**
	 * empty constructor
	 */
	private SQLSingleton() {
	}

	/**
	 * 
	 * @return the instance of SQLConnection
	 * @throws Exception
	 */
	public static SQLConnection getInstance() throws Exception {
		try {
			if (sql == null) {
				synchronized (SQLSingleton.class) {
					if (sql == null) {
						sql = new SQLConnection();
						sql.setUp();
					}
				}
			}
			return sql;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sql;
	}
}
