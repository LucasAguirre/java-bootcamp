package abstractFactory;

public class OracleSQL implements OtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to Oracle SQL database");

	}

}
