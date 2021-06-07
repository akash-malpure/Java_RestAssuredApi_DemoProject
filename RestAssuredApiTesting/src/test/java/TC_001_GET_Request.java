import org.testng.Assert;
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
		System.out.println("Response Body is: "+response.getBody().asString());
		
//      Status code verification
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
//      Status line verification	
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: " +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
}
