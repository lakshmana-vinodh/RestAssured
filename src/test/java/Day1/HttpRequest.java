package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  

import java.util.HashMap;

public class HttpRequest {
	
//	@Test
	void getUser()
	{
		given()
		
		.when()
		    .get("https://reqres.in/api/users/2")
		
		.then()
		    .statusCode(200)
		    .log().all();
		
	}
	@Test
	void getAllUsers()
	{
		given()
			.queryParam("", "")
			.pathParam("vin", "")
		.when()
		    .get("https://reqres.in/api/users/{vin}")
		.then()
		     .statusCode(200)
//		     .body("page",equalTo(2))
		     .log().all();
	}
    
//	@Test
	void Login()
	{
		HashMap<String, String> H=new HashMap<String,String>();
		H.put("name","Admin");
		H.put("salary","123");
		H.put("age", "23");
				
		given()
		     .contentType("application/json")
		     .body(H)
		.when()
		     .post("https://dummy.restapiexample.com/create")
		.then()
		     .statusCode(201)
		     .log().all();
		
	}
}
