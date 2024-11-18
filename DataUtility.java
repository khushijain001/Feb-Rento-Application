package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility implements FrameworkConstants {
	public String getDataFromProperties(String key) throws IOException {

		FileInputStream fis = new FileInputStream(PROPERTIES_PATH);
		Properties pro = new Properties();
		pro.load(fis);
		return pro.getProperty(key);
	}
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(cellNum).toString();
	}
	
	public Object[][] getMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(EXCEL_PATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);

		int lastRow = sh.getPhysicalNumberOfRows();
		int lastCell = sh.getRow(0).getPhysicalNumberOfCells();

		Object[][] obj = new Object[lastRow - 1][lastCell];

		for (int i = 1; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i - 1][j] = sh.getRow(i).getCell(j).toString();
			}
		}
		return obj;
	}

}
