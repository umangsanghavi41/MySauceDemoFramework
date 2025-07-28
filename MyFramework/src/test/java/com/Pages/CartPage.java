package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage 
{
	private WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#remove-sauce-labs-backpack")
	WebElement removeButton;
	
	@FindBy(id="continue-shopping")
	WebElement continueShoppingButton;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	@FindBy(css=".cart_item")
	WebElement itemBlock;
	
	@FindBy(css=".inventory_list")
	WebElement inventoryList;
	
	@FindBy(id="first-name")
	WebElement checkoutForm;
	
	public void removeButtonFunctionality()
	{
		removeButton.click();	
	}
	public boolean verifyItemisRemoved()
	{
		try
		{
			itemBlock.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickContinueButton()
	{
		continueShoppingButton.click();
	}
	public boolean verifyinventoryList()
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
	public CheckoutPage clickCheckoutButton()
	{
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
}
