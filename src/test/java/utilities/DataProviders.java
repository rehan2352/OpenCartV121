package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".//testData//Login_Test_Data.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path); //Creating object of ExcelUtility class
		
		int totalRows=xlutil.getRowCount("LoginData");
		int totalCell=xlutil.getCellCount("LoginData",0);
		
		String logindata[][]=new String[totalRows][totalCell]; //creating two dimensional array
		
		for(int i=1;i<=totalRows;i++)  //reading data from xl and store in two dimensional array
		{
			for(int j=0;j<totalCell;j++) //
			{
				logindata[i-1][j]=xlutil.getCellData("LoginData", i, j);  //1,0
			}
		}
		
		return logindata;
		
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
}
