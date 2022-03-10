package rough.JacksonDaaBindPkg.Collections;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ListDemo {

	@Test
	public void listToJson()
	{
	ObjectMapper mapper = new ObjectMapper();
	List<String> list = new ArrayList<>();
	
	list.add("Java");
	list.add("Python");
	list.add("C++");
	list.add("C");
	
	String str=null, str1 = null;
	try {
		str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
		str1 = mapper.writeValueAsString(list);
	} catch (JsonProcessingException e) {
 		e.printStackTrace();
	}
	System.out.println(str);  // with space
	System.out.println(str1); // without space, 
	// with HashSet
	}


	@Test
	public void setToJson()
	{
	ObjectMapper mapper = new ObjectMapper();
	Set<String> set= new HashSet<String>();
	
	set.add("Appium");
	set.add("Kotlin");
	set.add("Tosca");
	
	String str=null, str1 = null;
	try {
		str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(set);
		str1 = mapper.writeValueAsString(set);
	} catch (JsonProcessingException e) {
 		e.printStackTrace();
	}
	System.out.println(str);  // with space
	System.out.println(str1); // without space, 
 
	}
	
	@Test
	public void mapToJson()
	{
	ObjectMapper mapper = new ObjectMapper();
	Map<String, Integer> map= new HashMap<String, Integer>();
	
	map.put("Mon",Calendar.MONDAY);
	map.put("Tue",Calendar.TUESDAY);
	map.put("Wed",Calendar.WEDNESDAY);
	map.put("Thu",Calendar.THURSDAY);
	map.put("Fri",Calendar.FRIDAY);
	map.put("Sat",Calendar.SATURDAY);
	map.put("Sun",Calendar.SUNDAY);
	
	String str=null, str1 = null;
	try {
		str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		str1 = mapper.writeValueAsString(map);
	} catch (JsonProcessingException e) {
 		e.printStackTrace();
	}
	System.out.println(str);  // with space
	System.out.println(str1); // without space, 
 
	}
}
