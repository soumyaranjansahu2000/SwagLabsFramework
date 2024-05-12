package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class CheckOutPage 
{
	private WebDriver driver;
	

	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	private By fname=By.id("first-name");
	private By lname=By.id("last-name");
	private By zcode=By.id("postal-code");
	private By Continuebtn=By.id("continue");
	
	//methods
	public void doContinue(String fn,String ln,String zc)
	{
		System.out.println("User Fillup the detials for Checkout");
		driver.findElement(fname).sendKeys(fn);
		driver.findElement(lname).sendKeys(ln);
		driver.findElement(zcode).sendKeys(zc);
		Utility.getScreenshot(driver);
		System.out.println("Firstname: "+fn);
		System.out.println("Lastname: "+ln);
		System.out.println("Postal code: "+zc);

		
		driver.findElement(Continuebtn).click();
		Utility.getScreenshot(driver);
		
	}
	
	
	
	
	
}
