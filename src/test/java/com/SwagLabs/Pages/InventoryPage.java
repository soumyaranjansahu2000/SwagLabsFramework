package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SwagLabs.Utility.Utility;

public class InventoryPage 
{
	private WebDriver driver;
	
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locator
	By productlist=By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']");
	By addcartbtn=By.xpath("//button[text()='Add to cart']");
	
	
	//Methods
	public int getProductCount()
	{
		return driver.findElements(productlist).size();
		
	}
	
	public void getProductName()
	{
		
		System.out.println("*****Product details*****");
		List<WebElement> list1=driver.findElements(productlist);
		
		for(WebElement i:list1)
		{
			System.out.println(i.getText());
		}
		Utility.getScreenshot(driver);
	}
	
	
	public void addProductToCart(String pname)
	{
		List<WebElement> list1=driver.findElements(productlist);
		
		for(WebElement i:list1)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				
				break;
			}
		}
		
		Utility.getScreenshot(driver);
		driver.findElement(addcartbtn).click();
		System.out.println("Selected Product added to the Cart: "+pname);
		
	}
	
	
	
	
	

}
