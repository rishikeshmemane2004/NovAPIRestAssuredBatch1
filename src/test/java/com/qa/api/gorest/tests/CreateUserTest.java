package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;
import com.qa.api.gorest.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

@Epic("Create gorest  user api feature implementation")
@Feature("Create user api feature")
public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "90d7c227d056a668554d486727c22eb34ac99997b70607e35cd8b863740b3adc";
	
	@Description("Create a user api test... Verify create user from post call")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void createUserAPIPOSTTest()
	{
		Random random = new Random();
		int rndVal = random.nextInt(100000);
		String name = "Aditya"+rndVal;
		String email = name + "@gmail.com";
		String gender = "male";
		String status = "active";
		
		User user = new User(name, email, gender, status);
		
		Map<String, String> autTokenMap = new HashMap<String, String>();
		autTokenMap.put("Authorization", "Bearer " + token);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, autTokenMap, null, null, true, user);
		
//		System.out.println("status Code ===> "+ response.getStatusCode());
		
		TestUtil.verifyStatusCode(response, 200, true);
		
		System.out.println("Response priting ===> " + response.prettyPrint());
		String fieldValue = TestUtil.getFieldValue(response, "data.name");
		TestUtil.verifyFieldValue(response, fieldValue, name, true);
		
	}

	@Description("Create multiple users api test... Verify create users from post call")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider="getUserData")
	public void createMultipleUsersAPIPOSTTest(String name, String email, String gender, 
											   String status)
	{		
		User user = new User(name,email,gender,status);
		
		Map<String, String> autTokenMap = new HashMap<String, String>();
		autTokenMap.put("Authorization", "Bearer " + token);
		Response response = RestClient.doPost("JSON", baseURI, basePath, autTokenMap, null,null, true, user);
		
		System.out.println("status Code      ===> "+ response.getStatusCode());
		System.out.println("Response priting ===> " + response.prettyPrint());
		
		TestUtil.verifyStatusCode(response, 200, true);
		
	}

	@DataProvider
	public Object[][] getUserData()
	{
		String filePath = System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\api\\gorest\\testdata\\goRestTestData.xlsx";

//		Object[][] userData =  ExcelUtil.getTestData("userdata", filePath);
//		return userData;  
// 		OR below will also work
		return ExcelUtil.getTestData("userdata", filePath);
	}
}
