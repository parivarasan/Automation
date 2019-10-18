package seleniumsample;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


  
 
import java.util.concurrent.TimeUnit;


public class screenshot {
      
	      
	public static void main(String[] args) throws Exception{
	             
	            //  WebDriver driver;
	              System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
	             
	            WebDriver driver=new ChromeDriver();
	              driver.get("http://www.facebook.com");
	              //this.takeSnapShot(driver,"C:\\software");
	              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           // Now you can do whatever you need to do with it, for example copy somewhere
	           FileUtils.copyFile(scrFile, new File("c:\\software\\screenshot.png"));
	             
	       }
	      
}
	      
	        	
	

