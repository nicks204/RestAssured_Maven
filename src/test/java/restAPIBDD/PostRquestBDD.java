package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRquestBDD {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000/employees")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"Moksha\",\r\n"
				+ "    \"salary\": \"10000\"\r\n"
				+ "}")
		.when()
		.post("/create")
		.then()
		.statusCode(201)
		.body("name",Matchers.equalTo("Moksha"))
		.body("salary",Matchers.equalTo("10000"))
		.log()
		.all();
	
	}

}
