package abstractFactory;

public class PostgreSQL implements IOtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to PostgreSQL database");

	}

}
