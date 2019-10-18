package sampleJava;

public class CountWord {
	
	
	public static void main(String[] args)
	{
		//String s2[]=new s2[];
		String s1="Welcome to learn java program";
		//String s1="prabhavathi";
		String[] s2=s1.split(" ");
		
		int j=0;
		for(int i=0;i<=s2.length-1;i++)
		{
			
			String s3=s2[i];
			System.out.println(s3);
			++j;
			
				
		}
		
		System.out.println(j);
		
		
		
	}
}

