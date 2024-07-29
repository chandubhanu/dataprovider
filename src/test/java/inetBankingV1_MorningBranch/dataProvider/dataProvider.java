package inetBankingV1_MorningBranch.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
 DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="drivetest")
	public void testCaseData(String greeting,String communication,String id)
	{
		System.out.println(greeting+" "+communication+" "+id);
		
	}
	
	@DataProvider(name="drivetest")
	public Object getData() throws IOException {
		// Initialize a FileInputStream to read the Excel file located in the target directory of the current user's working directory
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//target//dataprovider.xlsx");

		// Create an XSSFWorkbook object to represent the Excel workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Select the sheet named "data" from the workbook
		XSSFSheet sheet = wb.getSheet("data");

		// Get the number of rows that contain data in the sheet
		int rowcount = sheet.getPhysicalNumberOfRows();

		// Get the first row to determine the number of columns
		XSSFRow row = sheet.getRow(0);
		int columncount = row.getLastCellNum();

		// Initialize a 2D array to hold the data from the Excel sheet, excluding the header row
		Object[][] data = new Object[rowcount - 1][columncount];

		// Iterate over the rows of the sheet, starting from the second row (index 1) to skip the header row
		for (int i = 0; i < rowcount - 1; i++) {
		    // Get the current row
		    row = sheet.getRow(i + 1);

		    // Iterate over the columns of the current row
		    for (int j = 0; j < columncount; j++) {
		        // Get the cell at the current column
		        XSSFCell cell = row.getCell(j);

		        // Format the cell's value and store it in the data array
		        data[i][j] = formatter.formatCellValue(cell);
		    }
		}

		// Return the 2D array containing the data from the Excel sheet
		return data;

	}
}
