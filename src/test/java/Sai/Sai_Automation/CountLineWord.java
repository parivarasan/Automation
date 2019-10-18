package sampleJava;

import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.util.StringTokenizer;

public class CountLineWord {
	
	public static void main(String[] args) throws Exception
	{
		FileReader fr=new FileReader("C:/Users/user/Downloads/fileread.txt");
		BufferedReader br=new BufferedReader(fr);
		String line=" ";
		String str=" ";
		int a=0;
		int b=0;
		
		while((line=br.readLine()) !=null)
		{
			str +=line + " ";
			a++;
		}
		System.out.println("Total lines" + a);
		
		System.out.println(str);
		
		StringTokenizer st=new StringTokenizer(str);
		while(st.hasMoreTokens())
		{
			String s=st.nextToken();
			
			b++;
		}
		
		System.out.println(b);
	}
	
	}
