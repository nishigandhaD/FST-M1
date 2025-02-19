package activities;

public class Activity6 {
	public static void main(String[] args) throws InterruptedException{
		Plane plane = new Plane(10);
		plane.onboard("Renuka");
		plane.onboard("Kishore");
		plane.onboard("Nishi");
		plane.onboard("Shreya");
		plane.onboard("Sagar");
		plane.onboard("Gauri");
		System.out.println("Plane take off time: "+plane.takeOff());
		System.out.println("Passengers on the plane while flying: "+plane.getPassengers());
		Thread.sleep(7000);
		plane.land();
		System.out.println("time of plane landed: "+plane.getLastTimeLanded());
		System.out.println("Passengers list on the plane after landing: "+plane.getPassengers());
		
		
		
	}

}
