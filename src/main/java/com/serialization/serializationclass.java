package com.serialization;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class serializationclass 
{
	
	

	String response = given()
			.body("\"userEmail\":\"sujalunni009@gmail.com\",\r\n"
					+ "\"userPassword\":\"Testapi@1\"")
			.when().log().all()
			.post("api/ecom/auth/login")
			.then().assertThat()
			.statusCode(200)
			.extract().asString();
}
