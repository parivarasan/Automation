package sampleJava;

public class Countwordanotherway {

	public static void main(String[] args)
	{
		//String s2[]=new s2[];
		String s1="Welcome to learn java program";
		//String s1="prabhavathi";
		//String[] s2=s1;
		
		int j=1;
		for(int i=0;i<=s1.length()-1;i++)
		{
			char c=s1.charAt(i);
			System.out.println(c);
			if(c!='\u0000')
			{
			
			}
			else
			{
				++j;
			}
				
		}
		
		System.out.println(j);
		
		
		
	}

	
}
