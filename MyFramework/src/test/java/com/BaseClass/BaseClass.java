package com.BaseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Pages.CartPage;
import com.Pages.CheckoutPage;
import com.Pages.InventoryItemPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.OverviewPage;
import com.Utilities.GetPageData;
import com.Utilities.PropertyFileDataRead;

public class BaseClass 
{	
	private WebDriver driver;
	public LoginPage loginPage;
	public PropertyFileDataRead propertyFileDataRead;
	public GetPageData getPageData;
	public InventoryPage invenPage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public OverviewPage overviewPage;
	
	@BeforeMethod
	public void setUp()
	{
		ChromeOptions options=new ChromeOptions();
		Map<String,Object> preferences=new HashMap<>();
		preferences.put("profile.password_manager_leak_detection",false);
		options.setExperimentalOption("prefs", preferences);
		driver=new ChromeDriver(options);
		getPageData=new GetPageData(driver);
		propertyFileDataRead=new PropertyFileDataRead();
		driver.get(propertyFileDataRead.readData("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		loginPage=new LoginPage(driver);	
		invenPage=new InventoryPage(driver);
		cartPage=new CartPage(driver);
		checkoutPage=new CheckoutPage(driver);
		overviewPage=new OverviewPage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
