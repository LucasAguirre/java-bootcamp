package com.globant.abstractFactory;

public class MySQL implements IOtherSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to MySQL database");

	}

}
