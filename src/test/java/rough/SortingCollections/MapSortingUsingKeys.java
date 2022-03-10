package rough.SortingCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.testng.annotations.Test;

public class MapSortingUsingKeys {

	
	@Test
	public void SrotingOfMap()
	{
		Map<Integer, String>map = new HashMap<Integer, String>();
		map.put(600, "France");
		map.put(400, "UK");
		map.put(200, "USA");
		map.put(500, "UAE");
		map.put(100, "India");
		
		displayMap("Original Map contents: ", map);
		
		// sort the map
		TreeMap<Integer, String> smapOnKey = new TreeMap<Integer, String>(map);
		displayMap("Sorted Map contents: ", smapOnKey);

		
		
		
	}
	public void displayMap(String displayString, Map<Integer,  String> m)
	{
		System.out.println(displayString);
	//	for(Entry<Integer, String> pair : m.entrySet())
	//		System.out.println(pair.getKey() + " ===> " + pair.getValue());
	
		// using set to display map
		Set<Integer> set = m.keySet();
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext())
		{
			Integer key =  iter.next();
			String value = m.get(key);
			System.out.println(key + " ===> " + value);
		}
	}
}
