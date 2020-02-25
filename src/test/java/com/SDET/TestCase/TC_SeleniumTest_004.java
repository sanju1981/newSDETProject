package com.SDET.TestCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SDET.Base.TestBase;
import com.SDET.Page.LoginPage;
import com.SDET.Page.SeleniumPage;

public class TC_SeleniumTest_004 extends TestBase {
	
	@Test
	public void ValidateOnSelenium() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage();
		lp.validateUserName(prop.getProperty("uname"));
		logger.info("Enter user name");
		lp.validatePassword(prop.getProperty("pwd"));
		logger.info("Enetered password");
		lp.clickLogin();
		Thread.sleep(2000);
		SeleniumPage sp=new SeleniumPage();
		sp.clcikOnSelenium();
		logger.info("Clicked on Selenium Tab");
		Thread.sleep(1000);
		sp.selectRadioTab();
		logger.info("Clicked on Radrio and checkbox ");
		//System.out.println("PageTitle==>"+driver.getTitle());
		if(driver.getTitle().equals(prop.getProperty("radipageTitle")))
		{
			Assert.assertTrue(true);
			System.out.println("Selenium PageTest Passed");
		}
		else
		{
			captureScreen(driver, "SeleniumTest");
			Assert.assertTrue(false);
			System.out.println("Selenium PageTest Failed");
		}
		Thread.sleep(2000);
		sp.clickOnRadio();
		logger.info("checked Radio button");
		Thread.sleep(2000);
		
	}

}
