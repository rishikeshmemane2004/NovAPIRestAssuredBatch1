package rough.JacksonDaaBindPkg.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserailizeJsonToList {

	@Test
	public void JsonToList() {

		ObjectMapper mapper = new ObjectMapper();
		
        String jsonStr = "[ \"C\", \"C++\", \"Java\", \"Java EE\", \"Python\", \"Scala\", \"JavaScript\" ]";
		
		List<String> list = new ArrayList<String>();
		
		try {
			list = mapper.readValue(jsonStr, List.class);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
				
		System.out.println("Print using traditional for loop for list");
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
				
		System.out.println("Print using traditional set for list");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext())
			System.out.println((String) iter.next());
		
		System.out.println("Print using traditional listIterator for list");
		Iterator<String> iterList = list.listIterator();
		while(iterList.hasNext())
			System.out.println( iterList.next());
		 		
	}
}
