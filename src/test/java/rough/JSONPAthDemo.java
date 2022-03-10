package rough;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JSONPAthDemo {

	
	@Test
	public void  jsonPathExtractionDemo()
	{
		String json = "{\r\n"
				+ "    \"store\": {\r\n"
				+ "        \"book\": [\r\n"
				+ "            {\r\n"
				+ "                \"category\": \"reference\",\r\n"
				+ "                \"author\": \"Nigel Rees\",\r\n"
				+ "                \"title\": \"Sayings of the Century\",\r\n"
				+ "                \"price\": 8.95\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"Evelyn Waugh\",\r\n"
				+ "                \"title\": \"Sword of Honour\",\r\n"
				+ "                \"price\": 12.99\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"Herman Melville\",\r\n"
				+ "                \"title\": \"Moby Dick\",\r\n"
				+ "                \"isbn\": \"0-553-21311-3\",\r\n"
				+ "                \"price\": 8.99\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "                \"category\": \"fiction\",\r\n"
				+ "                \"author\": \"J. R. R. Tolkien\",\r\n"
				+ "                \"title\": \"The Lord of the Rings\",\r\n"
				+ "                \"isbn\": \"0-395-19395-8\",\r\n"
				+ "                \"price\": 22.99\r\n"
				+ "            }\r\n"
				+ "        ],\r\n"
				+ "        \"bicycle\": {\r\n"
				+ "            \"color\": \"red\",\r\n"
				+ "            \"price\": 19.95\r\n"
				+ "        }\r\n"
				+ "    },\r\n"
				+ "    \"expensive\": 10\r\n"
				+ "}";
		
		JsonPath jp = new JsonPath(json);
		String title= (String) jp.get("store.book[0].title");
		System.out.println("title : " + title);
		
		System.out.println("title : " + jp.get("store.book.title"));
		List<String> totalNoOfTitles = jp.getList("store.book.title");
		System.out.println("Total  no of titles : " + totalNoOfTitles.size());
		
		
		
		
	}
}
