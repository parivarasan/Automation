import java.util.*;

public class Looping {

public static void main(String[] args){
		
		String n,rev="";
		
		n="SELENIUM";
		
		int n1=n.length();
		
		for(int i=n1-1; i>=0; i--)
			
		{
			
			rev = rev+ n.charAt(i);
			
		}
		
		System.out.println(rev);
		
	}
	
	
	
}
