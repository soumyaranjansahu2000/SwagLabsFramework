package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class LoginPage 
{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)//base class
	{
		this.driver=driver;
	}
	
	//locators
	By username=By.id("user-name");
	By password=By.id("password");
	By btn=By.id("login-button");
	
	//Methods
	
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public void doLogin(String un,String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		Utility.getScreenshot(driver);
		driver.findElement(btn).click();
	}
	

}
