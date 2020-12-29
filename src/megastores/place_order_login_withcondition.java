package megastores;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class place_order_login_withcondition
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
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe");
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
	
  @Test(priority = 1)
  public void place_order_login()  
  {
	  String result = "";
	  String exception = null;

	    // Do login
	  try {
		  WebElement login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")));
		    login.click();
		    Reporter.log("clicked on login button successfully");
		    Thread.sleep(10000);
		    
		    WebElement username = driver.findElement(By.id("username_or_mobile"));
		    username.clear();
		    username.sendKeys("ashwini");
		    Reporter.log("Username entered successfully");
		    Thread.sleep(5000);
		    	    
		    WebElement password = driver.findElement(By.name("password"));
		    password.clear();
		    password.sendKeys("Mega@123");
		    Reporter.log("Password entered successfully");
		    Thread.sleep(5000);
		   
		    WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button"));
		    login_button.click();
		    Reporter.log("clicked on login button successfully");
		    Thread.sleep(3000);
		    
		    if(driver.getPageSource().contains("Session expired. Please login again."))
		    {
				driver.findElement(By.id("username_or_mobile")).sendKeys("ashwini");
				Reporter.log("Username added");
				Thread.sleep(3000);
				
				driver.findElement(By.name("password")).sendKeys("Mega@123");
				Reporter.log("Password added");
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
				Reporter.log("Submit clicked");
				Thread.sleep(3000);
				
				//To check that the Login is successfull after session expiry
				if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed())
				{
					Reporter.log("Login successfull after session expiry");
					Thread.sleep(3000);
				}
				else 
				{
					Reporter.log("Login failed after session expiry");
					
					
					org.testng.Assert.fail();
				}
			} 
		    if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed())
		    {
				Reporter.log("Login successfull");
				Thread.sleep(3000);
			}
			else 
			{
				Reporter.log("Failed to login");
				
				
				org.testng.Assert.fail();
			}
		    		                           
		   //clear cart if product is there in cart already
		    
		    if(driver.findElement(By.id("cart-count")).getText().contains("0"))
		    {
		    	 WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
				    image1.click();
				    Reporter.log("Go to dashboard");
				    Thread.sleep(10000);
				   
					
		    	
		    }
		    else
		    { 

		    WebElement go_to_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[3]/a/i")));
		    go_to_cart.click();
		    Reporter.log("Clicked on go to cart successfully");
		    Thread.sleep(10000);

		    WebElement clear_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clear-cart-btn\"]")));
		    clear_cart.click();
		    Reporter.log("Clicked on clear cart successfully");
		    Thread.sleep(10000); 

		    WebElement ok = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/button[1]")));
		    ok.click();
		    Reporter.log("Clicked on ok button successfully");
		    Thread.sleep(10000); 
		    	
		    WebElement image1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img"));
		    image1.click();
		    Reporter.log("Go to dashboard");
		    Thread.sleep(10000);
		   
			
		    }
		    
		    WebElement segment = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
		    segment.click();
		    Reporter.log("Clicked on segment successfully");
		    Thread.sleep(5000);
		    
		    WebElement accessories = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a/span"));
		    accessories.click();
		    Reporter.log("Clicked on accessories successfully");
		    Thread.sleep(5000);
		    
		    WebElement hebags = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/a"));
		    hebags.sendKeys(Keys.ENTER);                    
		    Reporter.log("Clicked on subcategory successfully");
		     Thread.sleep(10000);
		    	  
		     WebElement product_grid = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-body\"]/div[1]/div")));
				if(product_grid.findElements(By.cssSelector(".float-right.b-out_of_stock")).size() !=0) 
				{
					if(product_grid.isDisplayed() && product_grid.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[2]/div/div[1]/span[2]")).getText().equals("Out of stock"))
					{
						
						Reporter.log(product_grid.findElement(By.xpath("//*[@id=\"product-body\"]/div[1]/div/div[2]/div/div[1]/span[2]")).getText());
						
						WebElement segment1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4")));
					    segment1.click();
					    Reporter.log("Clicked on segment successfully");
					    Thread.sleep(5000);
					    
					    WebElement accessories1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a/span"));
					    accessories1.click();
					    Reporter.log("Clicked on accessories successfully");
					    Thread.sleep(5000);
					    
					    WebElement mebags1 = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/a"));
					    mebags1.sendKeys(Keys.ENTER);     
					    Reporter.log("Clicked on subcategory successfully");
					     Thread.sleep(10000);
					     
					     WebElement addto_cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"37549\"]/a")));
						 addto_cart.sendKeys(Keys.ENTER);
						 Reporter.log("Clicked on add to cart button successfully");
						 Thread.sleep(10000);
						    
						 WebElement goto_cart= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"37549\"]/a")));
						 goto_cart.sendKeys(Keys.ENTER);
						 Reporter.log("Clicked on go to cart button successfully");
						 Thread.sleep(10000);
						 after(driver);
						
						 
						
					}
					else 
					{
						Reporter.log("Failed to add product into cart");
						
						
						org.testng.Assert.fail();     
					}
					
				}
				else if (product_grid.findElements(By.cssSelector(".float-right.b-add_cart")).size() != 0) 
				{
					String product_id = product_grid.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
					if(product_grid.isDisplayed() && product_grid.findElement(By.id(product_id)).getText().equals("Add to Cart")) 
					{
						WebElement Addtocart = product_grid.findElement(By.xpath("//*[@id=\""+product_id+"\"]/a"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", Addtocart);
						Reporter.log("Clicked on add to cart button successfully");
						Thread.sleep(10000);
						
						WebElement gotocart = product_grid.findElement(By.xpath("//*[@id=\""+product_id+"\"]/a"));
						JavascriptExecutor executor1 = (JavascriptExecutor) driver;
						executor1.executeScript("arguments[0].click();", gotocart);
						Reporter.log("Clicked on go to cart successfully");
						Thread.sleep(10000);
						after(driver);
						
						
						
					}
					else 
					{
						Reporter.log("Failed to add product into cart");
						
						
						org.testng.Assert.fail();
					}
				}
				else 
				{
				
					Reporter.log("Failed to add product into cart");
					
					
					org.testng.Assert.fail();
				}
		   
    } 
	  catch (Exception e)
	 {
		exception=e.getMessage();
		
		
		Reporter.log("Failed to add product into cart");
		org.testng.Assert.fail();
     }  
	  
  }
 
  public void after(ChromeDriver driver) throws InterruptedException 
  {
	  String result = "";
	  String exception = null;
	  	try {
		  		WebElement checkout= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"check-out-btn\"]")));
		   		checkout.sendKeys(Keys.ENTER);
		   		Reporter.log("Clicked on checkout button sucessfully");
		    	Thread.sleep(10000);
		    
		    	WebElement addaddress= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-checkout_default\"]/div/div[1]/div[1]/div/div[1]/button")));
			   	addaddress.sendKeys(Keys.ENTER);
			   	Reporter.log("Clicked on add address button sucessfully");
			    Thread.sleep(10000);
		  
		    	WebElement addresstype= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[1]/div[1]/div/input"));
			  	addresstype.clear();
			  	addresstype.sendKeys("Address_tester1554545100");
			  	Reporter.log("Address type added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement name= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[1]/div[2]/div/input"));
			  	name.clear();
			  	name.sendKeys("ashwini");
			  	Reporter.log("Name added sucessfully");
			    Thread.sleep(5000);
			  	
			  	WebElement phoneno= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[1]/div[3]/div/input"));
			  	phoneno.clear();
			  	phoneno.sendKeys("9975517145");
			  	Reporter.log("Phone number added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement address1= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[1]/div[4]/div/input"));
			  	address1.clear();
			  	address1.sendKeys("mulund");
			  	Reporter.log("Address added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement locality= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[1]/div[5]/div/input"));
			  	locality.clear();
			  	locality.sendKeys("mumbai");
			  	Reporter.log("Locality added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement pincode= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[2]/div[1]/div/input"));
			  	pincode.clear();
			  	pincode.sendKeys("400080");
			  	Reporter.log("Pincode added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement city= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[2]/div[2]/div/input"));
			  	city.clear();
			  	city.sendKeys("mumbai");
			  	Reporter.log("City added sucessfully");
			    Thread.sleep(5000);
			  	
			  	WebElement state= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[2]/div[3]/div/input"));
			  	state.clear();
			  	state.sendKeys("Maharashtra");
			  	Reporter.log("State added sucessfully");
			    Thread.sleep(5000);
			    
			  	WebElement country= driver.findElement(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[2]/div[4]/div/input"));
			  	country.clear();
			  	country.sendKeys("India");
			  	Reporter.log("Country added sucessfully");
			    Thread.sleep(5000);
			    
			    WebElement setdefault= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add_address_form\"]/div[2]/div/div[2]/div[5]/div/label[2]/span")));
			    setdefault.click();
			    Reporter.log("Address type added sucessfully");
			    Thread.sleep(5000);
			    
			    WebElement save= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-address-btn\"]")));
			    save.click();
			    Reporter.log("Address saved sucessfully");
			    Thread.sleep(8000);
			    
			    
			    WebElement elementToClick =(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"place-order\"]")));
			    Thread.sleep(5000);	  
			 ((JavascriptExecutor)driver).executeScript("window.scrollTo(40,"+elementToClick.getLocation().y+")");
			 elementToClick.sendKeys(Keys.ENTER);
			 Reporter.log("Order placed successfully");
			 Thread.sleep(8000);
			    
			  //  ((JavascriptExecutor) driver).executeScript(
			       //     "arguments[0].scrollIntoView();", element);
			    
			    	  
			   // WebElement placeorder= driver.findElement(By.xpath("//*[@id=\"place-order\"]"));
			   //placeorder.click();
		        //Thread.sleep(5000);
		    
			 driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='razorpay-checkout-frame']"))); 
			 driver.findElement(By.id("contact")).sendKeys("919975517145");
			 Reporter.log("Focus shifted to razorpay payment screen and contact no. added sucessfully");
			    Thread.sleep(3000);
			    		    
		    WebElement email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
		    email.clear();
		    email.sendKeys("ashwini@atulsia.com");
		    Reporter.log("Email id added sucessfully");
		    Thread.sleep(5000);
		    
		    WebElement proceed = driver.findElement(By.id("footer"));
	    	proceed.click();
	    	Reporter.log("Clicked on proceed button");
	    	Thread.sleep(5000);
	    	
	    	WebElement netbanking = driver.findElement(By.xpath("//*[@id=\"form-common\"]/div/div[1]/div[3]/div/div/div[2]/div/button[2]"));
	    	netbanking.click();
	    	Reporter.log("Clicked on Net banking button");
	    	Thread.sleep(5000);
	    	
	    	
	    	WebElement sbi = driver.findElement(By.id("bank-item-SBIN"));
	    	sbi.click();
	    	Reporter.log("Clicked on SBI");
	    	Thread.sleep(5000);
	    	
		    WebElement pay= driver.findElement(By.id("footer"));
		    pay.click();
		    Reporter.log("Clciked on pay sucessfully");
		    Thread.sleep(10000);
		    
//		    WebElement netbanking= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-options\"]/div[2]/label/i")));
//		    netbanking.click();
//		    Reporter.log("Clicked on netbanking sucessfully");
//		    Thread.sleep(5000);
//		    
//		    WebElement pay= driver.findElement(By.xpath("//*[@id=\"netb-banks\"]/div[2]/label/div"));
//		    pay.click();
//		    Reporter.log("Clciked on pay sucessfully");
//		    Thread.sleep(10000);
		    
//		    WebElement clickpay= driver.findElement(By.xpath("//*[@id=\"footer\"]/span[2]"));
//		    clickpay.click();
//		    Thread.sleep(10000);
		    
		    String currentTab = driver.getWindowHandle();
		    for (String tab : driver.getWindowHandles()) 
		    {
		       if (!tab.equals(currentTab)) 
		       {
		           driver.switchTo().window(tab);
		           Reporter.log("Focus shfted to razorpay success screen sucessfully");
		       }
		    }
		    
		    WebElement success= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/button[1]")));
		    success.sendKeys(Keys.ENTER);
		    Reporter.log("Clicked on success button sucessfully");
		    Thread.sleep(10000);
		   
			
		    
		    // For scrolling in trending
		    	//WebElement scrollArea = driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[2]/div[2]"));
		        //for(int i=0; i<=15; i++)
		        //{
			    //scrollArea.click();
			    //Thread.sleep(2000);
		        //}
	} catch (Exception e) {
		exception=e.getMessage();
		
		
		org.testng.Assert.fail();
	}
  }
  
  
  
  @AfterClass
  public void quit() {
	  driver.quit();
  }
  
}
