package com.globant.java_bootcamp_maven;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Test1 extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Test1( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	this.xx();
        assertTrue( true );
    }
	public void xx() {
		System.out.println("Hello Maven from Junit");
		
	}
	
	
}
