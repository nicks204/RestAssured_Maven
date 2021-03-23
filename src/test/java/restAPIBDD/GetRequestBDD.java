package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequestBDD {
	
	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.queryParam("id", "1")
					.when()
					.get()
					.then()
					.statusCode(200)
					.body("[0].name", Matchers.equalTo("pankaj"))
					.body("[0].salary", Matchers.equalTo("10000"))
					.body("[0].id", Matchers.equalTo(1))
					.log()
					.all();
					
		
	}

}
