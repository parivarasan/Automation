package GreeAssign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;



public class GroupsTC {

	
	WebDriver driver;
	@BeforeClass
	public void DriveInat(){
		System.setProperty("webdriver.chrome.driver","C://Users//user//Downloads//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.demoqa.com/");
	}
		
		@Test(priority=1,groups="TextBox")
		
		public void Textbox() throws InterruptedException
		{
		driver.findElement(By.xpath("//li[@class='menu-item menu-item-type-post_type menu-item-object-page menu-item-374']")).click();
			
			driver.findElement(By.xpath("//li[@id='menu-item-374']")).click();
			WebElement WE1=driver.findElement(By.name("first_name"));
		WE1.sendKeys("Raji");
		String WG1=WE1.getAttribute("value");
		System.out.println(WG1);
			WebElement WE2=driver.findElement(By.name("last_name"));
					WE2.sendKeys("siva");
			String WG2=WE2.getAttribute("value");
			System.out.println(WG2);
			WebElement WE3=driver.findElement(By.name("phone_9"));
					WE3.sendKeys("9840637967");
			String WG3=WE3.getAttribute("value");
			System.out.println(WG3);
			WebElement WE4=driver.findElement(By.id("username"));
					WE4.sendKeys("prabha4");
			String WG4=WE4.getAttribute("value");
			System.out.println(WG4);
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			WebElement WE5=driver.findElement(By.name("e_mail"));
					WE5.sendKeys("prabhavathimunuswamy3@gmail.com");
					String WG5=WE5.getAttribute("value");
					System.out.println(WG5);
	WebElement WE6=driver.findElement(By.id("description"));
	WE6.sendKeys("Selenium automation");
	String WG6=WE6.getAttribute("value");
	System.out.println(WG6);
	WebElement WE7=driver.findElement(By.id("password_2"));
	WE7.sendKeys("sai123!@#");
	String WG7=WE7.getAttribute("value");
	System.out.println(WG7);
	WebElement WE8=driver.findElement(By.id("confirm_password_password_2"));
	WE8.sendKeys("sai123!@#");
	String WG8=WE8.getAttribute("value");
	System.out.println(WG8);
	if((WG1.equals("Raji")) && (WG2.equals("siva")) && (WG3.equals("9840637967")) && (WG4.equals("prabha4")) && (WG5.equals("prabhavathimunuswamy3@gmail.com")) && (WG6.equals("Selenium automation")) && (WG7.equals("sai123!@#")) && (WG8.equals("sai123!@#")))
	{
		System.out.println("All given inputs are matched with expected input");
	}
	else
	{
		
		System.out.println("All given inputs are not matched with expected input");
		}
		}
		@Test(priority=2,groups="Optionbutton")
		public void Optionbt()
		{
			driver.findElement(By.name("radio_4[]")).click();
			
		}
		
		@Test(priority=3,groups="CheckBox")
		public void Chkboxbt()
		{
			driver.findElement(By.name("checkbox_5[]")).click();
			
		}
		

		

	@Test(priority=4)
	public void Submit()
	{
		driver.findElement(By.name("pie_submit")).click();
	}

	
}
