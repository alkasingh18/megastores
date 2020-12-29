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


public class Change_Email {
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
  public void Go_to_change_email()  {
	  String result="";
		String exception=null;
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
					Reporter.log("Login not successfull after session expiry");
					
					
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
			
			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
			Reporter.log("My Account Clicked successfully");
			Thread.sleep(3000);
			
			if(driver.findElement(By.id("changeEmailBtn")).isDisplayed()) {
				driver.findElement(By.id("changeEmailBtn")).click();
				Reporter.log("Test Passed: User has been directed to change password screen successfully");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Change Email button not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
  }
  
  @Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
  public void chng_email_empty_mail_id(){
	  String result = "";
	  String exception = null;
	  try {
		if(driver.findElement(By.id("new_email")).isDisplayed()) {
			driver.findElement(By.id("new_email")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("new_email")).sendKeys(data.empty());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.emailrequired())) {
				Reporter.log("Test Passed : Not allowing user to change email if it is empty");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Email required tooltip message not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		}
		else {
			Reporter.log("Test failed: Email field not getting displayed");
			
			
			org.testng.Assert.fail();
		}
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  
  @Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
  public void change_email_invalid_email() {
	  String result = "";
	  String exception = null;
	  try {
		  if(driver.findElement(By.id("new_email")).isDisplayed()) {
				driver.findElement(By.id("new_email")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("new_email")).sendKeys(data.inv_email_format());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.invalid_email())) {
					Reporter.log("Test Passed : Giving invalid email message if email format is not proper without including @");
					Thread.sleep(3000);
					 
					
				}
				else {
					Reporter.log("Test failed: Email format tooltip message not getting displayed");
					org.testng.Assert.fail();
				}
				driver.findElement(By.id("new_email")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("new_email")).sendKeys(data.inv_email_format1());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.invalid_email1())) {
					Reporter.log("Test Passed : Giving invalid email message if email format is not proper with including @ and domain name");
					Thread.sleep(3000);
					 
					
				}
				else {
					Reporter.log("Test failed: Email format tooltip message not getting displayed");
					
					
					org.testng.Assert.fail();
				}
		  }
		  else {
			  Reporter.log("Test failed: Email field not getting displayed");
			  
			  
			  org.testng.Assert.fail();
		  }
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  
  @Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
  public void change_email_existing_id()  {
	  String result = "";
	  String exception = null;
	try {
		if(driver.findElement(By.id("new_email")).isDisplayed()) {
			driver.findElement(By.id("new_email")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("new_email")).sendKeys(data.existing_email());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
			Thread.sleep(3000);
			if(driver.findElement(By.className("tooltipster-base")).getText().contains(data.existing_email_message())) {
				Reporter.log("Test Passed: Not allowing the user to change email if it already exist");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Existing email tooltip message not getting displayed");
				
				
				org.testng.Assert.fail();
			}
		}
		else {
			Reporter.log("Test failed: Email field not getting displayed");
			
			
			org.testng.Assert.fail();
		}
		
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}  
  }
  
  @Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
  public void change_email_valid_id() {
	  String result = "";
	  String exception = null;
	  try {
		  if(driver.findElement(By.id("new_email")).isDisplayed()) {
				driver.findElement(By.id("new_email")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("new_email")).sendKeys(data.email_valid_id());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
				Thread.sleep(3000);
				if(driver.getPageSource().contains(data.change_email_message()) && driver.findElement(By.xpath("//*[@id=\"email\"]")).getAttribute("value").equals(data.email_valid_id())){
					Reporter.log("Test passed : Got message that the verification link is sent and also changed email is displayed in email text field");
					Thread.sleep(3000);
					 
					
				}
				else {
					Reporter.log("Test failed: Verification Link sent message not displayed or the email changed is not getting displayed in email text field.");
					
					
					Thread.sleep(5000);
					driver.findElement(By.id("changeEmailBtn")).click();
					Reporter.log("Retrying: User has been directed to change password screen successfully");
					org.testng.Assert.fail();
				}
		  }
		  else {
			  Reporter.log("Test failed: Email field not getting displayed");
			  
				
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
