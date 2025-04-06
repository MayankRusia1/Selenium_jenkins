package TestReporterCode;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass 
{
	public static ExtentReports getReporter(String filename)
	{
		String timestamp = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());
		
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\TestReports_folder\\"+filename+"_"+timestamp+".html");
		extentReports.attachReporter(sparkReporter);
		return extentReports;
	}
}
