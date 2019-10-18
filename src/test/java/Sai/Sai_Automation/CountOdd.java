package sampleJava;

import java.util.Scanner;

public class CountOdd { 
	
	public static void main(String[] args)
	
	{
		Scanner S1=new Scanner(System.in);
		System.out.println("Enter number of input");
		int S2=S1.nextInt();
		int[] a1=new int[S2];
		int j=0;
		
		
		for(int i=1;i<=a1.length;i++)
		{
			if(i % 2 == 1)
			{
				j++;
			}
		}
		
		
		System.out.println(j);
	}

}
