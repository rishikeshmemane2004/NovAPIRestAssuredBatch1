package rough;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class ConvertMapToJson {

	public static void main(String[] args) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "India");
		map.put("2", "Australia");
		map.put("3", "England");
 
		List<String> list = new ArrayList<String>();
		list.add("UK");
		list.add("USA");
		list.add("UAE");
 
		// this method converts a list to JSON Array
 		String jsonStr = JSONArray.toJSONString(list);
		//System.out.println(jsonStr);
 		map.put("4", jsonStr);
		
	 	
		Map<String, String> jsonObj = new HashMap<String, String>();
		jsonObj.put("country", "Russia");
		jsonObj.put("capital", "Peterburg");
		map.put("5", jsonObj);
	 		
		
		// converts Map to JSON
		String jsonStr1 = JSONValue.toJSONString(map); 
		System.out.println(jsonStr1);
		
		

	}
}
