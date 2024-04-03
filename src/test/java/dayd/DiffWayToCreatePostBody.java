package dayd;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class DiffWayToCreatePostBody {
	@Test
	void testPojo()
	{
		
	
	PojoClass data = new PojoClass();
	data.setName("Snehal");
	data.setjob("tester");
	
	given().contentType("application/json")
	.body(data)
	.when().post("https://reqres.in/api/users").
	
	then().
	statusCode(201).
	log().all()
   	.body("name", equalTo("Snehal"))
	.body("Job", equalTo("tester"));
	
	
	
	}
}
