package Activites;

public class Mybook extends Book{
   
	public static void main(String[] args) {
		Mybook newNovel=new Mybook();
		String title="Wonderland";
		newNovel.setTitle(title);
		newNovel.getTitle();
		System.out.println("The title is: " + newNovel.getTitle());
	}

	public void setTitle(String s) {
	    title = s;
	   
	}

	
}
