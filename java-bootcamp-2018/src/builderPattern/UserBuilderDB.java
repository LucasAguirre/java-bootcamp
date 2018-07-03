package builderPattern;

public class UserBuilderDB implements IBuilderDB{
	ConnectionDB db;
	public UserBuilderDB() {
		this.db=new ConnectionDB();
	}
	@Override
	public ConnectionDB getConnectionDB() {
		return db;
	}
	@Override
	public void buildUser() {
		db.setUser("Common_User");
		
	}
	@Override
	public void buildPass() {
		db.setPass("");
		
	}
	
}
