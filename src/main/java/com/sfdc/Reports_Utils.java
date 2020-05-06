package com.sfdc;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reports_Utils {
	
	static ExtentReports reports;
	static ExtentTest loggers;
	
	public static void report_start()
	{
		String path_report_file = System.getProperty("User.dir")+"//SFDC_Reports//project_reports.html";
		
		reports = new ExtentReports(path_report_file);
		loggers = reports.startTest("SFDC_usermenu");
	}
	
	public static void createTestcase()
	{
//		loggers.log
	}
	
	

}
