package Activities;

public class car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public car(int tyres,int doors){
		this.doors=doors;
		this.tyres=tyres;
		
	}
		void displayCharacteristics(){
		System.out.println("color:"+this.color);
		System.out.println("transmission:"+this.transmission);
		System.out.println("make:"+this.make);
		System.out.println("tyres:"+this.tyres);
		System.out.println("doors:"+this.doors);
		
	}
	void accelarate(){
		System.out.println("Car is moving forward.");
	}
	void brake() {
		
		System.out.println("Car has stopped.");
	}
}
