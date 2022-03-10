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
import io.restassured.response.Response;

@Epic("DElete gorest user api feature implementation")
@Feature("Delete user api feature")
public class DeleteUserTest {
	private static String accessToken = "90d7c227d056a668554d486727c22eb34ac99997b70607e35cd8b863740b3adc";

	@Description("Delete a user api test... Verify DELETE user from post call")
	@Severity(SeverityLevel.TRIVIAL)
	@Test
	public void deleteUserGoRestAPITEST() {

		String baseURI = "https://gorest.co.in";
		String basePath = "/public-api/users";

		// authorization
		Map<String, String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer " + accessToken);

		// Get id for deletion
		Response response1 = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, null, true);
		int id = response1.jsonPath().get("data[0].id");
		System.out.println("id =========> " + id);

		// Start of delete api
		basePath = "/public/v2/users/{id}";

		Map<String, String> pathParams = new HashMap<String, String>();
		pathParams.put("id", String.valueOf(id));

		Response response = RestClient.doDelete(null, baseURI, basePath, authTokenMap, null, pathParams, true, null);

		System.out.println("status Code      ===> " + response.getStatusCode());
		System.out.println("Response priting ===> " + response.prettyPrint());
	}
}
