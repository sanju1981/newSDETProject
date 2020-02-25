package com.SDET.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET.Base.TestBase;

public class SeleniumPage extends TestBase {
	
	public SeleniumPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//object repository
	@FindBy(xpath="//li[@class='dropdown']//a[@data-toggle='dropdown']")
	WebElement seleniumLink;
	@FindBy(xpath="//ul[@class='dropdown-menu']//li//a[text()='Radio & Checkbox Demo']")
	WebElement RadioBtn;
	@FindBy(css="input#vfb-7-2")
	WebElement radiobtn2;
	@FindBy(xpath="//a[@aria-expanded='true']")
	WebElement areaExpanded;
	
	//Method name for repository
	
	public void clcikOnSelenium()
	{
		seleniumLink.click();
		boolean areaTrue=areaExpanded.isDisplayed();
		if(areaTrue==true) {
			System.out.println("Dropdown is expaneded");
		}
		else
		{
			System.out.println("Dropdown is not expaneded");
		}
		
	}
	public void selectRadioTab()
	{
		RadioBtn.click();
	}
	public void clickOnRadio()
	{
		radiobtn2.click();
	}

}
