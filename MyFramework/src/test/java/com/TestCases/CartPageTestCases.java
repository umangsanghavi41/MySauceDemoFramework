package com.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

import junit.framework.Assert;

public class CartPageTestCases extends BaseClass {
	@BeforeMethod
	public void setup() {
		invenPage = loginPage.doLogin(propertyFileDataRead.readData("username"),
				propertyFileDataRead.readData("password"));
		cartPage = invenPage.addProducttoCart();
	}

	@Test(priority = 1)
	public void verifyRemoveFunctionality() {
		cartPage.removeButtonFunctionality();
		boolean result = cartPage.verifyItemisRemoved();
		Assert.assertEquals(result, false);
	}

	@Test(priority = 2)
	public void continueButtonFunctionality() {
		cartPage.clickContinueButton();
		boolean result = cartPage.verifyinventoryList();
		Assert.assertEquals(result, true);
		System.out.println("Inventory list is visible");
	}

	@Test(priority = 3)
	public void checkoutButtonFunctionality() {
		cartPage.clickCheckoutButton();
		String url = getPageData.getURL();
		Assert.assertTrue(url.contains("checkout"));
	}

}
