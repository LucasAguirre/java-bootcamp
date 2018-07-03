package abstractFactory;

public interface SQLConnection {

	MicrosoftSQL getMicrosoftSQL(String sql1);
	OtherSQL getOtherSQL(String sql2);
}
