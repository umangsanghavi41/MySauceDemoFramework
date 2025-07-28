package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	private WebDriver driver;
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#finish")
	WebElement finishButton;
	
	@FindBy(css="#cancel")
	WebElement cancelButton;
	
	@FindBy(css=".inventory_list")
	WebElement inventoryList;
	public void finishCheckout()
	{
		finishButton.click();
	}
	
	public void cancelCheckout()
	{
		cancelButton.click();
	}
	public boolean validateInventoryPageDisplay()
	{
		try
		{
			inventoryList.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
