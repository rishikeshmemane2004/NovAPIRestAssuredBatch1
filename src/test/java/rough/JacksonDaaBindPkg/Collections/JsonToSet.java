package rough.JacksonDaaBindPkg.Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToSet {

	/**
	 * 
	 */
	@Test
	public void jsonToSetDemo()
	{
		ObjectMapper mapper = new ObjectMapper();
		
        String json = "[ \"C\", \"C++\", \"Java\", \"Java EE\", \"Python\", \"Scala\", \"JavaScript\" ]";

		Set<String> set = new HashSet<String>();
		
		try {
			set = mapper.readValue(json, Set.class);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
	}
}
