package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Epic("get user gorest api feature implementation")
@Feature("Get user api feature")
public class GetUserTest {

	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "90d7c227d056a668554d486727c22eb34ac99997b70607e35cd8b863740b3adc";
	
	@Description("Get all user lists api test... Verify all user list frmo get call")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=1)
	public void  getAllUserListAPITest()
	{
		Map<String, String> authTokenmap = new HashMap<String, String>(); 
		authTokenmap.put("Authorization", "Bearer "+token);
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenmap, null,null, true);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		int id = response.jsonPath().get("data[0].id");
		System.out.println("id =========> " + id);
		int id1 = response.jsonPath().getInt("data[0].id");
		System.out.println("id1 =========> " + id1);
		
		/* can make use of JsonPath of rest assured, need to convert response to string and then operate */
		JsonPath js = new JsonPath(response.asString());
		int id2 = (int) js.get("data[0].id");
		System.out.println("id2 =========> " + id2);
			
		
		System.out.println("-------------- end of the test case --------------");
	}
	
	@Description("Get all user lists with query parameters api test... Verify all user list frmo get call")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void  getUserWithQueryParamsAPITest()
	{
		
		Map<String, String> authTokenmap = new HashMap<String, String>(); 
		authTokenmap.put("Authorization", "Bearer "+token);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "Vidhur Tandon");
		params.put("gender", "female");
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenmap, params, null, true);
		System.out.println(response.getStatusCode());
	   	System.out.println(response.prettyPrint());
		System.out.println("\n-------------- end of the test case --------------\n");
	   	
	}
}
