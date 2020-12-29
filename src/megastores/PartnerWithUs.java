package megastores;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class PartnerWithUs {
	
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath =  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
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
	  public void openUrl() 
	  {
		  String result="";
		  String notes = null;
		  String exception=null;
		  
		  System.setProperty("webdriver.chrome.driver", driverpath);
		  driver = new ChromeDriver();
		  driver.get(baseurl);
		  System.out.println("Browser launched !!");
		  Reporter.log("Browser launched !!");
		  assertEquals(driver.getCurrentUrl(), baseurl);
		  driver.manage().window().maximize();
		  driver.findElement(By.linkText("Partner with us")).sendKeys(Keys.ENTER);
		  Reporter.log("Partner with us page opened !!");
		  notes="Executed successfully";
		  notes = "Browser launched !!";
	}
	  
	  
	  private void clear() {
		  driver.findElement(By.id("shopName")).clear();
		  driver.findElement(By.id("contactPerson")).clear();
		  driver.findElement(By.id("userContact")).clear();
		  driver.findElement(By.id("userEmail")).clear();
		  driver.findElement(By.id("address")).clear();

	}
	  
	  @Test(priority=2)
	  public void InvalidShopName() throws InterruptedException {
		  String result="";
		  String notes = null;
		  String exception=null;
		  try {
			  
			if(driver.findElement(By.xpath("//*[@id=\"partner\"]/div/div/div[1]/div[1]/h2")).getText().contains("PARTNER WITH US")) {
				driver.findElement(By.id("shopName")).sendKeys(oData.invalidShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contactPerson")).sendKeys(oData.invalidName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userContact")).sendKeys(oData.validMobileNo());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("address")).sendKeys(oData.validAddress());
				  Thread.sleep(2000);
				  driver.findElement(By.id("partner-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  if (driver.getPageSource().contains(oData.invalidShopNameMessage())) {
					  Reporter.log("Test passed fo invalid shop name : " + oData.invalidShopNameMessage());
					System.out.println("Test passed fo invalid shop name : " + oData.invalidShopNameMessage());
					Thread.sleep(3000);
					
					notes = "Test passed fo invalid shop name";
					
				} else {
					Reporter.log("Test failed for invalid shop name");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed for invalid shop name");
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Reporter.log("Test failed for invalid shop name");
			org.testng.Assert.fail();
		}  
		  
	  }
	  
	  
	  @Test(priority=3)
	  public void InvalidName() throws InterruptedException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			if(driver.findElement(By.xpath("//*[@id=\"partner\"]/div/div/div[1]/div[1]/h2")).getText().contains("PARTNER WITH US")) {
		clear();
				driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contactPerson")).sendKeys(oData.invalidName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userContact")).sendKeys(oData.validMobileNo());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("address")).sendKeys(oData.validAddress());
				  Thread.sleep(2000);
				  driver.findElement(By.id("partner-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  if (driver.getPageSource().contains(oData.invalidNameMsg())) {
					  Reporter.log("Test passed for invalid Name : " +oData.invalidNameMsg());
					System.out.println("Test passed for invalid Name : " +oData.invalidNameMsg());
					Thread.sleep(3000);
					
					notes = "Test passed fo invalid Name";
					
				
				} else {
					Reporter.log("Test failed for invalid Name");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed for invalid Name");
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			Reporter.log("Test failed for invalid Name");
			
			
			org.testng.Assert.fail();
		}  
		  
	  }
	  
	  @Test(priority=4)
	  public void InvalidNumber() throws InterruptedException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			if(driver.findElement(By.xpath("//*[@id=\"partner\"]/div/div/div[1]/div[1]/h2")).getText().contains("PARTNER WITH US")) {
				clear();
				driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contactPerson")).sendKeys(oData.validName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userContact")).sendKeys("asdfghjklzxc");
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("address")).sendKeys(oData.validAddress());
				  Thread.sleep(2000);
				  driver.findElement(By.id("partner-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  if (driver.getPageSource().contains(oData.invalidMobileNoMessage())) {
					System.out.println("Test passed for invalid Mobile No. : " +oData.invalidMobileNoMessage());
					Reporter.log("Test passed for invalid Mobile No. : " +oData.invalidMobileNoMessage());
					
					notes = "Test passed for invalid email";
					
					Thread.sleep(3000);
				} else {
					Reporter.log("Test failed for invalid Mobile No.");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed for invalid Mobile No.");
				
				
				org.testng.Assert.fail();org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			Reporter.log("Test failed for invalid Mobile No.");
			
			
			org.testng.Assert.fail();org.testng.Assert.fail();
		}  
		  
	  }
	  
	  @Test(priority=5)
	  public void InvalidEmail() throws InterruptedException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			if(driver.findElement(By.xpath("//*[@id=\"partner\"]/div/div/div[1]/div[1]/h2")).getText().contains("PARTNER WITH US")) {
				clear();
				driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contactPerson")).sendKeys(oData.validName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userContact")).sendKeys(oData.validMobileNo());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.invalidEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("address")).sendKeys(oData.validAddress());
				  Thread.sleep(2000);
				  driver.findElement(By.id("partner-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  if (driver.getPageSource().contains(oData.invalidEmailMessage())) {
					System.out.println("Test passed for invalid Email : " +oData.invalidEmailMessage());
					Reporter.log("Test passed for invalid Email : " +oData.invalidEmailMessage());
					
					notes = "Test passed for invalid email";
					
					Thread.sleep(3000);
				} else {
					Reporter.log("Test failed for invalid email");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed for invalid email");
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			Reporter.log("Test failed for invalid email");
			
			
			org.testng.Assert.fail();
		}  
		  
	  }
	  
	  
	  @Test(priority=6)
	  public void validData() throws InterruptedException {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			if(driver.findElement(By.xpath("//*[@id=\"partner\"]/div/div/div[1]/div[1]/h2")).getText().contains("PARTNER WITH US")) {
				clear();
				driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("contactPerson")).sendKeys(oData.validName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userContact")).sendKeys(oData.validMobileNo());
				  Thread.sleep(2000);
				  driver.findElement(By.id("userEmail")).sendKeys(oData.validEmail());
				  Thread.sleep(2000);
				  driver.findElement(By.id("address")).sendKeys(oData.validAddress());
				  Thread.sleep(2000);
				  driver.findElement(By.id("partner-submit-btn")).sendKeys(Keys.ENTER);
				  Thread.sleep(3000);
				  if (driver.getPageSource().contains(oData.successMessage())) {
					System.out.println("Test passed for valid data : " +oData.successMessage());
					Reporter.log("Test passed for valid data : " +oData.successMessage());
					
					notes = "Test passed for invalid data";
					
					Thread.sleep(3000);
				} else {
					Reporter.log("Test failed for valid data");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed for valid data");
				
				
				org.testng.Assert.fail();
			}
			  
		} catch (Exception e) {
			Reporter.log("Test failed for valid data");
			
			
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
