package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.LoginPage;

public class VerifyLoginPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("Chrome");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());

	}

	@Test
	public void testLoginPage() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		String title = loginPage.getApplicationTitle();

		Assert.assertEquals(title, "SYNERZIP");

		loginPage.loginToApplication(DataProviderFactory.getExcelConfig()
				.getData(0, 0, 0), DataProviderFactory.getExcelConfig()
				.getData(0, 0, 1));

		loginPage.verifyWelcomeLink();

	}

	@AfterMethod
	public void tearDown() {

		BrowserFactory.closeBrowser(driver);
	}
}
