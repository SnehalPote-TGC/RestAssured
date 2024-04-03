package dayd;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponse {
	@Test
	
	void testJsonResponce() {
		Response res = given()
		//.contentType("ContentType.JSON")
		.when()
		.get("https://www.playtolearn.in/CubiCallGameNewAPi/api/GetCMSRoleFunctionList?OrgId=1");
		Assert.assertEquals(res.getStatusCode(), 200);
		String str = res.getBody().asString();
		//System.out.println(str);
		JSONObject jo = new JSONObject(res.asString());
		//for(int i = 0; i<jo.getJSONArray(str))
		
	}

}
