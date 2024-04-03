package dayd;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {
	@Test
	
	void loggingDemo1() {
		given()
		.when().get("https://www.google.com/")
		
		.then()
		.log().body();   /// this will print body
		//.log().cookies()   // this will print only cookies
		//.log().headers();    // this will print only headers.
		// 
	}

}
