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


public class Login {
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
	public void launch_browser() {
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
	public void login_valid_username_password()  {
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
				Reporter.log("Login unsuccessfull after session expiry");
				
				
				org.testng.Assert.fail();
			}
		} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
			Reporter.log("Login successfull");
			Thread.sleep(3000);
			
			
		}
		else {
			Reporter.log("Test failed: Some error occured while login");
			
			
			org.testng.Assert.fail();
		}
		driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).click();
	if (driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()){
		Reporter.log("Logout Successfull");
		Thread.sleep(3000);
		
		
	} else {
		Reporter.log("Something went wrong while logout");
		
		
		org.testng.Assert.fail();
		}
	}
	 catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
		
	}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void login_invusername_validpass()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_invalid());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(2000);
		
			if(driver.getPageSource().contains("Invalid credentials.")) {
			//if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
			Reporter.log("Test Passed: Not able to login using invalid username and valid password");
			Thread.sleep(3000);
			
			
			}
		else {
			Reporter.log("Test failed: Invalid username and valid password test failed");
			
			
			org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void valusername_invpass() {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_invalid());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(2000);
			
			if(driver.getPageSource().contains("Invalid password.")) {
				//if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()) {
				Reporter.log("Test Passed: Not able to login using valid username and Invalid password");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Valid username and Invalid password test failed");
				
				
				org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void invusername_invpassword()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_invalid());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_invalid());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(2000);
			if(driver.getPageSource().contains("Invalid credentials.")) {
			//if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).isDisplayed()){
			Reporter.log("Test Passed: Not able to login using invalid username and invalid password");
			Thread.sleep(3000);
			
			
			}
			else {
				Reporter.log("Test failed: Invalid username and Invalid password test failed");
				
				
				org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void empusername_emppassword()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_empty());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_empty());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(3000);
			if(driver.findElement(By.className("tooltipster-base")).isDisplayed()) {
				Reporter.log("Test Passed: Giving error message");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Empty username and Empty password Test Failed");
				
				
				org.testng.Assert.fail();
			}
	}
		catch (Exception e){
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
			}
		}
	
	@Test(priority = 6, retryAnalyzer = Retry_Analyzer.class)
	public void empusername_valpassword()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_empty());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(3000);
			if(driver.findElement(By.className("tooltipster-base")).isDisplayed()) {
				Reporter.log("Test Passed: Giving error message");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Empty username and Valid password Test Failed");
				
				
				org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
			exception=e.getMessage();
			
				
			org.testng.Assert.fail();
			}
		}
	
	@Test(priority = 7, retryAnalyzer = Retry_Analyzer.class)
	public void valusername_emppassword()  {
		String result = "";
		String exception = null;
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			Reporter.log("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_empty());
			Reporter.log("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(3000);
			if(driver.findElement(By.className("tooltipster-base")).isDisplayed()) {
				Reporter.log("Test Passed: Giving error message");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Valid username and Empty password Test Failed");
				
				
				org.testng.Assert.fail();
			}
		}
		catch (Exception e) {
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
