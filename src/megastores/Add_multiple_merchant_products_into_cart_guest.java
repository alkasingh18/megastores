package megastores;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_multiple_merchant_products_into_cart_guest
{
	public WebDriver driver;
	//Configure Testlink with Project Name, Testplan Name & Build Name
	public static String DEV_KEY = "1881c140942b0c0d0c824008f2d18006";

				
	//Following url posts the test results onto testlink
	public static String SERVER_URL = "http://testlink.atulsia.com/lib/api/xmlrpc/v1/xmlrpc.php";
				
	//Name of the project,plan & build you are testing on
	public static String PROJECT_NAME = "Megastores_Web"; 
	public static String PLAN_NAME = "Megastores-Web Test plan";
	public static String BUILD_NAME = "Version 1.2";
	
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
 public void add_product_multiple_merchant_guest() throws InterruptedException 
  {
	  String result= "";
	  String exception = null;
try 
{
	WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
	if(element.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).isDisplayed()) {
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[7]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[1]/a")).click();
		Reporter.log("Test Passed: Navigated to product listview");
		Thread.sleep(6000);
		 
		
	}
	else {
		Reporter.log("Test failed: Shop By is not getting displayed");
		
		
		org.testng.Assert.fail();
	}
} catch (Exception e) {
	exception=e.getMessage();
	
	
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
    for(int i=1;i<3;i++){
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
    	if(element.isDisplayed() && element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).isDisplayed()) {
    		element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).click();
    		Reporter.log("Add to cart clicked for product from merchant " + i);
    		Thread.sleep(3000);
    		if(driver.getPageSource().contains("Product added successfully")) {
    			Reporter.log("Product: " + id + " added successfully." );
    			Thread.sleep(3000);
    			 
    			
    		}
    		else if(driver.findElement(By.cssSelector(".swal2-modal.no-animation")).isDisplayed() && driver.findElement(By.cssSelector(".swal2-cancel.styled")).isDisplayed()) {
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
    						 
    		    			
    					}
    					else {
    						driver.close();
    					    driver.switchTo().window(currentTab);
    						Reporter.log("No message appeared for product added successfully.");
    						
    						
    						org.testng.Assert.fail();
    						break;
    					}
    				}
    				else {
    					driver.close();
    				    driver.switchTo().window(currentTab);
    					Reporter.log("Product not added neither a pop up appeared for diff merchant after cancel.");
    					
    					
    					org.testng.Assert.fail();
    					break;
    				}
    			}
    			else {
    				driver.close();
    			    driver.switchTo().window(currentTab);
    				Reporter.log("Element after cancel not displayed");
    				
    				
    				org.testng.Assert.fail();
    				break;
    			}
    		}
    		else {
    			driver.close();
    		    driver.switchTo().window(currentTab);
    			Reporter.log("Product not added neither a pop up appeared for diff merchant");
    			
    			
    			org.testng.Assert.fail();
    			break;
    		}
    	}
    	else {
    		driver.close();
    	    driver.switchTo().window(currentTab);
    		Reporter.log("Element not displayed");
    		
    		
    		org.testng.Assert.fail();
    		break;
    	}
    	driver.close();
	    driver.switchTo().window(currentTab);
	    Thread.sleep(3000);
	} catch (Exception e) {
		driver.close();
	    driver.switchTo().window(currentTab);
		exception = e.getMessage();
		
		
		org.testng.Assert.fail();
	}	
    }	
	
      
    driver.navigate().refresh();
    Thread.sleep(4000);
  
    WebElement goto_cart= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a/i")));
	goto_cart.click();
    Thread.sleep(5000);
     
	
	
	WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
    image1.click();
    Thread.sleep(5000);

} catch (Exception e) {
	exception = e.getMessage();
	
	
	org.testng.Assert.fail();
}
}



@AfterClass
public void quit() {
driver.quit();
}
}
