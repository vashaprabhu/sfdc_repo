package com.sfdc;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SFDC_Contact {
	
	static void createcontact()
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement newbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='new']"));
		newbtn.click();      
		WebElement newcntct = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(newcntct.isDisplayed());   
		WebElement conlastname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String conname = null;
//		String accname = null;
		
		
		try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				conname = System.getProperty("contactlname");
	//			accname = System.getProperty("accName");
				
				conlastname.sendKeys(conname); 
	//			WebElement acname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='con4']"));
	//			acname.sendKeys(accname);
				
				WebElement savecontact = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
				savecontact.click();   
				WebElement newcontactpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='bPageTitle']"));
				System.out.println(newcontactpage.isDisplayed());
				
				
			}catch(Exception e){
				System.out.println("email setting exception "+e);
			}
		
	}
	
	static void viewcontact()
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement crtview = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		crtview.click();
		WebElement vwname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='fname']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String vname = null;
		
		
		try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				vname = System.getProperty("contactvname");
				
				vwname.sendKeys(vname);
				
				WebElement cuview = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='devname']"));
				cuview.click();   
				Thread.sleep(2000);
				WebElement savecview = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
				SalesForce_Utilities.waiting(savecview);
				savecview.click();   
				WebElement contlist = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='controls']//select[@class='title']"));
				SalesForce_Utilities.waiting(contlist);
				System.out.println(contlist.getText());
				String str = contlist.getText();
				if(vname.contentEquals(str))
				{
					System.out.println("Displaying the created view");
				}
				else
				{
					System.out.println("incorrect");
				}
				
				
			}catch(Exception e){
				System.out.println("email setting exception "+e);
			}
		
	}
	
	static void recentcreat() throws Exception
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement viewtab = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		viewtab.click();    
		WebElement viewtabopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'Recently Viewed Contacts')]"));
		viewtabopt.click(); 
		Thread.sleep(2000);
		
		
	}
	
	static void mycontact() throws Exception
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement viewtab = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		viewtab.click();   
		WebElement viewtabopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'My Contacts')]"));
		viewtabopt.click();   
		Thread.sleep(2000);
		WebElement mycntcpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(mycntcpage.isDisplayed());
		
	}
	
	static void contactviewing() throws Exception
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();    
		WebElement contactname = SalesForce_Utilities.driver.findElement(By.xpath("//tr[@class='dataRow even first']//th[@class=' dataCell  ']//a[@href='/0035w000033bBKA']"));
		contactname.click();   
		Thread.sleep(2000);
		WebElement contactpage = SalesForce_Utilities.driver.findElement(By.xpath("//table[@id='bodyTable']"));
		System.out.println(contactpage.isDisplayed());  
		Thread.sleep(2000);
		
	}
	
	static void infomissing()
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement crtview = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		crtview.click();     
		WebElement newcntct = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(newcntct.isDisplayed()); 
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String vuname = null;
		try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				vuname = System.getProperty("viewunqname");
	
				WebElement cuview = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='devname']"));
				cuview.sendKeys(vuname);  
				
				WebElement savecview = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='save']"));
				savecview.click();  
				WebElement errormsg = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]"));
				System.out.println(errormsg.isDisplayed());
			}catch(Exception e){
				System.out.println("email setting exception "+e);
			}
	}
	
	static void cancelfunction()
	{
			WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
			contact.click();     
			WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
			System.out.println(contacthome.isDisplayed());  
			WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
			closead.click(); 
			WebElement crtview = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
			crtview.click();
			WebElement vwname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='fname']"));
			
			String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
			String vname = null;
			String uniname = null;
			
			
			try {
					Properties prop = new Properties();
					FileInputStream fis = new FileInputStream(sFilePath);
					prop.load(fis);
					System.getProperties().putAll(prop);
					vname = System.getProperty("contactvname");
					uniname = System.getProperty("viewunqname");
					
					vwname.sendKeys(vname);
					
					WebElement cuview = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='devname']"));
					cuview.sendKeys(uniname);   
					WebElement cancelbtn = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbHeader']//input[@name='cancel']"));
					SalesForce_Utilities.waiting(cancelbtn);
					Thread.sleep(2000);
					cancelbtn.click();
					
					
				}catch(Exception e){
					System.out.println("email setting exception "+e);
				}
			
	}
	
	static void savennew() 
	{
		WebElement contact = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Contacts Tab']"));
		contact.click();     
		WebElement contacthome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(contacthome.isDisplayed());  
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement newbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='new']"));
		newbtn.click();      
		WebElement newcntct = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(newcntct.isDisplayed());   
		WebElement conlastname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String conname = null;
		String accname = null;
		
		
		try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				conname = System.getProperty("savnnwlname");
				accname = System.getProperty("savnnwacname");
				
				conlastname.sendKeys(conname); 
				WebElement acname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='con4']"));
				acname.sendKeys(accname);
				
				WebElement savenewcontact = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='topButtonRow']//input[contains(@name,'save_new')]"));
				savenewcontact.click();   
				WebElement newcontactpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='bPageTitle']"));
				System.out.println(newcontactpage.isDisplayed());
				
				
			}catch(Exception e){
				System.out.println("email setting exception "+e);
			}
		
	}

}
