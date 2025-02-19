package activities;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
	
	//POST https://petstore.swagger.io/v2/user
	@Test(priority=1)
	public void createUser() throws IOException{
		FileInputStream inputJSON = new FileInputStream("src/test/java/activities/userInfo.json");
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/user")
				.header("Content-Type","application/json")
				.body(inputJSON)
				.when()
				.post();
		inputJSON.close();
		 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("14242"));
		
		
	}
	
	//GET https://petstore.swagger.io/v2/user/{username}
	@Test(priority=2)
	public void getUserName() {
		File outputJSON = new File("src/test/java/activities/userGETOutput.json");
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/user")
				.header("Content-Type","application/json")
				.pathParam("username", "RenukaDevi")
				.when()
				.get("/{username}");
		
		String resBody = response.getBody().asPrettyString();
		
		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		response.then().body("id", equalTo(14242));
		response.then().body("username", equalTo("RenukaDevi"));
		response.then().body("firstName", equalTo("Renuka"));
		response.then().body("lastName", equalTo("Devi"));
		response.then().body("email", equalTo("renukadevi@mail.com"));
		response.then().body("password", equalTo("password6785"));
		response.then().body("phone", equalTo("9812763450"));
				
		
	}
	
	//DELETE https://petstore.swagger.io/v2/user/{username}
	@Test(priority=3)
	public void deleteUserName() throws IOException{
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/user") 
				.header("Content-Type", "application/json")
				.pathParam("username", "RenukaDevi")
				.when().delete("/{username}"); 
	 
			
			response.then().body("code", equalTo(200));
			response.then().body("message", equalTo("RenukaDevi"));
		}
		
	}
