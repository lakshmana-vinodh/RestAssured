package Day2;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.Serializable;
import java.util.Map;  



public class PathAndQueryParams {
	
	@Test
	void GetUsersUsingPathAndQueryParams()
	{
		given()
		    .pathParam("path1", "v2")
		    .pathParam("path2", "users")
		    .queryParam("id",6180492)
		
	    .when()
	        .get("https://gorest.co.in/public/{path1}/{path2}")
	    
	    .then()
	        .log().all()
            .log().headers()
	        .statusCode(200)
	        .contentType("application/json");
//	        .body("name",equalTo("Adinath Jain"));
	}
//    @Test
	void GetCookies()
	{
		Response Res=given()
		    
	    .when()
	        .get("https://www.google.com/search?gs_ssp=eJzj4tTP1TcwrsrKM1FgNGB0YPBiT89PSUxJqQQATIQGhw&q=godaddy&rlz=1C1YQLS_enIN1043IN1043&oq=Goda&gs_lcrp=EgZjaHJvbWUqEwgBEC4YgwEYxwEYsQMY0QMYgAQyBggAEEUYOTITCAEQLhiDARjHARixAxjRAxiABDINCAIQABiDARixAxiABDINCAMQABiDARixAxiABDINCAQQABiDARixAxiABDINCAUQABiDARixAxiABDINCAYQLhiDARixAxiABDIGCAcQBRhA0gEIMzE1OGowajSoAgCwAgA&sourceid=chrome&ie=UTF-8");
        
		ResponseBody r= Res.body();
		String cook1=Res.getCookie("1P_JAR");
		System.out.println("Hi  "+cook1);
		
		Map<String,String> allCookies=Res.getCookies();
		for(String i:allCookies.keySet())
		{
			System.out.println(Res.getCookie(i));
		}
	    
	}

	  @Test
		void GetHeaders()
		{
//			Response Res=given()
//			    
//		    .when()
//		        .get("https://www.google.com/search?gs_ssp=eJzj4tTP1TcwrsrKM1FgNGB0YPBiT89PSUxJqQQATIQGhw&q=godaddy&rlz=1C1YQLS_enIN1043IN1043&oq=Goda&gs_lcrp=EgZjaHJvbWUqEwgBEC4YgwEYxwEYsQMY0QMYgAQyBggAEEUYOTITCAEQLhiDARjHARixAxjRAxiABDINCAIQABiDARixAxiABDINCAMQABiDARixAxiABDINCAQQABiDARixAxiABDINCAUQABiDARixAxiABDINCAYQLhiDARixAxiABDIGCAcQBRhA0gEIMzE1OGowajSoAgCwAgA&sourceid=chrome&ie=UTF-8");
//	        
//			ResponseBody r= Res.body();
//			String cook1=Res.getCookie("1P_JAR");
//			System.out.println("Hi  "+cook1);
//			
//			Headers allHeaders=Res.getHeaders();
//			
//			for(Header i:allHeaders)
//			{
//				System.out.println(i.getName()+"    "+i.getValue());
//			}
		  
		  
		  given()
		  
		  .when()
		       .get("https://www.google.com/search?gs_ssp=eJzj4tTP1TcwrsrKM1FgNGB0YPBiT89PSUxJqQQATIQGhw&q=godaddy&rlz=1C1YQLS_enIN1043IN1043&oq=Goda&gs_lcrp=EgZjaHJvbWUqEwgBEC4YgwEYxwEYsQMY0QMYgAQyBggAEEUYOTITCAEQLhiDARjHARixAxjRAxiABDINCAIQABiDARixAxiABDINCAMQABiDARixAxiABDINCAQQABiDARixAxiABDINCAUQABiDARixAxiABDINCAYQLhiDARixAxiABDIGCAcQBRhA0gEIMzE1OGowajSoAgCwAgA&sourceid=chrome&ie=UTF-8")
	      .then()
	      		.log().headers();
//		        .log().body();
		    
		}

}
