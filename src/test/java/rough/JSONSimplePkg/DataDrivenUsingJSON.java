package rough.JSONSimplePkg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenUsingJSON {
	static int rowNo = 0;
	
	@Test(dataProvider="getData")
	public void CreateUser(String id, String firstName, String lastName,  String email) {
		System.out.println(id + " == " + firstName + " == " + lastName + " == " + email);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data=null;
		
		JSONParser jsonParser = new JSONParser();
		FileReader fr = null;
		try {
			fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/rough/JSONSimplePkg/users.json");
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		}
		
		try {
			Object obj = jsonParser.parse(fr);
			JSONArray userList = (JSONArray) obj;
			System.out.println("size : " + userList.size());
			data= new Object[userList.size()][4];	
			for(int i=0;i<userList.size();i++)
			{
				int col = 0;
				JSONObject user = (JSONObject) userList.get(i);
				String firstName = (String) user.get("firstName");
				String lastName = (String) user.get("lastName");
				String email = (String) user.get("email");
				//long id = (Long) user.get("id");
				//Long id = (Long) user.get("id");
				String id = (String) user.get("id");
				//System.out.println("id==>"+ id + "  firstName:==>" + firstName + "  lastName==>" + lastName + "  email==>"+ email);
				data[i][col++] = id;
				data[i][col++] = firstName;
				data[i][col++] = lastName;
				data[i][col++] = email;
			}
			/*
			 * for(int i=0;i<data.length;i++) { for(int j=0;j<4;j++) System.out.print(" => "
			 * + data[i][j]); System.out.println(); }
			 */
		} catch (IOException | ParseException e) {
 			e.printStackTrace();
		}
	return data;	
	}
}
