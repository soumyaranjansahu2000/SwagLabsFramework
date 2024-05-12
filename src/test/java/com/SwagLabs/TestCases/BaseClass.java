package com.SwagLabs.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.SwagLabs.Pages.*;
import com.SwagLabs.Utility.PropertiesFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass
{
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage  ip;
	public AddToCartPage ap;
	public CheckOutPage cp;
	public OverviewPage op;
	public PropertiesFile ps;
	public  ExtentReports extent;
	public ExtentSparkReporter spark;
	public  ExtentTest test;
	
	@BeforeSuite
	public void setUpReport()
	{
		 extent = new ExtentReports();
		  //path
		   spark = new ExtentSparkReporter("./"+"/Report/SWagLabReport.html");
		  //configuration
		  spark.config().setDocumentTitle("SwagLab Automation Report");
		  spark.config().setReportName("SwagLab");
		  spark.config().setTheme(Theme.DARK);
		  
		  //attached
		  extent.attachReporter(spark);
		  
		  //create test
		  test=extent.createTest("SwagLab Report");
		  
	}
	
	
	
	@BeforeTest
	public void browserSetup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		ps=new PropertiesFile("Config.properties");
		lp=new LoginPage(driver);
		ip=new InventoryPage(driver);
		ap=new AddToCartPage(driver);
		cp=new CheckOutPage(driver);
		op=new OverviewPage(driver);
		
			
	}
	

	public void addWait()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeClass
	public void pageSetUp()
	{
		System.out.println("*****Login********");
		System.out.println("Title is: "+lp.getAppTitle());
		lp.doLogin(ps.getData("un"),ps.getData("psw"));
		test.log(Status.PASS,"Login test pass!");
		addWait();
		System.out.println("******Inventory Page*****");
		System.out.println("Total Products are: "+ip.getProductCount());
		addWait();
		test.log(Status.PASS,"Total Products calculated!");
		ip.getProductName();
		ip.addProductToCart(ps.getData("pname1"));
		test.log(Status.PASS,"Product added to the cart!");
		addWait();
		System.out.println("*******Cart Page*********");
		ap.getCartPage();
		addWait();
		ap.doRemoveProduct();
		test.log(Status.PASS,"Product removed");
		addWait();
		ap.doContinueshopping();
		addWait();
		test.log(Status.PASS,"Continue to inventory page for shopping");
		ip.addProductToCart(ps.getData("pname2"));
		addWait();
		ap.getCartPage();
		addWait();
		ap.doCheckout();
		System.out.println("*******Checkout Page*********");
		cp.doContinue(ps.getData("fn"),ps.getData("ln"),ps.getData("zc"));
		test.log(Status.PASS,"CheckOut is completed");
		System.out.println("*******Overview Page*********");
		test.log(Status.PASS,"Product details and Confirmation is done!");
		
		
		
		
	}
	@AfterTest 
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportFlush()
	{
		extent.flush();
	}
	
	
	
	
	
}
