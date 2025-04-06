package TestPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BasePackage.BaseClass;
import PageObjects.PageObjectClass;
import TestReporterCode.ExtentReportClass;
import Utilities.Testdata_login;

public class TestClass extends BaseClass
{
	WebDriver driver;
	ExtentTest test;
	ExtentReports extentReports;
	PageObjectClass pageObjectClass;
	
	
	@BeforeSuite
	public void reportSetup()
	{
		extentReports = ExtentReportClass.getReporter("valid_credentials");
	}
	
	@AfterSuite
	public void reportGeneration()
	{
		extentReports.flush();
	}
	
	
	@BeforeMethod
	public void setup() throws IOException
	{
		driver = getDriver();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void login_valid_credentials() throws InterruptedException
	{
		pageObjectClass = new PageObjectClass(driver);
		test = extentReports.createTest("Test 1","login functionality with valid credentails");
		test.info("user enter username, password");
		pageObjectClass.enterCredentials("John Doe", "ThisIsNotAPassword");
		Thread.sleep(3000);
		test.info("user click login button");
		pageObjectClass.clickLoginBtn();
		
		boolean result = pageObjectClass.verifyLogoutPresent(driver);
		Thread.sleep(3000);
		test.addScreenCaptureFromBase64String(capture(driver));
		Assert.assertTrue(result,"invalid login attempt");
	}
	
	
	@Test(enabled = false, dataProvider = "testdata_loginFunctionality",dataProviderClass = Testdata_login.class)
	public void datadriven_login(String email, String password)
	{
		
	}
	
}
