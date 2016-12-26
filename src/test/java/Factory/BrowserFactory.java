package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import DataProvider.ConfigDataProvider;

public class BrowserFactory {

	static WebDriver driver;

	public static WebDriver getBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", DataProviderFactory
					.getConfig().getChromeDriverPath());
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", DataProviderFactory
					.getConfig().getIEDriverPath());
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void closeBrowser(WebDriver currentDriver) {
		currentDriver.quit();

	}
}
