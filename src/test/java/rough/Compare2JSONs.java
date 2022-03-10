package rough;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class Compare2JSONs {

	@Test
	public void compare2JSONsDemo()
	{
	String json1 = "\r\n"
			+ "  \"firstName\" : \"Amod\",\r\n"
			+ "  \"lastName\": \"Mahajan\",\r\n"
			+ "  \"age\": \"28\"\r\n"
			+ "}";
	
	
	String json2 = "\r\n"
			+ "  \"FirstName\" : \"Amod\",\r\n"
			+ "  \"lastName\": \"Mahajan\",\r\n"
			+ "  \"age\": \"28\"\r\n"
			+ "}";

	String jsonAdditionalField = "{\r\n"
			+ "\"firstName\" : \"Amod\",\r\n"
			+ "\"lastName\" : \"Mahajan\",\r\n"
			+ "\"age\": \"28\",\r\n"
			+ "\"relatives\" : [\"brother\",\"sister\",\"mother\" ]\r\n"
			+ "}";

	String jsonAdditionalField1 = "{\r\n"
			+ "\"lastName\" : \"Mahajan\",\r\n"
			+ "\"firstName\" : \"Amod\",\r\n"
			+ "\"age\": \"28\",\r\n"
			+ "\"relatives\" : [\"brother\",\"sister\",\"mother\", \"father\"]\r\n"
			+ "}";
	
	
	try {
  		JSONAssert.assertEquals(json1, json2, true);
// 		JSONAssert.assertEquals(jsonAdditionalField,jsonAdditionalField1, false);
//		JSONAssert.assertEquals(json1,jsonAdditionalField1, true);

//		JSONAssert.assertEquals(json1, jsonAdditionalField1, true); //got: a JSON object
//		JSONAssert.assertEquals(json1, jsonAdditionalField1, false); //got: a JSON object

//		JSONAssert.assertEquals(jsonAdditionalField1,json1, true); //got: org.skyscreamer.jsonassert.JSONParser$1@b174a73
//		JSONAssert.assertEquals(json1, jsonAdditionalField1, JSONCompareMode.LENIENT); 
//		JSONAssert.assertEquals(jsonAdditionalField1, json1, JSONCompareMode.LENIENT); 
//		JSONAssert.assertEquals(jsonAdditionalField1, json1, JSONCompareMode.NON_EXTENSIBLE);
//		JSONAssert.assertEquals(json1, jsonAdditionalField1, JSONCompareMode.NON_EXTENSIBLE);


		// changed key/value order, order does not matter
//		JSONAssert.assertEquals(jsonAdditionalField, jsonAdditionalField1, false);
//		JSONAssert.assertEquals(jsonAdditionalField, jsonAdditionalField1, true);
	
		
 		
	} catch (JSONException e) {
 		e.printStackTrace();
	}
	}
}
