package com.SwagLabs.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OverviewPageTest extends BaseClass
{
  @Test(priority=1)
  public void verfiyUrl()
  {
	 Assert.assertTrue(op.getAppUrl().contains("checkout"),"Url not matched!");
	  System.out.println("Url is matched: "+op.getAppUrl());
  }
  
  @Test(priority=2)
  public void verfiyTitle()
  {
	  Assert.assertTrue(op.getAppTitle().contains("Labs"),"Title not matched!");
	  System.out.println("Title is matched: "+op.getAppTitle());
  }
  
  @Test(priority=3)
  public void verfiyOverviewOfOrder()
  {
	  op.doComplete();
  }
  
}
