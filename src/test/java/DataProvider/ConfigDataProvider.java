package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {

		File file = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);

			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getApplicationUrl() {

		return prop.getProperty("url");
	}

	public String getChromeDriverPath() {

		return prop.getProperty("ChromeDriver");
	}

	public String getIEDriverPath() {

		return prop.getProperty("IEDriver");
	}
}
