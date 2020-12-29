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

public class Change_Profile_Info {
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
	public void Go_to_profile() {
		String result = "";
		String exception = null;
		
		try {
			assertEquals(driver.getCurrentUrl(), baseurl);
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
					Reporter.log("Test failed: Login failed after session expiry");
					
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
			
			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
			Reporter.log("Test Passed : User successfully directed to My account");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
  }
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void empty_fname_lname() {
		String result ="";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[1]/a")).getText().equals("Information")) {
				driver.findElement(By.id("first_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("last_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("first_name")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.id("last_name")).sendKeys(data.empty());
				Thread.sleep(3000);
				
				
				driver.findElement(By.id("submitBasicInfo")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				//Tooltip condition here
				int size = driver.findElements(By.className("tooltipster-base")).size();
				Reporter.log("Tooltip size " + size);
				for(int i=0; i<size; i++) {
						if(driver.findElements(By.className("tooltipster-base")).get(i).getText().equals(data.field_required())) {
							Reporter.log("Test Passed: field required message found at tooltip " + i);
							Thread.sleep(3000);
							
							
						}
						else {
							Reporter.log("Test failed: Field required message not found at tooltip " + i);
							Thread.sleep(3000);
							
							
							org.testng.Assert.fail();
							break;
					}
				}	
				
			}
			else {
				Reporter.log("Test failed: Information tab not found");
				
				
				org.testng.Assert.fail();
			}
			
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}	
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void empty_fname() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[1]/a")).getText().equals("Information")) {
				driver.findElement(By.id("first_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("last_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("first_name")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.id("last_name")).sendKeys(data.lname());
				Thread.sleep(3000);
				driver.findElement(By.id("submitBasicInfo")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				//Tooltip condition here
				int size = driver.findElements(By.className("tooltipster-base")).size();
				Reporter.log("Tooltip size " + size);
				for(int i=0; i<size; i++) {
						if(driver.findElements(By.className("tooltipster-base")).get(i).getText().equals(data.field_required())) {
							Reporter.log("Test Passed: field required message found at tooltip " + i);
							Thread.sleep(3000);
							
							
						}
						else {
							Reporter.log("Test failed: Field required message not found at tooltip " + i);
							Thread.sleep(3000);
							
							
							org.testng.Assert.fail();
							break;
					}
				}	
				
			}
			else {
				Reporter.log("Test failed: Information tab not found");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void lname_empty() {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[1]/a")).getText().equals("Information")) {
				driver.findElement(By.id("first_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("last_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("first_name")).sendKeys(data.fname());
				Thread.sleep(3000);
				driver.findElement(By.id("last_name")).sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.id("submitBasicInfo")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				//Tooltip condition here
				int size = driver.findElements(By.className("tooltipster-base")).size();
				Reporter.log("Tooltip size " + size);
				for(int i=0; i<size; i++) {
						if(driver.findElements(By.className("tooltipster-base")).get(i).getText().equals(data.field_required())) {
							Reporter.log("Test Passed: field required message found at tooltip " + i);
							
							
							Thread.sleep(3000);
						}
						else {
							Reporter.log("Test failed: Field required message not found at tooltip " + i);
							Thread.sleep(3000);
							
							
							org.testng.Assert.fail();
							break;
					}
				}	
				
			}
			else {
				Reporter.log("Test failed: Information tab not found");
				
				
				org.testng.Assert.fail();
			}
			
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void all_filled_details()  {
		String result = "";
		String exception = null;
		try {
			if(driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[1]/a")).getText().equals("Information")) {
				driver.findElement(By.id("first_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("last_name")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("first_name")).sendKeys(data.fname());
				Thread.sleep(3000);
				driver.findElement(By.id("last_name")).sendKeys(data.lname());
				Thread.sleep(3000);	
				driver.findElement(By.id("submitBasicInfo")).sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				if(driver.getPageSource().contains(data.profile_update_message())) {
					Reporter.log("Test passed: Profile Updated.");
					Thread.sleep(3000);
					
					
				}
				else {
					Reporter.log("Test failed: Unable to get the expected message for profile update");
					
					
					org.testng.Assert.fail();
				}
				
			}
			else {
				Reporter.log("Test failed: Information tab not found");
				
				
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
