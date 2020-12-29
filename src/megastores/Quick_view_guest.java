package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Quick_view_guest
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
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
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
	public void quickview_guest() throws InterruptedException 
	{
		String result = "";
		String exception = null;
	try {
		
			WebElement product= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-new-products\"]")));
			product.click();
			Reporter.log("Product selected sucessfully");
			Thread.sleep(10000);
		    
		    WebElement quickbutton =driver.findElement(By.xpath("//*[@id=\"b-related_products\"]/div[1]/div/div[2]/div/div/div[1]/div/a[2]/i"));
		    quickbutton.click();
		    Reporter.log("Clicked on quick view button sucessfully");
		    Thread.sleep(5000);
		    
			
		    
		    WebElement cancel= driver.findElement(By.xpath("//*[@id=\"b-qucik_view\"]/div/div/button/i"));
		    cancel.click();
		    Reporter.log("Clicked on cancle button of quick view sucessfully");
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
