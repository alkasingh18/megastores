package megastores;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import testlink.api.java.client.TestLinkAPIClient;
//import testlink.api.java.client.TestLinkAPIException;
//import testlink.api.java.client.TestLinkAPIResults;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class add_multiple_merchant_product_into_cart_from_login
{
	public WebDriver driver;
	public String baseUrl = "http://54.147.24.85/megastores/home";
	

	
	@BeforeClass
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
	
  @Test(priority = 1, retryAnalyzer = Retry_Analyzer.class)
  public void goto_product_listview() throws InterruptedException 
  {
	  String result = "";
	  String exception = null;
	  	    try {
	    	
	  	    	WebElement login =(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")));
			    login.click();
			    Thread.sleep(3000);
			    
			    WebElement username = driver.findElement(By.id("username_or_mobile"));
			    username.clear();
			    username.sendKeys("ashwini");
			    Thread.sleep(3000);
			    	    
			    WebElement password = driver.findElement(By.name("password"));
			    password.clear();
			    password.sendKeys("Mega@123");
			    Thread.sleep(3000);
			   
			    WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
			    login_button.click();
			    Thread.sleep(3000);
			    
			    if(driver.getPageSource().contains("Session expired. Please login again."))
			    {
					driver.findElement(By.id("username_or_mobile")).sendKeys("ashwini");
					Reporter.log("Username added");
					Thread.sleep(3000);
					
					driver.findElement(By.name("password")).sendKeys("Mega@123");
					Reporter.log("Password added");
					Thread.sleep(3000);
					//Add_multiple_merchant_products_into_cart_guest
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
//						result = TestLinkAPIResults.TEST_FAILED;
//						updateTestLinkResult("MSW-77", exception, result);
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
//					result = TestLinkAPIResults.TEST_FAILED;
//					updateTestLinkResult("MSW-77", exception, result);
					org.testng.Assert.fail();
				}
	    }catch (Exception e)
		{	
	    	exception = e.getMessage();
//	    	result = TestLinkAPIResults.TEST_FAILED;
//			updateTestLinkResult("MSW-77", exception, result);
			org.testng.Assert.fail();
		 } 
	    
	    if(driver.findElement(By.id("cart-count")).getText().contains("0"))
        {
             	WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
                image1.click();
                Reporter.log("Go to dashboard");
                Thread.sleep(10000);
            
        }
        else
        {
        WebElement go_to_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[3]/a/i")));
        go_to_cart.click();
        Reporter.log("Clicked on go to cart successfully");
        Thread.sleep(10000);
       
        WebElement clear_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clear-cart-btn\"]")));
        clear_cart.click();
        Reporter.log("Clicked on clear cart successfully");
        Thread.sleep(10000); 
        
        WebElement ok = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/button[1]")));
        ok.click();
        Reporter.log("Clicked on ok button successfully");
        Thread.sleep(10000); 
            
        WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
        image1.click();
        Reporter.log("Go to dashboard");
        Thread.sleep(10000);
        }
       
	    try {
	    	WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
			if(element.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[1]/a")).click();
				Reporter.log("Test Passed: Navigated to product listview");
				Thread.sleep(6000);
//				result = TestLinkAPIResults.TEST_PASSED;
//				updateTestLinkResult("MSW-77", null, result);
			}
			else {
				Reporter.log("Test failed: Shop By is not getting displayed");
//				result = TestLinkAPIResults.TEST_FAILED;
//				updateTestLinkResult("MSW-77", exception, result);
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
//			result = TestLinkAPIResults.TEST_FAILED;
//			updateTestLinkResult("MSW-77", exception, result);
			org.testng.Assert.fail();
		}
  }
  
  @Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
  public void add_product_diff_merchant_guest()  {
	  String result = "";
	  String exception = null;
	  try {
		  	//click on product
		    List<WebElement> allelements = driver.findElements(By.className("b-product_grid_single"));
		    int size=allelements.size();
		    for(int i=1;i<3;i++)
		    {
		    	WebElement product = allelements.get(i).findElement(By.xpath("//*[@id=\"product-body\"]/div["+i+"]/div/div[1]/a/img"));
		    	product.click();
		    	Thread.sleep(8000);
		    	
		    	String currentTab = driver.getWindowHandle();
		    	
		    	try {
			    	for(String tab : driver.getWindowHandles()) {
			    		if (!tab.equals(currentTab)) 
			    		{
			    			driver.switchTo().window(tab);
			    			Thread.sleep(6000);
			    	   }
			    }
			    	
			    	JavascriptExecutor scroll = (JavascriptExecutor) driver;
			    	scroll.executeScript("window.scrollBy(0,250)");
			    	
			    	WebElement element = driver.findElement(By.cssSelector(".b-product_single_action.clearfix"));
			    	String id = element.getAttribute("id");
			    	if(element.isDisplayed() && element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).isDisplayed()) 
			    	{
			    		element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).click();
			    		Reporter.log("Add to cart clicked for product from merchant " + i);
			    		Thread.sleep(3000);
			    		if(driver.getPageSource().contains("Product added successfully")) {
			    			Reporter.log("Product: " + id + " added successfully.");
			    			Thread.sleep(3000);
//			    			result = TestLinkAPIResults.TEST_PASSED;
//			    			updateTestLinkResult("MSW-77", null, result);
			    		}
			    		else if(driver.findElement(By.cssSelector(".swal2-modal.no-animation")).isDisplayed() && driver.findElement(By.cssSelector(".swal2-cancel.styled")).isDisplayed()) 
			    		{
			    			driver.findElement(By.cssSelector(".swal2-cancel.styled")).click();
			    			Reporter.log("Cancel Button Clicked");
			    			Thread.sleep(6000);
			    			WebElement element1 = driver.findElement(By.cssSelector(".b-product_single_action.clearfix"));
			    			String id1 = element1.getAttribute("id");
			    			if(element1.isDisplayed() && element1.findElement(By.xpath("//*[@id=\""+id1+"\"]/button[1]")).isDisplayed()) {
			    				element1.findElement(By.xpath("//*[@id=\""+id1+"\"]/button[1]")).sendKeys(Keys.ENTER);
			    				Reporter.log("Add to cart clicked again for product from merchant " + i);
			    				Thread.sleep(3000);
			    				if(driver.getPageSource().contains("Product added successfully")) {
			    					Reporter.log("Product: " + id1 + " added successfully." );
			    	    			Thread.sleep(3000);
//			    	    			result = TestLinkAPIResults.TEST_PASSED;
//			    	    			updateTestLinkResult("MSW-77", null, result);
			    				}
			    				else if(driver.findElement(By.cssSelector(".swal2-modal.no-animation")).isDisplayed() && driver.findElement(By.xpath("/html/body/div[9]/div/button[1]")).isDisplayed()) {
			    					WebElement Okbutton = driver.findElement(By.xpath("/html/body/div[9]/div/button[1]"));
			    					JavascriptExecutor executor = (JavascriptExecutor) driver;
			    					executor.executeScript("arguments[0].click();", Okbutton);
			    					Reporter.log("Ok button clicked.");
			    					Thread.sleep(3000);
			    					if(driver.getPageSource().contains("Product added successfully")) {
			    						Reporter.log("Product: " + id1 + " added successfully." );
			    						Thread.sleep(3000);
//			    						result = TestLinkAPIResults.TEST_PASSED;
//			    						updateTestLinkResult("MSW-77", null, result);
			    					}
			    					else {
			    						driver.close();
			    			    	    driver.switchTo().window(currentTab);
			    						Reporter.log("No message appeared for product added successfully.");
//			    						result = TestLinkAPIResults.TEST_FAILED;
//			    						updateTestLinkResult("MSW-77", exception, result);
			    						org.testng.Assert.fail();
			    						break;
			    					}
			    				}
			    				else {
			    					driver.close();
			    		    	    driver.switchTo().window(currentTab);
			    					Reporter.log("Product not added neither a pop up appeared for diff merchant after cancel.");
//			    					result = TestLinkAPIResults.TEST_FAILED;
//			    					updateTestLinkResult("MSW-77", exception, result);
			    					org.testng.Assert.fail();
			    					break;
			    				}
			    			}
			    			else {
			    				driver.close();
					    	    driver.switchTo().window(currentTab);
			    				Reporter.log("Element after cancel not displayed");
//			    				result = TestLinkAPIResults.TEST_FAILED;
//			    				updateTestLinkResult("MSW-77", exception, result);
			    				org.testng.Assert.fail();
			    				break;
			    			}
			    		}
			    		else {
			    			driver.close();
				    	    driver.switchTo().window(currentTab);
			    			Reporter.log("Product not added neither a pop up appeared for diff merchant");
//			    			result = TestLinkAPIResults.TEST_FAILED;
//			    			updateTestLinkResult("MSW-77", exception, result);
			    			org.testng.Assert.fail();
			    			break;
			    		}
			    	}
			    	else {
			    		driver.close();
			    	    driver.switchTo().window(currentTab);
			    		Reporter.log("Element not displayed");
//			    		result = TestLinkAPIResults.TEST_FAILED;
//			    		updateTestLinkResult("MSW-77", exception, result);
			    		org.testng.Assert.fail();
			    		break;
			    	}
			    	
			    	driver.close();
		    	    driver.switchTo().window(currentTab);
		    	    Thread.sleep(3000);
			  
				
				} catch (Exception e) {
					driver.close();
		    	    driver.switchTo().window(currentTab);
					exception=e.getMessage();
//					result = TestLinkAPIResults.TEST_FAILED;
//					updateTestLinkResult("MSW-77", exception, result);
					org.testng.Assert.fail();
				}
		    }
		      
		    driver.navigate().refresh();
		    Thread.sleep(4000);
		  
		    WebElement goto_cart=(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a/i")));
			goto_cart.click();
		    Thread.sleep(5000);
//		    result = TestLinkAPIResults.TEST_PASSED;
//			updateTestLinkResult("MSW-77", null, result);
			
			WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
		    image1.click();
		    Thread.sleep(5000);
		
	} catch (Exception e) {
		exception=e.getMessage();
//		result = TestLinkAPIResults.TEST_FAILED;
//		updateTestLinkResult("MSW-77", exception, result);
		org.testng.Assert.fail();
	}
  }
  
//  private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
//		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
//		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
//		}
  
  @AfterClass
  public void quit() {
		
		driver.quit();
  }
}