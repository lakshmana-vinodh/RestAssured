package Day6;

import org.testng.annotations.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  



import java.util.HashMap;

public class Authentications {
	
	@Test(priority=1)
	void BasicAuth()
	{
		given()
			.auth().basic("Admin", "admin123")
		.when()
			.post("\r\n"
					+ "https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate")
		.then()
			.log().all()
			.statusCode(302);
	}

	@Test(priority=2)
	void NavigateToMyinfo()
	{
		given()
			
		.when()
			.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7")
		.then()
			.log().all()
			.statusCode(200);
	}

	@Test
	void Login()
	{
//		String B_Token="2939a9254af746ff9f49404b9b5237c7c19f9894cc074f88942af4338707a060";
		given()
			.header("x-auth-token","2939a9254af746ff9f49404b9b5237c7c19f9894cc074f88942af4338707a060")
		.when()
			.get("https://practice.expandtesting.com/notes/api/users/login")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	
	@Test
	void Oauth()
	{
//		String B_Token="2939a9254af746ff9f49404b9b5237c7c19f9894cc074f88942af4338707a060";
		given()
			.auth().oauth2("2939a9254af746ff9f49404b9b5237c7c19f9894cc074f88942af4338707a060")
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/login")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	void Login1()
	{

		HashMap<String,Object> Hm=new HashMap<>();
		Hm.put("email" , "lakshmana.vinodh@gmail.com");
		Hm.put("password", "Vinodh@3");
		
		given()
			.contentType(ContentType.JSON)
			.body(Hm)
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/login")
		.then()
			.log().all()
			.statusCode(200)
		    .log().body();
		    }
	
	@Test
	void returnToken()
	{

		HashMap<String,Object> Hm=new HashMap<>();
		Hm.put("email" , "lakshmana.vinodh@gmail.com");
		Hm.put("password", "Vinodh@3");
		
		String s=given()
			.contentType(ContentType.JSON)
			.body(Hm)
		.when()
			.post("https://practice.expandtesting.com/notes/api/users/login")
			.jsonPath().getString("data.token");
		System.out.println(s);
		
		    }
	
	
	
	@Test
	void getUser()
	{
		given()
			.header("x-auth-token","5fcbadcb09764a28b808c8922f220870846c01a2411e4a0c99741453bda109b0")
		.when()
			.get("https://practice.expandtesting.com/notes/api/users/profile")
		.then()
			.statusCode(200)
			.log().body();
	    }

	}
