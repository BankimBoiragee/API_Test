package com.ny.getemployeeinfo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	    public static RequestSpecification httpRequest;
		public static Response response;
		public String empID="hero";
		
		public static Logger log;
		@BeforeClass
		public void setUp() {
			log=Logger.getLogger("QA Lead Bankim");
			PropertyConfigurator.configure("log4j.properties");
			log.setLevel(Level.DEBUG);
		}

}
