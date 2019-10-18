package GreeAssign;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demoguru {

	WebDriver driver;
	WebDriverWait wait;
	//HSSFWorkbook workbook;
	//HSSFSheet sheet;
	//HSSFCell cell;

	
	@BeforeClass
	
	public void demodriverInit()
	{
		System.setProperty("webdriver.chrome.driver","C://Users//Home//Downloads//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demoqa.com/");
	}
	
	
	
	public void ReadData() throws IOException
	
	 {
	
	     // Import excel sheet.
	
	     File src=new File("C:\\Users\\Home\\workspace\\GreensTech\\src\\atadri.xls");
	
	      
	
	     // Load the file.
	
	     FileInputStream finput = new FileInputStream(src);
	
	      
	
	     // Load he workbook.
	
	    workbook = new HSSFWorkbook(finput);
	
	      
	
	     // Load the sheet in which data is stored.
	
	     sheet= workbook.getSheetAt(0);
	
	      
	
	     for(int i=1; i&amp;lt;=sheet.getLastRowNum(); i++)
	
	     {
	
	         // Import data for Email.
	
	         cell = sheet.getRow(i).getCell(1);
	
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	
	         driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
	
	          
	
	         // Import data for password.
	
	         cell = sheet.getRow(i).getCell(2);
	
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	
	         driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
	
	                 
	
	        }
	
	  }

	
	
	
	
	
	
	public void demoabtClick() throws InterruptedException
	{
		
	driver.findElement(By.xpath("//*[text()='About us']")).click();
	WebElement WE1=driver.findElement(By.xpath("//*[text()='About us']"));
	String S1=WE1.getText();
	if(S1.equals("About us"))
	{
		System.out.println("About us text is available");
	}
	else
	{
		System.out.println("About us text is available");
	}
	
	driver.findElement(By.xpath("//div[@class='entry-content']")).getText();
	
			
	}
	
	
	

	
	
	
}
