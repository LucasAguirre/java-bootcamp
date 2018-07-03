package abstractFactory;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
	//connect to Microsoft Access db
	//get a Microsoft factory
    SQLConnection microsoftSQLFactory = FactoryProducer.getFactory("Microsoft");
    //get the Access db
    MicrosoftSQL db1 = microsoftSQLFactory.getMicrosoftSQL("MicrosoftAccess");
    //connect
    db1.connect();
    
    
	//connect to MySQL db
	//get a Other SQL factory
    SQLConnection otherSQLFactory = FactoryProducer.getFactory("Other");
    //get the MySQL db
    OtherSQL db2 = otherSQLFactory.getOtherSQL("MySQL");
    //connect
    db2.connect();
    
    
	//connect to PostgreSQL db
    //get the MySQL db with the same Other SQL factory than previous connect
    OtherSQL db3 = otherSQLFactory.getOtherSQL("PostGreSQL");
    //connect
    db3.connect();
    
 }
}
