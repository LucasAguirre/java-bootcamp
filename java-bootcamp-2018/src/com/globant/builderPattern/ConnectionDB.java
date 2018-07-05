package com.globant.builderPattern;

public class ConnectionDB {
	private String user;
	private String pass;

	public ConnectionDB(String u, String p) {
		this.user = u;
		this.pass = p;
	}

	public ConnectionDB() {

	}

	public void setUser(String u) {
		user = u;
	}

	public void setPass(String p) {
		pass = p;
	}

	public boolean connect() {
		System.out.println("connection Success , jdbc:mysql://localhost:3306/ User:" + user + " pass:" + pass);
		return true;
	}
}
