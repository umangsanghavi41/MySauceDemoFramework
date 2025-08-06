package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.PropertyFileDataRead;

public class CheckoutPage {
	public PropertyFileDataRead propertyFileDataRead;
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#first-name")
	WebElement firstNameTextField;
	
	@FindBy(css="#last-name")
	WebElement lastNameTextField;
	
	@FindBy(css="#postal-code")
	WebElement postalCode;
	
	@FindBy(css="#continue")
	WebElement continueButton;
	
	@FindBy(id = "cancel")
	WebElement cancelButton;
	
	@FindBy(className = "title")
	WebElement cartTitle;
	
	public OverviewPage doCheckout(String firstname,String lastname,String zipcode)
	{
		firstNameTextField.sendKeys(firstname);
		lastNameTextField.sendKeys(lastname);
		postalCode.sendKeys(zipcode);
		continueButton.click();
		return new OverviewPage(driver);
	}
	
	public CartPage checkCancelButtonFunctionality()
	{
		cancelButton.click();
		return new CartPage(driver);
	}
	
	public String getCartTitle()
	{
		return cartTitle.getText();
	}
}
