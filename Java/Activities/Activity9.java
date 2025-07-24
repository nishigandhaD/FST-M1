package Activites;

import java.util.ArrayList;


public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList= new ArrayList<String>();
		myList.add("raj");
		myList.add("aman");
		myList.add("karan");
		myList.add("ram");
		myList.add("abhi");// TODO Auto-generated method stub
      for(String name:myList) {
    	  System.out.println(name);
      }
      System.out.println("3rd name in arraylist:"+myList.get(3));
      if(myList.contains("ram")) {
    	  System.out.println("ram is present in list");
      }
      else {
    	  System.out.println("ram is not present in list");
      }
      System.out.println("Size of array list :"+myList.size());
      myList.remove("karan");
      System.out.println(myList);
      System.out.println("Updated size of list:"+myList.size());
	}

}
