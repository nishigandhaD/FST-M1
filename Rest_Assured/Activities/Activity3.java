package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	RequestSpecification reqspec;
	ResponseSpecification resspec;
	
	@BeforeClass
	public void setUp() {
		reqspec = new RequestSpecBuilder()
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.addHeader("Content-Type", "application/json")
				.build();
		resspec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType("application/json")
				.expectBody("status",equalTo("alive"))
				.build();
		
		
	}
	
	@DataProvider(name= "petInfo")
	public Object[][] petInfoProvider(){
		Object[][] testData = new Object[][] { 
		    { 61876, "Husky", "alive" }, 
		    { 14242, "puppy", "alive" } 
		};
		return testData;
		
	}
	
	@Test(priority=1, dataProvider="petInfo")
	public void postRequest(int petId,String petName,String petStatus) {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", petId);
		reqBody.put("name", petName);
		reqBody.put("status", petStatus);
		
		given()
			.spec(reqspec)
			.body(reqBody)
			.when()
			.post()
			.then().spec(resspec)
			.body("name", equalTo(petName));
		
	}
	
	@Test(priority=2, dataProvider = "petInfo" )
	public void getRequest(int petId, String petName, String petStatus) {
		given().spec(reqspec) 
		.pathParam("petId", petId) 
		.log().all()
	.when()
		.get("/{petId}")
	.then().spec(resspec) 
	    .body("name", equalTo(petName))
	    .log().all();
		
	}
	
	@Test(priority=3,dataProvider = "petInfo")
	public void deleteRequest(int petId, String petName, String petStatus) {
		given().spec(reqspec)
		.pathParam("petId", petId) 
	.when()
		.delete("/{petId}") 
	.then()
		.body("code", equalTo(200))
		.body("message", equalTo(""+petId));
}

}
