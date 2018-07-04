package com.globant.builderPattern;

public interface IBuilderDB {

	public ConnectionDB getConnectionDB();

	public void buildUser();

	public void buildPass();
}
