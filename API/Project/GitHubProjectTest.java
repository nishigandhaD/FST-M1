package Project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {

	// SSH key to test with
	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAINRuOQJicsplD6i1JR5Gh2T3TYfYd45Gf9EFoc03R3xq";
	// Temp variable to share id
	int keyId;
	// Declare the request and response specs
	String token = System.getenv("GITHUB_TOKEN");
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
		// Initialize the request Specification
		requestSpec = new RequestSpecBuilder().setBaseUri("https://api.github.com")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token " + token)
				.addHeader("X-GitHub-Api-Version", "2022-11-28"). // this is custom header
				build();

		// Initialize the response Specification
		responseSpec = new ResponseSpecBuilder().expectBody("title", Matchers.equalTo("TestKeys"))
				.expectBody("key", Matchers.equalTo(sshkey)).expectResponseTime(Matchers.lessThanOrEqualTo(3000L))
				.build();

	}

	@Test(priority = 1)
	public void postRequest() {
		// Create Request Body
		HashMap<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("title", "TestKeys");
		reqBody.put("key", sshkey);
		// send request , save response
		Response response = RestAssured.given().spec(requestSpec).body(reqBody).log().all().when().post("/user/keys");
		// Extract the Id from Response
		response.then().log().all();

		keyId = response.then().extract().path("id");
		// Assertions
		response.then().statusCode(201).spec(responseSpec).log().all();

	}

	@Test(priority = 2)
	public void getRequestTest() {
		// Send request, save response
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).when().get("/user/keys/{keyId}").then().statusCode(200)
				.spec(responseSpec);
	}

	@Test(priority = 3)
	public void getDeleteTest() {
		// Send request, save response
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).when().delete("/user/keys/{keyId}").then().statusCode(204)
				.time(Matchers.lessThanOrEqualTo(3000L));
	}

}