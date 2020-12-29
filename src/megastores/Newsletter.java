package megastores;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Newsletter {

	
	
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath =  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
	public WebDriver driver;
	InputData oData = new InputData();
	
	
  @Test (priority =1)
  public void openUrl() {
	  System.setProperty("webdriver.chrome.driver", driverpath);
	  driver = new ChromeDriver();
	  driver.get(baseurl);
	  System.out.println("Browser launched !!");
	  Reporter.log("Browser launched !!");
	  assertEquals(driver.getCurrentUrl(), baseurl);
	  driver.manage().window().maximize();
  }
  

  @Test(priority=2)
  public void SingUp() throws InterruptedException {
	  try {
		if(driver.findElement(By.xpath("//*[@id=\"b-newslatter\"]/div/div/h3")).getText().contains("NEWSLETTER")) {
			driver.findElement(By.id("email")).sendKeys(oData.validEmail());
			driver.findElement(By.id("newslater-submit-btn")).click();
			  Thread.sleep(2000);
			  if (driver.getPageSource().contains(oData.successMessage())) {
				System.out.println("Test passed for valid Email : " + oData.successMessage());
				Reporter.log("Test passed for valid Email : " + oData.successMessage());
				Thread.sleep(3000);
			} else {
				org.testng.Assert.fail();
			}
		}
		else {
			org.testng.Assert.fail();
		}
		  
	} catch (Exception e) {
		org.testng.Assert.fail();
	}  
	  
  }
  
  
  @Test(priority=3)
  public void InvalidEmail() throws InterruptedException {
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"b-newslatter\"]/div/div/h3")).getText().contains("NEWSLETTER")) {
			  driver.findElement(By.id("email")).clear();
			  driver.findElement(By.id("email")).sendKeys(oData.invalidEmail());
			  driver.findElement(By.id("newslater-submit-btn")).click();
				  Thread.sleep(2000);
			 
			  if (driver.getPageSource().contains(oData.invalidEmailMessage())) {
				System.out.println("Test passed for invalid Email : " +oData.invalidEmailMessage());
				Reporter.log("Test passed for invalid Email : " +oData.invalidEmailMessage());
				Thread.sleep(3000);
			} else {
				org.testng.Assert.fail();
			}
		}
		else {
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
  
  
 