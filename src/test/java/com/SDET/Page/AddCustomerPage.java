package com.SDET.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET.Base.TestBase;

public class AddCustomerPage extends TestBase {
	
	
	public AddCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//create repository
	@FindBy(xpath="//a[text()='New Customer']")
	WebElement newCustomerLink;
	@FindBy(name="name")
	WebElement custName;
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	WebElement gender;
	@FindBy(id="dob")
	WebElement DOB;
	@FindBy(name="addr")
	WebElement address;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="pinno")
	WebElement pinno;
	@FindBy(name="telephoneno")
	WebElement telphone;
	@FindBy(name="emailid")
	WebElement emailid;
	@FindBy(name="password")
	WebElement passwoed;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutbtn;
	
	//Action
	
	public void addCustomerLink()
	{
		newCustomerLink.click();
	}
	public void custName(String custname)
	{
		
		custName.sendKeys(custname);
	}
	public void gender()
	{
		gender.click();
	}
	public void DOB(String mm,String dd,String yyyy)
	{
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yyyy);
	}
	public void Address(String addr)
	{		
		address.sendKeys(addr);
	}
	public void city(String cityname) 
	{		
		city.sendKeys(cityname);
	}
	public void state(String stateName)
	{
		state.sendKeys(stateName);
	}
	public void PINNO(String pinnum)
	{
		pinno.sendKeys(pinnum);
	}
	public void TElphone(String mobilno)
	{
		telphone.sendKeys(mobilno);
	}
	public void EMailID(String emailidname)
	{
		emailid.sendKeys(emailidname);
	}
	public void password(String pwdname)
	{
		passwoed.sendKeys(pwdname);
	}
	public void submit() 
	{
		submit.click();		
		
	}	
	public void clickLogout()
	{
		logoutbtn.click();
	}
	

}
