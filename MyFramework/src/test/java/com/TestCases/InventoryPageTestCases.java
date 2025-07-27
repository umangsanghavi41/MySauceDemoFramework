package com.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class InventoryPageTestCases extends BaseClass {
	@BeforeMethod
	public void setup() {
		invenPage = loginPage.doLogin(propertyFileDataRead.readData("username"),
				propertyFileDataRead.readData("password"));
	}

	@Test(priority = 1)
	public void validateProductLinkClickFunctionality() {
		invenPage.openProductLink();
		String url = getPageData.getURL();
		Assert.assertTrue(url.contains("item"), "URL doesn't contain this text");
	}

	@Test(priority = 2)
	public void addToCartFunctionality() {
		String productName=invenPage.getFirstProductName();
		invenPage.addProducttoCart();
		String cartProduct=invenPage.getCartProductName();
		Assert.assertTrue(productName.equals(cartProduct));
	}
	
	@Test(priority=3)
	public void addMultipleProducstoCart()
	{
		String firstproductName=invenPage.getFirstProductName();
		String secondProductName=invenPage.getSecondProductName();
		invenPage.addMultipleProductstoCart();
		String firstproductinCart=invenPage.getCartProductName();
		String secondproductinCart=invenPage.getSecondCartProductName();
		Assert.assertTrue(firstproductinCart.equals(firstproductName));
		Assert.assertTrue(secondproductinCart.equals(secondProductName));
		System.out.println("Both products are same");
	}
}
