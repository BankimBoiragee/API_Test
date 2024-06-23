package com.ny.getemployeeinfo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ny.restutils.Rest_Utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.usa.basepage.Base_Page;
import rest.usa.utils.Rest_Utils2;

public class Put_Method extends BaseTest {
	String empName=Rest_Utils.empName();
	String empSal=Rest_Utils.empSal();
	String empAge=Rest_Utils.empAge();
	String domain = "https://jsonplaceholder.typicode.com";
	@BeforeTest
	public void updateEmployee() {
	log.info("***** Start Employee information*****");	
	RestAssured.baseURI="domain"; //Specify base URI
	JSONObject requestParams=new JSONObject();//Request paylaod sending along with post request
	requestParams.put("name",empName);
	requestParams.put("salary",empSal);
	requestParams.put("age",empAge);
		
    httpRequest= RestAssured.given(); // Request Instance
	httpRequest.header("Content-Type","application/json; charset=utf-8");
	httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	response=httpRequest.request(Method.PUT,domain +"/posts");
	}
	@Test
	public void checkResponseBody() {
	String responseBody=response.getBody().asString();       //print response in console window
	System.out.println("Response Body Is:"+responseBody);
	Assert.assertEquals(responseBody.contains(empName),true);
	Assert.assertEquals(responseBody.contains(empSal),true);
	Assert.assertEquals(responseBody.contains(empAge),true);
	}
	@Test
	public void checkStatusCode() {
	int statusCode=response.getStatusCode(); //Status code validation
	System.out.println("Status code is:"+statusCode);
	Assert.assertEquals(statusCode,201);
	
	}
	@Test
	public void checkContentType() {
	String contentType = response.header("Content-Type"); // capture details of Content-Type header	
	System.out.println("Content Type is:" + contentType);
	Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	// Content-Encoding validation
	@Test
	public void checkContentEncoding() {
	String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
	System.out.println("Content Encoding is:" + contentEncoding);
	Assert.assertEquals(contentEncoding, "gzip");
	}
	// body as string validation
	@Test
	public void checkTitle() {
	String title = response.jsonPath().get("[1].title");
	System.out.println("Title validation " +title);
	Assert.assertEquals(title, "qui est esse");
	}
	@Test
	public void checkStatusLine() {
	String statusLine=response.statusLine();             //Status line validation
	System.out.println("Status Line is:"+statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	}
	@AfterTest
  public void tearDown() {
	  log.info("****end the employee info****");
  }
	
}
