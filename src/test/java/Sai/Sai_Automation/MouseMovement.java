package Sai.Sai_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
	
	public static void main (String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver.exe");
		WebDriver vdriver = new ChromeDriver();  
		vdriver.get("http://mrbool.com/");
		Actions action = new Actions(vdriver);
		action.moveToElement(vdriver.findElement(By.className("menulink"))).build().perform();
		Thread.sleep(3000);
		vdriver.findElement(By.xpath("//ul[@class='submenu']//li/a[text()='Articles']")).click();
		
	}
}
