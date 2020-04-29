package com.sfdc;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SFDC_RandomScenarios {
	
	static void firstnlastname() throws Exception
	{
		WebElement firstlastnamelink = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		String nameonloginscreen = firstlastnamelink.getText();  
		WebElement hometab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title,'Home')]"));
		hometab.click();
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();   
		WebElement homepage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='bPageTitle']"));
		System.out.println(homepage.isDisplayed()); 
		WebElement flnamehomepage  = SalesForce_Utilities.driver.findElement(By.xpath("//h1[@class='currentStatusUserName']//a"));
		String homepagename = homepage.getText(); 
		if(homepagename.contains(nameonloginscreen))
		{
			System.out.println("login name and name in home screen are same");
		}
		else
		{
			System.out.println("different");
		}
		/*
		firstlastnamelink.click();
		Thread.sleep(2000);
		WebElement myProfile = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myProfile.click();
		Thread.sleep(2000);     
		WebElement myprofilepage = SalesForce_Utilities.driver.findElement(By.xpath("//table[@id='bodyTable']"));
		System.out.println(myprofilepage.isDisplayed());
		
		flnamehomepage.click();
		Thread.sleep(2000); 
		WebElement myprofilepage1 = SalesForce_Utilities.driver.findElement(By.xpath("//table[@id='bodyTable']"));
		
		if(myprofilepage.isDisplayed())
		{
			System.out.println("myprofile and name in home tab takes us to same page");
		}
		else
		{
			System.out.println("both are not same");
		}
		*/
	
	}
	
	static void editablelastname() throws Exception
	{
		WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
		user_icon.click();
		Thread.sleep(2000);
		WebElement myProfile = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		myProfile.click();
		Thread.sleep(2000);
		WebElement editicn = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img"));
		editicn.click();	
		WebElement editwin = SalesForce_Utilities.driver.findElement(By.xpath("//h2[@id='contactInfoTitle']"));
		SalesForce_Utilities.waiting(editwin);
		//switch frame and move to lastname
		WebElement lnFrame = SalesForce_Utilities.driver.findElement(By.id("contactInfoContentId"));
		SalesForce_Utilities.driver.switchTo().frame(lnFrame);
		WebElement abtTab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		abtTab.click();
		WebElement lstnamefld = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='lastName']")); 
		SalesForce_Utilities.waiting(lstnamefld);
		lstnamefld.clear();
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String clname = null;
		
		
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			clname = System.getProperty("ranservicelastname");
			
			//about
			lstnamefld.sendKeys(clname);
	
			WebElement saveall = SalesForce_Utilities.driver.findElement(By.xpath("//input[@value='Save All']"));
			saveall.click();
			
		}catch(Exception e) {
			System.out.println("Exception while reading properties file  " +e);
		}
	}
	
	static void tabcustomization() throws Exception
	{
		WebElement plustab = SalesForce_Utilities.driver.findElement(By.xpath("//img[contains(@class,'allTabsArrow')]"));
		plustab.click();
		WebElement alltabspage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(alltabspage.isDisplayed());
		WebElement customisetab= SalesForce_Utilities.driver.findElement(By.xpath("//input[contains(@value,'Customize')]"));
		customisetab.click();
		WebElement customisetabpage= SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		customisetabpage.click();
		WebElement selectedtabscontainer = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		SalesForce_Utilities.waiting(selectedtabscontainer);
		WebElement tabtoremove = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'Libraries')]"));
		tabtoremove.click();
		WebElement removebutton = SalesForce_Utilities.driver.findElement(By.xpath("//img[contains(@class,'leftArrowIcon')]"));
		removebutton.click();
		WebElement savechanges = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='save']"));
		savechanges.click();
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
		List<WebElement> tabbar = SalesForce_Utilities.driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
		for(WebElement tabs : tabbar )
		{
			String tab = tabs.getText();
			System.out.println(tab +" ");
		}
	
	}
	
	static void blockcalender()
	{
		WebElement hometab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title,'Home')]"));
		hometab.click();
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();   
		WebElement homepage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='bPageTitle']"));
		System.out.println(homepage.isDisplayed()); 
		WebElement currentdat = SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]//a"));
		System.out.println(currentdat.isDisplayed()); 
		currentdat.click();     
		WebElement currentdatpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='bCalDiv']"));
		System.out.println(currentdatpage.isDisplayed());   
		WebElement time = SalesForce_Utilities.driver.findElement(By.xpath("//td[@class='fixedTable']//a[contains(text(),'8:00 PM')]"));
		time.click();    
		WebElement neweventpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(neweventpage.isDisplayed());    
		WebElement subcombo = SalesForce_Utilities.driver.findElement(By.xpath("//img[@class='comboboxIconOn']"));
		subcombo.click();       
		//i shuld write about subject combo box
		
		WebElement endtime = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		System.out.println(endtime.isDisplayed());
		endtime.click();    
		WebElement choosetime = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(text(), '9:00 PM')]"));
		choosetime.click();    
		WebElement savebtn = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
		savebtn.click();     
		System.out.println(currentdatpage.isDisplayed());   
		WebElement eventlink = SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(@class,'event_')]"));
		System.out.println(eventlink.isDisplayed());
		
		
	}

}
