package com.Utilities;

import org.openqa.selenium.WebDriver;

public class GetPageData {
	private WebDriver driver;
	public GetPageData(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
}
