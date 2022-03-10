package rough.JacksonDaaBindPkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
 
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * 
 * To de-serialize from JSON to object, all class should  have default constructor which does not have parameters
 */

public class ReadJSONintoObject {

	@Test
	public void readJSONintoObject() {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
					"\\src\\test\\java\\rough\\JacksonDaaBindPkg\\post.json");
			ObjectMapper mapper = new ObjectMapper();
			Class<Post> s = Post.class;
			Post post = mapper.readValue(fis,s);
			fis.close();
			
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getDescription());
			System.out.println(post.getContent());
			System.out.println(post.getPostDt());
			System.out.println(post.getLastUpdateDate());
			
			Iterator<Tag> iter = post.getTags().iterator();
 			while(iter.hasNext())
			{
				Tag tag = (Tag) iter.next();
				System.out.println(tag.getId() + " == " + tag.getName());
			}
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		} catch (StreamReadException e) {
 			e.printStackTrace();
		} catch (DatabindException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}
}
