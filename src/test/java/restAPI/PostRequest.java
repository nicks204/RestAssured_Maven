package restAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body("{\r\n"
											+ "    \"name\": \"Jai\",\r\n"
											+ "    \"salary\": \"10000\"\r\n"
											+ "}")
									.post("/create");
		
		String responsebody = response.getBody().asString();
		
		System.out.println(responsebody);
		
	}

}
