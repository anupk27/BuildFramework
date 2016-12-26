package DataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workBook;

	public ExcelDataProvider() {

		File file = new File("./ApplicationTestData/AppData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(file);
			workBook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}

	}

	public String getData(int sheetIndex, int row, int column) {
		String data = workBook.getSheetAt(sheetIndex).getRow(row)
				.getCell(column).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetName, int row, int column) {
		String data = workBook.getSheet(sheetName).getRow(row)
				.getCell(column).getStringCellValue();
		return data;
	}
}
