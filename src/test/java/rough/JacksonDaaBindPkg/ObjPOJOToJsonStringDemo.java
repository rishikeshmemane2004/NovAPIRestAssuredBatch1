package rough.JacksonDaaBindPkg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ObjPOJOToJsonStringDemo {

	
	@Test
	public void JacksonPojoToJson()
	{
		ObjectMapper mapper = new ObjectMapper();
		//below statement is not mandatory, need to read more about it though
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		
		Tag tag1 = new Tag(100L,"Java");
		Tag tag2 = new Tag(200L,"Python");
		Tag tag3 = new Tag(300L,"Postman");
		Set<Tag> tags = new HashSet<Tag>();
		tags.add(tag1);
		tags.add(tag2);
		tags.add(tag3);
			
		Post post = new Post(1L,"Jackson API guide", "Post about Jackson JSON API", "HTML content here",new Date(),new Date(),tags);
		String str = null;
		try {
			str  = mapper.writeValueAsString(post);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("str : "+ str);
		
		try {
			FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+
					"/src/test/java/rough/JacksonDaaBindPkg/post.json");
			mapper.writeValue(fos, post);
			fos.close();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		
	}
}
