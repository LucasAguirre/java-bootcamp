package abstractFactory;

public class OracleSQL implements IOtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to Oracle SQL database");

	}

}
