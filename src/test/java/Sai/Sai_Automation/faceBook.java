package GreeAssign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class faceBook {
	WebDriver driver;

	@BeforeTest
	public void DriveIn() {
		System.setProperty("webdriver.chrome.driver", "src/GreeAssign/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@Test(groups = "Textbox")
	public void facetextbox() {
		driver.findElement(By.name("email")).sendKeys("raji_1985@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("1234567");
		driver.findElement(By.id("u_0_5")).click();
	}

}
