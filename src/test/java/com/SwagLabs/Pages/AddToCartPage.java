package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwagLabs.Utility.Utility;

public class AddToCartPage 
{

	private WebDriver driver;
	
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	By removebtn=By.xpath("//button[text()='Remove']");
	By continuebtn=By.id("continue-shopping");
	By checkbtn=By.id("checkout");
	By cartbtn=By.xpath("//a[@class='shopping_cart_link']");
	
	//Method
	public void getCartPage()
	{
		driver.findElement(cartbtn).click();
		Utility.getScreenshot(driver);
	}
	
	public void doRemoveProduct()
	{
		driver.findElement(removebtn).click();
		System.out.println("Product removed Successfully");
		Utility.getScreenshot(driver);
	}
	
	public void doContinueshopping()
	{
		driver.findElement(continuebtn).click();
		System.out.println("Inventory page will open!");
		Utility.getScreenshot(driver);
	}
	
	
	public void doCheckout()
	{
		driver.findElement(checkbtn).click();
		Utility.getScreenshot(driver);
		System.out.println("On click Navigate to Checkout page!");
	}
}
