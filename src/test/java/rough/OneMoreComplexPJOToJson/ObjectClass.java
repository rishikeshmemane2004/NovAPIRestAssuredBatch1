package rough.OneMoreComplexPJOToJson;

import java.util.ArrayList;

import com.qa.api.gorest.util.TestUtil;

public class ObjectClass {
public static void main(String[] args) {
	
	//define root2 now
	Batter batter1_1 = new Batter("1","Regular");
	Batter batter2_1 = new Batter("2","Choco");
	Batter batter3_1 = new Batter("3","Food");
	ArrayList<Batter> l_1 = new ArrayList<Batter>();
	l_1.add(batter1_1);
	l_1.add(batter2_1);
	l_1.add(batter3_1);
	Batters batters_1 = new Batters(l_1);
	
	Topping topping1_1 = new Topping("500","Sugar");
	Topping topping2_1 = new Topping("600","Mapple");
	ArrayList<Topping> topping_1 = new ArrayList<Topping>();
	topping_1.add(topping1_1);
	topping_1.add(topping2_1);
	
	Root root1 = new Root("100", "donut", "Cake", 0.55,batters_1,topping_1); 
	
	//define root2 now
	Batter batter1_2 = new Batter("1","Regular");
	Batter batter2_2 = new Batter("2","Choco");
	Batter batter3_3 = new Batter("3","Food");
	ArrayList<Batter> l_2 = new ArrayList<Batter>();
	l_2.add(batter1_1);
	l_2.add(batter2_2);
	l_2.add(batter3_3);
	Batters batters_2 = new Batters(l_2);
	
	Topping topping1_2 = new Topping("500","Sugar");
	Topping topping2_2 = new Topping("600","Mapple");
	ArrayList<Topping> topping_2 = new ArrayList<Topping>();
	topping_2.add(topping1_2);
	topping_2.add(topping2_2);
	
	Root root2 = new Root("100", "donut", "Cake", 0.55,batters_1,topping_2); 
	
 	ArrayList<Root> mr = new ArrayList<Root>();
	mr.add(root1);
	mr.add(root2);
		
	String str = TestUtil.getSerializedJSON(mr);
	System.out.println("str : " + str);
	
	
}
}
