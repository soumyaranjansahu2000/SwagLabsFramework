package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class OverviewPage
{
	private WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	private By data=By.id("checkout_summary_container");
	private By fbtn=By.id("finish");
	private By msg=By.tagName("h2");
	
	//methods
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	

	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public void doComplete()
	{
		System.out.println(driver.findElement(data).getText());
		Utility.getScreenshot(driver);
		driver.findElement(fbtn).click();
		Utility.getScreenshot(driver);
		System.out.println(driver.findElement(msg).getText());
	}
}
