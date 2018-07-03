package unitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import abstractFactory.*;

public class FactoryProducerUnitTest {

	@Test
	public void test() {
    	//connect to Microsoft Access db
		//get a Microsoft factory
	    SQLConnection microsoftSQLFactory = FactoryProducer.getFactory("Microsoft");
	    assertNotNull(microsoftSQLFactory);
	    //get the Access db
	    MicrosoftSQL db1 = microsoftSQLFactory.getMicrosoftSQL("MicrosoftAccess");
	    assertNotNull(db1);
	    //connect
	    db1.connect();
	    
	    
		//connect to MySQL db
		//get a Other SQL factory
	    SQLConnection otherSQLFactory = FactoryProducer.getFactory("Other");
	    assertNotNull(otherSQLFactory);
	    //get the MySQL db
	    OtherSQL db2 = otherSQLFactory.getOtherSQL("MySQL");
	    assertNotNull(db2);
	    //connect
	    db2.connect();
	    
	    
		//connect to PostgreSQL db
	    //get the MySQL db with the same Other SQL factory than previous connect
	    OtherSQL db3 = otherSQLFactory.getOtherSQL("PostGreSQL");
	    assertNotNull(db3);
	    //connect
	    db3.connect();
	}

}
