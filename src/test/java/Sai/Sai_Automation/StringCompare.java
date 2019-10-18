package sampleJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class StringCompare {
	
	public static void main(String[] args) throws Exception
	{
		FileReader fr=new FileReader("C:/Users/user/Downloads/fileread.txt");
		BufferedReader br=new BufferedReader(fr);
		//String[] S2=new String[];
		String str=" ";
		int a=0;
		String S1=" ";
		
		while((str=br.readLine())!=null)
		{
			 S1 = str;
		}
		
		System.out.println(S1);
		
		StringTokenizer st=new StringTokenizer(S1);
		while(st.hasMoreTokens())
		{
		String s=st.nextToken();
		System.out.println(s.trim());
		if(s.equals("hello"))
		//if(s.trim()=="hello")
		{
			System.out.println(s);
			a++;
		}
		}
		
		System.out.println(a);
	}

}
