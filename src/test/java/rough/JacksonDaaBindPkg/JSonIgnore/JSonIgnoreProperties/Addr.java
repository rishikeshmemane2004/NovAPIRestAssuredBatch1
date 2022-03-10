package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
 
 
@JsonIgnoreProperties(value = {
		"city"
})
//@JsonIgnoreType
public class Addr {

	private String lane;
	private String city;
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Addr(String lane, String city) {
		super();
		this.lane = lane;
		this.city = city;
	}
	public Addr() {
		super();
	}
	
}
