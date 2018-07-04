package com.globant.proxyPattern;

public interface IConnectionDB {

	boolean connect();

	boolean makeQuery(String query);
}
