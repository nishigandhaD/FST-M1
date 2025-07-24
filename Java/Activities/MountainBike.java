package Activites;

public class MountainBike extends Bicycle{
	int seatHeight;
	MountainBike(int gears,int currentSpeed,int seatHeight){
		super( gears , currentSpeed);
		this.seatHeight=seatHeight;
		
	}
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	@Override
	public String bicycleDesc() {
		  return (super.bicycleDesc()+ "\nSeat height is :" + seatHeight);
	}

}
