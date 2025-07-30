package Activites;


import java.util.HashSet;

public class Activity10 {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<String>();
		hs.add("neha");
		hs.add("siya");
		hs.add("piya");
		hs.add("riya");
		hs.add("diya");
		hs.add("jiya");
		//System.out.println(hs);
		System.out.println(hs.size());
		hs.remove("diya");
		System.out.println("After Remove :"+hs);
		//remove element which is not present in set
		hs.remove("Maya");
		if(hs.contains("piya")) {
			System.out.println("piya is present in set");
		}
		else {
			System.out.println("piya is not present in set");
		}
		System.out.println("Updated set:"+hs);
	}

}
