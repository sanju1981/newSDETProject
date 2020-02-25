package com.SDET.Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.apache.log4j.PropertyConfigurator;




public class TestBase {

	//public String baseUrl="http://demo.guru99.com/V4/index.php";
	//public  String uname="mngr245435";
	//public  String pwd="syzAnEs";
	public static WebDriver driver;
	public static Logger logger;
	public static Properties prop;
	
	public TestBase() 
	{
		try {
			prop=new Properties();
			FileInputStream fip=new FileInputStream("./src/test/java/com/SDET/config/config.properties");   
			prop.load(fip);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	@BeforeClass
	public void SetUp()
	{
		String BrowserName="Chrome";
		if(BrowserName.equals(prop.getProperty("browsername")))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Driver//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		logger=Logger.getLogger("TestBase");
		PropertyConfigurator.configure("Log4j.properties");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		logger.info("URL is open");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File filesrc=ts.getScreenshotAs(OutputType.FILE);
		//File filedest=new File("C://Users//rajam//eclipse-workspace//NewSDETProject//Screenshot//testcase.png");
		File filedest=new File(System.getProperty("user.dir")+"//Screenshot//"+tname+".png");
		FileUtils.copyFile(filesrc, filedest);
		System.out.println("Screen shot taken");
	}
	
	
	
}
