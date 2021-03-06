package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Product_Listview_Left_Nav {
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath =  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
	public WebDriver driver;
	TestData data = new TestData();
	
	//Configure Testlink with Project Name, Testplan Name & Build Name
	public static String DEV_KEY = "1881c140942b0c0d0c824008f2d18006";

			
	//Following url posts the test results onto testlink
	public static String SERVER_URL = "http://testlink.atulsia.com/lib/api/xmlrpc/v1/xmlrpc.php";
			
	//Name of the project,plan & build you are testing on
	public static String PROJECT_NAME = "Megastores_Web"; 
	public static String PLAN_NAME = "Megastores-Web Test plan";
	public static String BUILD_NAME = "Version 1.2";
	
	@BeforeClass
	public void browser_launch() {
		 System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			try {
				driver.manage().window().maximize();
				driver.get(baseurl);	
			} catch (Exception e) {
				driver.navigate().refresh();
			}
	}
	
	@Test(priority = 1, retryAnalyzer = Retry_Analyzer.class)
	public void go_to_listview()  {
		String result = "";
		String exception = null;
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("location.reload()");
			assertEquals(driver.getCurrentUrl(), baseurl);
			WebElement element = (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[5]/a")).click();
				Thread.sleep(2000);
				
				
			}
			else {
				Reporter.log("Test failed: Shop By Segment is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void click_load_more()  {
		String result = "";
		String exception = null;
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("location.reload()");
			//WebElement element1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("load-more")));
			for (int i = 1; i >= 0; i++) {
				if (driver.findElement(By.id("load-more")).isDisplayed()) {
					//WebElement grid_element = (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
					driver.findElement(By.id("load-more")).sendKeys(Keys.ENTER); 
					Reporter.log("Load more clicked " + i + " times.");
					Thread.sleep(2000);
					
					
				}
				else if (driver.findElement(By.id("load-more")).isDisplayed()!=true) {
					Reporter.log("Load more not displayed, reached till the end of the listview");
					
					
					break;
				}
				else {
					Reporter.log("Test failed: Load More button is not getting displayed");
					
					
					org.testng.Assert.fail();
					break;
				}	
			}
		
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	

	@AfterClass
	public void quit() {
		driver.quit();
		boolean hasquit = driver.toString().contains("(null)");
		System.out.println("Did driver quit? (True/False): " + hasquit);
	}
}
