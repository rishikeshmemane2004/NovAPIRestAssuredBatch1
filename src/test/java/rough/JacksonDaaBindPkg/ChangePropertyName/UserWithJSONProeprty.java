package rough.JacksonDaaBindPkg.ChangePropertyName;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWithJSONProeprty {

	@JsonProperty("Id")
	private int id;
	@JsonProperty("First_Name")
	private String firstName;
	@JsonProperty("Last_Name")
	private String lastName;
	@JsonProperty("Full_Name")
	private String fullName;
	
	
	
	public UserWithJSONProeprty() {
		super();
	}
	public UserWithJSONProeprty(int id, String firstName, String lastName, String fullName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
	
}
