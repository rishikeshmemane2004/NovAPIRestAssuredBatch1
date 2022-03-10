package rough;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.annotations.Test;

 

public class example1 {

	@Test
	public void exampleemo() {
		String data = "{ \"ShopId3Digit\": \"ww0\"," + " \"ServerTime\":1426695017191, "
				+ "\"SMSTelephone\":\"2104851130\"," + "\"SendPODAgain\":true," + "\"SendLocationAgain\":true,"
				+ "\"IsHUB\":false," + "\"AllowReceiptsAndDeliveries\":true}";

		// Convert string to JSONObject
		Object obj = JSONValue.parse(data);
		JSONObject jObj = (JSONObject) obj;
		
		System.out.println(jObj.get("ShopId3Digit"));
	}
}
