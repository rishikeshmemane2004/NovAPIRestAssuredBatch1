package rough.JSONSimplePkg;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class ReadJSonIntoObject {

	static int recNo=1;
	
	@Test
	public void ReadJSonDemo() {
		JSONParser jsonParser = new JSONParser();
		
		FileReader fr = null;
		try {
			fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/rough/JSONSimplePkg/users.json");
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}

		try {
				Object obj = jsonParser.parse(fr);
				JSONArray userList = (JSONArray) obj;
				
				userList.forEach(user -> parseUserObject((JSONObject) user));
		} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private static void parseUserObject(JSONObject user) {

		System.out.println("============== RecNo :" + recNo++);
     	long id = (Long) user.get("id");
		System.out.println(id);
		// Or
		//Object id = user.get("id");
		//System.out.println(id.toString());
	

        // Get user first name
        String firstName = (String) user.get("firstName");
        System.out.println(firstName);

        // Get user last name
        String lastName = (String) user.get("lastName");
        System.out.println(lastName);

        // Get user website name
        String userName = (String) user.get("userName");
        System.out.println(userName);

        // Get user email name
        String email = (String) user.get("email");
        System.out.println(email);
    
        // Get user email name
        Object address =  user.get("Address");
        System.out.println(address); 
        
        JSONObject addr =  (JSONObject) address;
        System.out.println("Lane no: " + addr.get("laneNo"));
        System.out.println("Society: " + addr.get("Society"));
        System.out.println("city   : " + addr.get("city"));
        
        
        JSONArray relatives = (JSONArray) user.get("Relatives");
        for(int i=0;i<relatives.size();i++)
        	System.out.println("relatives.get(" + i + "): " +relatives.get(i));
 	}
}



























