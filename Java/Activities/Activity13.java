package activities;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	Random  indexGen = new Random();
	ArrayList<Integer> list=new ArrayList<Integer>();
	System.out.print("Enter an integer: ");
	System.out.println("(non-integer to terminate:) ");
	while(scan.hasNextInt()) {
		list.add(scan.nextInt());
	}
	Integer nums[] = list.toArray(new Integer[0]);
	
	int index=indexGen.nextInt(nums.length);
	System.out.println("Index value generated: " + index);
	System.out.println("Value of the array at the generated index " + nums[index]);
	
	scan.close();
	}

}
