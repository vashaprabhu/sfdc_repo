package com.sfdc;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sfdcReports {
	
	static ExtentReports reports;
	static ExtentTest logger;
	
	static WebDriver driver = null;
	
	static void browserConnect(String sBrowser)
	{
		if(sBrowser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(sBrowser.contains("fire"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	
	public static void loginTCReport() throws Exception
	{
		
		String path_report_file = System.getProperty("User.dir")+"//SFDC_Reports//project_reports.html";
		
		reports = new ExtentReports(path_report_file);
		 logger = reports.startTest("SFDC_Login");
	
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String userName = null;
		String passWord = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			 userName = System.getProperty("User_name");
			 passWord = System.getProperty("Pass_word");
		}catch(Exception e) {
			System.out.println("Exception while reading properties file");
		}
		driver.get("https://login.salesforce.com/");
		WebElement login_username = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='username']"));
		login_username.sendKeys(userName);
		logger.log(LogStatus.INFO, "Enteres Username Successfully");
		WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
		login_password.sendKeys(passWord);	
		logger.log(LogStatus.INFO, "Enteres Password Successfully");
		WebElement rememberMe = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='rememberUn']"));
		rememberMe.click();			
		logger.log(LogStatus.INFO, "Clicked on rememberme Successfully");
		WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
		login_btn.click();
		logger.log(LogStatus.INFO, "Clicked on login Successfully");
		Thread.sleep(2000);
		System.out.println(SalesForce_Utilities.driver.getCurrentUrl()+" is Home page url");
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "logged in Successfully");
	}
	
	static void endtestcase()
	{
		reports.endTest(logger);
		reports.flush();
	}
		
	public static void main(String [] args) throws Exception
	{
		sfdcReports.browserConnect("ch");
		sfdcReports.loginTCReport();
		sfdcReports.endtestcase();
		
	}

}



