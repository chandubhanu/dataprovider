package inetBankingV1_MorningBranch.dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
@Test
public class excel {
	public void getexcel() throws IOException
	{
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//target//dataprovider.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	//Object[][] data= {{"hello","text","1"},{"bye","Message","143"},{"solo","call","453"}};
	XSSFSheet sheet=wb.getSheet("sheet1");
	int rowcount=sheet.getPhysicalNumberOfRows();
	XSSFRow row=sheet.getRow(0);
	int columncount=row.getLastCellNum();
	Object data[][]=new Object[rowcount-1][columncount];
	for(int i=0;i<rowcount-1;i++)
	{
		row=sheet.getRow(i+1);
		for(int j=0;j<columncount;j++) 
		{
			System.out.println(row.getCell(j));
		}
	}
	}
	@Test
	public void logindata() throws IOException
	{
		//Object[][] data= {{"sa","Test@01"},{"help","Test@03"},{"chha244","Test@02"}};
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//target//dataprovider.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(1);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int columncount=row.getPhysicalNumberOfCells();
		for(int i=0;i<rowcount-1;i++)
		{
			for(int j=0;j<columncount;j++) 
			{
				System.out.println(i);
				System.out.println(j);
			}
		}
		
	}
}

