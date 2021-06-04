import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request {

	@Test
	public void getWeatherDetails() {
		
//      Step 1: Specifying the base URL
		RestAssured.baseURI="http://api.openweathermap.org/data/2.5/weather";
		
//      Creating request object to send request to an API
		RequestSpecification httprequest = RestAssured.given();
		
// 		Creating response object to store response data	
		Response response = httprequest.request(Method.GET,"?q=pune&appid=71d8b45560191d907ba6ce75041ad9f4");
		
// 	 	Print response on console
		System.out.println("Response Body asString(): "+response.getBody().asString());
	}
	
}
