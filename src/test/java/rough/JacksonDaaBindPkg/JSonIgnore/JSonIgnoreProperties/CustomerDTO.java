package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType  // ignores all fields of this class - currently does not work for this class some how
@JsonIgnoreProperties(      // Ignores the fields mentioned in this JsonIgnoreProperties
value = 
{
	"firstName",
	"id"  
})

public class CustomerDTO {

	
	private String id;
	private String firstName;
	private String lastName;
	private Addr addr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Addr getAddr() {
		return addr;
	}
	public void setAddr(Addr addr) {
		this.addr = addr;
	}
	public CustomerDTO(String id, String firstName, String lastName, Addr addr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addr = addr;
	}
	public CustomerDTO() {
		super();
	}
}
