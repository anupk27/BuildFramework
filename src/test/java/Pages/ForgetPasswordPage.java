package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage {

	WebDriver driver;

	public ForgetPasswordPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = ".//*[@id='employeeid']")
	WebElement employeeid;

	@FindBy(xpath = ".//*[@id='emailid']")
	WebElement emailid;

	@FindBy(xpath = ".//*[@id='btnReset']")
	WebElement btnReset;

	@FindBy(xpath = ".//*[@id='btnBack']")
	WebElement btnBack;
	
	
	public void forgetPasswordApplication(String employeeID, String emailID){
		
		employeeid.sendKeys(employeeID);
		emailid.sendKeys(emailID);
		btnReset.click();
		
	}

}
