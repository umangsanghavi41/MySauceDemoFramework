package com.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class LoginPage 
{
	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement userNameTextField;
	
	@FindBy(id="password")
	WebElement passwordTextField;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//h3")
	WebElement validationMessage;
	
	public InventoryPage doLogin(String username,String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		return new InventoryPage(driver);
	}
	
	public String validateMessage(String username,String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		return validationMessage.getText();
	}
	public Boolean validateMessage()
	{
		return validationMessage.isDisplayed();
	}
}
