package com.globant.proxyPattern;

public class ProxyConnectionDB implements IConnectionDB {

	private ConnectionDB db = new ConnectionDB();

	@Override
	public boolean connect() {
		db.connect();
		return true;
	}

	@Override
	public boolean makeQuery(String query) {
		if (query.contains("DELETE")) {
			System.out.println("you don't have permission to delete");
			return false;
		} else
			return db.makeQuery(query);

	}

}
