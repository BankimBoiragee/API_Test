package com.ny.getemployeeinfo;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Method {
	String domain = "https://jsonplaceholder.typicode.com";
	@Test
	public void getPost() {
	RestAssured.baseURI="domain"; //Specify base URI
	JSONObject requestParams=new JSONObject();//Request paylaod sending along with post request
	requestParams.put("batch-no", "27");
	requestParams.put("First_Name", "Aritra");
	requestParams.put("Last_Name", "Boiragee");
	requestParams.put("Company", "Smart Tech");
	requestParams.put("Position", "Automation");
	requestParams.put("Email", "bankim_cse@gmail.com");
	
	RequestSpecification httpRequest= RestAssured.given(); // Request Instance
	httpRequest.header("Content-Type","application/json; charset=utf-8");
	httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	Response response=httpRequest.request(Method.POST,domain +"/posts");
	
	String responseBody=response.getBody().asString();       //print response in console window
	System.out.println("Response Body Is:"+responseBody);
	
	int statusCode=response.getStatusCode(); //Status code validation
	System.out.println("Status code is:"+statusCode);
	Assert.assertEquals(statusCode,201);
	
	String emailVerify=response.jsonPath().get("Email"); // success code validation
	System.out.println("My Email is"+emailVerify);
	Assert.assertEquals(emailVerify,"bankim_cse@gmail.com");
	
	String statusLine=response.statusLine();             //Status line validation
	System.out.println("Status Line is:"+statusLine);
	Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	
  }
}
