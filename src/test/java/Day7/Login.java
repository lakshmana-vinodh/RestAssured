package Day7;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Login {
	
	@Test
	void LoginUser(ITestContext context)
	{

		JSONObject jo=new JSONObject();
		jo.put("email" , "lakshmana.vinodh@gmail.com");
		jo.put("password", "VinodhKum@3");
		
		Response res=given()
			.contentType(ContentType.JSON)
			.body(jo.toString())
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/login");
		
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.contentType(), "application/json; charset=utf-8");
		
		JsonPath jp = res.jsonPath();
		
		String tok = (String)jp.get("data.token");
		
		context.getSuite().setAttribute("Access_token",tok);
		
		System.out.println(res.body().asString());
		    }

}
