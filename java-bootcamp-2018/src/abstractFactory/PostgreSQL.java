package abstractFactory;

public class PostgreSQL implements OtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to PostgreSQL database");

	}

}
