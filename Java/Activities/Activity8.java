package Activites;

public class Activity8 {

	public static void main(String[] args) {
		 try {
	            Activity8.exceptionTest("Will print to console");
	            Activity8.exceptionTest(null); 
	            Activity8.exceptionTest("Won't execute");
	        } catch(CustomException e) {
	            System.out.println("Inside catch block: " + e.getMessage());
	        }
	    }
	 
	    static void exceptionTest(String msg) throws CustomException {
	        if(msg == null) {
	            throw new CustomException("String value is null");
	        } else {
	            System.out.println(msg);
	        }

	}

}
