package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.relevantcodes.extentreports.LogStatus;

//import org.apache.poi.xssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;

public class ReadDatafromExcel extends FunctionalLibrary {
	private static int testRow;
	private static int testCol;
	private static int c;
	public static HashMap<String, String> storeValues = new HashMap<String, String>();

	public static List<HashMap<String, String>> data(String filepath, String sheetName) {
		List<HashMap<String, String>> mydata = new ArrayList<>();
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			
			
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
					
					Cell currentCell = currentRow.getCell(j);
					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
						break;
					}
				}
				mydata.add(currentHash);
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mydata;
	}
	
	
	public static void writeToExcel(String filePath,String sheetName,String[] dataToWrite) {
		
		try{
	        FileInputStream fs = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(fs);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	        Row row = sheet.getRow(0);
	        Row newRow = sheet.createRow(rowCount+1);
	        
	        for(int j = 0; j < row.getLastCellNum(); j++){
	            Cell cell = newRow.createCell(j);
	            cell.setCellValue(dataToWrite[j]);
	        }
	            fs.close();
	            FileOutputStream outputStream = new FileOutputStream(filePath);
	            workbook.write(outputStream);
	            outputStream.close();
	        
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Integer> rowColNum(String filepath, String sheetName,String colName) {
        
        ArrayList<Integer> colRow = new ArrayList<Integer>();
        
        try {
               FileInputStream fs = new FileInputStream(filepath);
               XSSFWorkbook workbook = new XSSFWorkbook(fs);
               XSSFSheet sheet = workbook.getSheet(sheetName);
               
               //Get the Ordernumber column, from the first row
               Row getOrderrow = sheet.getRow(0);
                          
               for (int j = 0; j < getOrderrow.getPhysicalNumberOfCells(); j++) {
                      Cell currentCell = getOrderrow.getCell(j);
                     if(currentCell.getStringCellValue().equalsIgnoreCase(colName))
                     {
                            colRow.add(currentCell.getColumnIndex());
                            break;
                     }
               }      
                         
               
               //Search for each row,and get the row which has no order number 
               if(colRow.size() == 1)
               {
	               for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
	                       Row currentRow = sheet.getRow(i);
	                       Cell currentCelll = currentRow.getCell(colRow.get(0));
	                       
	                       if(currentCelll.getStringCellValue().isEmpty() || currentCelll.getStringCellValue() == null)
	                       {
	                              colRow.add(i);      
	                              break;
	                       }                                                                    
	                     
	               }
               }
               
               fs.close();                
               return colRow;      
        } catch (Exception e) {
               e.printStackTrace();
        }
        return colRow;
 }
		
	public static void updateExcel(String filepath, String sheetName, int rowNum, int colNum,String columnValue) {
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);		
			Cell cell = null;
			cell = sheet.getRow(rowNum).getCell(colNum);
            cell.setCellValue(columnValue);
            fs.close();
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            outputStream.close();
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public static void readdata(String filepath, String sheetName,WebElement element1,WebElement element2,WebElement element3,WebElement element4) throws Exception {
		List<HashMap<String, String>> mydata = new ArrayList<>();
	try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			int a=sheet.getPhysicalNumberOfRows();
			
			if(a>0)
			{
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				//HashMap<String, String> currentHash = new HashMap<String, String>();
				//int b=currentRow.getLastCellNum();
				//for (int j = 0; j < currentRow.getLastCellNum(); j++) {
					//.getPhysicalNumberOfCells()
					
					Cell currentCell = currentRow.getCell(0);
					String Cellvalue=currentCell.getStringCellValue();
					System.out.println(Cellvalue);
					element1.sendKeys(Cellvalue.trim());
					//FunctionalLibrary.MoveToElementAndClick(element2);
					//FunctionalLibrary.click(element2, "Search submit");
					FunctionalLibrary.MoveToElementAndClick(element2);
					FunctionalLibrary.jsWaitForPageLoad();
					FunctionalLibrary.implicitWait(20);
					//FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitFor(2000);
					FunctionalLibrary.click(element4, "Add to cart button");
					
					FunctionalLibrary.waitFor(7000);
					//FunctionalLibrary.click(element6, "View Cart button");
					//}
					Reports.logPassedStep(LogStatus.PASS,"Product Added","'"+i+"' products are added to cart",false);		
				}
			}
			
			else
			{
				Reports.logStep(LogStatus.FAIL,"No Data","There is no data in data sheet",true);
			}
			
			//fs.close();	
			}
		//	return mydata;
			
		 catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void singlecolumnread(String filepath, String sheetName,WebElement element1,WebElement element2) throws Exception {
		List<HashMap<String, String>> mydata = new ArrayList<>();
	try {
		    SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			int a=sheet.getPhysicalNumberOfRows();
			
			if(a>0)
			{
				//Get serial number value from serial number page
			for(int j=0; j<HeaderRow.getPhysicalNumberOfCells();j++)	{
				
				Cell serialCell = HeaderRow.getCell(j);
				if(serialCell.getStringCellValue().equals("serial_number"))
					{
				
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					
					Row currentRow = sheet.getRow(i);
					Cell currentCell = currentRow.getCell(j);
					//System.out.println(currentRow.getCell(j));
					String Cellvalue=currentCell.getStringCellValue();
					//System.out.println(Cellvalue);
					element1.sendKeys(Cellvalue.trim());
					//FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitForElementvisibility(element2);
					FunctionalLibrary.waitFor(1000);
					FunctionalLibrary.click(element2, "Search button");
					FunctionalLibrary.waitFor(1500);
					element1.clear();
					
					FunctionalLibrary.waitFor(15000);
					
					//Compare warranty details from warranty detail page
					
					WebElement wtSerno=FunctionalLibrary.driver.findElement(By.xpath("//table[@class='d-none d-lg-table table table-desktop mt-5']//tbody/tr/td[1]"));
					WebElement wtCovtype=FunctionalLibrary.driver.findElement(By.xpath("//table[@class='d-none d-lg-table table table-desktop mt-5']//tbody/tr/td[6]"));
					WebElement wtShipdt=FunctionalLibrary.driver.findElement(By.xpath("//table[@class='d-none d-lg-table table table-desktop mt-5']//tbody/tr/td[4]"));
					WebElement wtStartdt=FunctionalLibrary.driver.findElement(By.xpath("//table[@class='d-none d-lg-table table table-desktop mt-5']//tbody/tr/td[7]"));
					WebElement wtEnddt=FunctionalLibrary.driver.findElement(By.xpath("//table[@class='d-none d-lg-table table table-desktop mt-5']//tbody/tr/td[8]"));
					
					
					String SerNumber=FunctionalLibrary.getTextNew(wtSerno);
					String Coveragetype=FunctionalLibrary.getTextNew(wtCovtype);
					//System.out.println(Coveragetype);
					String Shipdate=FunctionalLibrary.getTextNew(wtShipdt);
					//System.out.println(Shipdate);
					String CStartdt=FunctionalLibrary.getTextNew(wtStartdt);
					String CEnddt=FunctionalLibrary.getTextNew(wtEnddt);
					int b=currentRow.getPhysicalNumberOfCells();
					//System.out.println(b);
					Warranty:
					for(int k=1;k<HeaderRow.getPhysicalNumberOfCells();k++) {
						Cell serialCell1 = HeaderRow.getCell(k);
						
						
					if(serialCell1.getStringCellValue().trim().equals("serial_number"))	{
							
							Cell currentCell1 = currentRow.getCell(k);
							String Cellvalue1=currentCell1.getStringCellValue();
							//System.out.println(Cellvalue1);
							if(Cellvalue1.equals(SerNumber)){
								//Reports.logPassedStep(LogStatus.PASS,"SerialNumber: ","" +SerNumber+" Matched",false);
								Reports.logPassedStep(LogStatus.PASS,"SerialNumber","Serial Number is matched");
								
							}
							else
							{
								Reports.logStep(LogStatus.FAIL,"SerialNumber ","" +SerNumber+" Not Matched",true);	
							}
								
					}	
					
				else if(serialCell1.getStringCellValue().trim().equals("contract_type"))	{
						
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						System.out.println(Cellvalue1);
						if(Cellvalue1.equals(Coveragetype)){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"Contract Type","Contract type is matched");
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"Contract Type ","" +Coveragetype+" Not Matched",true);	
						}
								
					}	
							
					else if(serialCell1.getStringCellValue().trim().equals("ship_dt"))	{
						
							Cell currentCell3 = currentRow.getCell(k);
							
							String Celllvalue3=sdf.format(currentCell3.getDateCellValue());
							System.out.println(Celllvalue3);
							if(Celllvalue3.equals(Shipdate)){
								//Reports.logPassedStep(LogStatus.PASS,"Ship Date: ","" +Shipdate+" Matched",false);
								Reports.logPassedStep(LogStatus.PASS,"Ship Date","Ship date is matched");
								
							}
							else
							{
								Reports.logStep(LogStatus.FAIL,"Ship Date ","" +Shipdate+" Not Matched",true);	
							}
							
					}	
					else if(serialCell1.getStringCellValue().trim().equals("coverage_start_dt"))	{
							Cell currentCell4 = currentRow.getCell(k);
							
							String Celllvalue4=sdf.format(currentCell4.getDateCellValue());
							
							System.out.println(Celllvalue4);
							if(Celllvalue4.equals(CStartdt)){
								//Reports.logPassedStep(LogStatus.PASS,"Coverage start Date: ","" +CStartdt+" Matched",false);
								Reports.logPassedStep(LogStatus.PASS,"Coverage start Date","Coverage start date is matched");
								
							}
							else
							{
								Reports.logStep(LogStatus.FAIL,"Coverage start Date ","" +CStartdt+" Not Matched",true);	
							}
							
					}		
					else if(serialCell1.getStringCellValue().trim().equals("coverage_end_dt"))	{
							Cell currentCell5 = currentRow.getCell(k);
							String Celllvalue5=sdf.format(currentCell5.getDateCellValue());
							System.out.println(Celllvalue5);
							if(Celllvalue5.equals(CEnddt)){
								//Reports.logPassedStep(LogStatus.PASS,"Coverage End Date: ","" +CEnddt+" Matched",false);
								Reports.logPassedStep(LogStatus.PASS,"Coverage End Date","Coverage End date is matched",false);
								
								
							}
							else
							{
								Reports.logStep(LogStatus.FAIL,"Coverage End Date ","" +CEnddt+" Not Matched",true);	
							}
							
							
					}	
							
					}			
							
							
						
					//}
					
				}
					}
			}
			}
			
			//		Reports.logPassedStep(LogStatus.PASS,"SerialNumber","'"+i+"' Serial Number verified",false);		
		//	}
			
						
			//}
			
			else
			{
				Reports.logStep(LogStatus.FAIL,"No Data","There is no data in data sheet",true);
			}
			
			fs.close();	
			}
		//	return mydata;
			
		 catch (Exception e) {
			 Reports.logStep(LogStatus.FAIL,"Warranty details","Unable to verify warranty details",true);
		}
		
	}
	
	public static void PDPreaddata(String filepath, String sheetName,WebElement element1,WebElement element2,WebElement element3) throws Exception {
//		List<HashMap<String, String>> mydata = new ArrayList<>();
		//ArrayList<Integer> colRow = ReadDatafromExcel.rowColNum("src/test/resources/testdata/ProductsList.xlsx","PDPvalidation","DT_Thumbnail_Count");
		//testCol = colRow.get(0);
			
		
	try {
		JavascriptExecutor js=(JavascriptExecutor) FunctionalLibrary.driver;
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			c=sheet.getPhysicalNumberOfRows();
			System.out.println(c);
			
			if(c>0)
			{
				//Get serial number value from serial number page
			
				
			
			for(int j=0; j<HeaderRow.getPhysicalNumberOfCells();j++)	{
				Cell serialCell = HeaderRow.getCell(j);
				//Rajani testRow = colRow.get(j+1);
				
				
			if(serialCell.getStringCellValue().equals("Item Number"))
					{
				
				for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
					
					Row currentRow = sheet.getRow(i);
					
				
					
					
					Cell currentCell = currentRow.getCell(j);
					//System.out.println(currentRow.getCell(j));
					String Cellvalue=currentCell.getStringCellValue();
					//System.out.println(Cellvalue);
					element1.sendKeys(Cellvalue.trim());
					//FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.MoveToElementAndClick(element2);
					FunctionalLibrary.jsWaitForPageLoad();
					FunctionalLibrary.implicitWait(10);
					FunctionalLibrary.waitForElementvisibility(element3);
					//FunctionalLibrary.waitFor(1000);
					
					
					FunctionalLibrary.waitFor(1000);
					
					//Compare warranty details from warranty detail page
					
					WebElement itemCode=FunctionalLibrary.driver.findElement(By.xpath("(//legend/span)[5]"));
					WebElement itemDesc=FunctionalLibrary.driver.findElement(By.xpath("(//legend/span)[6]"));
					
					
					
					String itemCodetxt=FunctionalLibrary.getTextNew(itemCode);
					String itemDesctxt=FunctionalLibrary.getTextNew(itemDesc);
					//String Infospectxt=FunctionalLibrary.driver.findElement(By.xpath("(//*[@class='product-long-description']/p)[1]")).getText();
					//System.out.println(Coveragetype);
					int b=currentRow.getPhysicalNumberOfCells();
					//System.out.println(b);
					Pdbvalidate:
					for(int k=0;k<HeaderRow.getPhysicalNumberOfCells();k++) {
						 Cell PDPval = HeaderRow.getCell(k);
						
						
					if(PDPval.getStringCellValue().trim().equals("Item Number"))	{
							
							Cell currentCell1 = currentRow.getCell(k);
							String Cellvalue1=currentCell1.getStringCellValue();
							//System.out.println(Cellvalue1);
							if(Cellvalue1.equals(itemCodetxt)){
								//Reports.logPassedStep(LogStatus.PASS,"SerialNumber: ","" +SerNumber+" Matched",false);
								Reports.logPassedStep(LogStatus.PASS,"'Item Code'-" +Cellvalue1+"","" +itemCodetxt+" is matched successfully with product");
								
							}
							else
							{
								Reports.logStep(LogStatus.FAIL,"'Item Code'-" +Cellvalue1+"","" +itemCodetxt+" Not Matched with product",true);	
							}
								
					}	
					
					
					
					else if(PDPval.getStringCellValue().trim().equals("Item Description"))	{
						
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						//System.out.println(Cellvalue1);
						if(Cellvalue1.equals(itemDesctxt)){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"'Item Description-'" +Cellvalue1+"","" +itemDesctxt+" is matched Successfully with product");
							
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"'Item Description-'" +Cellvalue1+"","" +itemDesctxt+" Not Matched with product",true);	
						}
						
							
					}	
					
					
					
					else if(PDPval.getStringCellValue().trim().equals("Infospec"))	{
						js.executeScript("window.scrollBy(0,700)");
						FunctionalLibrary.waitFor(1000);
						WebElement Infospectab=FunctionalLibrary.driver.findElement(By.xpath("//a[text()='Info and Specifications']"));
						Infospectab.click();
						FunctionalLibrary.waitFor(1000);
						String Infospectxt=FunctionalLibrary.driver.findElement(By.xpath("(//*[@class='product-long-description']/p)[1]")).getText();
						//System.out.println(Infospectxt);
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						//System.out.println(Cellvalue1);
						if(Cellvalue1.equals(Infospectxt)){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"'Info spec-'" +Cellvalue1+"","" +Infospectxt+" is matched Successfully with product");
							
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"'Info spec-'" +Cellvalue1+"","" +Infospectxt+" Not Matched with product",true);	
						}
						
							
					}	
					
					else if(PDPval.getStringCellValue().trim().equals("DT_Thumbnail_Count"))	{
						List<WebElement> prdtImgs=FunctionalLibrary.driver.findElements(By.xpath("//ol[@class='carousel-indicators img-item-indicator']/li"));
						System.out.println("Thumbnails :"+prdtImgs.size());
						int thumbnailcount=prdtImgs.size();
						String thumbnailsize=String.valueOf(thumbnailcount);
						System.out.println(i);
						System.out.println(k);
						
						
					
						
						File f1=new File(".");
						
						 ReadDatafromExcel.updateExcel(f1.getCanonicalPath()+"/src/test/resources/testdata/ProductsList.xlsx", "PDPvalidation", i, k, thumbnailsize);
						 Reports.logPassedStep(LogStatus.PASS,"Thumbnails count","Successfully displayed Thumbnails and count is "+prdtImgs.size());
						}


					
					
					
					else if(PDPval.getStringCellValue().trim().equals("Height"))	{
						
						try {
						//js.executeScript("window.scrollBy(0,500)");
						FunctionalLibrary.waitFor(2000);
						//WebElement Infospectab=FunctionalLibrary.driver.findElement(By.xpath("//a[text()='Info and Specifications']"));
						//Infospectab.click();
						
						
						String Dimensiontxt=FunctionalLibrary.driver.findElement(By.xpath("//*[@class='product-long-description']/p[2]")).getText();
						
					
						
						String[] Dimentxt1=Dimensiontxt.split(":");
						
						String Dimentxt2=Dimentxt1[1];
						
						 String[] Dimencross=Dimentxt2.split("X");
						
						 String  str1 = Dimencross[0];
					      String stra=str1.substring(0, str1.length() - 2);
					      System.out.println(stra);
					      
					     /* String  str2 = Dimencross[1];
					      String strb=str2.substring(0, Dimencross[1].length() - 2);
					      System.out.println(strb);
					      
					      String  str3 = Dimencross[2];
					      String strc=str3.substring(0, Dimencross[2].length() - 2);
					      System.out.println(strc);*/
						
						
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						//System.out.println(Cellvalue1);
						if(Cellvalue1.trim().equals(stra.trim())){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"Height-" +Cellvalue1+"","" +stra+" height is matched Successfully with product");
							
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"Height-" +Cellvalue1+"","" +stra+" height is not Matched with product",true);	
						}
						
						}catch(Exception e) {
							Reports.logStep(LogStatus.FAIL,"Height Validation","Height value is not avialable because of"  +e+"",false);					
							
						}
							
					}
					
					else if(PDPval.getStringCellValue().trim().equals("Width"))	{
						
						try
						{
						//js.executeScript("window.scrollBy(0,500)");
						FunctionalLibrary.waitFor(2000);
						//WebElement Infospectab=FunctionalLibrary.driver.findElement(By.xpath("//a[text()='Info and Specifications']"));
						//Infospectab.click();
						
						String Dimensiontxt=FunctionalLibrary.driver.findElement(By.xpath("//*[@class='product-long-description']/p[2]")).getText();
						String[] Dimentxt1=Dimensiontxt.split(":");
						
						String Dimentxt2=Dimentxt1[1];
						
						 String[] Dimencross=Dimentxt2.split("X");
						
						 /*String  str1 = Dimencross[0];
					      String stra=str1.substring(0, str1.length() - 2);
					      System.out.println(stra);*/
					      
					      String  str2 = Dimencross[1];
					      String strb=str2.substring(0, Dimencross[1].length() - 2);
					      System.out.println(strb);
					      
					     /* String  str3 = Dimencross[2];
					      String strc=str3.substring(0, Dimencross[2].length() - 2);
					      System.out.println(strc);*/
						
						
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						//System.out.println(Cellvalue1);
						if(Cellvalue1.trim().equals(strb.trim())){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"Width-" +Cellvalue1+"","" +strb+" Width is matched Successfully with product");
							
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"Width-" +Cellvalue1+"","" +strb+" Width is not Matched with product",true);	
						}
					}catch(Exception e) {
						Reports.logStep(LogStatus.FAIL,"Weight Validation","Width value is not avialable because of"  +e+"",false);					
						
					}
							
					}	
					
					else if(PDPval.getStringCellValue().trim().equals("Length"))	{
						
						try
						{
						//js.executeScript("window.scrollBy(0,500)");
						FunctionalLibrary.waitFor(2000);
						//WebElement Infospectab=FunctionalLibrary.driver.findElement(By.xpath("//a[text()='Info and Specifications']"));
						//Infospectab.click();
						
						String Dimensiontxt=FunctionalLibrary.driver.findElement(By.xpath("//*[@class='product-long-description']/p[2]")).getText();
						String[] Dimentxt1=Dimensiontxt.split(":");
						
						String Dimentxt2=Dimentxt1[1];
						
						 String[] Dimencross=Dimentxt2.split("X");
						
						 /*String  str1 = Dimencross[0];
					      String stra=str1.substring(0, str1.length() - 2);
					      System.out.println(stra);
					      
					      String  str2 = Dimencross[1];
					      String strb=str2.substring(0, Dimencross[1].length() - 2);
					      System.out.println(strb);*/
					      
					      String  str3 = Dimencross[2];
					      String strc=str3.substring(0, Dimencross[2].length() - 2);
					      System.out.println(strc);
						
						
						Cell currentCell1 = currentRow.getCell(k);
						String Cellvalue1=currentCell1.getStringCellValue();
						//System.out.println(Cellvalue1);
						if(Cellvalue1.trim().equals(strc.trim())){
							//Reports.logPassedStep(LogStatus.PASS,"Contract Type: ","" +Coveragetype+" Matched",false);
							Reports.logPassedStep(LogStatus.PASS,"Length-" +Cellvalue1+"","" +strc+" Length is matched Successfully with product");
							
						}
						
						else
						{
							Reports.logStep(LogStatus.FAIL,"Length-" +Cellvalue1+"","" +strc+" Length is not Matched with product",true);	
						}
						
					}catch(Exception e) {
						Reports.logStep(LogStatus.FAIL,"Length Validation","Length value is not avialable because of"  +e+"",false);					
						
					}	
					}	
					
										
					
					
					
					
					}
					js.executeScript("window.scrollBy(0,-500)");
					
					try {
					WebElement prdtImg=FunctionalLibrary.driver.findElement(By.xpath("//img[@class='ccz-small img-responsive' and contains(@src,'not-available-image.jpg')]"));
					//boolean prdtImgdisplay = js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != "undefined" && arguments[0].naturalWidth > 0", prdtImg); 
					boolean prdtImgdisplay=prdtImg.isDisplayed();
					
					 if(prdtImgdisplay==true)	{
						
						 Reports.logStep(LogStatus.FAIL,"Product image loaded ","Product image is not loaded successfully",true);		
								
							}
							
					}catch(Exception e) {
						Reports.logPassedStep(LogStatus.PASS,"Product image loaded","Product image is loaded successfully");					
						
					}
					
							
				
					
				}
				Reports.logPassedStep(LogStatus.PASS,"PDP - Product details verified","Product details verified successfully in PDP page");
				
				
					
			}
			
			
			}
			
			
			
			}
		
			else
			{
				Reports.logStep(LogStatus.FAIL,"No Data","Product data is not available in PDP sheet",true);
			}
			
			fs.close();	
			
		
					
			}			
		
		//	return mydata;
			
			catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static void readdataPdpProductValidation(String filepath, String sheetName,WebElement element1,WebElement element2,WebElement element3,WebElement element4) throws Exception {
		List<HashMap<String, String>> mydata = new ArrayList<>();
	try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			int a=sheet.getPhysicalNumberOfRows();
			
			if(a>0)
			{
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
					
					Cell currentCell = currentRow.getCell(0);
					String Cellvalue=currentCell.getStringCellValue();
					element1.clear();

					System.out.println(Cellvalue);

					element1.sendKeys(Cellvalue.trim());
					FunctionalLibrary.waitFor(4000);
					FunctionalLibrary.MoveToElementAndClick(element2);
					FunctionalLibrary.jsWaitForPageLoad();
					FunctionalLibrary.implicitWait(20);
					//FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitFor(2000);
					
					
					FunctionalLibrary.waitFor(7000);
					//FunctionalLibrary.click(element6, "View Cart button");
					//}
					WebElement item = FunctionalLibrary.driver.findElement(By.xpath("//div[@id='product-details-panel']/div[1]/div[1]/legend/span[2]"));
				//	String ItemText = item.getText();
					String ItemText=FunctionalLibrary.getTextNew(item);
					
					if(Cellvalue.equals(ItemText))
					{
						Reports.logPassedStep(LogStatus.PASS,"validated the products","'"+ItemText+"' products are validated successfully",true);
					}
					FunctionalLibrary.click(element4, "Add to cart button");
					Reports.logPassedStep(LogStatus.PASS,"Product Added","'"+i+"' products are added to cart",true);		
				}
			}
			
			else
			{
				Reports.logStep(LogStatus.FAIL,"No Data","There is no data in data sheet",true);
			}
			
			//fs.close();	
			}
		//	return mydata;
			
		 catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void Advsearchreaddate(String filepath, String sheetName,WebElement element1,WebElement element2,WebElement element3,WebElement element4) throws Exception {
		List<HashMap<String, String>> mydata = new ArrayList<>();
	try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			int a=sheet.getPhysicalNumberOfRows();
			
			if(a>0)
			{
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
					
					Cell currentCell = currentRow.getCell(0);
					String Cellvalue=currentCell.getStringCellValue();
					System.out.println(Cellvalue);
					element1.sendKeys(Cellvalue.trim());
					FunctionalLibrary.waitFor(4000);
					FunctionalLibrary.MoveToElementAndClick(element2);
					FunctionalLibrary.jsWaitForPageLoad();
					FunctionalLibrary.implicitWait(20);
					//FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitForElementvisibility(element3);
					FunctionalLibrary.waitFor(2000);
					
					
					FunctionalLibrary.waitFor(7000);
					//FunctionalLibrary.click(element6, "View Cart button");
					//}
					WebElement item = FunctionalLibrary.driver.findElement(By.xpath("//div[@id='product-details-panel']/div[1]/div[1]/legend/span[2]"));
				//	String ItemText = item.getText();
					String ItemText=FunctionalLibrary.getTextNew(item);
					
					if(Cellvalue.equals(ItemText))
					{
						Reports.logPassedStep(LogStatus.PASS,"validated the products","'"+ItemText+"' products are validated successfully",true);
					}
					FunctionalLibrary.click(element4, "Add to cart button");
					Reports.logPassedStep(LogStatus.PASS,"Product Added","'"+i+"' products are added to cart",true);		
				}
			}
			
			else
			{
				Reports.logStep(LogStatus.FAIL,"No Data","There is no data in data sheet",true);
			}
			
			//fs.close();	
			}
		//	return mydata;
			
		 catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void OrderSearch(String filepath,String SheetName,WebElement advsearchdrpdown,WebElement advseachlist,WebElement searchinput,WebElement Advsearchbtn,WebElement Ordnolnk,WebElement Orddetail) throws Exception {
		
		FileInputStream fs=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheet(SheetName);
		Row HeaderRow=sheet.getRow(0);
		int a=sheet.getPhysicalNumberOfRows();
		if(a>0)
		{
			
			for(int i=0;i<HeaderRow.getPhysicalNumberOfCells();i++)
			{
				Cell Searchcol=HeaderRow.getCell(i);
				if(Searchcol.getStringCellValue().trim().equals("Searchcriteria"))
				{
					
					
					for(int j=1;j<sheet.getPhysicalNumberOfRows();j++)
					{
						Row Searchfilter=sheet.getRow(j);
						Cell Searchfilterval=Searchfilter.getCell(i+1);
						String Searchfiltervalue=Searchfilterval.getStringCellValue();
						
						if(!Searchfiltervalue.equals(""))
						{
							//if(Searchcol.getStringCellValue().trim().equals("SearchCriteria"))
							//{
							Row Search1=sheet.getRow(j);
							Cell Search2=Search1.getCell(i);
							Cell Search3=Search1.getCell(i+1);
							
							FunctionalLibrary.listBoxelementclickwithbutton(advsearchdrpdown, advseachlist, "Advance Search Drop down", Search2.getStringCellValue(),"Advance Search listbox");
							FunctionalLibrary.setText(searchinput, "Search inputs", Search3.getStringCellValue());
							FunctionalLibrary.click(Advsearchbtn,"Advance Search button");
							FunctionalLibrary.waitFor(2000);
							
							
							FunctionalLibrary.waitFor(8000);
							FunctionalLibrary.waitForElementvisibility(Ordnolnk);
							
							try
							{
							if(Ordnolnk.isDisplayed()==true)
							{
							
								
								
							//if(Ordernolink.getText().equals(OrderNum))
							//{
							FunctionalLibrary.click(Ordnolnk, "Order Number link");
							
							FunctionalLibrary.waitFor(15000);
							FunctionalLibrary.waitForElementvisibility(Orddetail); 
							FunctionalLibrary.waitFor(1000);
							if(FunctionalLibrary.driver.getCurrentUrl().contains("orderdetails")) {
								//ordervalidation = true;
						    	Reports.logPassedStep(LogStatus.PASS, "Order details validation", "Successfully displayed '"+Search2.getStringCellValue()+"'- '"+Search3.getStringCellValue()+"' orderdetails page",true);
						    }
						    else
						    {
						    	Reports.logStep(LogStatus.FAIL, "Order details validation", " '"+Search2.getStringCellValue()+"'-'"+Search3.getStringCellValue()+"'Order details page is not successfully displayed",true);
						    }  
							//}
							}
							}
							catch(NoSuchElementException e1)
							{
								Reports.logStep(LogStatus.FAIL, "Order details validation", "This order is not available for this user",true);
							}


							
							
							break;
							//}
						}
						
					}
					
					
				}
				
			}
			
			
		
		
		
	}
		
		
		
	}
	
	
}
