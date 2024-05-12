package Day4;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;  

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;


public class XmlValidation {
	
	@Test
	void Xmldata()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		
		.then()
			.log().all()
			.statusCode(200)
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].id",equalTo("11133"));
		
		
	}
        
	@Test
	void Xmlobject()
	{   
		Response Res=
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler");
		
		
		String id1=Res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].id").toString();
		Assert.assertEquals(id1,"11133");
		
		String pageno=Res.xmlPath().getString("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno, "1");
		
//		System.out.println("3333333"+Res.asString());
		 List<String> Names=Res.xmlPath().getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		 
		 System.out.println(Names.size());
		 
		 Boolean k=false;
		 
		 for(String i :Names)
		 {
			 if(i.equals("Developer"))
			 {
				 k=true;
				 break;
			 }
		 } 
		 Assert.assertEquals(k.booleanValue(),true);
		 
		 
//		 ------------Using XmlObject------------------
		 
		 XmlPath Xobj=new XmlPath(Res.asString());
		 
 List<String> Names1=Xobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		 
		 System.out.println(Names1.size());
		 
		 Boolean k1=false;
		 
		 for(String i :Names)
		 {
			 if(i.equals("Developer"))
			 {
				 k1=true;
				 break;
			 }
		 } 
		 Assert.assertEquals(k1.booleanValue(),true);
		 
	}
}
