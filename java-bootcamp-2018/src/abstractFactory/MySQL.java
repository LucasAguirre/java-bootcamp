package abstractFactory;

public class MySQL implements OtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to MySQL database");

	}

}
