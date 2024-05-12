package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyURL()
  {
	  Assert.assertTrue(lp.getAppUrl().contains("sauce"),"Url text not matched!");
	  System.out.println("Url text Matched!");
  }
  
  @Test(priority=2)
  public void verifyTitle()
  {
	  Assert.assertTrue(lp.getAppTitle().contains("Labs"),"Title not matched!");
	  System.out.println("Title matched!");
  }
  
  @Test(priority=3)
  public void verifyLogin()
  {
	  lp.doLogin("standard_user","secret_sauce");
	  Assert.assertTrue(lp.getAppUrl().contains("inventory"),"Login Fail!");
	  System.out.println("Login Pass!");
  }
  
}
