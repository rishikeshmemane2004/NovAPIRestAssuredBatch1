package com.qa.api.gorest.util;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Token {

	public static Map<Object, Object> appTokenMap;
	public static Map<String, String> tokenMap = new HashMap<String, String>();
	
	private static String refresh_token = "f3e56aa32e95995a97ace53d174b86c08feb768a";
	private static String client_id = "2d2f5866fec77ec";
	private static String client_secret = "90a4548bf1bb9a1db44933edbeb3976bcf059942";
	private static String grant_type = "refresh_token";
	
	
	@Test
	public static Map<Object, Object> getAccessToken()
	{
		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token",refresh_token);
		formParams.put("client_id",client_id);
		formParams.put("client_secret",client_secret);
		formParams.put("grant_type",grant_type);
		
		JsonPath tokenJson = 
				RestAssured.given()
					.formParams(formParams)
				.when()
					.post("https://api.imgur.com/oauth2/token")
				.then()
					.extract().jsonPath();
		
		System.out.println("Toekn map =============> " + tokenJson.getMap(""));
		//return tokenJson.getMap("");
		appTokenMap = tokenJson.getMap("");
		return appTokenMap;
	}
	
	public static Map<String, String> getAuthToken()
	{
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("authToken ====> " + authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
	}
	
	public static Map<String, String> getClientId()
	{
		System.out.println("Client ID ========> " + client_id );
		tokenMap.put("Authorization", "Client-ID " + client_id);
		return tokenMap;
	}
	 
}
