package activities;

import java.util.HashMap;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
	@Test(priority = 1)
	public void CreateNewPet() {
		
		  Map<String, Object> reqBody = new HashMap<>();
		  reqBody.put("id", 91822);
		  reqBody.put("name", "goldie"); 
		  reqBody.put("status", "alive");
		 
		
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.body(reqBody) // Add request body
			.when().post(); // Send POST request

		// Assertion
		response.then().body("id", equalTo(91822));
		response.then().body("name", equalTo("goldie"));
		response.then().body("status", equalTo("alive"));
	}
	
	@Test(priority=2)
	public void getPetInfo() {
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
				.header("Content-Type", "application/json")
				.when().pathParam("petId",91822)
				.get("/{petId}");
		response.then().body("id", equalTo(91822));
		response.then().body("name", equalTo("goldie"));
		response.then().body("status", equalTo("alive"));
				
				
	}
	@Test(priority =3)
	public void deleteThePet() {
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.header("Content-Type","application/json")
				.when().pathParam("petId",91822)
				.delete("/{petId}");
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("91822"));
		
	}


}
