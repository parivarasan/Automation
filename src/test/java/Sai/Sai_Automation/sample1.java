package seleniumsample;
import org.openqa.selenium.WebDriver;

 
import org.openqa.selenium.chrome.ChromeDriver;








public class sample1 {

	public static void main(String[] args)
	{
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver dr1 = new ChromeDriver();
	
	 	dr1.navigate("http://www.Amazon.com");
	System.out.println("Successfully opened the website www.Store.Demoqa.com");
	}
	
	
	
}
