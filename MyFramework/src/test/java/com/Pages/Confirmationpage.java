package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationpage {
	private WebDriver driver;
	public Confirmationpage(WebDriver driver) //this driver comes from base class
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2")
	WebElement confirmationMessage;
	
	@FindBy(css = ".btn_primary")
	WebElement homeButton;
	
	public Boolean validateConfirmation()
	{
		try
		{
			confirmationMessage.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public InventoryPage validateHomeButton()
	{
		homeButton.click();
		return new InventoryPage(driver);
	}
}
