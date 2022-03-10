package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSonIgnoreDemo1 {

	@Test
	public void JSonIgnoreDemo1_1()
	{
		ObjectMapper mapper = new ObjectMapper();
		Addr1 addr1 = new Addr1("1234","Pune");
		CustomerDTO1 customerDto1 = new CustomerDTO1("1",null,"Patil", addr1);
		String str = null;
		
		try {
			str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(customerDto1);
		} catch (JsonProcessingException e) {
 			e.printStackTrace();
		}
		System.out.println(str);
	}
}
