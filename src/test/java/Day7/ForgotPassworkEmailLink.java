package Day7;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ForgotPassworkEmailLink {

	@Test
	void EmailLink(ITestContext context)
	{
		HashMap<String,Object> hm=new HashMap<>();
		hm.put("email","lakshmana.vinodh@gmail.com");
		
		String token=(String)context.getSuite().getAttribute("Access_token");
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/forgot-password")
		.then()
			.statusCode(200)
			.log().body();
	}
}
