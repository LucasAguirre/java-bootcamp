package Singleton;

public class Singleton {

	public static void main(String[] args) {
		DatabaseConnection db=DatabaseConnection.getInstance();
		if(db.connect())
			System.out.print("Connection Success");
		else
			System.out.print("Connection Failure");
	}
}

class DatabaseConnection{
	
	private DbConnection db;
	static DatabaseConnection obj= new DatabaseConnection();
	private DatabaseConnection() {
		db=new DbConnection();
	}
	public static DatabaseConnection getInstance() {
		return obj;
	}
	public boolean connect() {
		
		return db.connect();
	}
}