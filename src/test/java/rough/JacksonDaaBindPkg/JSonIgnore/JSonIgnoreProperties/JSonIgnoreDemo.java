package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonIgnoreDemo {

	@Test
	public void JSonIgnoreDemo1()
	{
		ObjectMapper mapper = new ObjectMapper();
		Addr addr = new Addr("1234","Pune");
		CustomerDTO customerDto = new CustomerDTO("1","Swaraj","Patil", addr);
		String str = null;
		
		try {
			str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerDto);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		System.out.println(str);
	}
}
