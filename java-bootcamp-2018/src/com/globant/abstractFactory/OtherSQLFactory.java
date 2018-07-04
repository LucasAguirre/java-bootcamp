package com.globant.abstractFactory;

public class OtherSQLFactory implements ISQLConnection {

	@Override
	public IMicrosoftSQL getMicrosoftSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOtherSQL getOtherSQL(String sql) {
		if (sql == null)
			return null;
		if (sql.equalsIgnoreCase("MySQL"))
			return new MySQL();
		else if (sql.equalsIgnoreCase("OracleSQL"))
			return new OracleSQL();
		else if (sql.equalsIgnoreCase("PostgreSQL"))
			return new PostgreSQL();

		return null;
	}

}
