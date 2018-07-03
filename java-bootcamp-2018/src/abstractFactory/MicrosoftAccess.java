package abstractFactory;

public class MicrosoftAccess implements MicrosoftSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to MicrosoftAccess database");

	}

}
