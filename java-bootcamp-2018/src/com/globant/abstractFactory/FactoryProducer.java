package com.globant.abstractFactory;

public class FactoryProducer {
	   public static ISQLConnection getFactory(String choice){
		   
		      if(choice.equalsIgnoreCase("Microsoft")){
		         return new MicrosoftSQLFactory();
		         
		      }else if(choice.equalsIgnoreCase("Other")){
		         return new OtherSQLFactory();
		      }
		      
		      return null;
		   }
}
