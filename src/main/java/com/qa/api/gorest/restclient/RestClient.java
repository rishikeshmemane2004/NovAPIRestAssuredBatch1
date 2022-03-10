package com.qa.api.gorest.restclient;

import java.io.File;
import java.util.Map;

import org.json.simple.JSONObject;

import com.qa.api.gorest.util.TestUtil;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is having all http methods which will call the apis 
 * and having generic methods for getting the response and fetch 
 * the value from it.
 * All wrapper classes for all http methods are defined here.
 * 
 * @author Rishi
 *
 */
public class RestClient {

	
	 /** This method is used to call GET API
	  * @param contentType
	  * @param baseUri
	  * @param basePath
	  * @param token
	  * @param queryParamsMap
	  * @param pathParamsMap
	  * @param log
	  * @return returns response from GET API
	  */
	@Step("GET CALL  with {0}, {1}, {2}, {3}, {4}, {5}, {6}")
	public static Response doGet(String contentType, String baseUri, String basePath, Map<String, String> token, 
			Map<String, String> queryParamsMap, Map<String, String> pathParamsMap, 
			boolean log)
	{
		if (setBaseURI(baseUri))
		{
			RequestSpecification request = createRequest(contentType, token, queryParamsMap, pathParamsMap, log);	
			return getResponse("GET",request, basePath);
		}
		return null;
	}
	
	/**
	 * This method is to call POST API
	 * @param contentType
	 * @param baseUri
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return this method returns response from the POST call/API
	 */
	@Step("POST CALL  with {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}")
	public static Response doPost(String contentType, String baseUri, String basePath, 
			Map<String, String> token, Map<String, String> queryParamsMap, Map<String, String> pathParamsMap, boolean log,
			Object obj)
	{
		if (setBaseURI(baseUri))
		{
			System.out.println("inside setBaseURI function");
			RequestSpecification request = createRequest(contentType, token, queryParamsMap, pathParamsMap,log);	
			addRequestPayload(request, obj);
			return getResponse("POST",request, basePath);
		}
		return null;
	}
	
	private static void addRequestPayload(RequestSpecification request, Object obj)
	{
		if (obj != null)
		{
			System.out.println("Inside  obj != null");

			if (obj instanceof JSONObject)
			{
				System.out.println("Inside obj instanceof JSONObject");
				String jsonPayload = TestUtil.getSerializedJSON(obj);
				request.body(jsonPayload);
			}
			else if(obj instanceof Map)
			{
				System.out.println("Inside  obj instanceof Map");
				request.formParams((Map<String, String>) obj);
			}
			else
			{	
				System.out.println("Inside  obj NOT instanceof MAP");
				String jsonPayload = TestUtil.getSerializedJSON(obj);
				request.body(jsonPayload);
			}
		} 
	}
	
	private static boolean setBaseURI(String baseURI)
	{
		if (baseURI == null || baseURI.isEmpty())
		{
			System.out.println("Please pass the correct base URI, either it is empty or null...");
			return false;
		}
		try
		{
			RestAssured.baseURI = baseURI;
			return true;
		}catch(Exception e)
		{
			System.out.println("Some exception occurred while setting up baseURI");
			return false;
		}
	}
	private static RequestSpecification createRequest(String contentType, Map<String, String> token, 
			Map<String, String> queryParamsMap, 
			Map<String, String> pathParamsMap, 
			boolean log)
	{
		RequestSpecification request;
		
		if (log)
		{
			System.out.println("Inside  log = true");
			request = RestAssured.given().log().all();
		}
		else
		{
			System.out.println("Inside  log = false");
			request = RestAssured.given();
		}
		
		if (token.size()>0)
		{
			System.out.println("Inside  token.size > 0 ");
			request.headers(token);
		}
		if (!(queryParamsMap==null))
		{
			System.out.println("Inside FORM Parameter...");
			request.queryParams(queryParamsMap);
		}
		if (!(pathParamsMap==null))
		{
			System.out.println("Inside path Parameter...");
			request.pathParams(pathParamsMap);
		}
		
		if(contentType != null)
		{
			System.out.println("Inside  content type != null");

			if (contentType.equalsIgnoreCase("JSON"))
				request.contentType(ContentType.JSON);
			else if (contentType.equalsIgnoreCase("XML"))
				request.contentType(ContentType.XML);
			else if (contentType.equalsIgnoreCase("TEXT"))
				request.contentType(ContentType.TEXT);
			else if (contentType.equalsIgnoreCase("multipart"))
				request.multiPart("image", new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\api\\gorest\\testdata\\Doctor.jpg"));
		} 
		
		return request;
	}

	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath)
	{
		return executeAPI(httpMethod, request, basePath);
	}
	
	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath)
	{
		Response response = null;
 		
		switch(httpMethod)
		{
		case "GET":
			response = request.get(basePath);
			break;
		case "POST":
			response = request.post(basePath);
			break;
		case "PUT":
			response = request.put(basePath);
			break;
		case "DELETE":
			response = request.delete(basePath);
			break;
		default:
			System.out.println("please pass the correct http method...");
			break;
		}
		return response;
	}
	
	@Step("DELETE CALL  with {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}")
	public static Response doDelete(String contentType, String baseUri, String basePath, 
			Map<String, String> token, Map<String, String> queryParamsMap, Map<String, String> pathParamsMap, boolean log,
			Object obj)
	{
		if (setBaseURI(baseUri))
		{
			RequestSpecification request = createRequest(contentType, token, queryParamsMap, pathParamsMap, log);	
			return getResponse("DELETE",request, basePath);
		}
		return null;
	}

	@Step("PUT CALL  with {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}")
	public static Response doPut(String contentType, String baseUri, String basePath, 
			Map<String, String> token, Map<String, String> queryParamsMap, Map<String, String> pathParamsMap, boolean log,
			Object obj)
	{
		if (setBaseURI(baseUri))
		{
			RequestSpecification request = createRequest(contentType, token, queryParamsMap, pathParamsMap, log);	
			addRequestPayload(request, obj);
			return getResponse("PUT",request, basePath);
		}
		return null;
	} 

}
