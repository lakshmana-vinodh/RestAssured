package Day5;

import org.testng.annotations.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  



import java.util.HashMap;

public class JsonSchemaValidation {

	@Test
	void JsonSchemaValidator()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.assertThat().body(io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
		
	}
}
