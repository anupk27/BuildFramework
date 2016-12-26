package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;
import Utility.Helper;

public class VerifyLoginPageWithReportsWithScreenshots {
	WebDriver driver;

	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUp() {

		report = new ExtentReports(".\\Reports\\LoginPageReport.html", true);
		logger = report.startTest("Verify Login Page");

		driver = BrowserFactory.getBrowser("Chrome");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());

		logger.log(LogStatus.INFO, "Application is up and running");

	}

	@Test
	public void testLoginPage() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		String title = loginPage.getApplicationTitle();

		Assert.assertEquals(title, "SYNERZIP");

		logger.log(LogStatus.PASS, "Home page loaded successfully");

		loginPage.loginToApplication(DataProviderFactory.getExcelConfig()
				.getData(0, 0, 0), DataProviderFactory.getExcelConfig()
				.getData(0, 0, 1));

		logger.log(LogStatus.INFO,"Login Successful");

		loginPage.verifyWelcomeLink();
		
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver, "Validation")));

		logger.log(LogStatus.PASS, "Welcome link appears");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			String path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
}
