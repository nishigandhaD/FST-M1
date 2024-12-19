package Activites;

public class Car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	 Car() {
		this.tyres=4;
		this.doors=4;
		
	}
	public void displayCharacteristics() {
		
		System.out.println("Car Color is "+ this.color);
		System.out.println("Car Transmission is "+ this.transmission);
		System.out.println("Car make is "+ this.make);
		System.out.println("Car tyres is "+ this.tyres);
		System.out.println("Car doors is "+ this.doors);
	}
	public void accelarate() {
		System.out.println("Car is moving forward.");
	}
	public void brake() {
		System.out.println("Car has stopped.");
		
		
	}
}
