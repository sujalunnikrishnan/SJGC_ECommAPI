package com.EComApp;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;

import com.pojo.AddnewProduct_Request;
import com.pojo.AddnewProduct_Response;
import com.pojo.EComLogin_Request;
import com.pojo.EComLogin_Response;

import io.restassured.specification.RequestSpecification;

public class EcomE2E {

	public static void main(String[] args) 
	{
		// created a Spec Builder for 'Request' and setting URL and Content type
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		
		
		//Step 1 - create spec builder 
		RequestSpecification reqspec = 
		new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON).build(); // Spec builder is builded
		
		//+++++ LOGIN to ECOMM +++++ ///
		
		// Login - capture token and userid details
		EComLogin_Request loginRequest = new EComLogin_Request();
		loginRequest.setUserEmail("sujalunni009@gmail.com"); //set the email and password
		loginRequest.setUserPassword("Testapi@1");
		
		//Sending login JSON as RequestSpec
		RequestSpecification reqlogin = 
		given().log().all()
		.spec(reqspec)
		.body(loginRequest);
		
		
		//Extracted response after successful login
		EComLogin_Response loginResponse = 
				reqlogin.when()
				.post("/api/ecom/auth/login")
				.then()
				.extract().response()
				.as(EComLogin_Response.class);
		
		System.out.println("---------------Token and User ID details---------------------------");
		
		//System.out.println(loginRequest.getUserEmail());
		//System.out.println(loginRequest.getUserPassword());
		//String token = loginResponse.getToken();
		//System.out.println("Token is "+loginResponse.getToken());
		System.out.println("user ID is "+loginResponse.getUserId());
		System.out.println("------------------Product Created successfully --------------------------");
		
	// ++++ Add new Product +++++ //
		
		//Step 1 - create spec builder 
	RequestSpecification addnewProduct = 
			new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com")
			.addHeader("Authorization", token)
			.build();
	
	//Created objects of both pojo classes
	//AddnewProduct_Request addProductRequest = new AddnewProduct_Request();
	//AddnewProduct_Response addProductResponse = new AddnewProduct_Response();
	
	
	//Sending Param body and multimedia file
	RequestSpecification requestAddProduct	= 
		given()
		.spec(addnewProduct)
		.header("token", loginResponse.getToken())
		.param("productName","xoSatinShirtxo")
		.param("productAddedBy",loginResponse.getUserId())
		.param("productCategory", "fashion")
		.param("productSubCategory", "shirts")
		.param("productPrice", "1500")
		.param("productDescription", "ZaraOriginals")
		.param("productFor", "women")
		.multiPart("productImage", 
				new File("D:\\Sujal\\Course details\\"
						+ "API automation\\Demo_Ecom website\\"
						+ "shirt image8.jpg"));
		
	
	//Get the response after addin new product into pojo class
	String responseAddProduct =
		requestAddProduct
		.when()
		.post("api/ecom/product/add-product")
		.then().extract()
		.asString();
	
	JsonPath js = new JsonPath(responseAddProduct);
	String productId = js.get("productId");
	
//String productId = responseAddProduct.getProductId();
	System.out.println("Product ID : " +productId);
	System.out.println("--------------------------------------------");
	
	
	
	
	// ++ Get the details of added product +++//
	
	
		
		
	}

}
