package Activites;

public class Activity4 {

	public static void main(String[] args) {
		int temp=0;
		int arr[]=new int[]{9,11,23,56,78,10,20,5,6}; 
		System.out.println("Before sorting:");
		for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+",");
		}
        for(int i=0;i<arr.length;i++) 
        {
        	for(int j=i;j<arr.length-1;j++) 
        	{
        		
        		if(arr[i]>arr[j+1]) 
        		{
        			temp=arr[i];
        			arr[i]=arr[j+1];
        			arr[j+1]=temp;
        		}
        	}
        	
        }
        System.out.println("\n After sorting:");
        for(int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+",");
		}
	}

}
