package sampleJava;

import java.util.Scanner;

public class Swappingnumbers {
	
	public static void main(String[] args)
	{
		int c=0;
		Scanner S1=new Scanner(System.in);
		System.out.println("Enter Input number");
		int a=S1.nextInt();
		System.out.println("Enter Input number");
		int b=S1.nextInt();
		
		c=a;
		a=b;
		b=c;
		
		System.out.println(c);
		System.out.println(a);
		System.out.println(b);
	}

}
