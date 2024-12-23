package Activites;

public class Bicycle implements BicycleOperations,BicycleParts {
 int gears ;
 int currentSpeed ;
	
	Bicycle(int gears,int currentSpeed){
		this.gears=gears;
		this.currentSpeed=currentSpeed;
		
	}

	@Override
	public void applyBrake(int decrement) {
		this.currentSpeed-=decrement;// TODO Auto-generated method stub
		
	}

	@Override
	public void speedUp(int increment) {
		this.currentSpeed+=increment;// TODO Auto-generated method stub
		
	}
	public String bicycleDesc() {
	    return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
	}

}
