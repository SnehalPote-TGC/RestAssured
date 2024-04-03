package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HttpRequest {
	String idFunction = null;	
	@Test(priority = 1)
	
	void getUsers() {

		
		Response getResponse = given().when().
		get("https://www.playtolearn.in/CubiCallGameNewAPi/api/GetCMSRoleFunctionList?OrgId=1");
		getResponse.then()
		.statusCode(200)
		
		.body("functionName[5]", equalTo("Configure Game Screen Image"))
		.log().all();
		
		System.out.println("time 1 " +getResponse.getTime());
		System.out.println("time 2 " +getResponse.getTimeIn(TimeUnit.SECONDS));
		System.out.println("time 3 " +getResponse.time());
		System.out.println("time 4 " +getResponse.timeIn(TimeUnit.SECONDS));
		
	}
	@Test(priority =2)
		void createUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("FunctionName", "Sujit");
		map.put("Description", "tester");
		map.put("IdOrganization", "1");
		map.put("IsActive", "A");
		
		
		given()
		.contentType("application/json")
		.body(map)
		
		.when()
		.post("https://www.playtolearn.in/CubicallGameNewApi_test/api/CreateFunction")
		.jsonPath().get("idFunction");
		
	}
	@Test(priority = 3, dependsOnMethods  = {"createUser"})
	void updateUser() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("FunctionName", "su");
		map.put("Description", "test");
		map.put("IdOrganization", "1");
		map.put("IsActive", "A");
		
		
		given()
		.contentType("application/json")
		.body(map)
		
		.when()
		.put("https://www.playtolearn.in/CubicallGameNewApi_test/api/CreateFunction" +idFunction) 
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}

}
