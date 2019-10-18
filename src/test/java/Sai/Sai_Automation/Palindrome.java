
public class Palindrome {
public static void main(String[] args)
	
	{
		String rev="RADAR";
		
		
		String rev1="";
		
		for(int i=(rev.length()-1); i>=0; i--)
			
		{
			rev1=rev1+rev.charAt(i);
		}
		
		System.out.println(rev1);
		
		if(rev1.equals(rev))
		{
			System.out.println("The given string is plaindrome");
			
		}
		else
		{
			System.out.println("The given string is not palindrome");
		}
	}


}
