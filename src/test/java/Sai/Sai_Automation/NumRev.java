package Pracprogram;

public class NumRev {
	
	private static int Inputnum=11;
	private static int Rev=0;
	
	public static void main(String[] args)
	{
		System.out.println(Inputnum);
		
		while(Inputnum!=0)
		{
			int Reminder=Inputnum % 10;
			Rev=Rev*10+Reminder;
			Inputnum/=10;
			
				
			
		}
		System.out.println(Rev);
		
	}

}
