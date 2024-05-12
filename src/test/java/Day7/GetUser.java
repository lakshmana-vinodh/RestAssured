package Day7;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	void getUser(ITestContext context)
	{
		String token=(String) context.getSuite().getAttribute("Access_token");
		given()
			.header("x-auth-token",token)
		.when()
			.get("https://practice.expandtesting.com/notes/api/users/profile")
		.then()
			.statusCode(200)
			.log().body();
	    }


}
