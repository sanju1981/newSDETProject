package com.SDET.Page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET.Base.TestBase;

public class LoginPage extends TestBase {
	//WebDriver ldriver;
	
	public LoginPage()
	{
	//	ldriver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Repository
	@FindBy(name="uid")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutbtn;
	
	//Action method
	public void validateUserName(String uname)
	{
		username.sendKeys(uname);
	}
	public void validatePassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		logoutbtn.click();
	}
	
}
