package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.ForgetPasswordPage;
import Pages.LoginPage;

public class VerifyForgetPasswordPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserFactory.getBrowser("Chrome");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());

	}

	@Test
	public void testForgetPasswordPage() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		String title = loginPage.getApplicationTitle();

		Assert.assertEquals(title, "SYNERZIP");

		loginPage.clickOnForgetPasswordLink();

		ForgetPasswordPage forgetPasswordPage = PageFactory.initElements(
				driver, ForgetPasswordPage.class);

		forgetPasswordPage.forgetPasswordApplication("1599",
				"vrushalee.ajotikar@synerzip.com");

	}

	@AfterMethod
	public void tearDown() {

		BrowserFactory.closeBrowser(driver);
	}
}
