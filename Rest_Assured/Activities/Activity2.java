package Activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity2 {
	
	@Test (priority = 1)
	public void addNewUserFromFile() throws IOException {
		
		FileInputStream inputJSON = new FileInputStream("src/test/java/Activities/userInfo.json");
		Response response = RestAssured.given().
								baseUri("https://petstore.swagger.io/v2/user").
								header("Content-Type", "application/json").
								body(inputJSON).
							when().post();
		inputJSON.close();
		
		response.then().body("code", Matchers.equalTo(200));
		response.then().body("message", Matchers.equalTo("9901"));
		
	}
	
	@Test (priority = 2)
	public void getUserInfo() {
		File outputJSON = new File("src/test/java/Activities/userGETResponse.json");
		Response response = RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/user").
				header("Content-Type", "application/json").
				pathParam("username", "justinc").
			when().get("/{username}");
		
		String resp = response.getBody().asPrettyString();
		
		try {
			outputJSON.createNewFile();
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resp);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}
		
		response.then().body("id", Matchers.equalTo(9901));
		response.then().body("username", Matchers.equalTo("justinc"));
		response.then().body("firstName", Matchers.equalTo("Justin"));
		response.then().body("lastName", Matchers.equalTo("Case"));
		response.then().body("email", Matchers.equalTo("justincase@mail.com"));
		response.then().body("password", Matchers.equalTo("password123"));
		response.then().body("phone", Matchers.equalTo("9812763450"));
		
	}
	
	@Test (dependsOnMethods = { "getUserInfo" })
	public void deleteUser() throws IOException {
		Response response = RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/user").
				header("Content-Type", "application/json").
				pathParam("username", "justinc").
			when().delete("/{username}");
		
		response.then().body("code", Matchers.equalTo(200));
		response.then().body("message", Matchers.equalTo("justinc"));
	}
	

}