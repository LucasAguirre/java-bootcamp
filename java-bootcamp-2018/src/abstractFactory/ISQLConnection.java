package abstractFactory;

public interface ISQLConnection {

	IMicrosoftSQL getMicrosoftSQL(String sql1);
	IOtherSQL getOtherSQL(String sql2);
}
