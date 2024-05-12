package Day5;

import org.testng.annotations.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  



import java.util.HashMap;

public class XmlSchemaValidation {

	@Test
	void xmlValidator()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XmlSchema.xsd"));
		
	}
}
