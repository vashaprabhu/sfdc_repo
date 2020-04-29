package com.sfdc;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce_Utilities {
	
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
	
	// 1. SF page navigation_login error
	static void sfloginError() throws Exception 
	{
			String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
			String userName = null;
			try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				userName = System.getProperty("User_name");
			}catch(Exception e) {
				System.out.println("Exception while reading properties file");
			}
			driver.get("https://login.salesforce.com/");
			WebElement login_username = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='username']"));
			login_username.sendKeys(userName);
			WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
			WebElement rememberMe = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='rememberUn']"));
			rememberMe.click();			
			WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
			login_btn.click();
			Thread.sleep(1000);
			WebElement login_error = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(text(), 'enter')]"));
			System.out.println(login_error.isDisplayed() + " Enter password error");
		
	}
	
	// 2. Login with valid UN and PW
	static void sfLogin() throws Exception
	{
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
		WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
		login_password.sendKeys(passWord);	
		WebElement rememberMe = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='rememberUn']"));
		rememberMe.click();			
		WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
		login_btn.click();
		Thread.sleep(2000);
		System.out.println(SalesForce_Utilities.driver.getCurrentUrl()+" is Home page url");
		Thread.sleep(2000);
		
		
	}
	
	//3. rememberme check box
	static void rememberFunction() throws Exception
	{
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
		WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
		login_password.sendKeys(passWord);	
		WebElement rememberMe = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='rememberUn']"));
		rememberMe.click();			
		WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
		login_btn.click();
		Thread.sleep(5000);
		WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
		user_icon.click();
		Thread.sleep(2000);
		WebElement lgout_btn = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Logout']"));
		lgout_btn.click();
		Thread.sleep(5000);
		WebElement lgin_page = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='main']"));
		SalesForce_Utilities.waiting(lgin_page);
		System.out.println(SalesForce_Utilities.driver.getCurrentUrl()+ " login page");
		WebElement name_field = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='idcard']"));
		System.out.println(name_field.getText() + " name in user name field");
		
	}
	//4. forgot password-> reset page
	static void forgotPassword() throws Exception
	{
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String userName = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			userName = System.getProperty("User_name");
		}catch(Exception e) {
			System.out.println("Exception while reading properties file");
		}
		driver.get("https://login.salesforce.com/");
		WebElement login_username = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='username']"));
		login_username.sendKeys(userName);
		WebElement forgotPLink = SalesForce_Utilities.driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		forgotPLink.click();
		Thread.sleep(2000);
		WebElement forgotPwpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='content']"));
		Thread.sleep(2000);
		WebElement pw_Uname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='un']"));
		pw_Uname.sendKeys(userName);
		WebElement contibtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='continue']"));
		contibtn.click();
		Thread.sleep(2000);
		WebElement resetpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='content']"));
		System.out.println(resetpage.isDisplayed());
		WebElement rtrntologinbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Return to')]"));
		rtrntologinbtn.click();
		WebElement lgin_page = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='main']"));
		System.out.println(lgin_page.isDisplayed());
		
	}
	
	// 5. invalid un pw, error message
	static void invalidLogin() throws Exception
	{
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String userName = null;
		String passWord = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			userName = System.getProperty("wr_uname");
			passWord = System.getProperty("Pass_word");
		}catch(Exception e) {
			System.out.println("Exception while reading properties file");
		}
		driver.get("https://login.salesforce.com/");
		WebElement login_username = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='username']"));
		login_username.sendKeys(userName);
		WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
		login_password.sendKeys(passWord);
		WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
		login_btn.click();
		Thread.sleep(2000);
		WebElement login_error = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='error']"));
		System.out.println(login_error.getText());
		System.out.println(login_error.isDisplayed());
	}
	
	

	
	static void waiting(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(SalesForce_Utilities.driver, 40);	
		wait.until(ExpectedConditions.visibilityOf(element));		
				
	}
	
	static void browserquit()
	{
		SalesForce_Utilities.driver.quit();
	}

}
