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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Goto_artisans_and_producers_page_goto_shrujan_detail_view_from_here	 
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
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
		  //go to website
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();	
		  
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

	          
	          driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	          driver.manage().window().maximize();
	          driver.get("http://54.147.24.85/megastores/home");
	      }
	}
	
  @Test(priority = 1, retryAnalyzer = Retry_Analyzer.class)
  public void goto_artisans_producers() throws InterruptedException 
  {
	  String result = "";
	  String exception = null;
	try {
		
		 WebElement artisan_producer = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[2]/a/span")));
		 artisan_producer.click();
		 Reporter.log("clicked on artisans and producers successfully");
		 Thread.sleep(8000);
			    
		 WebElement shrujan = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-top_category\"]/div[3]/div/div[1]/div/div[2]/h3/a")));
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click();", shrujan);
		 Reporter.log("clicked on Shrujan successfully");
		 Thread.sleep(5000);
			    
		 WebElement image = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/a/img"));
		 Thread.sleep(2000);
			 
		 WebElement story= driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div[2]/div/div/button"));
		 Thread.sleep(2000);
			    	    
		 WebElement embroidery=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[4]/div[1]/h3"));
		 Thread.sleep(2000);
			 
			 // Shrujan page
		 	if(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div")).isDisplayed())
			    {
			      driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/a/img")).isDisplayed();
			      Thread.sleep(3000);
			      driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[2]/div/h3")).equals("SHRUJAN");
			      Thread.sleep(3000);
			      Reporter.log("Shrujan loaded successfully");
			    }
			  else
			    {
				  
				  
				  org.testng.Assert.fail();
			      Reporter.log("Fail");
			    }
			    
			    //Story page
			    if(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div[2]/div/div/button")).isDisplayed())
			    {
			      driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[3]/div/div[2]/div/div/button")).sendKeys(Keys.ENTER);
			      Thread.sleep(3000);
			      Reporter.log("Story loaded successfully");
			      
			      
			    }
			  else
			    {
				  
				  
				  org.testng.Assert.fail();
			      Reporter.log("Fail");
			    }
			    
			    //embroidery
			    if(driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[4]/div[1]")).isDisplayed())
			    {
			    	driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[4]/div[1]/h3")).equals("EMBROIDERY");
			    	Thread.sleep(3000);
			    	Reporter.log("Embroidery page loaded successfully");
			    }
			  else
			    {
				  
				  
				  org.testng.Assert.fail();
			      Reporter.log("Fail");
			    }
		
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
