package CommonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class FunctionLibrary 
{
	public static WebDriver driver;
	public static Properties conpro;
	
	//method for launch browser
	
	public static WebDriver startBrowser() throws Throwable
	{
		// create object for properties class	
		conpro = new Properties();
		
		// load property file
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		else if(conpro.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else
		{
			Reporter.log("Browser value is not matching", true);
		}
		return driver;
		
	}
	
	// Method for launching URl
	public static void openUrl()
	{
		driver.get(conpro.getProperty("Url"));
	}
	
	// Method for wait for user name
	
	public static void waitForElement(String LocatorType, String LocatorValue, String Mywait)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(Mywait)));
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
			
		}
		
		if(LocatorType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
			
		}
		
		if(LocatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
			
		}
	}
	
	// method for text boxes
	public static void typeAction(String LocatorType, String LocatorValue, String TestData)
	{
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).clear();
			driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
		}
		
		if(LocatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(LocatorValue)).clear();
			driver.findElement(By.name(LocatorValue)).sendKeys(TestData);
		}
		
		if(LocatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LocatorValue)).clear();
			driver.findElement(By.id(LocatorValue)).sendKeys(TestData);
		}
				
	}
	
	// method for buttons, radio buttons, check boxes, links and images
	public static void clickAction(String LocatorType, String LocatorValue) throws Throwable
	{
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(LocatorValue)).click();
		}
		
		if(LocatorType.equalsIgnoreCase("name"))
		{
			Thread.sleep(2000);
			driver.findElement(By.name(LocatorValue)).click();
		}
		
		if(LocatorType.equalsIgnoreCase("id"))
		{
			Thread.sleep(2000);
			driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
		}
	}
	
	// method for capturing supplier number into note pad
	public static void capturesupp(String LocatorType, String LocatorValue) throws Throwable
	{
		String supplierNum="";	// Type of Variable is Local variable and Type data type is String
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			supplierNum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
		}
		
		if(LocatorType.equalsIgnoreCase("id"))
		{
			supplierNum = driver.findElement(By.id(LocatorValue)).getAttribute("value");
		}
		
		if(LocatorType.equalsIgnoreCase("name"))
		{
			supplierNum = driver.findElement(By.name(LocatorValue)).getAttribute("value");
		}
		
		// Create Note pad and Write Supplier Number
		FileWriter fw = new FileWriter("./CaptureData/supplier.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(supplierNum);
		bw.flush();
		bw.close();
	}
	
	// method for Validate Supplier Number in table
	public static void supplierTable() throws Throwable
	{
		// read supplier number from note pad
		FileReader fr = new FileReader("./CaptureData/supplier.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		
		// Click Search panel if search text box not displayed
		if(!driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).isDisplayed())
			driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
			driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).clear();
			driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).sendKeys(Exp_Data);
			driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
			Thread.sleep(3000);
			String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
			Reporter.log(Exp_Data+"           "+Act_Data,true);
			
			if(Exp_Data.equals(Act_Data))
			{
				Reporter.log("Supplier number Add Success", true);
			}
			else
			{
				Reporter.log("Supplier Number No Add Successfully", true);
			}
		
	}
	
	// Method for Close Browser
	public static void closeBrowser()
	{
		driver.quit();
	}

	
	
}
