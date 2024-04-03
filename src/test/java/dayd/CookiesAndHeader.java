package dayd;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CookiesAndHeader {
	@Test

	void testCookiesAndHeader() {
		given()
		
		
		
		.when().get("https://www.google.com/")
		
		
		.then()
		.cookie("AEC" , "abch") // value changes every time so test faile
		.log().all();
	}
	@Test
	void getcookies() {
		
		Response res = given()
				
				.when().get("https://www.google.com/");
		
		String cookie_value = res.getCookie("AEC");
		System.out.println("cooie Value " +cookie_value);
		
		res.getCookies();
	}
	@Test
	void getHeader() {
		Response res = given().
				when().get("https://www.google.com/");
		
		Headers meHeader = res.getHeaders();
		for(Header hd : meHeader)
		{
			System.out.println(hd.getName()+ "   " +hd.getValue());
		}
		///instead of this log()all() will also return the all the responce
	}
}
