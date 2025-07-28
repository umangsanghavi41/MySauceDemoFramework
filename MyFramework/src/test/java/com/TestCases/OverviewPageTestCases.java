package com.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

import junit.framework.Assert;

public class OverviewPageTestCases extends BaseClass {
	@BeforeMethod
	public void setup() {
		invenPage = loginPage.doLogin(propertyFileDataRead.readData("username"),
				propertyFileDataRead.readData("password"));
		cartPage = invenPage.addProducttoCart();
		checkoutPage = cartPage.clickCheckoutButton();
		overviewPage = checkoutPage.doCheckout(propertyFileDataRead.readData("checkoutfirstname"),
				propertyFileDataRead.readData("checkoutlastname"), propertyFileDataRead.readData("zipcode"));
	}

@Test(priority =1)
  public void finishCheckout() 
  {
	  overviewPage.finishCheckout();
	  String url=getPageData.getURL();
	  Assert.assertTrue(url.contains("complete"));
	  System.out.println("Checkout is successfull");
  }

@Test(priority=2)
public void cancelCheckout()
{
	overviewPage.cancelCheckout();
	boolean result=overviewPage.validateInventoryPageDisplay();
	Assert.assertEquals(result,true);
}
}
