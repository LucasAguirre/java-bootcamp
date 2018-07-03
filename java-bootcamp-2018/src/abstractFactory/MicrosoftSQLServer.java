package abstractFactory;

public class MicrosoftSQLServer implements MicrosoftSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to MicrosoftSQLServer database");
		
	}

}
