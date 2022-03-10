package rough.JacksonDaaBindPkg.JSonIgnore.JSonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
  
 

public class Addr1 {

	private String lane;
	@JsonIgnore
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
	public Addr1(String lane, String city) {
		super();
		this.lane = lane;
		this.city = city;
	}
	public Addr1() {
		super();
	}
	
}
