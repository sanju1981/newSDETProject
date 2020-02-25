package com.SDET.TestCase;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET.Base.TestBase;
import com.SDET.Page.AddCustomerPage;
import com.SDET.Page.LoginPage;
import com.SDET.Utility.XLUtils;

public class TC_AddCustomer_003 extends TestBase {

	
	@Test(dataProvider="customerData")
	public void VerifyNewCustomre(String uname,String pwd,String Name,String month,String day,String yesr,String Address,String City,String State,String PIN,String Mobile,String Email,String Password) throws InterruptedException, IOException
	{
		
		LoginPage lp=new LoginPage();
		lp.validateUserName(uname);
		logger.info("Username enterd");
		lp.validatePassword(pwd);
		lp.clickLogin();
		logger.info("Login successfully click");
		Thread.sleep(2000);
		AddCustomerPage adc=new AddCustomerPage();		
		adc.addCustomerLink();
		logger.info("Customer link clicked");
		//adc.custName(prop.getProperty("custname"));
		adc.custName(Name);
		logger.info("Customer name entered");
		adc.gender();
		adc.DOB(month,day,yesr);
		adc.Address(Address);
		adc.city(City);
		adc.state(State);
		adc.PINNO(PIN);
		adc.TElphone(Mobile);
		adc.EMailID(Email);
		adc.password(Password);
		adc.submit();
		logger.info("submit button clicked");
		Thread.sleep(4000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
			JavascriptExecutor JS=(JavascriptExecutor)driver;
			JS.executeScript("window.scrollBy(0,400)");
			Thread.sleep(2000);
			adc.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
		}
		else
		{
			captureScreen(driver, "Addnewcustomer");
			Assert.assertTrue(false);
			logger.info("Test case Failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			JavascriptExecutor JS=(JavascriptExecutor)driver;
			JS.executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
			adc.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
		}
		
		
	}
		
	

	@DataProvider(name="customerData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/SDET/TestData/testData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet2");
		int colnum=XLUtils.getCellCount(path, "Sheet2", 1);
		String customerData[][]=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				customerData[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}
		return customerData;
	}
	
}
