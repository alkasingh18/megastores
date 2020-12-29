package megastores;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.internal.annotations.TestAnnotation;


public class ContactUs {
	
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath = "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
	public WebDriver driver;
	InputData oData = new InputData();
	
	
	//Configure Testlink with Project Name, Testplan Name & Build Name
	public static String DEV_KEY = "1881c140942b0c0d0c824008f2d18006";
	//Following url posts the test results onto testlink
	public static String SERVER_URL = "http://testlink.atulsia.com/lib/api/xmlrpc/v1/xmlrpc.php";
	//Name of the project,plan & build you are testing on
	public static String PROJECT_NAME = "Megastores_Web"; 
	public static String PLAN_NAME = "Megastores-Web Test plan";
	public static String BUILD_NAME = "Version 1.2";
	

	

	
	  @Test(priority=1)
	  public void openUrl() throws  IOException, InterruptedException
	  {
		  String result="";
		  String notes = null;
		  String exception=null;
		  System.setProperty("webdriver.chrome.driver", driverpath);
		  driver = new ChromeDriver();
		  driver.get(baseurl);
		  Reporter.log("Browser launched !!");
		  assertEquals(driver.getCurrentUrl(), baseurl);
		  driver.manage().window().maximize();
		  	

		  driver.findElement(By.linkText("Contact us")).sendKeys(Keys.ENTER);
		  Thread.sleep(10000);
		  Reporter.log("Contact us page opened !!");
		  
		 

	}
	  
	  @Test(priority=2)
	  public void InvaliduserName() throws InterruptedException {
		  String result="";
		  String notes = null;
		  String exception=null;
		  try {
			  
			if(driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/div[1]/div[1]/h2")).getText().contains("GET IN TOUCH WITH US")) {
				driver.findElement(By.id("userName")).clear();
				driver.findElement(By.id("userEmail")).clear();
				driver.findElement(By.id("subject")).clear();
				driver.findElement(By.id("message")).clear();
				
				  driver.findElement(By.id("userName")).sendKeys(oData.invalidName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("subject")).sendKeys(oData.validSubject());
				  Thread.sleep(2000);
				  driver.findElement(By.id("message")).sendKeys(oData.validMessage());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contact-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  
			}
			else {
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			System.out.println("failed for invalid username" + e.getMessage());
			Reporter.log("Test failed for invalid username");
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}  
		  
	  }
	  
	  
	  @Test(priority=3)
	  public void InvalidEmail() throws InterruptedException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
				if(driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/div[1]/div[1]/h2")).getText().contains("GET IN TOUCH WITH US")) {
					driver.findElement(By.id("userName")).clear();
					driver.findElement(By.id("userEmail")).clear();
					driver.findElement(By.id("subject")).clear();
					driver.findElement(By.id("message")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("userEmail")).sendKeys(oData.invalidEmail());
					  Thread.sleep(2000);
					  driver.findElement(By.id("subject")).sendKeys(oData.validSubject());
					  Thread.sleep(2000);
					  driver.findElement(By.id("message")).sendKeys(oData.validMessage());
					  Thread.sleep(2000);
					  driver.findElement(By.id("contact-submit-btn")).sendKeys(Keys.ENTER);
					  Thread.sleep(3000);
					  
				}
				else {
					Reporter.log("Test failed for invalid email");
					
					
					org.testng.Assert.fail();
				}
				  
			} catch (Exception e) {
				Reporter.log("Test failed for invalid email");
				exception = e.getMessage();
				
				
				org.testng.Assert.fail();
			}  
			  
		  }
 
	  @Test(priority=4)
	  public void validData() throws  IOException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			if(driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/div[1]/div[1]/h2")).getText().contains("GET IN TOUCH WITH US")) {
				driver.findElement(By.id("userName")).clear();
				driver.findElement(By.id("userEmail")).clear();
				driver.findElement(By.id("subject")).clear();
				driver.findElement(By.id("message")).clear();
				
				driver.findElement(By.id("userName")).sendKeys(oData.validName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("subject")).sendKeys(oData.validSubject());
				  Thread.sleep(2000);
				  driver.findElement(By.id("message")).sendKeys(oData.validMessage());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contact-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				 
			}
			else {
				Reporter.log("Test failed for valid data");
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			Reporter.log("Test failed for valid data");
			exception = e.getMessage();
			
			
			org.testng.Assert.fail();
		}  
		  
	  }
	  
//	  private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
//			TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
//			testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
//			}
	  
	  @AfterClass
	  public void quit() {
			driver.quit();
			boolean hasquit = driver.toString().contains("(null)");
			System.out.println("Did driver quit? (True/False): " + hasquit);
		}
}

