package abstractFactory;

public class MicrosoftSQLFactory implements ISQLConnection{

	@Override
	public IMicrosoftSQL getMicrosoftSQL(String sql) {
		if(sql==null)
			return null;
		if(sql.equalsIgnoreCase("MicrosoftAccess"))
			return new MicrosoftAccess();
		else if(sql.equalsIgnoreCase("MicrosoftSQLServer"))
			return new MicrosoftSQLServer();
		return null;
	}

	@Override
	public IOtherSQL getOtherSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
