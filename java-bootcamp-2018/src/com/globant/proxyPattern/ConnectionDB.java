package com.globant.proxyPattern;

public class ConnectionDB implements IConnectionDB {

	@Override
	public boolean connect() {
		System.out.println("Connection Success");
		return true;
	}

	@Override
	public boolean makeQuery(String query) {
		System.out.println("Query return for: " + "\r" + query);
		return true;
	}

}
