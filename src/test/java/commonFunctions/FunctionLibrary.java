package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class FunctionLibrary {
	public static WebDriver driver;
	public static Properties pop;
	public  static WebDriver startBrowser() throws Throwable {
		pop=new Properties();
		pop.load(new FileInputStream("./PropertyFiles/Enviornment.properties"));
		if(pop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();


		}
		else if (pop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}
		else {
			Reporter.log("Browser value is not maching",true);
		}
		return driver;

	}

	public static void openUrl() {
		driver.get(pop.getProperty("Url"));
	}
	public static void waitforElement(String LocatorType,String LocatorValue,String TestData) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(TestData)));

		if(LocatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));

		}
		if(LocatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));

		}


	}		
	public static void typeAction(String LocatorType,String LoactorValue,String TestData) {
		if(LocatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(LoactorValue)).clear();
			driver.findElement(By.id(LoactorValue)).sendKeys(TestData);
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(LoactorValue)).clear();
			driver.findElement(By.name(LoactorValue)).sendKeys(TestData);

		}
		if(LocatorType.equalsIgnoreCase("Xpath")) {
			driver.findElement(By.xpath(LoactorValue)).clear();
			driver.findElement(By.xpath(LoactorValue)).sendKeys(TestData);


		}


	}
	public static void ClickAction(String LocatorType,String LocatorValue) {
		if(LocatorType.equalsIgnoreCase("Xpath")) {
			driver.findElement(By.xpath(LocatorValue)).click();
		}
		if(LocatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(LocatorValue)).click();
		}

	}
	public static void validateTitle(String EXP_Title) {
		String Actual_Title=driver.getTitle();
		try {
			Assert.assertEquals(Actual_Title, EXP_Title,"title is not matching");

		}catch (AssertionError a) {
			System.out.println(a.getMessage());
		}	
	}
	public static void CloseBrowser() {
		driver.quit();
	}
	public static String generatedate() {
		Date date=new Date();
		DateFormat df =new SimpleDateFormat("YYYY_MM_DD hh_mm");
		return df.format(date);
	}
	public static void dropdownAction(String LocatorType,String LocatorValue,String TestData ) {
		if(LocatorType.equalsIgnoreCase("name")) {
			int value=Integer.parseInt(TestData);
			Select elm=new Select(driver.findElement(By.name(LocatorValue)));
			elm.selectByIndex(value);
		}
		if(LocatorType.equalsIgnoreCase("id")) {
			int value=Integer.parseInt(TestData);
			Select elm=new Select(driver.findElement(By.id(LocatorValue)));
			elm.selectByIndex(value);
		}
		if(LocatorType.equalsIgnoreCase("Xpath")) {
			int value=Integer.parseInt(TestData);
			Select elm=new Select(driver.findElement(By.xpath(LocatorValue)));
			elm.selectByIndex(value);
		}

	}
	public static void CaptureStock(String LocatorType,String LocatorValue) throws Throwable {
		String StockNum="";
		if(LocatorType.equalsIgnoreCase("id")) {
			StockNum=driver.findElement(By.id(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			StockNum=driver.findElement(By.name(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("xpath")) {
			StockNum=driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
		}
		FileWriter fw= new FileWriter("./CaptureData/StockNumber.txt");
		BufferedWriter bw =new BufferedWriter(fw);
		bw.write(StockNum);
		bw.flush();
		bw.close();
	}
	public static void stocktable() throws Throwable {
		FileReader fr =new FileReader("./CaptureData/StockNumber.txt") ;
		BufferedReader br = new BufferedReader(fr);
		String Exp_Date=br.readLine();
		if(!driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).isDisplayed()) 
			driver.findElement(By.xpath(pop.getProperty("Search-pannal"))).click();

		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).clear();
		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).sendKeys(Exp_Date);
		driver.findElement(By.xpath(pop.getProperty("Search-button"))).click();
		Thread.sleep(2000);
		String Act_Data=driver.findElement(By.xpath("//table[@class='table ewTable']/tbody[1]/tr/td[8]/div/span/span")).getText();
		Reporter.log(Act_Data+"  "+Exp_Date,true);
		try {
			Assert.assertEquals("Act_Data","Exp_Date","Stock should not match");
		}catch (AssertionError a) {
			Reporter.log(a.getMessage(),true);
		}

	}

	public static void Capturesup(String LocatorType ,String LocatorValue) throws Throwable {
		String Suppliernum="";
		if(LocatorType.equalsIgnoreCase("id")) {
			Suppliernum=driver.findElement(By.id(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			Suppliernum=driver.findElement(By.name(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("xpath")) {
			Suppliernum=driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
		}
		FileWriter fw= new FileWriter("./CaptureData/SupplierNumber.txt");
		BufferedWriter bw =new BufferedWriter(fw);
		bw.write(Suppliernum);
		bw.flush();
		bw.close();

	}
	public static void SupplierTable() throws Throwable{
		FileReader fr =new FileReader("./CaptureData/SupplierNumber.txt") ;
		BufferedReader br = new BufferedReader(fr);
		String Exp_Date=br.readLine();
		if(!driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).isDisplayed()) 
			driver.findElement(By.xpath(pop.getProperty("Search-pannal"))).click();

		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).clear();
		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).sendKeys(Exp_Date);
		driver.findElement(By.xpath(pop.getProperty("Search-button"))).click();
		Thread.sleep(2000);
		String Act_Data=driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
		Reporter.log(Act_Data+"  "+Exp_Date,true);
		try {
			Assert.assertEquals("Act_Data","Exp_Date","Stock should not match");
		}catch (AssertionError a) {
			Reporter.log(a.getMessage(),true);
		}
	}
	public static void Capturecus(String LocatorType,String LoctorValue) throws Throwable {
		String customerNum="";
		if(LocatorType.equalsIgnoreCase("id")) {
			customerNum=driver.findElement(By.id(LoctorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("name")) {
			customerNum=driver.findElement(By.name(LoctorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("xpath")) {
			customerNum=driver.findElement(By.xpath(LoctorValue)).getAttribute("value");
		}
		FileWriter fw= new FileWriter("./CaptureData/customerNumber.txt");
		BufferedWriter bw =new BufferedWriter(fw);
		bw.write(customerNum);
		bw.flush();
		bw.close();


	}
	public static void CustomerTable() throws Throwable {
		FileReader fr =new FileReader("./CaptureData/customerNumber.txt") ;
		BufferedReader br = new BufferedReader(fr);
		String Exp_Date=br.readLine();
		if(!driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).isDisplayed()) 
			driver.findElement(By.xpath(pop.getProperty("Search-pannal"))).click();
		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).clear();
		driver.findElement(By.xpath(pop.getProperty("Search-textbox"))).sendKeys(Exp_Date);
		driver.findElement(By.xpath(pop.getProperty("Search-button"))).click();
		Thread.sleep(2000);
		String Act_Data=driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr/td[5]/div/span/span")).getText();
		Reporter.log(Act_Data+"  "+Exp_Date,true);
		try {
			Assert.assertEquals("Act_Data","Exp_Date","Stock should not match");
		}catch (AssertionError a) {
			Reporter.log(a.getMessage(),true);
		}
	}
}
