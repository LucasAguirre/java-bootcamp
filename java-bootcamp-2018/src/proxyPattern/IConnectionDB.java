package proxyPattern;

public interface IConnectionDB {

	boolean connect();
	boolean makeQuery(String query);
}
