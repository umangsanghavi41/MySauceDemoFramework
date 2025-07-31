package com.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.Utilities.ExcelFileDataReading;
import com.Utilities.RetryAnalyzer;

public class LoginPageTestCases extends BaseClass {
	

	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void doLogin() {
		loginPage.doLogin(propertyFileDataRead.readData("username"), propertyFileDataRead.readData("password"));
		String url = getPageData.getURL();
		Assert.assertTrue(url.contains("inventory"));
		System.out.println("User is logged in! Test case passed");
	}

	@Test(priority = 2, dataProvider = "TestDataAndConfigs", dataProviderClass = ExcelFileDataReading.class)
	public void validateLogin(String username, String password) {
		loginPage.doLogin(username, password);
		Assert.assertTrue(loginPage.validateMessage(), "Validation message not displayed");
		System.out.println("Validate message displayed!!!");
	}

}
