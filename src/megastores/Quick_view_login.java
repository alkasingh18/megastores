package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

public class Quick_view_login 
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
  public void quickview_login() throws InterruptedException
  {
	  String result = "";
	  String exception = null;
	  
	  try {   
		    WebElement login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")));
		    login.click();
		    Reporter.log("Clicked on login button sucessfully");
		    Thread.sleep(10000);
		    
		    WebElement username = driver.findElement(By.id("username_or_mobile"));
		    username.clear();
		    username.sendKeys("ashwini");
		    Reporter.log("Username added sucessfully");
		    Thread.sleep(5000);
		    	    
		    WebElement password = driver.findElement(By.name("password"));
		    password.clear();
		    password.sendKeys("Mega@123");
		    Reporter.log("Password added sucessfully");
		    Thread.sleep(5000);
		   
		    WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
		    login_button.click();
		    Reporter.log("Clicked on login button sucessfully");
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
					Reporter.log("Failed to login after session expiry");
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
				Reporter.log("Test failed: Some error occured while login");
			
				org.testng.Assert.fail();
			}
		    
		    WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
		    image1.click();
		    Reporter.log("Go to dashboard");
		    Thread.sleep(10000);
	  
		    WebElement product= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-new-products\"]")));
		    product.click();
		    Reporter.log("Product selected successfully");
		    Thread.sleep(10000);
		    
		    WebElement quickbutton =driver.findElement(By.xpath("//*[@id=\"b-related_products\"]/div[1]/div/div[2]/div/div/div[1]/div/a[2]/i"));
		    quickbutton.click();
		    Reporter.log("Clicked on quick view button successfully");
		    Thread.sleep(5000);
		    
		    WebElement cancel= driver.findElement(By.xpath("//*[@id=\"b-qucik_view\"]/div/div/button/i"));
		    cancel.click();
		    Reporter.log("Clicked on cancel button successfully");
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
