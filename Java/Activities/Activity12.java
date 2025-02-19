package activities;

public class Activity12 {
	public static void main(String[] args) {
	Addable ad1 = (num1,num2) -> num1+num2;
	System.out.println("ad1: "+ ad1.add(20,30));
	
	Addable ad2 = (num1,num2) ->{
		return (num1+num2);
	};
	System.out.println("ad2: "+ ad2.add(10,20));
	}
	
}
