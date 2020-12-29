package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Filters
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
	public void filter() throws InterruptedException 
	{
	String result = "";
	String exception = null;
	try {
			    WebElement segment = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
			    segment.click();
			    Reporter.log("clicked on segment successfully");
			    Thread.sleep(5000);
			    
			    WebElement accessories = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a/span"));
			    accessories.click();
			    Reporter.log("clicked on accessories successfully");
			    Thread.sleep(5000);
			  
			    WebElement bags = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/a"));
			    bags.click();
			    Reporter.log("clicked on sub category successfully");
			    Thread.sleep(10000);
			    
			    WebElement sortby = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-1\"]/div/ul/li[3]/label/span")));
			    JavascriptExecutor sort_executor = (JavascriptExecutor)driver;
			    sort_executor.executeScript("arguments[0].click();", sortby);
			    Reporter.log("selected sort by filter successfully");
			    Thread.sleep(8000);
			    
			    java.util.List<WebElement> price_high_low = driver.findElements(By.className("b-price"));
		        System.out.println(price_high_low.size());
		        //List ourAl = new ArrayList<>();
		        for (int i = 0; i<price_high_low.size(); i=i+1) 
		        {
		        	
		     	   Reporter.log(price_high_low.get(i).getText());         
		        }           
			    
			    WebElement subcategory = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-2\"]/div/ul/li[3]/label/span")));
			    JavascriptExecutor executor = (JavascriptExecutor)driver;
			     executor.executeScript("arguments[0].click();", subcategory);
			     Reporter.log("selected subcategory filter successfully");
			     Thread.sleep(8000);
			     
			     WebElement price = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-3-head\"]/h5")));
			     JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			     executor1.executeScript("arguments[0].click();", price);
			     Reporter.log("clicked on price filter successfully");
				    Thread.sleep(8000);
				    
				    WebElement pricefilter = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-2\"]/div")));
				     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pricefilter);
				     Reporter.log("clicked on price range successfully");
				     Thread.sleep(8000);
				      
			     WebElement pricebar = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"range-slider\"]/div/div[2]/div")));
			     
			     new Actions(driver).dragAndDropBy(pricebar, 100, 0).build().perform();
			     Reporter.log("selected price range successfully");
			     Thread.sleep(5000);
			     
			   // After 5 seconds, This will Move jQuery slider by 100 pixel offset using the combination of clickAndHold, moveByOffset and release methods of Actions class.
			     //new Actions(driver).clickAndHold(pricebar).moveByOffset(100,0).release().perform();
			   // Thread.sleep(3000);
			     
			      WebElement brands = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-4-head\"]/h5")));
				    brands.click();
				    Reporter.log("clicked on brands filter successfully");
				    Thread.sleep(8000);
				 
				  /*  if (driver.findElement(By.className("b-product_grid_single")).getText().contains("VGS Batik"))
				    {
				    	System.out.println("Products from "+driver.findElement(By.className("b-product_grid_single")).getText());
				    }
				    else
				    {
				    	org.testng.Assert.fail();
				    }
				    */
			     
				    WebElement brand = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-4\"]/div/ul/li[7]/label/span")));
				    JavascriptExecutor executor2 = (JavascriptExecutor)driver;
				     executor2.executeScript("arguments[0].click();", brand);
				     Reporter.log("selected brand filter successfully");
				     Thread.sleep(8000);
				     
				     WebElement merchantfilter = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-4\"]/div")));
				     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", merchantfilter);
				     Reporter.log("clicked on merchant filter successfully");
				     Thread.sleep(8000);
				     
				     WebElement merchants = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-merchant-head\"]/h5")));
					 merchants.click();
					 Reporter.log("selected merchant filter successfully");
					 Thread.sleep(5000);
				     
					 WebElement merchant = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filter-merchant\"]/div/ul/li[4]/label/span")));
					 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
					 executor3.executeScript("arguments[0].click();", merchant);
					 Reporter.log("selected merchant filter successfully");
					 Thread.sleep(5000);
					
			    WebElement clearall = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clear-filter\"]")));
			    clearall.sendKeys(Keys.ENTER);
			    Reporter.log("clicked on clear all button successfully");
			    Thread.sleep(5000);
			   
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
  
