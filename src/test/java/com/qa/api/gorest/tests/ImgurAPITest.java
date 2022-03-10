package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.Token;

import io.restassured.response.Response;

public class ImgurAPITest {

	Map<Object, Object> tokenMap;
	String accessToken;
	String accountUserName;
	
	@BeforeMethod
	public void setUp()
	{
		tokenMap = Token.getAccessToken();
		accessToken = tokenMap.get("access_token").toString();
		accountUserName  = tokenMap.get("account_username").toString();
	}
	
	@Test
	public void getAccountBlockStatusTest()
	{
		Map<String, String> authToken = Token.getAuthToken();
		
		Response response = RestClient
				.doGet(null, "https://api.imgur.com", "/account/v1/"+accountUserName+"/block", authToken, null, null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}

	@Test
	public void getAccountImagesTest()
	{
		Map<String, String> authToken = Token.getAuthToken();
		Response response = RestClient
				.doGet(null, "https://api.imgur.com", "/3/account/me/images", authToken, null,null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
	
	@Test
	public void getAccountSettingsTest()
	{
		Map<String, String> authToken = Token.getAuthToken();
		Response response = RestClient
				.doGet(null, "https://api.imgur.com", "/3/account/me/settings", authToken, null,null, true);
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
	}
		
	@Test
	public void uploadImagePostAPITest()
	{
		Map<String, String> clientIdMap = Token.getClientId();
		
		Map<String, String> formMap = new HashMap<String, String>();
		formMap.put("title", "Test Title of Image from API");
		formMap.put("description", "Test description of Image from API");
		
		Response response = RestClient.doPost("multipart", "https://api.imgur.com", "/3/image", clientIdMap, null, null, true, formMap);
		System.out.println("response.getStatusCode: " + response.getStatusCode());
		System.out.println("response..prettyPrint : " + response.prettyPrint());
	}
	
}

















