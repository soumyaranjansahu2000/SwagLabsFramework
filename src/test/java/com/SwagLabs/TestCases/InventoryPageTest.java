package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyProductCount()
  {
	  Assert.assertEquals(ip.getProductCount(),6,"Product count not matched!");
	  System.out.println("Total Products are: "+ip.getProductCount());
  }
  
  @Test(priority=2)
  public void verifyProducts()
  {
	  ip.getProductName();
  }
  
  
  @Test(priority=3)
  public void verifyAddProductToCart()
  {
	  ip.addProductToCart("Sauce Labs Onesie");
  }
}
