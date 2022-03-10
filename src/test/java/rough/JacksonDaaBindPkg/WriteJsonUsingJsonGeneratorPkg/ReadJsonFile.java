package rough.JacksonDaaBindPkg.WriteJsonUsingJsonGeneratorPkg;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class ReadJsonFile {

	@Test
	public void readJsonFileDemo() {

		JsonFactory factory = new JsonFactory();
		File file = new File(
				"E:/NAL/RestAssuredFramework/src/test/java/rough/JacksonDaaBindPkg/WriteJsonUsingJsonGeneratorPkg/post123.json");
		JsonParser parser = null;
		try {
			parser = factory.createParser(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JsonToken token = null;
		try {
			token = parser.nextToken();  // Read first object {
			System.out.println("Token1:" + token);
			// Read JSON object
			token = parser.nextToken();
			System.out.println("Token2:" + token);
			System.out.println("parser.getCurrentName(): " + parser.getCurrentName());
			
 			if (token == JsonToken.FIELD_NAME && "id".equals(parser.getCurrentName())) 
			{
 				token = parser.nextToken();
 				System.out.println("token :"+token);
				if (token == JsonToken.VALUE_NUMBER_INT)  
					{System.out.print("ID : ");
					System.out.println(parser.getText());}
			}

			token = parser.nextToken();
			if (token == JsonToken.FIELD_NAME && "title".equals(parser.getCurrentName())) 
			{
				token = parser.nextToken();
				if (token == JsonToken.VALUE_STRING)  
					System.out.println("Title: " + parser.getText());
			}
			token = parser.nextToken();
			if (token == JsonToken.FIELD_NAME && "description".equals(parser.getCurrentName())) 
			{
				token = parser.nextToken();
				if (token == JsonToken.VALUE_STRING)  
					System.out.println("Description: " + parser.getText());
			} 
			token = parser.nextToken();
			if (token == JsonToken.FIELD_NAME && "content".equals(parser.getCurrentName())) 
			{
				token = parser.nextToken();
				if (token == JsonToken.VALUE_STRING)  
					System.out.println("Content: " + parser.getText());
			}


		
			token = parser.nextToken();
			System.out.println("token ****: "+ token);
			System.out.println("parser.getCurrentName(): " + parser.getCurrentName());
			
			if (token == JsonToken.FIELD_NAME && "tags".equals(parser.getCurrentName()))
				{
					System.out.println("Post Tags are: ");
					token = parser.nextToken();
					while(token  != JsonToken.END_ARRAY)
					{
						token = parser.nextToken();
						if (token == JsonToken.VALUE_STRING)
							System.out.println(parser.getText());
					}
				}
			System.out.println();
			parser.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
