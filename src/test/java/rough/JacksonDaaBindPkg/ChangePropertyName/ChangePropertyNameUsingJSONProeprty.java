package rough.JacksonDaaBindPkg.ChangePropertyName;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
 

public class ChangePropertyNameUsingJSONProeprty {

	
	@Test
	public void NoChangeInPropertyname() {

		ObjectMapper mapper = new ObjectMapper();
// below statement enables pretty printing of JSON string
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		User user = new User(100,"Shreya","Patil","Shreya Patil");
		String str = null;
		try {
			str = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		System.out.println(str);
	}
	
	@Test
	public void changePropertyname() {

		ObjectMapper mapper = new ObjectMapper();
		UserWithJSONProeprty user = new UserWithJSONProeprty(100,"Shreya","Patil","Shreya Patil");
		String str = null;
		try {
			// this function writerWithDefaultPrettyPrinter of ObjectMapper class enables pretty printing of JSON string
			str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		System.out.println(str);
	}
	
	
}






























