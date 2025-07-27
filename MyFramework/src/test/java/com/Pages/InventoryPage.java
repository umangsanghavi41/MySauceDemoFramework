package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	private WebDriver driver;
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//div[@class='inventory_item_name '])[1]")
	WebElement firstListedProduct;
	
	@FindBy(xpath = "(//button[contains(@class,'btn_primary')])[1]")
	WebElement firstAddtoCartButton;
	
	@FindBy(css = ".shopping_cart_link")
	WebElement shoppingCartIcon;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	WebElement cartProductName;
	
	@FindBy(xpath = "(//button[contains(@class,'btn_primary')])[3]")
	WebElement fourthProductAddToCartButton;
	
	@FindBy(xpath = "(//div[@class='inventory_item_name '])[4]")
	WebElement fourthListedProduct;
	
	@FindBy(xpath = "(//div[@class='inventory_item_name'])[2]")
	WebElement secondProductInCart;
	
	public InventoryItemPage openProductLink()
	{
		firstListedProduct.click();
		return new InventoryItemPage();
	}
	public String getFirstProductName()
	{
		return firstListedProduct.getText();
	}
	public String getCartProductName()
	{
		return cartProductName.getText();
	}
	public CartPage addProducttoCart()
	{
		firstAddtoCartButton.click();
		shoppingCartIcon.click();
		return new CartPage();
	}
	public String getSecondProductName()
	{
		return fourthListedProduct.getText();
	}
	public String getSecondCartProductName()
	{
		return secondProductInCart.getText();
	}
	public CartPage addMultipleProductstoCart()
	{
		firstAddtoCartButton.click();
		fourthProductAddToCartButton.click();
		shoppingCartIcon.click();
		return new CartPage();
	}
}
