package rough;

import java.util.ArrayList;
import java.util.List;

import com.qa.api.gorest.util.TestUtil;

public class Example1POJOConversion {

	List<ColorClass> colorList;

	public List<ColorClass> getColorList() {
		return colorList;
	}

	public void setColorList(List<ColorClass> colorList) {
		this.colorList = colorList;
	}

	public Example1POJOConversion(List<ColorClass> colorList) {
		super();
		this.colorList = colorList;
	}
	public static void main(String[] args) {
		List<ColorClass> cList = new ArrayList<>();
		ColorClass cc1 = new ColorClass("Pink", "100");
		ColorClass cc2 = new ColorClass("White", "200");
		ColorClass cc3 = new ColorClass("Yellow", "300");
		cList.add(cc1);
		cList.add(cc2);
		cList.add(cc3);
		Example1POJOConversion obj = new Example1POJOConversion(cList);
	
		String jsonStr = TestUtil.getSerializedJSON(obj);
		System.out.println("jSonStrin =======> " + jsonStr);
	}
	
	
}
