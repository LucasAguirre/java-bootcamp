package com.globant.abstractFactory;

public class FactoryProducer {
	static final String MICROSOFT = "Microsoft";
	static final String OTHER = "Other";

	public static ISQLConnection getFactory(String choice) {

		if (MICROSOFT.equalsIgnoreCase(choice)) {
			return new MicrosoftSQLFactory();

		} else if (OTHER.equalsIgnoreCase(choice)) {
			return new OtherSQLFactory();
		}

		return null;
	}
}
