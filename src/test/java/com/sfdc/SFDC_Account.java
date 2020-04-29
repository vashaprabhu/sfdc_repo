package com.sfdc;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SFDC_Account {
	
	//createacount
	static void createacc()
	{
		WebElement accountstab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		SalesForce_Utilities.waiting(accountstab);
		accountstab.click(); 
		WebElement acchome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(acchome.isDisplayed());
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();
		WebElement newbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@title='New']"));
		newbtn.click();
		WebElement accpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(accpage);
		System.out.println(accpage.isDisplayed()); 
		WebElement accname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='acc2']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String acntname = null;
		
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			acntname = System.getProperty("accName");
		
			accname.sendKeys(acntname);
			WebElement type = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='acc6']"));
			type.click();
			WebElement typeopt = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'Technology Partner')]"));
			SalesForce_Utilities.waiting(typeopt);
			typeopt.click(); 
			WebElement custpri = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='00N5w00000HXjdq']"));
			custpri.click();
			WebElement preority = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'High')]"));
			SalesForce_Utilities.waiting(preority);
			preority.click();
			WebElement saveacc = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@name='save']"));
			saveacc.click();
			WebElement accdetails = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='ep']"));
			SalesForce_Utilities.waiting(accdetails);
			System.out.println(accdetails.isDisplayed());
		}catch(Exception e) {
			System.out.println("Exception while reading properties file  " +e);
		}
		
	}

	//createnew view
	static void view() 
	{
		WebElement accountstab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		SalesForce_Utilities.waiting(accountstab);
		accountstab.click(); 
		WebElement acchome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(acchome.isDisplayed());
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement createview = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createview.click(); 
		WebElement viewpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		SalesForce_Utilities.waiting(viewpage);  
		WebElement viewname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='fname']"));
		
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String vname = null;
		String vuname = null;
		
		
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			vname = System.getProperty("viewName");
			WebElement viewuniquename = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='devname']"));
			
			
			viewname.sendKeys(vname);
			viewuniquename.click();
			Thread.sleep(2000);
	
			WebElement vsave = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@class='btn primary']"));
			vsave.click(); 
			WebElement viewinlist = SalesForce_Utilities.driver.findElement(By.xpath("//select[@class='title']"));
			System.out.println(viewinlist.getText());
			
			
		}catch(Exception e) {
			System.out.println("Exception while reading properties file  " +e);
		}

	}
	//editview
	static void editview()
	{
		WebElement accountstab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		SalesForce_Utilities.waiting(accountstab);
		accountstab.click(); 
		WebElement acchome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(acchome.isDisplayed());
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click(); 
		WebElement viewedit = SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(@class,'fFooter')]//a[contains(text(),'Edit')]"));
		viewedit.click();
		WebElement editpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(editpage.isDisplayed());  
		WebElement editname = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='fname']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String evname = null;
		String val = null;
	
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			evname = System.getProperty("newViewName");
			val = System.getProperty("valu");
			
			editname.sendKeys(evname); 
			WebElement editfield = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcol1']"));
			editfield.click(); 
			WebElement editfldopt = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fcol1']//option[contains(text(),'Account Name')]"));
			editfldopt.click();
			WebElement editopr = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fop1']"));
			editopr.click();
			WebElement editopropt = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='fop1']//option[contains(text(),'contains')]"));
			editopropt.click();  
			WebElement editval = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='fval1']"));
			editval.sendKeys(val); //div[3]//table[1]//tbody[1]//tr[1]//td[2]//input[1]
			WebElement saveedit = SalesForce_Utilities.driver.findElement(By.xpath("(//td[@class='pbButtonb']//input[@name='save'])[3]"));
			saveedit.click();
			
			
			}catch(Exception e) {
				System.out.println("Exception while reading properties file  " +e);
			}
		
	}
	//mergeaccount
	static void mergeacc()
	{
//		SFDC_Account.createacc();
		WebElement accountstab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		SalesForce_Utilities.waiting(accountstab);
		accountstab.click(); 
		WebElement acchome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(acchome.isDisplayed());
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();    
		WebElement mergeacc = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(), 'Merge')]"));
		mergeacc.click();   
		WebElement mergeaccpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(mergeaccpage.isDisplayed());  
		WebElement accsearch = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='srch']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String accnsrch = null;
//		String accmrg = null;
	
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			accnsrch = System.getProperty("accName");
//			accmrg = System.getProperty("acctoMrg");
			accsearch.sendKeys(accnsrch);  
			WebElement findbtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='srchbutton']"));
			findbtn.click();  
			WebElement chckbox1 = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='cid0']"));
			chckbox1.click();
			WebElement chckbox2 = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='cid1']"));
			chckbox2.click();
			WebElement nextbtn = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='goNext']"));
			nextbtn.click();    
			WebElement mergeaccdetailspage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
			SalesForce_Utilities.waiting(mergeaccdetailspage);
			WebElement mergebtn = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[@name='save']"));  
			mergebtn.click();
			Alert al = SalesForce_Utilities.driver.switchTo().alert();
			al.accept();  
			List<WebElement> accinrecview = SalesForce_Utilities.driver.findElements(By.xpath("//table[contains(@class,'list')]"));  
			for(WebElement accnam : accinrecview)
			{
				System.out.println(accnam.getText());
			}
			}catch(Exception e) {
				System.out.println("Exception while reading properties file  " +e);
			}
	}
	
	//accreport
	static void accreport()
	{
		WebElement accountstab = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		SalesForce_Utilities.waiting(accountstab);
		accountstab.click(); 
		WebElement acchome = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
		System.out.println(acchome.isDisplayed());
		WebElement closead = SalesForce_Utilities.driver.findElement(By.xpath("//a[@class='dialogClose']"));
		closead.click();    
		WebElement reportg30link  = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		reportg30link.click();  
		WebElement unsavedrepo  = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='content']"));
		SalesForce_Utilities.waiting(unsavedrepo);
		System.out.println(unsavedrepo.isDisplayed());  
		WebElement strtdate  = SalesForce_Utilities.driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		strtdate.click();     
		WebElement strttody  = SalesForce_Utilities.driver.findElement(By.xpath("//button[contains(text(), 'Today')]"));
		strttody.click();     
		WebElement enddate  = SalesForce_Utilities.driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		enddate.click();
		WebElement endtody  = SalesForce_Utilities.driver.findElement(By.xpath("//table[@id='ext-comp-1113']//td[@class='x-btn-mc']"));
		endtody.click();
		WebElement savebtn  = SalesForce_Utilities.driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		savebtn.click();
		WebElement reponame  = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='reportName']"));
		
		String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
		String rname = null;
		String runame = null;
		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(sFilePath);
			prop.load(fis);
			System.getProperties().putAll(prop);
			rname = System.getProperty("repoName");
			runame = System.getProperty("repoUNamae");
			
			reponame.sendKeys(rname); 
			WebElement repouniname  = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='reportDevName']"));
			repouniname.sendKeys(runame);    
			WebElement reposav  = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='ext-gen315']"));
			reposav.click();    
			WebElement reporun  = SalesForce_Utilities.driver.findElement(By.xpath("//button[@id='ext-gen63']"));
			reporun.click(); 
			WebElement repopage  = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='outerNoSidebar']"));
			System.out.println(repopage.isDisplayed());  
			
			
		}catch(Exception e) {
			System.out.println("Exception while reading properties file  " +e);
		}
		
	}

}
