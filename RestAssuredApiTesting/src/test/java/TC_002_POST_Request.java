import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_Request {
	
	
	@Test
	public void postCommentAPI() {
		
		
//      Step 1: Specifying the base URL
		RestAssured.baseURI="http://localhost:3000";
		
//      Step 2: Create the request object
		RequestSpecification httpRequest = RestAssured.given();

//      Step 3: Creating the request payload 
		JSONObject params = new JSONObject();
		params.put("id",3);
		params.put("body","Creating second comment via Java");
		params.put("postId",3);
	
//      Step 4: Specifying the content Type of the request 
		httpRequest.header("Content-Type","application/json");
		
//      Step 5: Converting the parameters to JSON format		
		httpRequest.body(params.toJSONString());
		
//      Step 6: Creating response object  		
		Response resp = httpRequest.request(Method.POST, "/comments");
		
//      Step 7: Verification of status code
		int statusCode = resp.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
//      Step 8: Verification of success code
		System.out.println(resp.jsonPath().get("SuccessCode")); //This statement will return null with the json db since no success code is returned on success of post request. 
	}

}
