package com.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

import junit.framework.Assert;

public class ConfirmationTestCases extends BaseClass{
	@BeforeMethod
	public void setup()
	{
		invenPage = loginPage.doLogin(propertyFileDataRead.readData("username"),
				propertyFileDataRead.readData("password"));
		cartPage = invenPage.addProducttoCart();
		checkoutPage = cartPage.clickCheckoutButton();
		overviewPage = checkoutPage.doCheckout(propertyFileDataRead.readData("checkoutfirstname"),
				propertyFileDataRead.readData("checkoutlastname"), propertyFileDataRead.readData("zipcode"));
		confirmationpage=overviewPage.finishCheckout();
	}
  @Test(priority=1)
  public void validateConfirmationMessage()
  {
	  boolean result=confirmationpage.validateConfirmation();
	  Assert.assertEquals(true,result);
  }
  
  @Test(priority = 2)
  public void validateHomeButton()
  {
	  confirmationpage.validateHomeButton();
	  String url=getPageData.getURL();
	  Assert.assertTrue(url.contains("inventory"));
  }
}
