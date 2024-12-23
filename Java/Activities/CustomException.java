package Activites;

public class CustomException extends Exception {

	private String message=null;
	
	CustomException(String message){
		this.message=message;
		//System.out.println(message);
		
		
	}
	@Override
	public String getMessage() {
	    return message;
	}

}
