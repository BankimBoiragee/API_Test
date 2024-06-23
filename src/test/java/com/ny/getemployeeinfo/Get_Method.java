
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

// https://jsonplaceholder.typicode.com/


import com.gargoylesoftware.htmlunit.javascript.host.fetch.Request;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
@Test
public class Get_Method extends BaseTest{
	String domain = "https://jsonplaceholder.typicode.com";
	public void getMethod() {
	RestAssured.baseURI="domain";//RestAssured.baseURI="https://jsonplaceholder.typicode.com";	
// Request Instance/ RequestSpecification
    httpRequest = RestAssured.given();
// Response Instance, end point(query=/posts)or path parameter
    response = httpRequest.request(Method.GET, domain + "/posts");

// print response in console window
String responseBody = response.getBody().asString();
System.out.println("Response Body is:" + responseBody);

// status code validation
int statusCode = response.getStatusCode();
System.out.println("Status code is: " + statusCode);
Assert.assertEquals(statusCode, 200);

// validating headers
String contentType = response.header("Content-Type"); // capture details of Content-Type header
System.out.println("Content Type is:" + contentType);
Assert.assertEquals(contentType, "application/json; charset=utf-8");

// Content-Encoding validation
String contentEncoding = response.header("Content-Encoding");// capture details of Content-Encoding header
System.out.println("Content Encoding is:" + contentEncoding);
Assert.assertEquals(contentEncoding, "gzip");

// body as string validation
String title = response.jsonPath().get("[1].title");
System.out.println("Title validation " +title);
Assert.assertEquals(title, "qui est esse");

}

	}
