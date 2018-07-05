package com.globant.abstractFactory;

public class MicrosoftSQLFactory implements ISQLConnection {
	static final String MICROSOFTACCESS = "MicrosoftAccess";
	static final String MICROSOFTSQLSERVER = "MicrosoftSQLServer";

	@Override
	public IMicrosoftSQL getMicrosoftSQL(String sql) {
		if (sql == null) {
			return null;
		}
		if (MICROSOFTACCESS.equalsIgnoreCase("sql")) {
			return new MicrosoftAccess();
		} else if (MICROSOFTSQLSERVER.equalsIgnoreCase("sql")) {
			return new MicrosoftSQLServer();
		}
		return null;
	}

	@Override
	public IOtherSQL getOtherSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
