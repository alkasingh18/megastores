package megastores;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class My_Order {
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
	
	@Test(priority = 1)
	public void place_order()  {
		String result = "";
		String exception  = null;
		
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
					Reporter.log("Test failed: Login unsuccessfull after session expiry");
					
					
					org.testng.Assert.fail();
				}
			} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
				Reporter.log("Login successfull");
				Thread.sleep(3000);
				
				
			}
			else {
				Reporter.log("Test failed: Login Unsucessfull");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement shop_by_segment = (new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4"))));
			if(shop_by_segment.isDisplayed()) {
				shop_by_segment.click();
				Reporter.log("Shop By Segment Clicked");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a")).click();
				Reporter.log("Accessories Clicked");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[2]/a")).click();
				Reporter.log("Hand Embroidery Bags Clicked");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Shop By Segment is not getting displayed");
				
				
				org.testng.Assert.fail();
			}
			
			WebElement product_grid = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-body\"]/div[1]/div")));
			if(product_grid.findElements(By.cssSelector(".float-right.b-out_of_stock")).size() !=0) {
				if(product_grid.isDisplayed() && product_grid.findElement(By.cssSelector(".float-right.b-out_of_stock")).getText().equals("Out of stock")) {
					Reporter.log(product_grid.findElement(By.cssSelector(".float-right.b-out_of_stock")).getText());
				}
				else {
					Reporter.log("Test failed: Product grid is not getting displayed or unable to get text OUT OF STOCK");
					
					
					org.testng.Assert.fail();
				}
			}
			else if (product_grid.findElements(By.cssSelector(".float-right.b-add_cart")).size() != 0) {
				String product_id = product_grid.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
				//If the product and Add to Cart is displayed.
				if(product_grid.isDisplayed() && product_grid.findElement(By.id(product_id)).getText().equals("Add to Cart")) {
					WebElement Addtocart = product_grid.findElement(By.xpath("//*[@id=\""+product_id+"\"]/a"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", Addtocart);
					Reporter.log("Add to cart Clicked");
					Thread.sleep(3000);
					if(driver.getPageSource().contains(data.add_to_cart_message()) && product_grid.findElement(By.id(product_id)).getText().equals("Go to Cart")) {
						WebElement Gotocart = product_grid.findElement(By.xpath("//*[@id=\""+product_id+"\"]/a"));
						JavascriptExecutor executor1 = (JavascriptExecutor) driver;
						executor1.executeScript("arguments[0].click();", Gotocart);
						Reporter.log("Go to cart Clicked");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Test failed: Expected add to cart does not match the current displayed message and/or Go to cart is not displayed on that product");
						
						
						org.testng.Assert.fail();
					}
					//If on the cart page then click on checkout
					WebElement cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-cart_default\"]/div/div/div/div[1]/h5")));
					if(cart.getText().equals("Your Cart") && driver.findElement(By.id("check-out-btn")).isDisplayed()) {
						driver.findElement(By.id("check-out-btn")).sendKeys(Keys.ENTER);
						Reporter.log("Checkout button Clicked");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Test failed: Cart does not have Your Cart text and/or the checkout button is not getting displayed");
						
						
						org.testng.Assert.fail();
					}
					
					//To check that the address is checked or not.
					WebElement address_check = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addressCard\"]/div[1]/div/div[2]/h5/label/span")));
					if(address_check.isDisplayed() && address_check.isSelected()) {
						Reporter.log("Address already selected.");
					}
					else if(address_check.isDisplayed() && address_check.isSelected() !=true) {
						address_check.click();
						Reporter.log("Address selected.");
						Thread.sleep(3000);
					}
					
					//On checkout screen check the order_confirmation message and then place order.
					WebElement placeorder = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("place-order")));
					if(driver.getPageSource().contains(data.delivery_confirmation()) && placeorder.isDisplayed()) {
						JavascriptExecutor placeorderexecutor = (JavascriptExecutor) driver;
						placeorderexecutor.executeScript("arguments[0].click();", placeorder);
						Thread.sleep(5000);

						String parentwindowhandler = driver.getWindowHandle(); // Store your parent window
						driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='razorpay-checkout-frame']")));
						driver.findElement(By.id("contact")).sendKeys(data.existing_phno());
						Reporter.log("Phone Number Added");
						Thread.sleep(3000);
						
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
						    
						driver.findElement(By.id("email")).sendKeys(data.email_valid_id());
						Reporter.log("Email Added");
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
					    
						String currentTab_checkout = driver.getWindowHandle();
						for (String tab : driver.getWindowHandles()) {
						   if (!tab.equals(currentTab_checkout)) {
						       driver.switchTo().window(tab);
						       Thread.sleep(3000);
						   }
						}
						
						if(driver.findElement(By.className("success")).isDisplayed()) {
							driver.findElement(By.className("success")).sendKeys(Keys.ENTER);
							Reporter.log("Clicked on Success button");
							
							
						}
						else {
							Reporter.log("Test failed: Success not found");
							
							
							org.testng.Assert.fail();
						}
						
						driver.switchTo().window(parentwindowhandler);
						Thread.sleep(6000);
					}
					else {
						Reporter.log("Test failed: Expected Delivery confirmation message does not match the current displayed one and/or place order is not getting displayed");
						
						
						org.testng.Assert.fail();
					}
					
				}
				// To check if the product is already added in the cart.
				else if (product_grid.isDisplayed() && product_grid.findElement(By.id(product_id)).getText().equals("Go to Cart")) {
					WebElement Gotocart = product_grid.findElement(By.xpath("//*[@id=\""+product_id+"\"]/a"));
					JavascriptExecutor executor2 = (JavascriptExecutor) driver;
					executor2.executeScript("arguments[0].click();", Gotocart);
					Reporter.log("Go to cart Clicked");
					Thread.sleep(6000);
					
					//If on the cart page then click on checkout
					WebElement cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-cart_default\"]/div/div/div/div[1]/h5")));
					if(cart.getText().equals("Your Cart") && driver.findElement(By.id("check-out-btn")).isDisplayed()) {
						driver.findElement(By.id("check-out-btn")).sendKeys(Keys.ENTER);
						Reporter.log("Checkout button Clicked");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Test failed: Cart does not contain text Your Cart and/or checkout button is not displayed");
						
						
						org.testng.Assert.fail();
					}
					
					//To check that the address is checked or not.
					WebElement address_check = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addressCard\"]/div[1]/div/div[2]/h5/label/span")));
					if(address_check.isDisplayed() && address_check.isSelected()) {
						Reporter.log("Address already selected.");
					}
					else if(address_check.isDisplayed() && address_check.isSelected() !=true) {
						address_check.click();
						Reporter.log("Address selected.");
						Thread.sleep(3000);
					}
					
					//On checkout screen check the order_confirmation message and then place order.
					WebElement placeorder = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("place-order")));
					if(driver.getPageSource().contains(data.delivery_confirmation()) && placeorder.isDisplayed()) {
						JavascriptExecutor placeorderexecutor = (JavascriptExecutor) driver;
						placeorderexecutor.executeScript("arguments[0].click();", placeorder);
						Reporter.log("Place Order Clicked");
						Thread.sleep(5000);

						String parentwindowhandler = driver.getWindowHandle();
						driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='razorpay-checkout-frame']")));
						driver.findElement(By.id("contact")).sendKeys(data.existing_phno());
						Reporter.log("Contact Added");
						Thread.sleep(3000);
						driver.findElement(By.id("email")).sendKeys(data.email_valid_id());
						Reporter.log("Email Added");
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
						    
//						    WebElement netbanking= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"payment-options\"]/div[2]/label/i")));
//						    netbanking.click();
//						    Reporter.log("Clicked on netbanking sucessfully");
//						    Thread.sleep(5000);
//						    
//						    WebElement pay= driver.findElement(By.xpath("//*[@id=\"netb-banks\"]/div[2]/label/div"));
//						    pay.click();
//						    Reporter.log("Clciked on pay sucessfully");
//						    Thread.sleep(10000);
						    
//						    WebElement clickpay= driver.findElement(By.xpath("//*[@id=\"footer\"]/span[2]"));
//						    clickpay.click();
//						    Thread.sleep(10000);
						    
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
						   
					
						
						driver.switchTo().window(parentwindowhandler);
						Thread.sleep(6000);
					}
					else {
						Reporter.log("Test failed: Expected Delivery confirmation message does not match the current displayed one and/or place order is not getting displayed");
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					Reporter.log("Test failed: Product Grid is not getting displayed and/or not able to view Go to Cart on already added product");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Element .float-right.b-add_cart not found");
				
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			
			
			org.testng.Assert.fail();
		}
  }
	
	@Test(priority = 2)
	public void view_latest_order() {
		String result = "";
		String exception = null;
		try {
			WebElement order_detail = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/span")));
			if(order_detail.isDisplayed()) {
				String order_id = order_detail.getText();
				Reporter.log(order_id);
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).isDisplayed()) {
					driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
					Reporter.log("My account clicked");
					Thread.sleep(3000);
					WebElement my_order = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myOrders\"]/a")));
					if(my_order.isDisplayed()) {
						my_order.sendKeys(Keys.ENTER);
						Reporter.log("My Order Clicked");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Test failed: My Order is not getting displayed");
						
						
						org.testng.Assert.fail();
					}
					
					WebElement my_order_tab = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/ul/li/a")));
					if(my_order_tab.isDisplayed() && my_order_tab.getText().equals("My Orders")) {
						WebElement odd = driver.findElement(By.className("odd"));
						String order_id1 = odd.getAttribute("id");
						Reporter.log(order_id1);
						if(odd.getAttribute("id").contentEquals(order_id)) {
							Reporter.log("Test Passed : Able to view latest order on the top");
							Thread.sleep(3000);
							
						}
						else {
							Reporter.log("Test failed: Not able to view the latest order on the top");
							
							
							org.testng.Assert.fail();
						}
					}
					else {
						Reporter.log("Test failed: My order tab not getting displayed and/or not able to view 'My Order' on that Tab");
						
						
						org.testng.Assert.fail();
					}
				}
				else {
					Reporter.log("Test failed: My Account is not getting displayed");
					
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Order detailview is not getting displayed");
				
				
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
