package Activites;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer, String> colors = new HashMap<Integer, String>();
		colors.put(1,"red");
		colors.put(2,"yellow");
		colors.put(3,"pink");
		colors.put(4,"white");
		colors.put(5,"black");
		System.out.println(colors);
		colors.remove(3);
		System.out.println("After Remove:"+colors);
		if(colors.containsKey("green")) {
			System.out.println("Green color is present in map");
		}
		else {
			System.out.println("Green color is not present");
		}
		System.out.println(colors.size());

	}

}
