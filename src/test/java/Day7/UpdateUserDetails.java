package Day7;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateUserDetails {
	
	@Test
	void updateDetails(ITestContext context)
	{
		JSONObject jo=new JSONObject();
		jo.put("name" , "Vinodh");
		jo.put("phone", "9701170920");
		jo.put("company", "naval Services");
		
		String token=(String)context.getSuite().getAttribute("Access_token");

		given()
			.header("x-auth-token",token)
			.contentType(ContentType.JSON)
			.body(jo.toString())
		
		.when()
		    .patch("https://practice.expandtesting.com/notes/api/users/profile")
		.then()
			.statusCode(200)
			.log().body();
	}
}
