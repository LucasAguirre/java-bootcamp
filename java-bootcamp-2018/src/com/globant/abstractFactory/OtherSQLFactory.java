package com.globant.abstractFactory;

public class OtherSQLFactory implements ISQLConnection {
	static final String MYSQL = "MySQL";
	static final String ORACLESQL = "OracleSQL";
	static final String POSTGRESQL = "PostgreSQL";

	@Override
	public IMicrosoftSQL getMicrosoftSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOtherSQL getOtherSQL(String sql) {
		if (sql == null)
			return null;
		if (MYSQL.equalsIgnoreCase(sql)) {
			return new MySQL();
		} else if (ORACLESQL.equalsIgnoreCase(sql)) {
			return new OracleSQL();
		} else if (POSTGRESQL.equalsIgnoreCase(sql)) {
			return new PostgreSQL();
		}

		return null;
	}

}
