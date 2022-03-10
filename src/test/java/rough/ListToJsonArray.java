package rough;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

public class ListToJsonArray {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("India");
		list.add("Australia");
		list.add("England");
		
		// this method converts a list to JSON Array
		String jsonStr = JSONArray.toJSONString(list);
		System.out.println(jsonStr);
	}
}
