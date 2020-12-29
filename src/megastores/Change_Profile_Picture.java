package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class Change_Profile_Picture {
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
	public void Go_to_profile()  {
		
		try {
			assertEquals(baseurl, driver.getCurrentUrl());
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(3000);
			if(driver.getPageSource().contains(data.session_expiry())) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
				Reporter.log("Username added");
				Thread.sleep(3000);
				driver.findElement(By.name("password")).sendKeys(data.password_valid());
				Reporter.log("Password added");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
				Reporter.log("Submit clicked");
				Thread.sleep(3000);
				
				//To check that the Login is successfull after session expiry
				if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()) {
					Reporter.log("Login successfull after session expiry");
					Thread.sleep(3000);
					
				}
				else {
					Reporter.log("Login unsuccessfull after session expiry");
					
					org.testng.Assert.fail();
				}
			} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
				Reporter.log("Login successfull");
				Thread.sleep(3000);
				
			}
			else {
				Reporter.log("Some error occured while login");
				
				org.testng.Assert.fail();
			}
			
		}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				org.testng.Assert.fail();
			}
	}
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void edit_valid_profile_pic() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
				Thread.sleep(3000);
				//Uploading valid image file
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/form/div/input")).sendKeys(data.valid_image());
				Reporter.log("Valid Image added");
				Thread.sleep(5000);
				
				WebElement webElement = driver.findElement(By.id("img-submit-btn"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
				Reporter.log("Upload button clicked");
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.valid_image_message()))
				{
					Reporter.log("Test Passed: Profile picture updated successfully.");
					Thread.sleep(6000);
				}
				else {
					Reporter.log("Test failed: Expected message for profile update does not match the displayed message");
					Thread.sleep(6000);
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: My account not displayed");
				Thread.sleep(6000);
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void edit_invalid_profile_pic()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).isDisplayed()) {
				
				//Uploading invalid image file
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/form/div/input")).sendKeys(data.invalid_image());
				Reporter.log("Invalid Image added");
				Thread.sleep(3000);
				
				WebElement webElement = driver.findElement(By.id("img-submit-btn"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
				Reporter.log("Upload button clicked");
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.invalid_image_message()))
				{
					Reporter.log("Test Passed: Profile picture did not update as the file was not an image format");
					Thread.sleep(2000);
					
						
				}
				else {
					Reporter.log("Test failed: Expected message for invalid image format does not match the current displayed message");
					
						
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: My account not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
