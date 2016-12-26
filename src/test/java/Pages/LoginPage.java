package Pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btn-login")
	WebElement button;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	WebElement link;

	By welcomeLink = By.xpath(".//*[@id='welcome']");

	public void clickOnLoginButton() {

		button.click();
	}

	public String getApplicationTitle() {

		return driver.getTitle();

	}

	public void clickOnForgetPasswordLink() {
		link.click();

	}

	public void loginToApplication(String user, String pass) {

		username.sendKeys(user);
		password.sendKeys(pass);
		button.click();
	}

	public void verifyWelcomeLink() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions
				.presenceOfElementLocated(welcomeLink));

		String linkText = element.getText();

		Assert.assertTrue("Welcome link is not verified properly",
				linkText.contains("Welcome"));

	}
}
