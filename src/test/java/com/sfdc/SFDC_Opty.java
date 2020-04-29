package com.sfdc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SFDC_Opty {
	
	
	static void oppordrpdwn()
	{
		WebElement opportnbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title, 'Opportunities')]"));
		opportnbtn.click();     
		WebElement opportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(opportnpage); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement opportn = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcf']"));
		opportn.click();   
		WebElement opportnmenu = SalesForce_Utilities.driver.findElement(By.xpath("//span[@class='fBody']"));
		System.out.println(opportnmenu.isDisplayed());
		
	}
	
	static void creatnopportn()
	{
		WebElement opportnbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title, 'Opportunities')]"));
		opportnbtn.click();     
		WebElement opportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(opportnpage); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();      
		WebElement newbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@title='New']"));
		newbtn.click();   
		WebElement newopportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(newopportnpage.isDisplayed());   
		WebElement opportnname= SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='opp3']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String oname = null;
		String aname = null;
		String propability = null;
		
	
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			oname = System.getProperty("oppname"); 
			aname = System.getProperty("accName");
			propability = System.getProperty("propab");
			
			opportnname.sendKeys(oname);   
			WebElement clsdate= SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(@class,'dateInput dateOnlyInput')]//input[@type='text']"));
			clsdate.click();
			WebElement seldate= SalesForce_Utilities.driver.findElement(By.xpath("//tr[@id='calRow5']//td[5]"));
			seldate.click();
			WebElement accnamelook = SalesForce_Utilities.driver.findElement(By.xpath("//a[@id='opp4_lkwgt']//img[contains(@class,'lookupIcon')]"));
			accnamelook.click();
			ArrayList<String> windows = new ArrayList(SalesForce_Utilities.driver.getWindowHandles());
			System.out.println(windows.size());
//			WebDriver popupwin = SalesForce_Utilities.driver.switchTo().window(windows.get(1));
			
		/*	WebElement typeacname = popupwin.findElement(By.xpath("//input[@id='lksrch']"));
			typeacname.sendKeys(aname);
			WebElement gobtn = popupwin.findElement(By.xpath("//input[@name='go']"));
			gobtn.click();
			WebElement optdata = popupwin.findElement(By.xpath("//tr[contains(@class, 'datarow')]//a[contains(text(), aname)]"));
			optdata.click();    */
			
			WebElement stage = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='opp11']"));
			stage.click();    
			WebElement stageopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[@value='Qualification']"));
			stageopt.click();
			WebElement probab = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='opp12']"));
			probab.sendKeys(propability);
			WebElement leadsou = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='opp6']"));
			leadsou.click();   
			WebElement souropt = SalesForce_Utilities.driver.findElement(By.xpath("//option[@value='Web']"));
			souropt.click();  
			WebElement opptnsave = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']"));
			opptnsave.click();
			WebElement opptndisplay = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
			SalesForce_Utilities.waiting(opptndisplay);
			System.out.println(opptndisplay.isDisplayed());
			
			}catch(Exception e) {
				System.out.println("Exception while reading properties file  " +e);
			}
	
	}
	
	static void optnpipeln()
	{
		WebElement opportnbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title, 'Opportunities')]"));
		opportnbtn.click();     
		WebElement opportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(opportnpage); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();    
		WebElement oppipe = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		oppipe.click();   
		WebElement pipelnpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(@class,'outerNoSidebar')]"));
		System.out.println(pipelnpage.isDisplayed());
		
	}
	
	static void struckoptn()
	{
		WebElement opportnbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title, 'Opportunities')]"));
		opportnbtn.click();     
		WebElement opportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(opportnpage); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement struckopp = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		struckopp.click();   
		WebElement struckopppage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='noTableContainer']"));
		System.out.println(struckopppage.isDisplayed());
	}
	
	static void summaryrepo()
	{
		WebElement opportnbtn = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(@title, 'Opportunities')]"));
		opportnbtn.click();     
		WebElement opportnpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(opportnpage); 
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement interval = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='quarter_q']"));
		interval.click();  
		WebElement intervalopt = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='quarter_q']//option[@value='next1']"));
		intervalopt.click();   
		WebElement include = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='open']"));
		include.click();  
		WebElement includeopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[@value='open']"));
		includeopt.click();   
		WebElement runreportbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[contains(@value,'Run')]"));
		runreportbtn.click();  
		WebElement reportsummarypage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='noTableContainer']"));
		reportsummarypage.click(); 
		
	}
	
}
