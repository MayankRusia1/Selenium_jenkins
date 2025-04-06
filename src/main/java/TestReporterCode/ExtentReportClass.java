package TestReporterCode;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClass 
{
	public static ExtentReports getReporter(String filename)
	{
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\TestReports_folder\\"+filename+".html");
		extentReports.attachReporter(sparkReporter);
		return extentReports;
	}
}
