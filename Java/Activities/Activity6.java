package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        
        Plane plane = new Plane(10);
       
        plane.onboard("Amu");
        plane.onboard("Sunita");
        plane.onboard("Anuja");
        
        System.out.println("Plane took off at: " + plane.takeOff());
        
        System.out.println("People on the plane: " + plane.getPassengers());
        
        Thread.sleep(5000);
        
        plane.land();
        
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}