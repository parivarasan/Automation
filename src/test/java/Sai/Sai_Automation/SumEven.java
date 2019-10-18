package sampleJava;

import java.util.Scanner;

public class SumEven {
	
	

	public static void main(String[] args)
	{
		int k=0;
		Scanner S1=new Scanner(System.in);
		System.out.println("Enter number of input");
		int S2=S1.nextInt();
		int[] S3=new int[S2];
		
		for(int i=1;i<=S3.length;i++)
		{
			
			
			if(i % 2 == 0)
			{
				k=k+i;
			}
		}  
		
		System.out.println(k);
	}

}
