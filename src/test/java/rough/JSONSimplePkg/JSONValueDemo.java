package rough.JSONSimplePkg;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;
 

public class JSONValueDemo {

	@Test
	public void JSONValueDemo1()
	{
		  List<Object> arr = new ArrayList<Object>();  
		  arr.add("Amit Kumar");    
		  arr.add(Integer.parseInt("27"));    
		  arr.add(Double.parseDouble("600000"));   
		  String jsonText = JSONValue.toJSONString(arr);  
		  System.out.print(jsonText); 
	}
	
	@Test
	public void StringToJSONDemo()
	{
		
		String s="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";  
		
		
		Object obj = JSONValue.parse(s);
		JSONObject jobj = (JSONObject) obj;
		System.out.println("name  : " + (String) jobj.get("name"));
		System.out.println("age   : " + (Long) jobj.get("age"));
		System.out.println("salary: " + (Double) jobj.get("salary"));
		
		
		
		
		
		
		
		
		
		
	}
	
}
