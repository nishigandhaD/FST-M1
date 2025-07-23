package Activities;



public class Activity2 {
	
	public static void main(String[] args) {
		int add = 0;
		// TODO Auto-generated method stub
    int arr[]=new int[]{10, 77, 10, 40, -11, 10}; 
    for(int i=0;i<arr.length;i++) 
    {
    	if(arr[i]==10)
    	{
    		add +=arr[i];
    	}
    }
	
	if(add==30) 
	{
		System.out.println("addition is ="+add);
		
	}
	else {
		System.out.println("addition is not equal to 30");
	}
	}
}