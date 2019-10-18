package sampleJava;

public class CountConsonants {

	public static void main(String[] args)
	
	{
		String s1="Prabhavathi";
		int j=0;
				for(int i=0;i<=s1.length()-1;i++)
		{
					char c=s1.charAt(i);

			System.out.println(c);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				
			{
				j++;
			}
		}
		System.out.println(j);
	}
}
