package rough.JAcksonDataBind;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class ExtendableBean 
{
    public String name;
    private Map<String, String> properties;

    public ExtendableBean(String string) {
 	}

	@JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
