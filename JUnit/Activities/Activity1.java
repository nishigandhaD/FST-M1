package activities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
	static ArrayList<String> list;
	
	@BeforeEach
	void setup() throws Exception{
		// Initialize a new ArrayList
		list = new ArrayList<String>();

		// Add values to the list
		list.add("alpha"); // at index 0
		list.add("beta"); // at index 1
	}
	
	@Test
	public void insertTest() {
		assertEquals(2,list.size(),"list size is wrong");
		list.add("Charlie");
		assertEquals(3,list.size(),"list size is wrong");
		assertEquals("alpha",list.get(0),"wrong element");
		assertEquals("beta",list.get(1),"wrong element");
		assertEquals("Charlie",list.get(2),"wrong element");
	}
	
	@Test
	public void replaceTest() {
		assertEquals(2,list.size(),"list size is wrong");
		list.add("Charlie");
		assertEquals(3,list.size(),"list size is wrong");
		list.set(1, "Renuka");
		assertEquals("alpha",list.get(0),"wrong element");
		assertEquals("Renuka",list.get(1),"wrong element");
	}
	
	

}
