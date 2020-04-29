package com.sfdc;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SFDC_Leads {
	
	static void leadcheck()
	{
		List<WebElement> tabbar = SalesForce_Utilities.driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		for(WebElement tabs : tabbar )
		{
			String tab = tabs.getText();
			if(tab.contains("Leads"))
			{
				System.out.println("Leads tab is in nav bar");
			}
			
		}
		
		
	}
	
	static void validateview()
	{
		WebElement leads = SalesForce_Utilities.driver.findElement(By.xpath("//ul[@id='tabBar']//li[@id='Lead_Tab']"));
		leads.click();   
		WebElement leadhomepage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(leadhomepage.isDisplayed()); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement view = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		System.out.println(view.isDisplayed());
		view.click();      
		WebElement viewopt = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']//option"));
		SalesForce_Utilities.waiting(viewopt);
		System.out.println(viewopt.isDisplayed());
		
	}
	
	static void gofunctionality() throws Exception
	{
		WebElement leads = SalesForce_Utilities.driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		leads.click();   
		WebElement leadhomepage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(leadhomepage.isDisplayed()); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement view = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		System.out.println(view.isDisplayed());
		view.click(); 
		WebElement todayopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),\"Today\")]"));
		todayopt.click();
//		WebElement unreadopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'My Unread Leads')]"));
//		unreadopt.click();
		WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
		user_icon.click();
		Thread.sleep(2000);
		WebElement lgout_btn = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Logout']"));
		lgout_btn.click();
		Thread.sleep(2000);
		WebElement lgin_page = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='main']"));
		SalesForce_Utilities.waiting(lgin_page);
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String passWord = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			passWord = System.getProperty("Pass_word");
			WebElement login_password = SalesForce_Utilities.driver.findElement(By.xpath("//*[@name='pw']"));
			login_password.sendKeys(passWord);	
			WebElement login_btn = SalesForce_Utilities.driver.findElement(By.xpath("//*[@id='Login']"));
			login_btn.click();

		}catch(Exception e) {
			System.out.println("Exception while reading properties file");
		}
		SalesForce_Utilities.waiting(leads);
		leads.click();   
		System.out.println(leadhomepage.isDisplayed()); 
//		closead.click();  
		WebElement gobtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@value=' Go! ']"));
		gobtn.click();
		WebElement todayview = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='00B5w00000D6unk_listSelect']"));
		System.out.println(todayview.isDisplayed());
		
	}
	
	static void todaylead()
	{
		WebElement leads = SalesForce_Utilities.driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		leads.click();   
		WebElement leadhomepage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(leadhomepage.isDisplayed()); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement view = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		System.out.println(view.isDisplayed());
		view.click(); 
		WebElement todayopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),\"Today\")]"));
		SalesForce_Utilities.waiting(todayopt);
		todayopt.click();
		WebElement gobtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@value=' Go! ']"));
		gobtn.click();
		WebElement todayview = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='00B5w00000D6unk_listSelect']"));
		System.out.println(todayview.isDisplayed());
	}
	
	static void newbutton()
	{
		WebElement leads = SalesForce_Utilities.driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		leads.click();   
		WebElement leadhomepage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(leadhomepage.isDisplayed()); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();   
		WebElement newbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[contains(@name,'new')]"));
		newbtn.click();   
		WebElement lstname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String lastn = null;
		String compn = null;
		
		
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			lastn = System.getProperty("leadlname");
			compn = System.getProperty("leadcname");
			
			lstname.sendKeys(lastn);
			
			WebElement cmpname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='lea3']"));
			cmpname.sendKeys(compn);   
			
			WebElement savelead = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
			savelead.click();   
			WebElement newleadpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(@class,'bPageTitle')]"));
			System.out.println(newleadpage.isDisplayed());
			
			
		}catch(Exception e){
			System.out.println("email setting exception "+e);
		}
		
		
	}

}
