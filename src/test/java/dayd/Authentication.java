package dayd;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Authentication {
	@Test
	void testBasicAuthentication() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	void testDigestAuthentication() {
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	void testPreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman", "password")  // combination of preemptive and basic
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test
	
	void testBearerToken(){
		
		String bearerToken = "token from any site like github or any";
		given()
		.headers("Authorization" , "Bearer" +bearerToken)  // headers are also two types request header and response header
		
		.when()
		.get("https://api.github.com/user/repos")
		
		 .then()
		.statusCode(200)
		.log().all();
		}
	
	void testOAuth1Authentication() {
		
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret" )
		// if we are using auth1.0 authentication then we need this info consumerKey", "consumerSecret", "accessToken", "tokenSecret
		.when()
		.get("URL")
		
		.then()
		.statusCode(200);
		
	}
	
	void testOAuth2Authentication() {
		given()
		.auth().oauth2("token" )
		// if we are using auth2.0 only parameter and that is token
		.when()
		.get("URL")
		
		.then()
		.statusCode(200);
	}
	
	void testApiKeyAuthentication() {
		given()
		.queryParam("appid", "key will be here")
		.when()
		.get("URL")
		.then()
		.statusCode(200)
		.log().all();
	}
}
