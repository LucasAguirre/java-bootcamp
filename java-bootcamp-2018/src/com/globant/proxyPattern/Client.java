package com.globant.proxyPattern;

public class Client {
	public static void main(String[] args) {
		IConnectionDB db= new ProxyConnectionDB();
		System.out.println("Try connect to db");
		db.connect();
		System.out.println("Try make a Select query");
		db.makeQuery("SELECT id FROM ld_users WHERE name='agustin'");
		System.out.println("Try make a Delete query");
		db.makeQuery("DELETE FROM ld_users WHERE name='agustin'");
	}
}
