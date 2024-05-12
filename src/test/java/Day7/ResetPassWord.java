package Day7;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class ResetPassWord {
	


	@Test
	void testResetPassword()
	{
		String newpw= "{\"token\":\"ef8f85111f6540259047825f774e1b83087576d0ed394b789e49b85fe26411fa\",\"newPassword\":\"Vinodh@3\"}";
		
		given()
			.contentType("application/json")
			.body(newpw)
			
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/reset-password")
			
		.then()
			.statusCode(200)
			.contentType("application/json; charset=utf-8")
			.log().body();
	}
}
