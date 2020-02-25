package com.SDET.TestCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.SDET.Base.TestBase;
import com.SDET.Page.LoginPage;

public class TC_LoginTest_001 extends TestBase {
	
	//public static Logger logger=Logger.getLogger(TC_LoginTest_001.class);
	
	@Test
	public void verifyLogin() throws InterruptedException, IOException
	{
		
		
		LoginPage lp= new LoginPage();
		lp.validateUserName(prop.getProperty("uname"));
		Thread.sleep(1000);
		logger.info("Entered user name");
		lp.validatePassword(prop.getProperty("pwd"));
		Thread.sleep(1000);
		logger.info("Entered password");
		lp.clickLogin();
		
		if(driver.getTitle().equals(prop.getProperty("homeTitle")))
		{
			Assert.assertTrue(true);
			logger.info("Login Test pass");
		}
		else 
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			
		}
		
	}

}
