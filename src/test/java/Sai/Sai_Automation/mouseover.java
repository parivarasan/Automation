package seleniumsample;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.Chromedriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class mouseover {

	public static void main(String[] args)

	{
		String baseurl = "http://newtours.demoaut.com";
		System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(baseurl);
		
		
		
		
	}
	
	
	
}
