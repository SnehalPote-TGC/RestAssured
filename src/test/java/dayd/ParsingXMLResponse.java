package dayd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class ParsingXMLResponse {
	@Test
	public void xmlParsing() {
		given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	}
	@Test
		public void xmlParsing1() {
		Response res=given().
				
				
				when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
				
				Assert.assertEquals(res.getStatusCode(), 200);
				Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
				String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
				Assert.assertEquals(pageNo, "1");
				
				String travelName = res.xmlPath().getString("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
				Assert.assertEquals(travelName, "Developer");
				
				//some additional operation we can do when we store response in XML res.
				XmlPath xm = new XmlPath(res.asString());
				List<String> travellers = xm.getList("TravelerinformationResponse.travelers.Travelerinformation");
		        Assert.assertEquals(travellers.size(), 10);  //checking size 
		        
		        //verify traveller name is present in response
				List<String> travellers1 = xm.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
				boolean status = false;
				for (String travelName1 : travellers1) 
				{
					System.out.println(travelName1);
					if(travelName1.equals("Ashor")) {
						status = true;
						break;
					}
				}
 
		        
	}

}
