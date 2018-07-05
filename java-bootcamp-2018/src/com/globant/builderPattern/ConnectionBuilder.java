package com.globant.builderPattern;

public class ConnectionBuilder {

	private String user;
	private String pass;

	public ConnectionBuilder setUser(String u) {
		this.user = u;
		return this;
	}

	public ConnectionBuilder setPass(String p) {
		this.pass = p;
		return this;
	}

	public ConnectionDB buildConnectionDB() {
		return new ConnectionDB(user, pass);
	}

}
