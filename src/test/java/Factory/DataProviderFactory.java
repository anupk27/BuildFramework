package Factory;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;

public class DataProviderFactory {

	public static ConfigDataProvider getConfig() {

		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}

	public static ExcelDataProvider getExcelConfig() {

		ExcelDataProvider excelConfig = new ExcelDataProvider();
		return excelConfig;
	}
}
