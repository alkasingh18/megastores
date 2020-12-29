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


public class Profile_Change_Mobile_Number {
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
	public void Go_to_Change_mobile_number()  {
		String result = "";
		String exception = null;
	
		try {
			assertEquals(baseurl, driver.getCurrentUrl());
			//Clicking on Login link
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login link clicked successfully");
			Thread.sleep(3000);
			
			//Entering username on Login
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			Reporter.log("username entered");
			Thread.sleep(3000);
			
			//Entering password on Login
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			Reporter.log("password entered");
			Thread.sleep(3000);
			
			//Clicking on Submit button
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("submit clicked successfully");
			Thread.sleep(3000);
			if(driver.getPageSource().contains(data.session_expiry())) {
				//Entering username on Login
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
				Reporter.log("username entered");
				Thread.sleep(3000);
				
				//Entering password on Login
				driver.findElement(By.name("password")).sendKeys(data.password_valid());
				Reporter.log("password entered");
				Thread.sleep(3000);
				
				//Clicking on Submit button
				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
				Reporter.log("submit clicked successfully");
				Thread.sleep(3000);
				
				//To check that Login is successfull after session expiry message
				if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()) {
					Reporter.log("Login successfull after session expiry message");
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Login unsuccessfull after session expiry message");
					org.testng.Assert.fail();
				}
			}
			//To check that Login is successfull
			else if (driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()) {
				Reporter.log("Login successfull");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Test failed: Login unsuccessfull");
				
				org.testng.Assert.fail();
			}
			
			
			//Clicking on My Account
			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
			Reporter.log("My Account clicked successfully");
			Thread.sleep(3000);
			//Clicking on Phone icon to change phone number
			driver.findElement(By.xpath("//*[@id=\"changePhoneBtn\"]/i")).click();
			Reporter.log("Phone icon clicked successfully");
			Thread.sleep(3000);
			
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			org.testng.Assert.fail();
		}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void empty_field() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				driver.findElement(By.id("phone")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the field is empty
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.field_required())) {
					Reporter.log("Test Passed: Not allowing the user to submit if all field is empty.");
					
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for field required does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			} 
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void phone_number_exist()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				driver.findElement(By.id("phone")).sendKeys(data.existing_phno());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the field is empty
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.phone_no_exist())) {
					Reporter.log("Test Passed: Not allowing the user to submit if all field is empty.");
					
					
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for phone number exist does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			} 
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void four_alphabets()  {
		String result ="";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				driver.findElement(By.id("phone")).sendKeys(data.four_alphabets());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the user has entered only 4 alphabets.
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.ten_character())) {
				Reporter.log("Will not allow the user to add only 4 alphabets since minimum is 10 characters");
				Thread.sleep(3000);
				
				
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for minimum character does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void ten_alphabets()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("phone")).sendKeys(data.ten_alphabets());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the user has entered 10 alphabets.
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.valid_number())) {
					Reporter.log("Test Passed: Not allowing user to add alphabets even if we enter 10 alphabets.");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for valid number does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Phone field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 6, retryAnalyzer = Retry_Analyzer.class)
	public void four_numbers()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("phone")).sendKeys(data.four_numbers());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the user has entered only 4 digits.
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.ten_character())) {
					Reporter.log("Test Passed: Not allowing the user to enter less then 10 characters");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for minimum character does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
				
			}
			else {
				Reporter.log("Test failed: Phone field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
		
	}
	
	@Test(priority = 7, retryAnalyzer = Retry_Analyzer.class)
	public void sixteen_numbers()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("phone")).sendKeys(data.sixteen_numbers());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system gives a valid message to validate if the user has entered 16 digits.
				if(driver.findElement(By.className("tooltipster-base")).getText().equals(data.fifteen_character())) {
					Reporter.log("Test Passed: Not allowing the user to enter more then 15 characters");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Expected tooltip message for maximum characters does not match the current displayed message");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Phone field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 8, retryAnalyzer = Retry_Analyzer.class)
	public void ten_numbers()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("phone")).sendKeys(data.ten_numbers());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system leads the user to OTP screen if he enters minumum requirement to 10 digits.
				if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/h2")).getText().equals(data.onetimepassword_text())) {
					Reporter.log("Test Passed: Allowing only number with minimum length 10 and leading user to OTP screen");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"verify-otp-form\"]/div/input[1]")).sendKeys(data.empty());
					Thread.sleep(3000);
					driver.findElement(By.id("verify-submit-btn")).click();
					Thread.sleep(3000);
					
					//To check that system gives a valid message to validate if no OTP is entered.
					if(driver.getPageSource().contains(data.otp_required())) {
						Reporter.log("Test Passed: Will not allow user to submit without OTP");
						Thread.sleep(3000);
						
						
					}
					else {
						Reporter.log("Test failed: Expected message for OTP required does not match the current displayed message");
						
						
						org.testng.Assert.fail();
					}
					driver.findElement(By.xpath("//*[@id=\"verify-otp-form\"]/div/input[1]")).sendKeys("333333");
					Thread.sleep(3000);
					driver.findElement(By.id("verify-submit-btn")).click();
					Thread.sleep(3000);
					
					//To check that system gives a valid message to validate if invalid OTP is entered.
					if(driver.getPageSource().contains(data.invalid_otp())) {
						Reporter.log("Test Passed: Will not allow user to submit Invalid OTP");
						Thread.sleep(3000);
						
						
					}
					else {
						Reporter.log("Test failed: Expected message for invalid OTP does not match the current displayed message");
						
						
						org.testng.Assert.fail();
					}
				}
			}
			else {
				Reporter.log("Test failed: Phone field is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 9, retryAnalyzer = Retry_Analyzer.class)
	public void fifteen_numbers()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"changePhoneBtn\"]/i")).click();
			Thread.sleep(3000);
			if(driver.findElement(By.id("phone")).isDisplayed()) {
				driver.findElement(By.id("phone")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("phone")).sendKeys(data.fifteen_numbers());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"phone-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				//To check that the system leads the user to OTP screen if we enter 15 digits as it is the maximum limit.
				if(driver.findElement(By.xpath("//*[@id=\"b-my_account\"]/div/div/div/h2")).getText().equals(data.onetimepassword_text())) {
					Reporter.log("Test Passed: Allowing only number with minimum length 10 and leading user to OTP screen");
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id=\"verify-otp-form\"]/div/input[1]")).sendKeys(data.empty());
					Thread.sleep(3000);
					driver.findElement(By.id("verify-submit-btn")).click();
					Thread.sleep(3000);
					
					//To check that system gives a valid message to validate if no OTP is entered.
					if(driver.getPageSource().contains("The otp field is required.")) {
						Reporter.log("Test Passed: Will not allow user to submit without OTP");
						Thread.sleep(3000);
						
						
					}
					else {
						Reporter.log("Test failed: Expected message for OTP required does not match the current displayed message");
						
						
						org.testng.Assert.fail();
					}
					driver.findElement(By.xpath("//*[@id=\"verify-otp-form\"]/div/input[1]")).sendKeys("333333");
					Thread.sleep(3000);
					driver.findElement(By.id("verify-submit-btn")).click();
					Thread.sleep(3000);
					
					//To check that system gives a valid message to validate if invalid OTP is entered.
					if(driver.getPageSource().contains(data.invalid_otp())) {
						Reporter.log("Test Passed: Will not allow user to submit Invalid OTP");
						Thread.sleep(3000);
						
						
					}
					else {
						Reporter.log("Test failed: Expected message for invalid OTP does not match the current displayed message");
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					Reporter.log("Test failed: The screen does not consist of OTP text");
					
					
					org.testng.Assert.fail();
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
