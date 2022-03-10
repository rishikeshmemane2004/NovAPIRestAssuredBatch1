package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

 

public class CustomerDTO1 {

	
	private String id;
	private String firstName;
	@JsonIgnore
	private String lastName;
	private Addr1 addr1;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JsonInclude(Include.NON_NULL)
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
	public Addr1 getAddr() {
		return addr1;
	}
	public void setAddr(Addr1 addr1) {
		this.addr1 = addr1;
	}
	public CustomerDTO1(String id, String firstName, String lastName, Addr1 addr1) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr1 = addr1;
	}
	public CustomerDTO1() {
		super();
	}
}
