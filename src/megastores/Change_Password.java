package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Change_Password {
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
	public void go_to_change_pass()  {
		String result = "";
		String exception = null;
			
			
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
						Reporter.log("Test failed: Login not successfull after session expiry");
						
						
						org.testng.Assert.fail();
					}
				} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
					Reporter.log("Login successfull");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Login not successfull");
					
						
					org.testng.Assert.fail();
				}
				
				//To click on My Account link
				driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
				Reporter.log("My Account Clicked successfully");
				Thread.sleep(3000);
				
				//To check that the change password icon exist. If yes then click it.
				if(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/button/i")).isDisplayed()) {
					driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/button/i")).click();
					Reporter.log("Test Passed: User successfully navigated to change password screen");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Change password icon not getting displayed");
					
						
					org.testng.Assert.fail();
				}
			} catch (Exception e) {
				exception=e.getMessage();
				
					
				org.testng.Assert.fail();
			}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_all_empty(){
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")) {
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.id("password-field")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
			}	
			else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
					
				org.testng.Assert.fail();
			}
				if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.field_required())) {
					System.out.println("Test Passed: Giving message on all the fields that it is required");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Field required tooltip message not getting displayed");
					
						
					org.testng.Assert.fail();
				}
		} catch (Exception e) {
			exception = e.getMessage();
			
				
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_old_empty() {
		String result = "";
		String exception = null;
		try {
			if (driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")) {
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.id("password-field")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.field_required())){
					Reporter.log("Test Passed: Giving field required message if old password not entered");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Field required tooltip message not getting displayed");
					
					
					org.testng.Assert.fail();
				}
			} else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception = e.getMessage();
			
				
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_min_length_check()  {
		String result = "";
		String exception = null;
		try {
			if (driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")) {
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.id("password-field")).clear();
				driver.findElement(By.id("password-field")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(3000);				
			} else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
				
				org.testng.Assert.fail();
			}
			
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.invalid_pass_min_length());
			Thread.sleep(3000);
			driver.findElement(By.id("password-field")).sendKeys(data.invalid_pass_min_length());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.invalid_pass_min_length());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			
			if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.min_length_pass_message())){
				Reporter.log("Test Passed: Giving error message if the minimum length is less than 6");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Not giving the expected error message if the minimum length is less than 6");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception = e.getMessage();
			
				
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_format_check() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")){
					driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(Keys.TAB);
					Thread.sleep(1000);
					driver.findElement(By.id("password-field")).clear();
					driver.findElement(By.id("password-field")).sendKeys(Keys.TAB);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).clear();
					driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(Keys.TAB);
					Thread.sleep(3000);				
				} else {
					Reporter.log("Test failed: Password form does not consist title 'Change Password'");
					
					
					org.testng.Assert.fail();
				}
				
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.id("password-field")).sendKeys(data.invalid_pass_format());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.invalid_pass_format());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				
				if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.pass_format_message())){
					Reporter.log("Test Passed: Giving error for password format");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Not giving expected error message for the password format");
					
					
					org.testng.Assert.fail();
				}
				
		} catch (Exception e) {
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 6, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_new_confirm_dont_match() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")){
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.id("password-field")).clear();
				driver.findElement(By.id("password-field")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(3000);				
			} else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
				
				org.testng.Assert.fail();
			}
			
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.valid_pass());
			Thread.sleep(3000);
			driver.findElement(By.id("password-field")).sendKeys(data.valid_new_pass());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.invalid_pass_format());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			
			if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.pass_dont_match())) {
				Reporter.log("Test Passed: Gives proper message if password dosent match the new one.");
				
				
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Test failed: Not giving expected message if the password does not match the new one");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 7, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_old_pass_dont_match() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")){
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.id("password-field")).clear();
				driver.findElement(By.id("password-field")).sendKeys(Keys.TAB);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(Keys.TAB);
				Thread.sleep(3000);				
			} else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
				
				org.testng.Assert.fail();
			}
			
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.wrong_old_pass());
			Thread.sleep(3000);
			driver.findElement(By.id("password-field")).sendKeys(data.valid_new_pass());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.valid_new_pass());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			
			if(driver.getPageSource().contains(data.old_pass_dont_match())) {
				Reporter.log("Test Passed: Giving message if old password doesn't match");
				Thread.sleep(3000);
				
				
			}
			else {
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/button")).click();
				Reporter.log("Retried: User successfully navigated to change password screen");
				Reporter.log("Test failed: Not giving expected message if the old password dosen't match");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 8, retryAnalyzer = Retry_Analyzer.class)
	public void change_pass_all_validdata() {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/button")).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")) {
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.id("password-field")).sendKeys(data.valid_new_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.valid_new_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.getPageSource().contains(data.pass_updated_successfully())) {
					Reporter.log("Test Passed: Password updated successfully");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Not giving expected message for the password updation");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	//=======================Resetting the password to Old one========================================================================
	@Test(priority = 9, retryAnalyzer = Retry_Analyzer.class)
	public void reset_password() {
		try {
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[5]/button")).click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[1]/h4")).getText().equals("Change Password")) {
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[1]/div/input")).sendKeys(data.valid_new_pass());
				Thread.sleep(3000);
				driver.findElement(By.id("password-field")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[2]/div[3]/div/input")).sendKeys(data.valid_pass());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"password-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.getPageSource().contains(data.pass_updated_successfully())) {
					Reporter.log("Test Passed: Password Reset successfully");
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Not giving expected message for the password updation while reset");
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Password form does not consist title 'Change Password'");
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
