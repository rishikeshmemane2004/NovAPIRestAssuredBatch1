package com.qa.api.gorest.util;

import java.util.Random;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class TestUtil {
/**
 * This method is to convert POJO object in json String
 * @param obj
 * @return json string
 */
	public static String getSerializedJSON(Object obj)
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		String jsonString1 = null;
		try
		{
			jsonString = mapper.writeValueAsString(obj);
			System.out.println("JSON body payload ======> " + jsonString);
			jsonString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			System.out.println("JSON body payload ======> " + jsonString);
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return jsonString1;
	}

	public static int generateRandomValue()
	{
		Random random = new Random();
		int rndVal = random.nextInt(10000);
		return rndVal;
	}	
	
	public static void verifyStatusCode(Response response, int expStatusCode, boolean log)
	{
		int actStatusCode = response.getStatusCode();
		if (log)
		{
			System.out.println("**** Actual Status Code   : " + actStatusCode);
			System.out.println("**** Expected Status Code : " + expStatusCode);
		}
		Assert.assertEquals(actStatusCode, expStatusCode, "Exp Status Code: " + expStatusCode + " does not match with actual status code: " + actStatusCode);
		System.out.println("Exp status code: " + actStatusCode + " matched with actual status code : " + actStatusCode);
		
	}
	
	public static void verifyFieldValue(Response response, String actValue, 
			String expValue, boolean log)
	{
		if (log)
		{
			System.out.println("Act value: " + actValue);
			System.out.println("Exp value: " + expValue);
		}
		
		Assert.assertEquals(actValue, expValue, "ERROR ===> Exp Field Value: " + expValue + " does not match with actual Value: " + actValue);
		System.out.println("Exp Field Value: " + expValue + " matched with actual Value: " + actValue);

	}

	public static String getFieldValue(Response response, String fieldName)
	{
		String value = null;
		try
		{
			value = response.jsonPath().get(fieldName);
		} catch(Exception e)
		{
			System.out.println("ERROR ===> " + fieldName + " not found in the response body");
			return null;
		}
		return value;
	}
	
}
