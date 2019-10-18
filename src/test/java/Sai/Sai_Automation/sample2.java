package seleniumsample;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

public class sample2{

	
	public static void main(String[] args) throws Exception {
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\U27813\\Downloads\\chromedriver.exe");
       
        //Set the chrome path
        System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
       
 /*     // Create object of ChromeOptions class
        ChromeOptions options = new ChromeOptions();
       
        // add parameter which will disable the extension
        options.addArguments("--disable-extensions");
       
        // Start the chrome session
        WebDriver driver = new ChromeDriver(options); */
       
WebDriver driver = new ChromeDriver();

       
       
       
       
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-extensions");
        //driver = new ChromeDriver(options);
        // Create a new instance of the Firefox driver
        //options.addArguments("--test-type");
       
       
        System.out.println("test");
  //Launch the Online Store Website
       
       
       
       
       
       
        //driver.get("http://www.google.com");
        
        driver.get("http://www.facebook.com");
        driver.findElement(By.id("u_0_r")).click();
        driver.findElement(By.id("email")).sendKeys("prabha_vathi1985@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("sai123");
       driver.findElement(By.id("loginbutton")).click();
       
       String astring = driver.findElement(By.xpath("span[@class='val1ue']")).getText();
       
       System.out.println(astring);
        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.MICROSECONDS);
       // driver.findElement(By.linktext("button")).click();
       
//      driver.findElement(By.xpath(//a[@href ='https://gateway.zscaler.net:443/auD?origurl=https%3A%2F%2Fwww%2ecostco%2ecom%2f&aftrlgn=1&_ordtok=k4Z3WV3bK4VjNqVmrGn2HsqKLP')).click();
        //driver.switchTo().frame(1);1

       
        //driver.findElement(By.name("button")).click();

  // Print a Log In message to the screen
 System.out.println("Successfully opened the website www.costco.com");

        //Wait for 5 Sec
  //Thread.sleep(5);
       
  // Close the driver
 // driver.close();
}
}



 
 
 
