//package Day7;
//
//import static io.restassured.RestAssured.given;
//
//import java.util.HashMap;
//
//import org.json.JSONObject;
//import org.testng.annotations.Test;
//import org.testng.ITestContext;
//
//
//public class ChangePassword {
//	
//	@Test
//	void testChangePassword(ITestContext context)
//	{
//		
//		JSONObject josn=new JSONObject();
//		josn.put("currentPassword", "Vinodh@3");
//		josn.put("newPassword", "VinodhKum@3");
//	
//		String token=(String) context.getSuite().getAttribute("Access_token");
//		
//		given()
//			.contentType("application/json")
//			.body(josn.toString())
//			.header("x-auth-token",token)
////			.header("x-auth-token","5fcbadcb09764a28b808c8922f220870846c01a2411e4a0c99741453bda109b0")
//		.when()
//			.post("https://practice.expandtesting.com/notes/api/users/change-password")
//		.then()
//			.statusCode(200)
//			.log().body();
//	}
//
//}
