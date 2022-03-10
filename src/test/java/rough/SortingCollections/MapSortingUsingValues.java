package rough.SortingCollections;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
 import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class MapSortingUsingValues {

	
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
		
		Map<Integer, String> smap = sortValues(map);
		displayMap("Sorted map using  values", smap);
		
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
	
	public HashMap sortValues(Map<Integer, String> m)
	{
		List list = new LinkedList(m.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2)
			{
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());  
			} 
		});
		System.out.println("Sorted List: " + list);
		
		HashMap<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();
		//iterate over List which is already sorted now
	 
		Iterator<Map.Entry<Integer, String>> iter = list.iterator();
		while(iter.hasNext())
		{
			Entry<Integer, String> keyValue  =  iter.next();
			
			Integer key   = keyValue.getKey();
			String value = keyValue.getValue();
			sortedHashMap.put(key, value);
		}
		return sortedHashMap;
	}
}
