package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Goto_productdetailveiw {
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
	public void goto_detailview_Dashboard()  {
		String result = "";
		String exception = null;
		//assertEquals(baseurl, driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
		//Going to product detailview from Best Merchants.
		String currentTab_bestmerchant = driver.getWindowHandle();
		try {
			WebElement best_merchant = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-featured-products\"]/div[1]/h4")));
			if (driver.findElement(By.xpath("//*[@id=\"b-featured-products\"]/div[1]/h4")).getText().equals("BEST MERCHANTS")) {
				driver.findElement(By.xpath("//*[@id=\"b-featured_products\"]/div[1]/div/div[1]/div/div/div[1]/a/img")).click();
				Thread.sleep(5000);
			} else {
				Reporter.log("Test failed: Section does not contain title best merchant");
				
				
				org.testng.Assert.fail();
			}
		}
			catch (Exception e) {
				exception=e.getMessage();
				
				
				org.testng.Assert.fail();
			}
		
		try {
			for (String tab : driver.getWindowHandles()) {
			   if (!tab.equals(currentTab_bestmerchant)) {
			       driver.switchTo().window(tab);
			       Thread.sleep(3000);
			   }
			}
			WebElement detailview_best_merchant = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
			WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
			WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
			WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
			WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
			WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
			
			if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
				Merchant_Info.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				WebElement merchant_info_best = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
				if(merchant_info_best.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
					Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
					Thread.sleep(2000);
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_bestmerchant);
					Reporter.log("Test failed: VRDI merchant info is not getting displayed");
					org.testng.Assert.fail();
				}
			}
			else {
				driver.close();
				driver.switchTo().window(currentTab_bestmerchant);
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			driver.close();
			driver.switchTo().window(currentTab_bestmerchant);
			Thread.sleep(6000);
		}
		catch (Exception e) {
			driver.close();
			driver.switchTo().window(currentTab_bestmerchant);
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
		//=====================================================================================
			
		//===============Going to detailview from New Arrivals=================================
			String currentTab_newarrival = driver.getWindowHandle();
			try {
				WebElement new_arrivals = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-new-products\"]/div[1]/h4")));
				if (driver.findElement(By.xpath("//*[@id=\"b-new-products\"]/div[1]/h4")).getText().equals("NEW ARRIVALS")) {
					driver.findElement(By.xpath("//*[@id=\"b-related_products\"]/div[1]/div/div[2]/div/div/div[1]/a/img")).click();
					Thread.sleep(5000);
				} else {
					Reporter.log("Test failed: Section does not consist of New Arrival title");
					
					
					org.testng.Assert.fail();
				}
			}
			catch (Exception e) {
					exception=e.getMessage();
					
					
					org.testng.Assert.fail();
				}
				
			try {
				for (String tab : driver.getWindowHandles()) {
				   if (!tab.equals(currentTab_newarrival)) {
				       driver.switchTo().window(tab);
				       Thread.sleep(3000);
				   }
				}
				WebElement detailview_newarrivals = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
				WebElement description_newarrival = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
				WebElement Reviews_newarrival = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
				WebElement Specifications_newarrival = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
				WebElement Merchant_Info_newarrival = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
				WebElement Created_By_newarrival = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
				
				if(description_newarrival.isDisplayed() && Reviews_newarrival.isDisplayed() && Specifications_newarrival.isDisplayed() && Merchant_Info_newarrival.isDisplayed() && Created_By_newarrival.isDisplayed()) {
					Merchant_Info_newarrival.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					WebElement merchant_info_newarr = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
					if(merchant_info_newarr.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Shrujan Creations")) {
						Reporter.log("Test Passed: Navigated to detailview of Shrujan product successfully");
						Thread.sleep(2000);
						
						
					}
					else {
						driver.close();
						driver.switchTo().window(currentTab_newarrival);
						Reporter.log("Test failed: Merchant Info for Shrujan is not getting displayed");
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_newarrival);
					Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
					
					
					org.testng.Assert.fail();
				}
				driver.close();
				driver.switchTo().window(currentTab_newarrival);
				Thread.sleep(6000);
			} catch (Exception e) {
				driver.close();
				driver.switchTo().window(currentTab_newarrival);
				exception=e.getMessage();
				
				
				org.testng.Assert.fail();
			}
			
		//=========================================================================================================
		
		//=========================Go to product detailview from Trending==========================================
			String currentTab_trending = driver.getWindowHandle();
			try {
				WebElement trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-trending-products\"]/div[1]/h4")));
				if (driver.findElement(By.xpath("//*[@id=\"b-trending-products\"]/div[1]/h4")).getText().equals("TRENDING")) {
//					Actions actions_scroll = new Actions(driver);
//					actions_scroll.moveToElement(driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[2]/div[2]")));
//					for(int i=0; i<1; i++) {	
//						actions_scroll.click().build().perform();
//						Thread.sleep(5000); 
//					}
					
					WebElement scroll = driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[2]/div[2]"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", scroll);
					Thread.sleep(5000);
					
					if(driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")).isDisplayed()) {
						Actions actions = new Actions(driver);
						actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")));
						actions.click().build().perform();
						Reporter.log("Rogan Product clicked");
						Thread.sleep(10000);
						
						
					}
					else {
						Reporter.log("Trending Product not found.");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
					
					//driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")).sendKeys(Keys.ENTER);
					
				} else {
					Reporter.log("Test failed: Section does not consist of title Trending");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
					}
			}
			catch (Exception e) {
					exception=e.getMessage();
					
					
					org.testng.Assert.fail();
				}
				
			try {
				for (String tab : driver.getWindowHandles()) {
				   if (!tab.equals(currentTab_trending)) {
				       driver.switchTo().window(tab);
				       Thread.sleep(3000);
				   }
				}
				
				WebElement detailview_trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
				WebElement description_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
				WebElement Reviews_trending = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
				WebElement Specifications_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
				WebElement Merchant_Info_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
				WebElement Created_By_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
				
				if(description_trending.isDisplayed() && Reviews_trending.isDisplayed() && Specifications_trending.isDisplayed() && Merchant_Info_trending.isDisplayed() && Created_By_trending.isDisplayed()) {
					Merchant_Info_trending.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					WebElement merchant_info_trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
					if(merchant_info_trending.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("The Traditional Rogan Art")) {
						Reporter.log("Test Passed: Navigated to detailview of Rogan Art product successfully");
						Thread.sleep(2000);
						
						
					}
					else {
						driver.close();
						driver.switchTo().window(currentTab_trending);
						Reporter.log("Test failed: Merchant Info for Rogan Art is not getting displayed");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_trending);
					Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
				driver.close();
				driver.switchTo().window(currentTab_trending);
				Thread.sleep(6000);
			} catch (Exception e) {
				driver.close();
				driver.switchTo().window(currentTab_trending);
				exception=e.getMessage();
				
				
				org.testng.Assert.fail();
			}

		//=======================================================================================================
		
		//==================================Featured Segments====================================================
			String currentTab_segment = driver.getWindowHandle();
			try {
				WebElement segments = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-products_cat\"]/div[2]/div/div/div[3]/div/a/img")));
				if(segments.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-products_cat\"]/div[2]/div/div/div[3]/div/a/img")).isDisplayed()) {
					Actions segment = new Actions(driver);
					segment.moveToElement(driver.findElement(By.xpath("//*[@id=\"b-products_cat\"]/div[2]/div/div/div[3]/div/a/img")));
					segment.click().build().perform();
					//driver.findElement(By.xpath("//*[@id=\"b-products_cat\"]/div[2]/div/div/div[3]/div/div/a")).click();
					Reporter.log("Segment Accessories clicked successfully");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Segments is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
				
				WebElement merchants = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
				if (merchants.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div[1]/a/img")).isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div[1]/a/img")).click();
					Reporter.log("Segment Shrujan Merchant clicked successfully");
					Thread.sleep(3000);
					
					
				} else {
					Reporter.log("Test failed: Merchant Shrujan is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
				
				WebElement prod_listview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
				if (prod_listview.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
					Reporter.log("Shrujan product clicked successfully");
					Thread.sleep(5000);
					
					
				} else {
					Reporter.log("Test failed: Product Listview is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
			}
				catch (Exception e) {
					exception=e.getMessage();
					
					
					org.testng.Assert.fail();
				}
				
			try {
				for (String tab : driver.getWindowHandles()) {
				   if (!tab.equals(currentTab_segment)) {
				       driver.switchTo().window(tab);
				       Thread.sleep(3000);
				   }
				}
				
				WebElement prod_detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
				WebElement description_seg = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
				WebElement Reviews_seg = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
				WebElement Specifications_seg = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
				WebElement Merchant_Info_seg = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
				WebElement Created_By_seg = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
				
				if(description_seg.isDisplayed() && Reviews_seg.isDisplayed() && Specifications_seg.isDisplayed() && Merchant_Info_seg.isDisplayed() && Created_By_seg.isDisplayed()) {
					Merchant_Info_seg.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					WebElement merchant_info_seg = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
					if(merchant_info_seg.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Shrujan Creations")) {
						Reporter.log("Test Passed: Navigated to detailview of Shrujan Creations product successfully");
						Thread.sleep(2000);
						
						
					}
					else {
						driver.close();
						driver.switchTo().window(currentTab_segment);
						Reporter.log("Test failed: Merchant Info for Shrujan is not getting displayed");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_segment);
					Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
				driver.close();
				driver.switchTo().window(currentTab_segment);
				Thread.sleep(6000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				driver.close();
				driver.switchTo().window(currentTab_segment);
				exception=e.getMessage();
				
				
				org.testng.Assert.fail();
			}
			
			
		//======================================================================================================================================
			
		//==========================================Top Category====================================================
			String currentTab_topcat = driver.getWindowHandle();
			try {
			WebElement top_category = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-top_category\"]/div[2]/div/div[1]/div/div[1]")));
			if (top_category.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-top_category\"]/div[2]/div/div[1]/div/div[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-top_category\"]/div[2]/div/div[1]/div/div[1]")).click();
				Reporter.log("Bags clicked in Top Category");
				Thread.sleep(6000);
				
				
			} else {
				Reporter.log("Test failed: Top Category is not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			
			WebElement prod_listview_topcat = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
			if (prod_listview_topcat.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
				Reporter.log("Shrujan product clicked successfully");
				Thread.sleep(5000);
				
				
			} else {
				Reporter.log("Test failed: Product Listview is not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
		}
			catch (Exception e) {
				exception=e.getMessage();
				
				
				org.testng.Assert.fail();
			}
		
		try {
			for (String tab : driver.getWindowHandles()) {
			   if (!tab.equals(currentTab_topcat)) {
			       driver.switchTo().window(tab);
			       Thread.sleep(3000);
			   }
			}
			
			WebElement prod_topcat = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
			WebElement description_topcat = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
			WebElement Reviews_topcat = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
			WebElement Specifications_topcat = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
			WebElement Merchant_Info_topcat = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
			WebElement Created_By_topcat = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
			
			if(description_topcat.isDisplayed() && Reviews_topcat.isDisplayed() && Specifications_topcat.isDisplayed() && Merchant_Info_topcat.isDisplayed() && Created_By_topcat.isDisplayed()) {
				Merchant_Info_topcat.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				WebElement merchant_info_topcat = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
				if(merchant_info_topcat.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Shrujan Creations")) {
					Reporter.log("Test Passed: Navigated to detailview of Shrujan Creations product successfully");
					Thread.sleep(2000);
					
					
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_topcat);
					Reporter.log("Test failed: Merchant Info for Shrujan is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				driver.close();
				driver.switchTo().window(currentTab_topcat);
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			driver.close();
			driver.switchTo().window(currentTab_topcat);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
			Thread.sleep(6000);
		} 
		catch (Exception e) {
			driver.close();
			driver.switchTo().window(currentTab_topcat);
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	  }
//=====================================================================================================================================

	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void goto_detailview_solar()  {
		String result = "";
		String exception = null;
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
		try {
			Thread.sleep(6000);
			WebElement solar = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")));
			if(solar.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys("Tharad");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[2]/div[2]/form/div/input")).sendKeys(Keys.ENTER);
				Reporter.log("Searched for Tharad");
				Thread.sleep(5000);
				
				
			}
			else {
				Reporter.log("Test failed: Solar search is not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			
			WebElement listview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
			if(listview.isDisplayed() && driver.findElement(By.className("b-product_grid_single")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
				Reporter.log("Product Clicked successfully");
				Thread.sleep(5000);
				
				
			}
			else {
				Reporter.log("Test failed: Product Listview is not getting displayed");
				Thread.sleep(6000);
				
				
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
				WebElement merchant_info = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
				if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("Shrujan Creations")) {
					Reporter.log("Test Passed: Navigated to detailview of Shrujan product successfully");
					Thread.sleep(2000);
					
					
				}
				else {
					Reporter.log("Merchant Info for Shrujan is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
		
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
				Thread.sleep(6000);
			}
			else {
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}	
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void go_to_detailview_shopby()  {
		String result = "";
		String exception = null;
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
		try {
			Thread.sleep(6000);
			WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
			if(element.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[5]/a")).click();
				Thread.sleep(2000);
			}
			else {
				Reporter.log("Test failed: Shop By is not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			
			WebElement shopby_listview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("b-product_grid_single")));
			if(shopby_listview.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[1]/a/img")).click();
				Thread.sleep(5000);
			}
			else {
				Reporter.log("Test failed: Product listview for Shop By is not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
			}
			
		String currentTab = driver.getWindowHandle();
		try {
			for (String tab : driver.getWindowHandles()) {
			   if (!tab.equals(currentTab)) {
			       driver.switchTo().window(tab);
			       Thread.sleep(3000);
			   }
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
				WebElement merchant_info = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
				if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
					Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
					Thread.sleep(2000);
					
					
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab);
					Reporter.log("Test failed: Merchant Info for VRDI is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				driver.close();
				driver.switchTo().window(currentTab);
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			driver.close();
			driver.switchTo().window(currentTab);
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
			Thread.sleep(6000);		
			
		} catch (Exception e) {
			driver.close();
			driver.switchTo().window(currentTab);
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void goto_detailview_cart()  {
		String result = "";
		String exception = null;
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
		try {
			Thread.sleep(6000);
			WebElement cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
			//If cart count is 1 then click the cart and delete the cart item first then add a new product and go to detailview of that product
			if(cart.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
				WebElement cart_element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a")));
				if (cart_element.isDisplayed()) {
					WebElement webElement = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", webElement);
					Thread.sleep(5000);	
				} else {
					Reporter.log("Test failed: Cart element is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
			
			WebElement clear_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("clear-cart-btn")));
			if(clear_cart.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/div/div[1]/h5")).getText().contains("Your Cart")) {
				driver.findElement(By.id("clear-cart-btn")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/div[7]/div/button[1]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				if (driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/h3")).getText().equals("YOUR CART IS CURRENTLY EMPTY.")) {
					Reporter.log("Cart Cleared successfully");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
					Thread.sleep(3000);
			} else {
					Reporter.log("Test failed: Does not give the expected message if the cart is empty");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
			}
			}
			else {
				Reporter.log("Test failed: Cart does not have text as Your Cart");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
			
			//Adding product to the cart after clearing
			String id = driver.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
			WebElement cart_count1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
			if(cart_count1.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("0")) {
				if(driver.findElement(By.cssSelector(".float-right.b-add_cart")).isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);
				}
				else {
					Reporter.log("Test failed: Add to cart not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
					}	
				}
			else {
					Reporter.log("Test failed: Cart element is not getting displayed or the cart count is not = 0");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
				
			if(cart_count1.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
					driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).click();
					Thread.sleep(10000);
					}
			else {
					Reporter.log("Test failed: Cart element is not getting displayed or the cart count is not = 1");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
					
				WebElement prod_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4")));
				if (prod_cart.isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4/a")).click();
					Thread.sleep(3000);	
				} else {
					Reporter.log("Test failed: Product in the cart is not getting displayed");
					Thread.sleep(6000);
					
					
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
					WebElement merchant_info = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
						if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
							Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
							Thread.sleep(2000);
							
							
						}
						else {
							Reporter.log("Test failed: Merchant Info of VRDI is not getting displayed");
							Thread.sleep(6000);
							
							
							org.testng.Assert.fail();
						}
					}
				else {
					Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by is not getting displayed");
					Thread.sleep(6000);
					
					
					org.testng.Assert.fail();
				}
					
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
				Thread.sleep(2000);		
				}
			
			//Adding product to the cart and go to detailview if the cart count is 0
			else if(driver.findElement(By.id("cart-count")).getText().equals("0")) {
					String id = driver.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
					WebElement cart_count = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
					if(cart_count.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("0")) {
						if(driver.findElement(By.cssSelector(".float-right.b-add_cart")).isDisplayed()) {
							driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).sendKeys(Keys.ENTER);
							Thread.sleep(3000);
						}
						else {
							Reporter.log("Test failed: Add to cart is not getting displayed");
							Thread.sleep(6000);
							
							
							org.testng.Assert.fail();
						}	
					}
					else {
						Reporter.log("Test failed: Cart is not getting displayed or cart count is not = 0");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
				
					if(cart_count.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
							driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).click();
							Thread.sleep(3000);
						}
					else {
						Reporter.log("Test failed: Cart is not getting displayed or cart count is not = 1");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
					
					WebElement prod_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4")));
					if (prod_cart.isDisplayed()) {
						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4/a")).click();
						Thread.sleep(3000);	
					} else {
						Reporter.log("Test failed: Product is not getting displayed in the cart");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
					
					WebElement detailview1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
					WebElement description1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
					WebElement Reviews1 = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
					WebElement Specifications1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
					WebElement Merchant_Info1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
					WebElement Created_By1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
					
					if(description1.isDisplayed() && Reviews1.isDisplayed() && Specifications1.isDisplayed() && Merchant_Info1.isDisplayed() && Created_By1.isDisplayed()) {
						Merchant_Info1.sendKeys(Keys.ENTER);
						Thread.sleep(2000);
						WebElement merchant_info = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
						if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
							Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
							Thread.sleep(2000);
							
							
						}
						else {
							Reporter.log("Test failed: Merchant Info for VRDI is not getting displayed");
							Thread.sleep(6000);
							
							
							org.testng.Assert.fail();
						}
					}
					else {
						Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by is not getting displayed");
						Thread.sleep(6000);
						
						
						org.testng.Assert.fail();
					}
					
					driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
					Thread.sleep(2000);		
			}
			else {
				Reporter.log("Test failed: Cart count element is not getting displayed");
				Thread.sleep(6000);
				
				
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
