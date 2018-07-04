package com.globant.abstractFactory;

public class MicrosoftSQLServer implements IMicrosoftSQL {

	@Override
	public void connect() {
		System.out.println("Connection Success to MicrosoftSQLServer database");

	}

}
