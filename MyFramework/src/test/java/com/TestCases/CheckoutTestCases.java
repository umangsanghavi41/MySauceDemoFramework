package com.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

import junit.framework.Assert;

public class CheckoutTestCases extends BaseClass{
	@BeforeMethod
		public void setup() {
			invenPage = loginPage.doLogin(propertyFileDataRead.readData("username"),
					propertyFileDataRead.readData("password"));
			cartPage = invenPage.addProducttoCart();
			checkoutPage=cartPage.clickCheckoutButton();
			}
  @Test
  public void doCheckout() 
  {
	  checkoutPage.doCheckout(propertyFileDataRead.readData("checkoutfirstname"), propertyFileDataRead.readData("checkoutlastname"), propertyFileDataRead.readData("zipcode"));
	  String url=getPageData.getURL();
  }
}
