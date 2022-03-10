package rough;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareJSONResponseUsingJacksonBind {

	/*Compare Two Simple JSON Objects
	 * It's important to note that even though the order of attributes in input JSON variables s1 and s2 
	 * is not the same, the equals() method ignores the order and treats them as equal.
	 */
	
	@Test
	public void compare2JSON()
	{
		ObjectMapper mapper = new ObjectMapper();
		String json1 = "{"
				+ "    \"employee\":{"
				+ "    \"id\": \"1212\","
				+ "    \"fullName\": \"John Miles\","
				+ "    \"age\": 34"
				+ "    }"
				+ "}";
	
		String json2 = "{"
				+ "    \"employee\":\r\n"
				+ "    {"
				+ " 	   \"id\": \"1212\","
				+ "    	   \"age\": 34,"
				+ "        \"fullName\": \"John Miles\""
				+ "    }"
				+ "}";
	
		try {
			Assert.assertEquals(mapper.readTree(json1), mapper.readTree(json2),"jsons are unequal...");
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
	}
	
	//. Compare Two JSON Objects with a Nested Element
	@Test
	public void  compare2JsonsWithNestedObjects()
	{
		ObjectMapper mapper = new ObjectMapper();

		String json1 = "{ \r\n"
				+ "    \"employee\":\r\n"
				+ "    {\r\n"
				+ "        \"fullName\":\"John Miles\",\r\n"
				+ "        \"id\": \"1212\",\r\n"
				+ "        \"age\": 34,\r\n"
				+ "        \"contact\":\r\n"
				+ "        {\r\n"
				+ "            \"email\": \"john@xyz.com\",\r\n"
				+ "            \"phone\": \"9999999999\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
	
		String json2 = "{\r\n"
				+ "    \"employee\":\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"1212\",\r\n"
				+ "        \"age\": 34,\r\n"
				+ "        \"fullName\": \"John Miles\",\r\n"
				+ "        \"contact\":\r\n"
				+ "        {\r\n"
				+ "            \"email\": \"john@xyz.com\",\r\n"
				+ "            \"phone\": \"9999999999\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
		
		try {
			Assert.assertEquals(mapper.readTree(json1), mapper.readTree(json2),"jsons are not equals");
		} catch (JsonMappingException e) {
 			e.printStackTrace();
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
	
	}
	
	//Compare Two JSON Objects Containing a List Element
	// two list elements are only compared as equal if they have the same values in the exact same order.
	
	@Test
	public void compare2JsonsWithList()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		String json1 = "{\r\n"
				+ "    \"employee\":\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"1212\",\r\n"
				+ "        \"fullName\": \"John Miles\",\r\n"
				+ "        \"age\": 34,\r\n"
				+ "        \"skills\": [\"Java\", \"C++\", \"Python\",\"C\"]\r\n"
				+ "    }\r\n"
				+ "}";
		String json2 = "{\r\n"
				+ "    \"employee\":\r\n"
				+ "    {\r\n"
				+ "        \"id\": \"1212\",\r\n"
				+ "        \"age\": 34,\r\n"
				+ "        \"fullName\": \"John Miles\",\r\n"
				+ "        \"skills\": [\"Java\", \"C++\", \"Python\",\"C\"] \r\n"
				+ "    } \r\n"
				+ "}";
			
		try {
			Assert.assertEquals(mapper.readTree(json1), mapper.readTree(json2),"Jsons are not equal");
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
	}
	//Compare Two JSON Objects with a Custom Comparator
	@Test
	public void coompare2JsonsWithCustomComparatorNumberic()
	{
		ObjectMapper mapper = new ObjectMapper();
		String s1 = "{\r\n"
				+ "    \"name\": \"John\",\r\n"
				+ "    \"score\": 5.0\r\n"
				+ "}";
		String s2 = "{\r\n"
				+ "    \"name\": \"John\",\r\n"
				+ "    \"score\": 5\r\n"
				+ "}";
		
		JsonNode actualObj1=null;
		JsonNode actualObj2=null;
		try {
			actualObj1 = mapper.readTree(s1);
			actualObj2 = mapper.readTree(s2);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		 
		//Assert.assertEquals(actualObj1, actualObj2,"jsons are not equal...");
 		
		
		NumericNodeComparator cmp = new NumericNodeComparator();
		Assert.assertTrue(actualObj1.equals(cmp, actualObj2));
		
	}
	
	//Custom Comparator to Compare Text Values
	//example of a custom Comparator for a case-insensitive comparison of two JSON values.
	@Test
	public void coompare2JsonsWithCustomComparatorText()
	{
		ObjectMapper mapper = new ObjectMapper();
		String s1 = "{\r\n"
				+ "    \"name\": \"john\", \r\n"
				+ "    \"score\": 5 \r\n"
				+ "}";
		String s2 = "{ \r\n"
				+ "    \"name\": \"JOHN\", \r\n"
				+ "    \"score\": 5 \r\n"
				+ "}";
		JsonNode actualObj1 = null;
		JsonNode actualObj2 = null;
		try {
			actualObj1 = mapper.readTree(s1);
			actualObj2 = mapper.readTree(s2);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		


	//	Assert.assertEquals(actualObj1, actualObj2, "jsons are not equal");

		
		TextModeComparator cmp = new TextModeComparator();
		Assert.assertTrue(actualObj1.equals(cmp, actualObj2));
	}
	
	
	
	
	
	
	
	
	
}
