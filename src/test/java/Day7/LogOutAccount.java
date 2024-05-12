package Day7;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class LogOutAccount {
	
	 @Test
	void testLogOut(ITestContext context)
	{
		 
		String token=(String) context.getSuite().getAttribute("Access_token");
		given()
			.contentType("application/json")
			.header("x-auth-token",token)
//			.header("x-auth-token","5fcbadcb09764a28b808c8922f220870846c01a2411e4a0c99741453bda109b0")
		
		.when()
			.delete("https://practice.expandtesting.com/notes/api/users/logout")
		.then()
			.statusCode(200)
			.log().body();
		
	}

}
