package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Forgot_Username {
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
  public void fgt_usr_existing_username()  {
	  String result = "";
	  String exception = null;
		
		
		try {
			assertEquals(baseurl, driver.getCurrentUrl());
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Existing Username: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Existing Username: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot username link is displayed or not, if displayed then click it.
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).click();
				Reporter.log("Existing Username: Forgot Username Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot username link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the email field is displayed to enter the existing email and submit the request for username.
			if(driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data.existing_email());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[3]/button")).click();
				Thread.sleep(3000);
				if(driver.getPageSource().contains(data.username_message())) {
					Reporter.log("Test Passed : Username successfully sent to email id.");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for username sent does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Email field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
  }
  
  @Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
  public void fgt_user_non_existing_username()  {
	  String result = "";
	  String exception = null;
	  try {
		  	//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Non-Existing Username: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Non-Existing Username: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot username link is displayed or not, if displayed then click it.
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).click();
				Reporter.log("Non-Existing Username: Forgot Username Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot username link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the email field is displayed to enter the non existing email and submit the request for username.
			if(driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data.non_existing_email());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[3]/button")).click();
				Thread.sleep(3000);
				if(driver.getPageSource().contains(data.user_not_found_message())) {
					Reporter.log("Test Passed: Non-Existing Username: Giving User Not found message if the email id does not exist");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for user not found does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Email field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  
  @Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
  public void fgt_usr_empty_email()  {
	  String result = "";
	  String exception = null;
	  try {
		//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Empty Email: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Empty email: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot username link is displayed or not, if displayed then click it.
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).click();
				Reporter.log("Empty email: Forgot Username Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot username link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the email field is displayed to enter nothing in email and submit the request for username.
			if(driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[3]/button")).click();
				Thread.sleep(3000);
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.field_required())) {
					Reporter.log("Test Passed: Empty email: Displaying message as Email is required and will not Send");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[1]/button/i")).click();
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Expected message for email required does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Email field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  
  @Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
  public void fgt_usr_invalid_email()  {
	  String result = "";
	  String exception = null;
	  try {
		//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Invalid Email: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Invalid email: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot username link is displayed or not, if displayed then click it.
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center[2]/a")).click();
				Reporter.log("Invalid email: Forgot Username Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot username link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the email field is displayed to enter invalid email and submit the request for username.
			if(driver.findElement(By.xpath("//*[@id=\"email\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data.username_valid());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[3]/button")).click();
				Thread.sleep(3000);
				if(driver.findElement(By.className("tooltipster-base")).getText().equals("Please enter a valid email address.")) {
					Reporter.log("Test Passed: Invalid email: Empty email: Displaying message please enter a valid email address.");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"forgot-username-form\"]/div[1]/button/i")).click();
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Expected message to enter a valid email address does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Email field is not getting displayed");
				
				
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
