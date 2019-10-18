package sampleJava;

import java.util.Scanner;

public class Fabonosis {

	public static void main(String[] args)
	{
		Scanner S1=new Scanner(System.in);
		System.out.println("Enter number of input");
		int S2=S1.nextInt();
		int[] S3=new int[S2];
		int n=0;
		for(int i=0;i<=S3.length;i++)
		{
			n=n+i;
		}
		
		System.out.println(n);
		
	}
	
}
