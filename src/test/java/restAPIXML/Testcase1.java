package restAPIXML;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class Testcase1 {
	
	@Test
	public void test1() {
		
		RestAssured.given()
		.baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.statusCode(200);
	
	}
	
	@Test
	public void test2() {
		
		Response response = RestAssured.given()
								.baseUri("https://chercher.tech/sample/api/books.xml")
								.when()
								.get();
		
		String Title = response.then().extract().xmlPath().getString("bookstore.book.title");
		
		System.out.println(Title);
		
	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given()
								.baseUri("https://chercher.tech/sample/api/books.xml")
								.when()
								.get();
		
		NodeChildrenImpl Books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("just single string: "+ Books.toString());
		System.out.println("spcific index : "+ Books.get(0).toString());
	}

}
