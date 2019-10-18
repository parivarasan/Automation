package sampleJava;

public class SwappingChar {
	
	public static void main(String[] args)
	{
		String S1="prabhavathi";
		char[] c=S1.toCharArray();
		char temp;
		int len=c.length;
		//for(int i=S1.length()-1;i>=0;i--)
			for(int i=0;i<=S1.length()-1;i++)
		{
				temp=c[i];
			c[i]=c[len-1];
			c[len-1]=temp;
			
			//char a=c;
				}
			System.out.println(String.valueOf(c));

		
	}

}
