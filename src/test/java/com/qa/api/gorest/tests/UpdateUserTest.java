package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.response.Response;

public class UpdateUserTest {
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "90d7c227d056a668554d486727c22eb34ac99997b70607e35cd8b863740b3adc";
	
	
	@Test
	public void updateUserAPIPOSTTest()
	{
// ADd new user first 
		int rndVal = TestUtil.generateRandomValue();
		
		User user = new User("Aditya"+rndVal,"Aditya"+rndVal+"@gmail.com","male","active");
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + token);
		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, null, true, user);
		
		System.out.println("status Code ===> "+ response.getStatusCode());
		System.out.println("Response priting ===> " + response.prettyPrint());

		int id = response.jsonPath().getInt("data.id");
		System.out.println("id =======> " + id);

		
		// Update userid created in above POST API
		
		String baseURI = "https://gorest.co.in";
		String basePath = "/public-api/users/{id}";
		
		// update user data
		updateUserData(user);
		
		// add path parameter
		Map<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("id", String.valueOf(id));

		Response resp = RestClient.doPut("JSON", baseURI, basePath, authTokenMap, null, pathParams, true, user);
		
		System.out.println("status Code ===> "+ resp.getStatusCode());
		System.out.println("Response priting ===> " + resp.prettyPrint());
	}
	
	public void updateUserData(User user)
	{
		String name = user.getName();
		int rndVal = TestUtil.generateRandomValue();
		user.setName(name+rndVal);

		String gender = user.getGender();
		if (gender.equals("male"))
			user.setGender("female");
		else
			user.setGender("male");
				
		String status= user.getStatus();
		if (status.equals("active"))
			user.setStatus("inactive");
		else
			user.setStatus("active");
	}
}
