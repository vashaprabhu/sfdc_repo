package com.sfdc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SFDC_UsrMenu {
	
		//1. User menu DropDoun
		static void usrdrpdwn() throws Exception 
		{
			WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
			user_icon.click();
			Thread.sleep(2000);
			WebElement user_menu = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavMenu']"));
			System.out.println(user_menu.isDisplayed());
		}
		
		//2. my profile
		
		static void myProfile() throws Exception
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
			String postText = null;
			String file = null;
			
			try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				clname = System.getProperty("changelname");
				postText = System.getProperty("text");
				file = System.getProperty("fpath");
				//about
				lstnamefld.sendKeys(clname);
		
				WebElement saveall = SalesForce_Utilities.driver.findElement(By.xpath("//input[@value='Save All']"));
				saveall.click();
				
			}catch(Exception e) {
				System.out.println("Exception while reading properties file  " +e);
			}
			
		//posting
			WebElement postTab = SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'Post')]"));
			WebElement postarea = SalesForce_Utilities.driver.findElement(By.xpath("//div[contains(@class,'publisherTextAreaInner')]"));
			SalesForce_Utilities.waiting(postarea);
			postarea.click();
			WebElement pstframe = SalesForce_Utilities.driver.findElement(By.className("cke_wysiwyg_frame"));
			SalesForce_Utilities.driver.switchTo().frame(pstframe);
			WebElement ptextarea = SalesForce_Utilities.driver.findElement(By.xpath("//body[@contenteditable='true']"));
			SalesForce_Utilities.waiting(ptextarea);
			Thread.sleep(5000);
			ptextarea.sendKeys(postText);   
			Thread.sleep(2000);
			SalesForce_Utilities.driver.switchTo().parentFrame();
			WebElement sharebtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='publishersharebutton']"));
			sharebtn.click();
			Thread.sleep(2000);
			WebElement postedText = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='cxfeeditemtextwrapper']"));
			SalesForce_Utilities.waiting(postedText);
			String enteredText = postedText.getText();
			System.out.println(enteredText.contentEquals(postText));
			//file
			WebElement fileTab = SalesForce_Utilities.driver.findElement(By.xpath("//span[contains(text(),'File')]"));
			fileTab.click();
			List<WebElement> uploadtabs = SalesForce_Utilities.driver.findElements(By.xpath("//div[@id='chatterFileStageOne']"));
			WebElement upcomp = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(), 'computer')]"));
			upcomp.click();
			WebElement choose = SalesForce_Utilities.driver.findElement(By.xpath("//input[@class='file']"));
			System.out.println("here");
			//have to use autoit
			choose.sendKeys("C:\\Users\\varsh\\Documents\\Files_Read_write");
			WebElement sharefile = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
			sharefile.click();
			Thread.sleep(9000);
			
			Actions act = new Actions(SalesForce_Utilities.driver);
			WebElement photo = SalesForce_Utilities.driver.findElement(By.xpath("//img[@class='chatter-photo']"));
			System.out.println("till here");
			SalesForce_Utilities.waiting(photo);
			act.moveToElement(photo).build().perform();
			SalesForce_Utilities.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement photolink = SalesForce_Utilities.driver.findElement(By.xpath("//a[@id='uploadLink' and contains(text(), 'Add Photo')]"));
			SalesForce_Utilities.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			photolink.click();
//			WebElement uploadWindow = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='uploadPhoto']/div[@class='middle']/div[@id='uploadPhotoContent']"));
//			System.out.println(uploadWindow.isDisplayed());
			WebElement photoframe = SalesForce_Utilities.driver.findElement(By.id("uploadPhotoContentId"));
			SalesForce_Utilities.driver.switchTo().frame(photoframe);
			WebElement choosephoto = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
			choosephoto.click();
			// have to use autoit
			WebElement save = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='j_id0:uploadFileForm:save']"));
			save.click();
		
			
			
		}
		
		
		//7.MySetting
		static void mysetting() throws Exception
		{
			WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
			user_icon.click();
			Thread.sleep(2000);
			WebElement setting = SalesForce_Utilities.driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
			setting.click();
			Thread.sleep(1000);
			WebElement personalinfo = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='PersonalInfo_font']"));
			personalinfo.click();
			WebElement loginhistory = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
			SalesForce_Utilities.waiting(loginhistory);
			loginhistory.click();
			Thread.sleep(3000);
			WebElement historypage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='RelatedUserLoginHistoryList']"));
			SalesForce_Utilities.waiting(historypage);
			System.out.println(historypage.isDisplayed());
			
			WebElement displaylay = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='DisplayAndLayout_font']"));
			displaylay.click();
			WebElement customtabs = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='CustomizeTabs_font']"));
			customtabs.click();
//			WebElement customtpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
//			System.out.println(customtpage.isDisplayed());
			
			WebElement appcontainer = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='p4']"));
			appcontainer.click();
			WebElement app = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'Salesforce Chatter')]"));
			WebElement availtabs = SalesForce_Utilities.driver.findElement(By.xpath("//select[@id='duel_select_0']"));
			WebElement reporttab = SalesForce_Utilities.driver.findElement(By.xpath("//option[contains(text(),'Reports')]"));
			JavascriptExecutor js = (JavascriptExecutor) SalesForce_Utilities.driver;
			js.executeScript("arguments[0].scrollIntoView()", reporttab);
			reporttab.click();
			WebElement adding = SalesForce_Utilities.driver.findElement(By.xpath("//img[@title='Add']"));
			SalesForce_Utilities.waiting(adding);
			adding.click();
			WebElement saverepo = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='save']"));
			SalesForce_Utilities.waiting(saverepo);
			saverepo.click();
			Thread.sleep(3000);
			List<WebElement> tabbar = SalesForce_Utilities.driver.findElements(By.xpath("//ul[@id='tabBar']//li"));
			for(WebElement tabs : tabbar )
			{
				String tab = tabs.getText();
				System.out.println(tab +" ");
			}
			
			//email
			WebElement emailbtn = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='EmailSetup_font']"));
			SalesForce_Utilities.waiting(emailbtn);
			emailbtn.click();
			WebElement emailsetting = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='EmailSettings_font']"));
			emailsetting.click();
			
			String sFilePath = "C:\\Users\\varsh\\Documents\\JavaTraining\\com.sfdc\\help_sfdc.properties";
			String mailname = null;
			String mailid = null;
			
			
			try {
				Properties prop = new Properties();
				FileInputStream fis = new FileInputStream(sFilePath);
				prop.load(fis);
				System.getProperties().putAll(prop);
				mailname = System.getProperty("emailName");
				mailid = System.getProperty("emailID");
			}catch(Exception e){
				System.out.println("email setting exception "+e);
			}
			
			WebElement emailsettingpage = SalesForce_Utilities.driver.findElement(By.xpath("//div[@class='pbBody']"));
			SalesForce_Utilities.waiting(emailsettingpage);
			System.out.println(emailsettingpage.isDisplayed());
//			WebElement ename = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='sender_name']"));
//			ename.clear();
//			ename.sendKeys(mailname);
//			WebElement eid = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='sender_email']"));
//			eid.clear();
//			eid.sendKeys(mailid);
//			WebElement bcc = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
//			bcc.click();
			WebElement emailsave = SalesForce_Utilities.driver.findElement(By.xpath("//input[@name='save']"));
			emailsave.click();
			WebElement successmsg = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='meSaveCompleteMessage']"));
			System.out.println(successmsg.isDisplayed());
			
			//calender
			WebElement calender = SalesForce_Utilities.driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
			calender.click();
			WebElement activereminder = SalesForce_Utilities.driver.findElement(By.xpath("//a[@id='Reminders_font']"));
			activereminder.click();
			WebElement reminderpage = SalesForce_Utilities.driver.findElement(By.xpath("//td[@id='bodyCell']"));
			SalesForce_Utilities.waiting(reminderpage);
			WebElement testrembtn = SalesForce_Utilities.driver.findElement(By.xpath("//input[@id='testbtn']"));
			testrembtn.click();
			Thread.sleep(3000);
			
//			WebElement popupwin = SalesForce_Utilities.driver.findElement(By.xpath("//body[contains(@class,'brandNoBgrImg')]"));
//			SalesForce_Utilities.waiting(popupwin);
//			System.out.println(popupwin.isDisplayed());
			
			ArrayList<String> windows = new ArrayList(SalesForce_Utilities.driver.getWindowHandles());
			System.out.println(windows.size());
//			WebDriver popupwin = SalesForce_Utilities.driver.switchTo().window(windows.get(1));
//			System.out.println(popupwin.getTitle());
			
			
			
			
		}
			//developer consolle
		static void devconsole() throws Exception
		{
			WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
			user_icon.click();
			Thread.sleep(2000);
			WebElement devcon = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
			devcon.click();
			Thread.sleep(1000);
			ArrayList<String> windows = new ArrayList(SalesForce_Utilities.driver.getWindowHandles());
			WebDriver consol = SalesForce_Utilities.driver.switchTo().window(windows.get(1));
			System.out.println(consol.getTitle());
			SalesForce_Utilities.driver.close();
			
			
		}
		
		static void logout() throws Exception
		{
			WebElement user_icon = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='userNavButton']"));
			user_icon.click();
			Thread.sleep(2000);
			WebElement lgout_btn = SalesForce_Utilities.driver.findElement(By.xpath("//a[@title='Logout']"));
			lgout_btn.click();
			Thread.sleep(5000);
			WebElement lgin_page = SalesForce_Utilities.driver.findElement(By.xpath("//div[@id='main']"));
			SalesForce_Utilities.waiting(lgin_page);
			System.out.println(SalesForce_Utilities.driver.getCurrentUrl()+ " login page");
		}
			
			
			
			

		
	

}
