package seleniumsample;

import jxl.*;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Datadriven {
	
	public WebDriver driver;
	public int i,j;
	@Test(dataProvider ="testdata")
	public void login(String uname, String pwd){
		System.setProperty("webdriver.chrome.driver","C:\\software\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("pass")).sendKeys(pwd);
		driver.findElement(By.id("u_0_r")).click();
		
		driver.close();
	}

 @DataProvider(name="testdata")

	public Object [][] readExcel() throws BiffException, IOException {
		
		File f=new File("C:\\software\\Test.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet(0);
		int rows = s.getRows();
		int columns = s.getColumns();

		System.out.println(rows);
		System.out.println(columns);
	
	String inputdata [][] = new String [rows][columns];
	
	for(int i=0;i<rows;i++)
	{
		for(j=0;j<columns;j++)
		{
			
			Cell c=s.getCell(j,i);
			inputdata[i][j] = c.getContents();
			System.out.println(inputdata[i][j]);
	}
	
	}
	return inputdata;
	
	
	
}
}