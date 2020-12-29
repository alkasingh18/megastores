package megastores;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class product_reviewt_thumb_guest  
{
	public ChromeDriver driver;
	//Configure Testlink with Project Name, Testplan Name & Build Name
	public static String DEV_KEY = "1881c140942b0c0d0c824008f2d18006";

				
	//Following url posts the test results onto testlink
	public static String SERVER_URL = "http://testlink.atulsia.com/lib/api/xmlrpc/v1/xmlrpc.php";
				
	//Name of the project,plan & build you are testing on
	public static String PROJECT_NAME = "Megastores_Web"; 
	public static String PLAN_NAME = "Megastores-Web Test plan";
	public static String BUILD_NAME = "Version 1.2";
	
  @Test
  public void vote_review_guest() throws InterruptedException
  {
	String result ="";
	String exception = null;
	 try {
		  System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
		  
	//go to website   
	driver = new ChromeDriver();
	driver.manage().window().maximize();	
	//String baseUrl = "http://54.147.24.85/megastores/home";
	//driver.get(baseUrl);
	//assertEquals(driver.getCurrentUrl(), baseUrl);

	//waits 10 seconds for page to load
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	try 
	{
	driver.get("http://54.147.24.85/megastores/home");
	}
	catch (TimeoutException e)
	{
	driver.close();
	driver.quit();

	//create new instance of webdriver
	driver = new ChromeDriver();

	//waits 5 minutes for page to load
	driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://54.147.24.85/megastores/home");

	}
			WebElement trending=(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("b-trending-products")));
		    trending.click();
			Reporter.log("Go to trending product");
		    Thread.sleep(5000);
		    
		    WebElement product_click = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[1]/div/div/div[1]/a/img")));
		    product_click.click();
		    Reporter.log("Clicked on product successfully");
		    Thread.sleep(10000);
		    
		    String currentTab = driver.getWindowHandle();
		    for (String tab : driver.getWindowHandles()) 
		    {
		       if (!tab.equals(currentTab)) 
		       {
		           driver.switchTo().window(tab);
		           Reporter.log("Focus shifted to product detail view successfully");
		       }
		    }
		    WebElement review_tab =(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"open_review_tab\"]/a")));
		    review_tab.sendKeys(Keys.ENTER);
		    Reporter.log("Go to review tab");
	        Thread.sleep(8000);
	        
	        
	        WebElement thumb = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vote_btn_58\"]/i")));
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thumb);
		     
		     WebElement thumb1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vote_btn_68\"]")));
	        thumb1.sendKeys(Keys.ENTER);
		    Reporter.log("Clicked on thumb icon successfully");
	        Thread.sleep(5000);
	        
	        WebElement click_ok = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[9]/div/button[1]")));
		    click_ok.sendKeys(Keys.ENTER);
		    Reporter.log("Clicked on ok button successfully");
	        Thread.sleep(10000);
	        
	        WebElement username = driver.findElement(By.id("username_or_mobile"));
	        username.clear();
	        username.sendKeys("ashwini");
	        Reporter.log("Username entered successfully");
		    Thread.sleep(5000);
	        
		    WebElement password = driver.findElement(By.name("password"));
	        password.clear();
	        password.sendKeys("Mega@123");
	        Reporter.log("Password entered successfully");
		    Thread.sleep(5000);	
		    
		    WebElement login = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
		    login.click();
		    Reporter.log("Clicked on login button successfully");
		    Thread.sleep(3000);
		    
		    if(driver.getPageSource().contains("Session expired. Please login again."))
		    {
				driver.findElement(By.id("username_or_mobile")).sendKeys("ashwini");
				Reporter.log("Username added");
				Thread.sleep(3000);
				
				driver.findElement(By.name("password")).sendKeys("Mega@123");
				Reporter.log("Password added");
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
				Reporter.log("Submit clicked");
				Thread.sleep(3000);
				
				//To check that the Login is successfull after session expiry
				if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed())
				{
					Reporter.log("Login successfull after session expiry");
					Thread.sleep(3000);
				}
				else 
				{
					
					
					org.testng.Assert.fail();
				}
			} 
		    if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed())
		    {
				System.out.println("Login successfull");
				Thread.sleep(3000);
			}
			else 
			{
				
				
				org.testng.Assert.fail();
			}
		    	 
		    if(driver.getPageSource().contains("YOUR CART IS CURRENTLY EMPTY") || driver.getPageSource().contains("You have 1 item in your cart"))
		    {
		    	
		    WebElement image1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")));
		    image1.click();
		    Reporter.log("Go to dashboard");
		    Thread.sleep(10000);
		    
		    WebElement trending1= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("b-trending-products")));
		    trending1.click();
		    Reporter.log("Go to trending products");
		    Thread.sleep(5000);
		    
		    WebElement product_click1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[1]/div/div/div[1]/a/img")));
		    product_click1.click();
		    Reporter.log("Product selected successfully");
		    Thread.sleep(10000);
		    
		    String currentTab1 = driver.getWindowHandle();
		    for (String tab : driver.getWindowHandles()) 
		    {
		       if (!tab.equals(currentTab1)) 
		       {
		           driver.switchTo().window(tab);
		           Reporter.log("Focus shifted to product detail view successfully");
		       }
		    }
		    
		    WebElement reviewtab= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"open_review_tab\"]/a")));
		    reviewtab.sendKeys(Keys.ENTER);
		    Reporter.log("Go to review tab");
	        Thread.sleep(8000);
	        
	        WebElement thumb2= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vote_btn_68\"]")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thumb2);
	        thumb2.sendKeys(Keys.ENTER);
	        Reporter.log("Clicked on thumb icon successfully");
	        Thread.sleep(5000);
	        
			
		   }       
		    else if(driver.getPageSource().contains("VGS Batik Womens Machine Embroidered and Hand Stitched Black Velvet Zola Bag"))
		    {
		    	WebElement reviewtab1= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"open_review_tab\"]/a")));
		   reviewtab1.sendKeys(Keys.ENTER);
	        Reporter.log("Go to review tab");
	        Thread.sleep(5000);
	        
	        WebElement thumb2= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vote_btn_68\"]")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thumb2);
	        thumb2.sendKeys(Keys.ENTER);
	        Reporter.log("Clicked on thumb icon successfully");
	        Thread.sleep(5000);
	        Reporter.log("Review Voted successfully");
	       }
	      
		    
	    /*    if(driver.getPageSource().contains("Review voted successfully."))
	        {
	            System.out.println("Review Voted successfully");
	        }
	      */
		  
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  

  
  @AfterClass
  public void quit() {
	  driver.quit();
  }
}
