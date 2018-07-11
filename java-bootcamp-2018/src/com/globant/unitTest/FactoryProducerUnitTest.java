package com.globant.unitTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.globant.abstractFactory.FactoryProducer;
import com.globant.abstractFactory.IMicrosoftSQL;
import com.globant.abstractFactory.IOtherSQL;
import com.globant.abstractFactory.ISQLConnection;

public class FactoryProducerUnitTest {

	static final String MICROSOFT = "Microsoft";
	static final String MICROSOFTACCESS = "MicrosoftAccess";
	static final String OTHER = "Other";
	static final String MYSQL = "MySQL";
	static final String POSTGRESQL = "PostgreSQL";
	@Test
	public void test() {
		// connect to Microsoft Access db
		// get a Microsoft factory
		ISQLConnection microsoftSQLFactory = FactoryProducer.getFactory(MICROSOFT);
		assertNotNull(microsoftSQLFactory);
		// get the Access db
		IMicrosoftSQL db1 = microsoftSQLFactory.getMicrosoftSQL(MICROSOFTACCESS);
		assertNotNull(db1);
		// connect
		db1.connect();

		// connect to MySQL db
		// get a Other SQL factory
		ISQLConnection otherSQLFactory = FactoryProducer.getFactory(OTHER);
		assertNotNull(otherSQLFactory);
		// get the MySQL db
		IOtherSQL db2 = otherSQLFactory.getOtherSQL(MYSQL);
		assertNotNull(db2);
		// connect
		db2.connect();

		// connect to PostgreSQL db
		// get the MySQL db with the same Other SQL factory than previous
		// connect
		IOtherSQL db3 = otherSQLFactory.getOtherSQL(POSTGRESQL);
		assertNotNull(db3);
		// connect
		db3.connect();
	}

}
