package inetBankingV1_MorningBranch.dataProvider;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class axxosExcel {
	public WebDriver driver;
	DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="logindata")
	public void login(String Username,String Password) 
	{
		driver=new ChromeDriver();
		driver.get("http://dga1app06axoqa/axxos");
		driver.findElement(By.id("pnlLogin_tbUserName_I")).sendKeys(Username);
		driver.findElement(By.id("pnlLogin_tbPassword_I")).sendKeys(Password);
		driver.findElement(By.id("pnlLogin_chkSkipConfigure")).click();
		driver.findElement(By.id("pnlLogin_LoginButton_CD")).click();
	}

	@DataProvider
	public Object[][] logindata() throws IOException
	{
		//Object[][] data= {{"sa","Test@01"},{"help","Test@03"},{"chha244","Test@02"}};
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//target//dataprovider.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(1);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int columncount=row.getPhysicalNumberOfCells();
		Object[][] data = new Object[rowcount - 1][columncount];
		for(int i=0;i<rowcount-1;i++)
		{
			row = sheet.getRow(i + 1);
			for(int j=0;j<columncount;j++) 
			{
				XSSFCell cell = row.getCell(j);
				 data[i][j]=formatter.formatCellValue(cell);
		}
		}
		return data;
	}
}
