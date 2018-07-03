package abstractFactory;

public class MicrosoftSQLFactory implements SQLConnection{

	@Override
	public MicrosoftSQL getMicrosoftSQL(String sql) {
		if(sql==null)
			return null;
		if(sql.equalsIgnoreCase("MicrosoftAccess"))
			return new MicrosoftAccess();
		else if(sql.equalsIgnoreCase("MicrosoftSQLServer"))
			return new MicrosoftSQLServer();
		return null;
	}

	@Override
	public OtherSQL getOtherSQL(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
