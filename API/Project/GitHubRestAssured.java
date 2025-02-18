package liveProject;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubRestAssured {
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	String SSHKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIK2WBRiytgQ75tsomB/Em5nxWXwvVOamF/4UNpOW4b5P";
	int id;
	
	@BeforeClass
	public void setUp() {
		reqspec = new RequestSpecBuilder()
				.setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization" , "token ghferiidenw.... ")
				.build();
		resspec = new ResponseSpecBuilder()
				.expectResponseTime(lessThan(4000L))
				.expectBody("key", equalTo(SSHKey))
	            .expectBody("title", equalTo("TestAPIKey"))
				.build();
				
				
	}
	
	@Test(priority=1)
	public void postReq() {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key",SSHKey );
		Response response= given()
				.spec(reqspec)
				.body(reqBody)
				.when()
				.post();
		
		id=response.then().extract().path("id");
		response.then().statusCode(201).spec(resspec);
		Reporter.log("POST request successful. Key ID: " + id, true);
		}
	
	@Test(priority=2)
	public void getReq() {
		Response response = given()
				.spec(reqspec)
				.pathParam("keyId",id)
				.when()
				.get("/{keyId}");
		Reporter.log("GET request successful. Retrieved Key ID: " + id, true);
		response.then().statusCode(200).spec(resspec);
				
		
	}
	
	@Test(priority=3)
	public void deleteReq() {
		Response response = given()
				.spec(reqspec)
				.pathParam("keyId", id)
				.when()
				.delete("/{keyId}");
				response.then().statusCode(204).time(lessThan(3000L));
		
		Reporter.log("DELETE request successful. Deleted Key ID: " + id, true);
		
		
		
	}

}

