package com.globant.abstractFactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
	//connect to Microsoft Access db
	//get a Microsoft factory
    ISQLConnection microsoftSQLFactory = FactoryProducer.getFactory("Microsoft");
    //get the Access db
    IMicrosoftSQL db1 = microsoftSQLFactory.getMicrosoftSQL("MicrosoftAccess");
    //connect
    db1.connect();
    
    
	//connect to MySQL db
	//get a Other SQL factory
    ISQLConnection otherSQLFactory = FactoryProducer.getFactory("Other");
    //get the MySQL db
    IOtherSQL db2 = otherSQLFactory.getOtherSQL("MySQL");
    //connect
    db2.connect();
    
    
	//connect to PostgreSQL db
    //get the MySQL db with the same Other SQL factory than previous connect
    IOtherSQL db3 = otherSQLFactory.getOtherSQL("PostGreSQL");
    //connect
    db3.connect();
    
 }
}
