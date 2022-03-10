package rough;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("map.isEmpty() : " + map.isEmpty());
		
		if (!(map == null))
			System.out.println("map is null");
		else
			System.out.println("map is NOT null");
				
	}

}
