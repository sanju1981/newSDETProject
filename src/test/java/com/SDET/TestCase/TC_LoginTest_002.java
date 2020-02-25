package com.SDET.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET.Base.TestBase;
import com.SDET.Page.LoginPage;
import com.SDET.Utility.XLUtils;

public class TC_LoginTest_002 extends TestBase {
	
	@Test(dataProvider="LoginData")
	public void loginDD(String uname,String pwd) throws InterruptedException, IOException
	{
		driver.get(prop.getProperty("url"));
		logger.info("URL is open");
		LoginPage lp= new LoginPage();
		lp.validateUserName(uname);
		Thread.sleep(1000);
		logger.info("Entered user name");
		lp.validatePassword(pwd);
		Thread.sleep(1000);
		logger.info("Entered password");
		lp.clickLogin();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
		//	lp.clickLogout();
			//driver.switchTo().alert().accept();
			//driver.switchTo().defaultContent();			
		}
		
	}
	public boolean isAlertPresent() //user defined method
	{	try
		{
		driver.switchTo().alert();
		return true;
		}catch(Exception e)
		{
		return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String Path=System.getProperty("user.dir")+"/src/test/java/com/SDET/TestData/testData.xlsx";
		int rownum=XLUtils.getRowCount(Path, "Sheet1");
		int colnum=XLUtils.getCellCount(Path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(Path, "Sheet1", i, j);
			}
			
		}
		return loginData;
	}

}
