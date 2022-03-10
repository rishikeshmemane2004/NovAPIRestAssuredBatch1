package rough.JacksonDaaBindPkg.WriteJsonUsingJsonGeneratorPkg;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class WriteJsonUsingJsonGenerator {

	@Test
	public void WriteJsonUsingJG() {

	
	JsonFactory factory = new JsonFactory();
	
	
	try {
		JsonGenerator  generator = factory.createGenerator(new File("E:/NAL/RestAssuredFramework/src/test/java/rough/JacksonDaaBindPkg/WriteJsonUsingJsonGeneratorPkg/post123.json"),  JsonEncoding.UTF8);
	
		generator.writeStartObject(); //{
		generator.writeNumberField("id", 100);
		generator.writeStringField("title","Jackson Json API Guide");
		generator.writeStringField("description","Post about Jackson Json API");
		generator.writeStringField("content", "HTML Document here");
		generator.writeFieldName("tags");
		generator.writeStartArray(); // [
		
		generator.writeStartObject();
		generator.writeStringField("id", "4000");
		generator.writeStringField("name","Java");
		generator.writeEndObject();
		
		generator.writeStartObject();
		generator.writeStringField("id", "5000");
		generator.writeStringField("name","Python");
		generator.writeEndObject();
		
		generator.writeEndArray();
		generator.writeEndObject();
		
		generator.close();
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	} catch (IOException e) {
 		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
