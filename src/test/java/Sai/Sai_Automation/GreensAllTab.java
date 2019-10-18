package GreeAssign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;




public class GreensAllTab {

	
	WebDriver driver;
	@BeforeClass
	
	public void DriverInit()
	{
		
		System.setProperty("webdriver.gecko.driver", "C://Users//user//Downloads");
		
		driver=new FirefoxDriver();
	
		driver.get("http://www.greenstechnologys.com/");
	}
	@Test	
	public void HomeClick() throws InterruptedException
	{
		
	driver.findElement(By.xpath("//*[@class='activeLink']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");
	WebElement WE1=driver.findElement(By.xpath("//*[text()='contact@greenstechnologys.com']"));
	String email=WE1.getText();
			//WE1.getAttribute("value");
			System.out.println(email);
	}
	@Test	
	public void AboutClick() throws InterruptedException
	{
		
	driver.findElement(By.xpath("//*[text()='ABOUT US']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");
	String S1="We differentiate ourselves by involving professional technical consultants and trainers in the recruitment process like screening, assessing and interviewing candidates, hence delivering most precise and perfect match to your technical requirements. Our technical consultants are Consultants and Developers that have more than eight many years of professional hands on experience in designing and developing applications utilizing Java, .Net and Databases related technologies. This enables them to work with, and advice, both clients and candidates in all areas of the IT place.";
	
	int i=S1.indexOf("We differentiate");
	System.out.println(i);
	String x=S1.substring(i, S1.length()-1);
	System.out.println(x);
	//WebElement WE2=driver.findElement(By.xpath("//div[@id='article-wrapper']"));
		//	String para=WE2.getText();
			//System.out.println(para);
	}
	
	@Test	
	public void CourseClick()
	{
		
	WebElement WE1=driver.findElement(By.xpath("//*[text()='COURSES']"));
	Actions Ac1=new Actions(driver);
	Ac1.moveToElement(WE1).build().perform();
	
		WebElement WE2=driver.findElement(By.xpath("//*[text()='Software Testing Training']"));
	
	//Actions Ac2=new Actions(driver);
	Ac1.moveToElement(WE2).build().perform();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement WE3=driver.findElement(By.xpath("//*[text()='Selenium Training']"));
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WE3.click();
JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");
	
	String S4="Greens Technology provides Selenium training in Chennai to freshers and Working professionals. Learn Software Testing course from the Best Selenium Training Institute in Chennai with the most experienced trainers in the field. Awarded as the Best Selenium Training Center in Chennai - We Guarantee Your Selenium Automation Testing Training Success in Chennai.";
	int i4=S4.indexOf("Greens Technology");
	System.out.println(i4);
	String x4=S4.substring(i4, S4.length()-1);
	System.out.println(x4);
	
	
	//driver.findElement(By.xpath("//div[@id='content-wrapper']")).getText();
			
	}
	@Test
	public void CarriersClick()
	{
		
driver.findElement(By.xpath("//*[text()='CAREERS']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");
	
WebElement WE4=driver.findElement(By.xpath("//span[@class='testimonial-name']"));
			String para1=WE4.getText();
			System.out.println(para1);
	}
@Test
	public void TestimonialClick()
	{
		
	driver.findElement(By.xpath("//*[text()='TESTIMONIALS']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1000)", "");
	
	String S2="Thank you very much for your help and further help needed. and my special thanks to Mr. Sandeep";
	
	int i1=S2.indexOf("Thank you");
	System.out.println(i1);
	String x1=S2.substring(i1, S2.length()-1);
	System.out.println(x1);
	
	
	//WebElement WE5=driver.findElement(By.xpath("//span[@class='testimonial-name']"));
		//	String para2=WE5.getText();
			//System.out.println(para2);
	}
@Test
	public void ContactClick()
	{
		
	driver.findElement(By.xpath("//*[text()='CONTACT US']")).click();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
String S3="PS:We assure that traveling 10 - 15mins additionally will lead you to the best training institute which is worthy of your money and career.";
	
	int i2=S3.indexOf("PS:We");
	System.out.println(i2);
	String x2=S3.substring(i2, S3.length()-1);
	System.out.println(x2);
	
	//driver.findElement(By.xpath("//span[@class='testimonial-name']")).getText();
	

	}
	
	@AfterClass
	public void AfterClass()
	{
		driver.quit();
	}

	
	
	
	

	
	
}
