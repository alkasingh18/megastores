package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Add_product_to_fav_login 
{
	public WebDriver driver;
	
	@BeforeSuite
	public void browser_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
		  //go to website
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();	
		  //  String baseUrl = "http://54.147.24.85/megastores/home";
		   // driver.get(baseUrl);
		   // assertEquals(driver.getCurrentUrl(), baseUrl);
		    
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

	}
	
  @Test(priority = 1)
  public void Goto_productdetailview() throws InterruptedException
  {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
	  
	  //go to website
	  
       	 driver = new ChromeDriver();
	  	 driver.manage().window().maximize();	
	    String baseUrl = "http://54.147.24.85/megastores/home";
	    driver.get(baseUrl);
	    assertEquals(driver.getCurrentUrl(), baseUrl);
	    
	    try {
	    	WebElement login = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]"));
		    login.click();
		    Reporter.log("clicked on login button successfully");
		    Thread.sleep(3000);
		    
		    WebElement username = driver.findElement(By.id("username_or_mobile"));
		    username.clear();
		    username.sendKeys("ashwini");
		    Reporter.log("Username entered successfully");
		    Thread.sleep(3000);
		    	    
		    WebElement password = driver.findElement(By.name("password"));
		    password.clear();
		    password.sendKeys("Mega@123");
		    Reporter.log("Password enetered successfully");
		    Thread.sleep(3000);
		   
		    WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
		    login_button.click();
		    Reporter.log("Logged in successfully");
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
					Reporter.log("Login unsuccessfull after session expiry");
					org.testng.Assert.fail();
				}
			} 
		    if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed())
		    {
				Reporter.log("Login successfull");
				Thread.sleep(3000);
			}
			else
			{
				Reporter.log("Login unsucesfull");
				org.testng.Assert.fail();
			}
				
		    	WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
		        image1.click();
		        Reporter.log("go to dashboard");
		        Thread.sleep(3000);
		    	
		
			 driver.findElement(By.id("b-featured-products")).click();
			 Reporter.log("Go to featured-products");
			    Thread.sleep(6000);
			    
			    WebElement product_click = driver.findElement(By.xpath("//*[@id=\"b-featured_products\"]/div[1]/div/div[1]/div/div/div[1]/a/img"));
			    product_click.click();
			    Reporter.log("clicked on product successfully");
			    Thread.sleep(10000);

		} catch (Exception e) {
			e.printStackTrace();
			org.testng.Assert.fail();
		}
  }
  
  @Test(priority = 2)
  public void add_prod_fav_login() throws InterruptedException {
	  try {
		   String currentTab = driver.getWindowHandle();

			  for (String tab : driver.getWindowHandles()) 
			   {
			       if (!tab.equals(currentTab))
			       {
			           driver.switchTo().window(tab);
			           Reporter.log("Focus shifted to product detail tab successfully");
			           Thread.sleep(10000);
			       }
			    }     
			  
			  	JavascriptExecutor scroll = (JavascriptExecutor) driver;
		    	scroll.executeScript("window.scrollBy(0,250)");
		    	Thread.sleep(10000);
		    	
			    WebElement fav = driver.findElement(By.className("makeWishlist"));
			    Actions actions_scroll = new Actions(driver);
				actions_scroll.moveToElement(fav);
				actions_scroll.click().build().perform();
			  
			  	//driver.findElement(By.className("makeWishlist")).click();
			  
			  
//			    JavascriptExecutor executor = (JavascriptExecutor) driver;
//			    executor.executeScript("arguments[0].click();", fav);
			    Reporter.log("clicked on fav successfully");
			    Thread.sleep(2000);
		        if(driver.getPageSource().contains("Product added successfully")) {
		        	WebElement wishlist = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a")));
				    JavascriptExecutor executor_wishlist = (JavascriptExecutor) driver;
		 		    executor_wishlist.executeScript("arguments[0].click();", wishlist);
				    Reporter.log("clicked on wishlist successfully");
			        Thread.sleep(10000);
		        }
		        else if(driver.getPageSource().contains("Product removed from your wishlist")) {
		        	WebElement fav1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[1]/div/div/div/div/div[2]/div/div[4]/ul/li[1]/a")));
		        	JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		 		    executor1.executeScript("arguments[0].click();", fav1);
		 		    Reporter.log("clicked on fav successfully");
		 	        Thread.sleep(2000);
		 	        if (driver.getPageSource().contains("Product added successfully")) {
		 	        	WebElement wishlist1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a")));
					    JavascriptExecutor executor_wishlist1 = (JavascriptExecutor) driver;
			 		    executor_wishlist1.executeScript("arguments[0].click();", wishlist1);
					    Reporter.log("clicked on wishlist successfully");
				        Thread.sleep(10000);
					} else {
						Reporter.log("Test failed: Expected message of product added to favorite does not match the current displayed message");
						Thread.sleep(10000);
						org.testng.Assert.fail();
					}
		        }
		        else {
		        	Reporter.log("Test failed: None of the expected messages occured");
		        	Thread.sleep(10000);
		        	org.testng.Assert.fail();
		        }
		        
		       
		        WebElement logout = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a"));
			    logout.click();
			    Reporter.log("logged out successfully");
			    Thread.sleep(3000);
			         
			//driver.switchTo().window(currentTab);
	} catch (Exception e) {
		e.printStackTrace();
		org.testng.Assert.fail();
	}
  }
 
  @AfterClass
  public void quit() {
	  driver.quit();
  }
}

