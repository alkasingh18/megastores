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



public class Forgot_Password {
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
	public void existing_email_id() {
		try {
			assertEquals(baseurl, driver.getCurrentUrl());
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Existing Email: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Existing Email: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link is not getting displayed");
				
					
				org.testng.Assert.fail();
			}
			
			//To check that on Forgot Password the text field is displayed and the Send keys with existing email id
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.existing_email());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Reporter.log("Existing Email: Navigated to OTP screen successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password text field is not getting displayed");
				
					
				org.testng.Assert.fail();
			}
			
			//To check that the user is directed to OTP screen and is not able to submit null OTP.
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/h3")).getText().equals(data.onetimepassword_text())) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/div/input[1]")).sendKeys("");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.invalid_otp())) {
					Reporter.log("Test Passed: Existing Email: Not able to Submit null OTP");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for invalid OTP does not match current displayed message");
					
						
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: The screen does not consist of title OTP");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			org.testng.Assert.fail();
		}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void non_existing_email_id() {
		String result = "";
		String exception = null;
		try {
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Non Existing Email: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Non Existing Email: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot Password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check on Forgot password page the field is displayed and the user is not redirected to OTP screen if it is a non existing email id.
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.non_existing_email());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.user_not_found_message())) {
					Reporter.log("Test Passed: Non Existing Email: Not redirecting the user to OTP screen if the email does not exist.");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for user found does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Username or mobile field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void existing_phone_number() {
		String result = "";
		String exception = null;
		try {
			//To check that the Login link is displayed and Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Existing Phone Number: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot Password link is displayed and Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Existing Phone Number: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot Password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the text field in Forgot Password Page is displayed and Send Keys existing Phone number
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.existing_phno());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Reporter.log("Existing Phone Number: Navigated to OTP screen successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Username or Mobile field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the user has navigated to OTP screen and is unable to submit null OTP
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/h3")).getText().equals(data.onetimepassword_text())) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/div/input[1]")).sendKeys("");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.invalid_otp())) {
					Reporter.log("Test Passed: Existing Phone Number: Not able to Submit null OTP");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for Invalid OTP does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
				
			}
			else {
				Reporter.log("Test failed: The screen does not match the expected OTP title");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void non_existing_phone_number() {
		String result = "";
		String exception = null;
		try {
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Non Existing Phone number: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Non Existing Phone number: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check on Forgot password page the field is displayed and the user is not redirected to OTP screen if it is a non existing phone number.
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.non_existing_phno());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.user_not_found_message())) {
					Reporter.log("Test Passed: Non Existing Phone number: Not redirecting the user to OTP screen if the phone number does not exist.");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for user not found does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Username or Mobile field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void existing_user_name() {
		String result = "";
		String exception = null;
		try {
			//To check that the Login link is displayed and Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Existing username: Existing Phone Number: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot Password link is displayed and Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Existing username: Existing Phone Number: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot Password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the text field in Forgot Password Page is displayed and Send Keys existing username
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.existing_username());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Reporter.log("Existing username: Existing Phone Number: Navigated to OTP screen successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Username or Mobile is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the user has navigated to OTP screen and is unable to submit null OTP
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/h3")).getText().equals(data.onetimepassword_text())) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/div/input[1]")).sendKeys("");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/form/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.invalid_otp())) {
					Reporter.log("Test Passed: Existing username: Existing Phone Number: Not able to Submit null OTP");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for invalid OTP does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
				
			}
			else {
				Reporter.log("Test failed: The screen does not consist of the title OTP");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 6, retryAnalyzer = Retry_Analyzer.class)
	public void non_existing_username() {
		String result = "";
		String exception = null;
		try {
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Non existing username: Login clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Non existing username: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Forgot password link is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			//To check on Forgot password page the field is displayed and the user is not redirected to OTP screen if it is a non existing username.
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.non_existing_username());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.user_not_found_message())) {
					Reporter.log("Test Passed: Non existing username: Non Existing Phone number: Not redirecting the user to OTP screen if the phone number does not exist.");
					
					
				}
				else {
					Reporter.log("Test failed: Expected message for user not found does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Username or Mobile filed is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 7, retryAnalyzer = Retry_Analyzer.class)
	public void empty_field() {
		try {
			//To check that the Login link is displayed and then Click it
			if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
				Reporter.log("Empty field: Login clicked successfully");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Test failed: Login Link is not getting displayed");
				org.testng.Assert.fail();
			}
			
			//To check that the Forgot password link is displayed and then click it
			if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/div[1]/center/a")).click();
				Reporter.log("Empty field: Forgot Password Link clicked successfully");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Forgot Password link is not getting displayed");
				org.testng.Assert.fail();
			}
			
			//To check on Forgot password page the field is displayed and the user is not redirected to OTP screen if it is a non existing username.
			if(driver.findElement(By.id("username_or_mobile")).isDisplayed()) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"forgot-password-form\"]/button")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/div/center/h3")).getText().equals(data.onetimepassword_text())) {
					Reporter.log("Test failed: Redirecting the user to OTP screen if the fields are empty");
					org.testng.Assert.fail();
				}
				else {
					Reporter.log("Test Passed : Empty field : Not redirecting user to OTP screen if the fields are empty");
				}
			}
			else {
				Reporter.log("Username or Mobile field is not getting displayed");
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
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
