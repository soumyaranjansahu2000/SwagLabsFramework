package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CartPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyCartPage()
  {
	  ap.getCartPage();
  }
  
  @Test(priority=2)
  public void verifyProductRemove()
  {
	  ap.doRemoveProduct();
	  addWait();
	  
	
	  
  }
  @Test(priority=3)
  public void verifyContinueShopping()
  {
	  ap.doContinueshopping();
	  addWait();
	  ip.addProductToCart("Sauce Labs Backpack");
	  addWait();
	  ap.getCartPage();
  }
  
  
  @Test(priority=4)
  public void verifyCheckoutPage()
  {
	  ap.doCheckout();
  }
}
