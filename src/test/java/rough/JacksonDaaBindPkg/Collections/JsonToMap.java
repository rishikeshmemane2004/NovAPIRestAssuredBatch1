package rough.JacksonDaaBindPkg.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToMap {

	/**
	 * 
	 */
	@Test
	public void jsonToMapDemo()
	{
		ObjectMapper mapper = new ObjectMapper();
		
		   String json = "{" +
		            "  \"THU\" : 5," +
		            "  \"TUE\" : 3," +
		            "  \"WED\" : 4," +
		            "  \"SAT\" : 7," +
		            "  \"FRI\" : 6," +
		            "  \"MON\" : 2," +
		            "  \"SUN\" : 1" +
		            "}";
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		
		try {
			map= mapper.readValue(json, Map.class);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		
		for(Entry<String, Integer> day: map.entrySet())
			System.out.println(day.getKey() + " ===> " + day.getValue());
	 
		
	}
}
