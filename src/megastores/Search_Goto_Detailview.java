package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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


public class Search_Goto_Detailview {
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath = "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
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
	public void start_browser() {
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
	public void search_Goto_detailview_shrujan()  {
		String result = "";
		String exception = null;
		
	try {
		assertEquals(baseurl, driver.getCurrentUrl());
		if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys("Tharad");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys(Keys.ENTER);
			Reporter.log("Searched for Tharad");
			Thread.sleep(3000);
			
			
		}
		else {
			Reporter.log("Test failed: Solar search is not getting displayed");
			
			
			org.testng.Assert.fail();
		}
		
		WebElement listview = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
		if(driver.findElement(By.className("b-product_grid_single")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
			Reporter.log("Product Clicked successfully");
			Thread.sleep(3000);
			
			
		}
		else {
			Reporter.log("Test failed: Product Listview is not getting displayed");
			
			
			org.testng.Assert.fail();
		}
		
		WebElement detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
		WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
		WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
		WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
		WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
		WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
		
		if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
			Merchant_Info.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Shrujan Creations")) {
				Reporter.log("Test Passed: Navigated to detailview of Shrujan product successfully");
				Thread.sleep(2000);
				
				
			}
			else {
				Reporter.log("Test failed: Merchant Info for Shrujan is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
	
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
			Thread.sleep(2000);
		}
		else {
			Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by not getting displayed");
			
			
			org.testng.Assert.fail();
		}
	} catch (Exception e) {
		exception=e.getMessage();
		
			
		org.testng.Assert.fail();
	}		
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void goto_detailview_vrdi()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys("Batik Kurti");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys(Keys.ENTER);
				Reporter.log("Searched for Batik Kurti");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Solar search not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement listview = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
			if(driver.findElement(By.className("b-product_grid_single")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
				Reporter.log("Product Clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Product Listview is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
			WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
			WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
			WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
			WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
			WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
			
			if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
				Merchant_Info.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				if(driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
					Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
					Thread.sleep(2000);
					
					
				}
				else {
					Reporter.log("Test failed: Merchant Info for VRDI is not getting displayed");
					
					
					org.testng.Assert.fail();
				}
		
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
				Thread.sleep(2000);
			}
			else {
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}		
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void goto_detailview_mohmed_khatri()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys("Ajrakh");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys(Keys.ENTER);
				Reporter.log("Searched for Ajrakh");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Solar search not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement listview = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
			if(driver.findElement(By.className("b-product_grid_single")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
				Reporter.log("Product Clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Product Listview is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
			WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
			WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
			WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
			WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
			WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
			
			if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
				Merchant_Info.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				if(driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Dr. Ismail Mohmed Khatri")) {
					Reporter.log("Test Passed: Navigated to detailview of Mohmed Khatri product successfully");
					Thread.sleep(2000);
					
					
				}
				else {
					Reporter.log("Test failed: Merchant Info for Mohmed Khatri is not getting displayed");
					
					
					org.testng.Assert.fail();
				}
		
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
				Thread.sleep(2000);
			}
			else {
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by not getting displayed");
				
				
				org.testng.Assert.fail();
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
