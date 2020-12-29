package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Registration 
{
	public ChromeDriver driver;
	//Configure Testlink with Project Name, Testplan Name & Build Name
	public static String DEV_KEY = "1881c140942b0c0d0c824008f2d18006";

				
	//Following url posts the test results onto testlink
	public static String SERVER_URL = "http://testlink.atulsia.com/lib/api/xmlrpc/v1/xmlrpc.php";
				
	//Name of the project,plan & build you are testing on
	public static String PROJECT_NAME = "Megastores_Web"; 
	public static String PLAN_NAME = "Megastores-Web Test plan";
	public static String BUILD_NAME = "Version 1.2";
	
	
	@BeforeClass
	public void browser_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
		  //go to website
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();	
		  //  String baseUrl = "http://54.147.24.85/megastores/home";
		   // driver.get(baseUrl);
		   // assertEquals(driver.getCurrentUrl(), baseUrl);
		    
	      //waits 10 seconds for page to load
	      driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	      try 
	      {
	          driver.get("http://54.147.24.85/megastores/home");
	      }
	      catch (TimeoutException e)
	      {
	          driver.close();
	          driver.quit();

	          //create new instance of webdriver
	          driver = new ChromeDriver();

	          //waits 5 minutes for page to load
	          driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	          driver.manage().window().maximize();
	          driver.get("http://54.147.24.85/megastores/home");
	      }
	}
	
	
		@Test(priority = 1, retryAnalyzer = Retry_Analyzer.class)  
	  public void register() throws InterruptedException
		{
	  		String result = "";
	  		String exception = null;
	  	try {
	 			    
	 		    // with all valid data
	 		    //By name Text area1
	 		WebElement register = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[2]")));
	 		register.sendKeys(Keys.ENTER); 
	 		Reporter.log("Clicked on register button successfully");
	 		Thread.sleep(5000);
	 	
	 		WebElement text1 = driver.findElement(By.name("first_name"));
	 		text1.clear();
	 		text1.sendKeys("Ashwini");
	 		Reporter.log("First name entered successfully");
	 		Thread.sleep(5000);

	 		WebElement text2 = driver.findElement(By.name("last_name"));
	 		text2.clear();
	 		text2.sendKeys("Datal");
	 		Reporter.log("Last name entered successfully");
	 		Thread.sleep(5000);
	 		    
	 		WebElement text3 = driver.findElement(By.name("username"));
	 		text3.clear();
	 		text3.sendKeys("alkatest06547851");
	 		Reporter.log("Username entered successfully");
	 		Thread.sleep(5000);

	 		// WebElement text4 = driver.findElement(By.id("country-dropdown"));
	 		//text4.clear();
	 		//text4.sendKeys("123abcdxy");
	 		Select countrycode = new Select(driver.findElement(By.id("country-dropdown")));
	 		countrycode.selectByValue("+91");
	 		Reporter.log("Country code selected successfully");
	 		Thread.sleep(5000);

	 		WebElement text5 = driver.findElement(By.name("mobile"));
	 		text5.clear();
	 		text5.sendKeys("5789782558");
	 		Reporter.log("Phone no. entered successfully");
	 		Thread.sleep(5000);
	 		    
	 		WebElement text6 = driver.findElement(By.name("email"));
	 		text6.clear();
	 		text6.sendKeys("testemail253_tester544867@gmail.com");
	 		Reporter.log("Email id entered successfully");
	 		Thread.sleep(5000);
	 		    
	 		WebElement text7 = driver.findElement(By.name("password"));
	 		text7.clear();
	 		text7.sendKeys("mega@123");
	 		Reporter.log("Password entered successfully");
	 		Thread.sleep(5000);
	 		    
	 		WebElement text8 = driver.findElement(By.name("confirm_password"));
	 		text8.clear();
	 		text8.sendKeys("mega@123");
	 		Reporter.log("Confirm password entered successfully");
	 		Thread.sleep(5000);
	 		    
	 		WebElement text10 = driver.findElement(By.xpath("//*[@id=\"register-form\"]/button"));
	 		text10.click();
	 		Reporter.log("Clicked on register button successfully");
	 		Thread.sleep(5000);
	 		    
			} catch (Exception e) {
				exception=e.getMessage();
				org.testng.Assert.fail();
			}
		 }

		
		@AfterClass
		public void quit(){
			driver.quit();
		}
}
