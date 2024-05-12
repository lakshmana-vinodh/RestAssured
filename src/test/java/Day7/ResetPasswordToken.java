package Day7;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ResetPasswordToken {
	
	@Test
	void testResetPasswordToken()
	{
		HashMap<String,String> h=new HashMap<>();
		h.put("token", "5b05fb4b5c534091b5b315c981f10da5a78dd72dfead4630a3192bfa490a6e8c");
		
		given()
			.contentType("application/json")
			.body(h)
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/verify-reset-password-token")
		
		.then()
			.statusCode(200)
			.log().body();
	}

}
