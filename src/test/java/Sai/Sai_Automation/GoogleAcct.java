package GreeAssign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleAcct {

	WebDriver driver;
	@BeforeTest
	
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("https://accounts.google.com/SignUp?hl=en");
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
		@Test(groups="TextBox")
		public void Gootextbox()
		{
			driver.findElement(By.name("FirstName")).sendKeys("Madhu");
			driver.findElement(By.name("LastName")).sendKeys("Santosh");
			driver.findElement(By.name("GmailAddress")).sendKeys("Santoshsanga22");
			driver.findElement(By.name("Passwd")).sendKeys("Santosh123!@#");
			driver.findElement(By.name("PasswdAgain")).sendKeys("Santosh123!@#");
			driver.findElement(By.name("BirthDay")).sendKeys("01");
			driver.findElement(By.name("BirthYear")).sendKeys("1989");
			driver.findElement(By.name("RecoveryPhoneNumber")).sendKeys("9843222456");
			driver.findElement(By.name("RecoveryEmailAddress")).sendKeys("santoshtdee@gmail.com");
			
		}
/*@Test(groups="DropDown")
		public void GooDrop()
		
		{
	//WebElement Sc1=driver.findElement(By.xpath("//*[@class='goog-inline-block goog-flat-menu-button jfk-select']"));
			Select Sc5=new Select(driver.findElement(By.xpath("//*[@class='goog-inline-block goog-flat-menu-button jfk-select']")));
				//driver.findElement(By.xpath("//div[@class='goog-inline-block goog-flat-menu-button jfk-select'][1]"));
			//Sc1.getOptions();
			System.out.println(Sc5);
		
			Sc5.selectByVisibleText("May");
			
			Select Sc2=new Select(driver.findElement(By.xpath("//div[@class='goog-inline-block goog-flat-menu-button jfk-select']")));
			Sc2.selectByValue("Male");
			Select Sc3=new Select(driver.findElement(By.xpath("//div[@class='goog-inline-block goog-flat-menu-button-caption']")));
			Sc3.selectByValue("India");
			
		}*/
	
}
