package rough.complexJSONConversion;

import java.util.ArrayList;

import com.qa.api.gorest.util.TestUtil;

public class ObjectClass {
public static void main(String[] args) {
	
	Batter batter1 = new Batter("1","Regular");
	Batter batter2 = new Batter("2","Choco");
	Batter batter3 = new Batter("3","Food");
	ArrayList<Batter> l = new ArrayList<Batter>();
	l.add(batter1);
	l.add(batter2);
	l.add(batter3);
	Batters batters = new Batters(l);
	
	Topping topping1 = new Topping("500","Sugar");
	Topping topping2 = new Topping("600","Mapple");
	ArrayList<Topping> topping = new ArrayList<Topping>();
	topping.add(topping1);
	topping.add(topping2);
	
	
	Root root = new Root("100", "donut", "Cake", 0.55,batters,topping); 
	String str = TestUtil.getSerializedJSON(root);
	System.out.println("str : " + str);
	
	
}
}
