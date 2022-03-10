package rough.JSONSimplePkg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.TestUtil;

import io.restassured.response.Response;

public class EnCodeJSONObject {

	@Test
	public void createUserUsingJSONObject() {
		String baseURI = "https://gorest.co.in";
		String basePath = "/public-api/users";
		String token = "90d7c227d056a668554d486727c22eb34ac99997b70607e35cd8b863740b3adc";
		
		Random random = new Random();
		int rndVal = random.nextInt(100000);
		String name = "Aditya"+rndVal;
		String email = name + "@gmail.com";
		String gender = "male";
		String status = "active";
			
		Map<String, String> autTokenMap = new HashMap<String, String>();
		autTokenMap.put("Authorization", "Bearer " + token);
	 
		JSONObject jObj = new JSONObject();
		jObj.put("name",   name);
		jObj.put("email",  email);
		jObj.put("gender", gender);
		jObj.put("status", status);
		
 
		System.out.println(jObj);
		if (jObj instanceof JSONObject)
			System.out.println("ITs JSONObject only");
		else
			System.out.println("ITs NOT JSONObject");
 	
		Response response = RestClient.doPost("JSON",     baseURI, basePath, 
											  autTokenMap, null,    null,     true, jObj);
		 
		 
		TestUtil.verifyStatusCode(response, 200, true);

		System.out.println("Response priting ===> " + response.prettyPrint());
		String fieldValue = TestUtil.getFieldValue(response, "data.name");
		TestUtil.verifyFieldValue(response, fieldValue, name, true);
	}
	

	@Test
	public void encodeJsonObject() 
	{
		JSONObject jObj = new JSONObject();
		jObj.put("name", new String("Swaraj"));
		Integer age = Integer.valueOf(13);
		jObj.put("age", age);
		jObj.put("salary", new Double(1111111));

		JSONObject addr = new JSONObject();
		addr.put("laneNo", "1234");
		addr.put("city", "Nagar");
		addr.put("isMale", true);
		JSONArray pCodeArr = new JSONArray();
		pCodeArr.add(411016);
		pCodeArr.add(411014);
		pCodeArr.add(414001);
		addr.put("pinCodes", pCodeArr);		
		
		jObj.put("address", addr);
		

		JSONArray jArr = new JSONArray();
		jArr.add(new String("Java"));
		jArr.add("Python");
		jArr.add("C++");
		
		jObj.put("lang", jArr);

		System.out.println(jObj);
		
		// finding data type of a field in a json Object
		Object dataType_name = jObj.get("name");
		findDataType(dataType_name);
		
		Object dataType_age = jObj.get("age");
		findDataType(dataType_age);
		
		Object dataType_salary = jObj.get("salary");
		findDataType(dataType_salary);
		
		
		Object dataType_address = jObj.get("address");
		findDataType(dataType_address);		
		
		System.out.println("------------");
		JSONObject jsonObjectAddress = (JSONObject) jObj.get("address");
		Object addrObj = jsonObjectAddress.get("laneNo");
		System.out.println("addrsObj : "+ addrObj);
		findDataType(addrObj);		
		System.out.println("------------");

		System.out.println("=============");
		Object cityObj = jsonObjectAddress.get("city");
		System.out.println("cityObj : "+ cityObj );
		findDataType(cityObj);		
		System.out.println("=============");

		System.out.println("=============");
		Object pCodesObj = jsonObjectAddress.get("pinCodes");
		System.out.println("pCodesObj : "+ pCodesObj );
		findDataType(pCodesObj);		
		System.out.println("=============");
		
		System.out.println("=============");
		Object isMaleObj = jsonObjectAddress.get("isMale");
		System.out.println("isMaleObj : "+ isMaleObj );
		findDataType(isMaleObj);		
		System.out.println("=============");

		
		Object dataType_lang = jObj.get("lang");
		findDataType(dataType_lang);	
		
		
		System.out.println("********************** Print Address object: ");
		JSONObject jsonChildObject = (JSONObject) jObj.get("address");
		
		Set<Entry<Object, Object>> entry = jsonObjectAddress.entrySet();
		Iterator<Entry<Object, Object>> iter = entry.iterator();
		while(iter.hasNext())
		{
			Entry<Object, Object> pair = iter.next();
			
			Object k = pair.getKey();
			Object v = pair.getValue();
		    System.out.println("Key = " + k + ", Value = " + v);
			findDataType(v);	
			if (k.equals("pinCodes"))
			{
				JSONArray ObjPinCodes = (JSONArray) jsonObjectAddress.get("pinCodes");
				for(int i=0;i<ObjPinCodes.size();i++)
					{
						System.out.println("ObjPinCodes.get(i):  " + ObjPinCodes.get(i));
						System.out.println("return data type  :  " +returnDataType(ObjPinCodes.get(i)));	
					}
			}
		}
	}
	
	public void findDataType(Object obj)
	{
		if (obj instanceof String)
			System.out.println("obj : " + obj + " is of type String");
		if (obj instanceof Integer)
			System.out.println("obj : " + obj + " is of type Integer");
		if (obj instanceof Double)
			System.out.println("obj : " + obj + " is of type Double");
		if (obj instanceof Boolean)
			System.out.println("obj : " + obj + " is of type Boolean");
		
		if (obj instanceof JSONObject)
			System.out.println("obj : " + obj + " is of type JSONObject");
		
		if (obj instanceof JSONArray)
			System.out.println("obj : " + obj + " is of type JSONArray");
				
	}
	
	public String returnDataType(Object obj)
	{
		if (obj instanceof String)
			return "String";
		if (obj instanceof Integer)
			return "Integer";
		if (obj instanceof Double)
			return  "Double";
		if (obj instanceof Boolean)
			return "Boolean";
		
		if (obj instanceof JSONObject)
			return "JSONObject";
		
		if (obj instanceof JSONArray)
			return "JSONArray";
		
		return null;
	}
}
