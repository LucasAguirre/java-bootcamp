package builderPattern;

public class AdminBuilderDB implements IBuilderDB{

	ConnectionDB db;
	public AdminBuilderDB() {
		this.db=new ConnectionDB();
	}
	@Override
	public ConnectionDB getConnectionDB() {
		return db;
	}
	@Override
	public void buildUser() {
		db.setUser("admin");
		
	}
	@Override
	public void buildPass() {
		db.setPass("admin");
		
	}
	
	
}
