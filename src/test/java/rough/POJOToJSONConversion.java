package rough;

import java.util.ArrayList;
import java.util.List;

import com.qa.api.gorest.util.TestUtil;
/*Expected output
 * json String: {
  "id" : 100,
  "name" : "Amit",
  "email" : "amit@gmail.com",
  "gender" : true,
  "status" : "active",
  "links" : {
    "self" : {
      "href" : "www.amazon.com"
    },
    "edit" : {
      "href" : "www.netflix.com"
    },
    "avatar" : {
      "href" : "www.google.com"
    }
  },
  "countryList" : [ "India", "UK", "USA" ]
}
 */
public class POJOToJSONConversion {

    private int id;
    private String name;
    private String email;
    private boolean gender;
    private String status;
	Links links;
	List<String> countryList;
	
	public POJOToJSONConversion(int id, String name, String email, boolean gender, String status, Links links,
			List<String> countryList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
		this.links = links;
		this.countryList = countryList;
	}
	public List<String> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<String> countryList) {
		this.countryList = countryList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}
	
  public static void main(String[] args) {
		
		Self sf = new Self("www.amazon.com");
		Edit ed = new Edit("www.netflix.com");
		Avatar av = new Avatar("www.google.com");
		
		List<String> countryList = new ArrayList<String>();
		countryList.add("India");
		countryList.add("UK");
		countryList.add("USA");
		
		Links links = new Links(sf,ed,av);
		POJOToJSONConversion newUser = new POJOToJSONConversion(
				100, "Amit", "amit@gmail.com", true, "active", links, countryList);
		
		String jsonStr = TestUtil.getSerializedJSON(newUser);
		System.out.println("json String: " + jsonStr);
	}
	
}











