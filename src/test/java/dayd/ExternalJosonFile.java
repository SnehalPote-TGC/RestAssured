package dayd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class ExternalJosonFile {
	
	@Test
	void externalFile() throws FileNotFoundException {
		
	
	
	File f = new File(".\\target\\body.json");
	
	FileReader fr = new FileReader(f);
	
	JSONTokener jt = new JSONTokener(fr);
	
	JSONObject data = new JSONObject(jt);
	
	given().contentType("application/json")
	.body(data.toString())
	.when().post("https://reqres.in/api/users").
	
	then().
	statusCode(201).
	log().all()
   	.body("name", equalTo("morpheus"));
	//.body("Job", equalTo("leader"));
	
	}
}
