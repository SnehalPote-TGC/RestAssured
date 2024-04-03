package dayd;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	//https://reqres.in/api/users?page=2
	@Test
	
	public void testSchema() {
	 given()
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidator.json"));    //tovalidate the schema
	
	}
}
