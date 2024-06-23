package com.ny.getemployeeinfo;

import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Delete_Method extends BaseTest {
	String domain = "https://jsonplaceholder.typicode.com";
	@BeforeClass
	public void deleteEmployee() throws InterruptedException {
		log.info("***** Start Employee delete records*****");	//http://dummy.restapiexample.com/api/v1
		RestAssured.baseURI="domain"; //Specify base URI
		httpRequest=RestAssured.given();	
	    response=httpRequest.request(Method.GET,domain +"/posts");
	    JsonPath jsonPathEvaluator=response.jsonPath();
	    String empID=jsonPathEvaluator.get("[0].id"); //hero
	    response=httpRequest.request(Method.DELETE,"/delete/" +empID);
	    Thread.sleep(3000);
	    
		}
		@Test
		public void checkResponseBody() {
		String responseBody=response.getBody().asString();       //print response in console window
		System.out.println("Response Body Is:"+responseBody);
		Assert.assertEquals(responseBody.contains("successfully! deleted records"),true);
		
		}
		@Test
		public void checkStatusCode() {
		int statusCode=response.getStatusCode(); //Status code validation
		System.out.println("Status code is:"+statusCode);
		Assert.assertEquals(statusCode,200);
		
		}
		@Test
		public void checkContentType() {
		String contentType = response.header("Content-Type"); //capture details of Content-Type header	
		System.out.println("Content Type is:" + contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8"); //utf
		}
		// Content-Encoding validation
		@Test
		public void checkContentEncoding() {
		String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
		System.out.println("Content Encoding is:" + contentEncoding);
		Assert.assertEquals(contentEncoding, "br");
		}
		// body as string validation
		@Test
		public void checkServerType() {
		String serverType = response.header("server");
		System.out.println("Title validation " +serverType);
		Assert.assertEquals(serverType, "cloudflare");
		}
		@Test
		public void checkStatusLine() {
		String statusLine=response.statusLine();             //Status line validation
		System.out.println("Status Line is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ok");
		}
		@AfterClass
	  public void tearDown() {
		  log.info("****end the employee delete records****");
	  
		
	}

}
