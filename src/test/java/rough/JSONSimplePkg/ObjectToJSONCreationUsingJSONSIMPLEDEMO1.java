package rough.JSONSimplePkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ObjectToJSONCreationUsingJSONSIMPLEDEMO1 {

	/*
	 * JSONArray: To write data in JSON arrays. Use its add() method to add objects of type JSONObject.
	   JSONObject : To write JSON objects. Use it’s put() method to populate fields.
	 */

@Test
public void WriteJSONToFile()
{
	
	// Firsst user
	JSONObject user1 = new JSONObject();
	user1.put("id",100);
	user1.put("firstName", "Ramesh");
	user1.put("lastName", "Fadatare");
	user1.put("userName", "Ramesh@gmail.com");
	user1.put("email", "RameshFadatare");
	JSONObject address1 = new JSONObject();
	address1.put("laneNo", "44/1");
	address1.put("Society", "Sanjeevani park");
	address1.put("city", "Pune");
	user1.put("Address", address1);
	JSONArray user1RelativesArray = new JSONArray();
	user1RelativesArray.add("Brother");
	user1RelativesArray.add("Sister");
	user1.put("Relatives",user1RelativesArray);
	
// second user	
	JSONObject user2 = new JSONObject();
	user2.put("id",200);
	user2.put("firstName", "Suresh");
	user2.put("lastName", "PAcharane");
	user2.put("userName", "Suresh@gmail.com");
	user2.put("email", "SureshPAcharane");
	JSONObject address2 = new JSONObject();
	address2.put("laneNo", "1/234");
	address2.put("Society", "Shwet park");
	address2.put("city", "Mumbai");
	user2.put("Address", address2);
	JSONArray user2RelativesArray = new JSONArray();
	user2RelativesArray.add("Father");
	user2RelativesArray.add("Mother");
	user2RelativesArray.add("in Laws");
	user2.put("Relatives",user2RelativesArray);

	
	JSONObject user3 = new JSONObject();
	user3.put("id",300);
	user3.put("firstName", "Tejas");
	user3.put("lastName", "Patil");
	user3.put("userName", "Tejas@gmail.com");
	user3.put("email", "TejasPatil");
	JSONObject address3 = new JSONObject();
	address3.put("laneNo", "3/4");
	address3.put("Society", "Jan path");
	address3.put("city", "Delhi");
	user3.put("Address", address3);
	JSONArray user3RelativesArray = new JSONArray();
	user3RelativesArray.add("Neighbour");
	user3RelativesArray.add("Mama");
	user3RelativesArray.add("Kaka");
	user3RelativesArray.add("Daji");
	user3RelativesArray.add("Mami");
	
	user3.put("Relatives",user3RelativesArray);

	JSONArray userList = new JSONArray();
	userList.add(user1);
	userList.add(user2);
	userList.add(user3);
	
	
	FileWriter fw=null;
	try {
		fw = new FileWriter(System.getProperty("user.dir") 
				+ "/src/test/java/rough/JSONSimplePkg/users.json");
		fw.write(userList.toJSONString());
		fw.flush();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
	

}

}
