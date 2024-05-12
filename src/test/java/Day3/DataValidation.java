package Day3;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  

import java.util.HashMap;


public class DataValidation {
	
//	@Test
	void responseBody()
	{
		given()
			.pathParam("path1","users")
			.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/{path1}")
		.then()
		    .body("data[3].last_name",equalTo("Fields"))
		    .log().status()
		    .log().headers()
		    .log().body();
	}
	
//	@Test
	void responseBodyObject()
	{
		Response res=given()
			.pathParam("path1","users")
			.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/{path1}");
		
		Assert.assertEquals(res.getStatusCode(),200);
		System.out.println("Status code is as expected");
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		System.out.println("Content-Type is as expected");
		String lname=res.jsonPath().get("data[3].last_name").toString();
		Assert.assertEquals(lname,"Fields");
		System.out.println("Last name of data[3].last_name is as expected");;
		
	}
	@Test
	void responseBodyObjectValidationWithoutJsonPath()
	{
		Response res=given()
			.pathParam("path1","users")
			.queryParam("page", 2)
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/{path1}");
		
		JSONObject js=new JSONObject(res.asString());
//		JSONArray jsonArray = new JSONArray(res.toString());
		for(int i=0;i<js.getJSONArray("data").length();i++)
		{              
			String lname=js.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(lname);
		}
		boolean status=false;
		
		for(int i=0;i<js.getJSONArray("data").length();i++)
		{
			String lname=js.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			if(lname.equals("Edwards"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}
}
