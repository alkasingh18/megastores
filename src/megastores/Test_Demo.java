package megastores;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Test_Demo {
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath = "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
	public WebDriver driver;
	TestData data = new TestData();
	
	@Test(priority = 1)
  public void go_to_contact_us() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
		assertEquals(driver.getCurrentUrl(), baseurl);
		
		
//		try {
//			if(driver.findElement(By.linkText("Contact us")).isDisplayed()){
//				driver.findElement(By.linkText("Contact us")).sendKeys(Keys.ENTER);;
//				System.out.println("Contact Us clicked successfully");
//				Thread.sleep(3000);
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		}
  }
	
//	@Test(priority = 2)
//	public void contact_us_test() {
//		try {
//			if(driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/div[2]/div[1]/h2")).getText().contains("CONTACT US")) {
//				driver.findElement(By.id("userName")).sendKeys("Test");
//				Thread.sleep(3000);
//				driver.findElement(By.id("userEmail")).sendKeys("test@gmail.com");
//				Thread.sleep(3000);
//				driver.findElement(By.id("subject")).sendKeys("Test subject");
//				Thread.sleep(3000);
//				driver.findElement(By.id("message")).sendKeys("Test Message");
//				Thread.sleep(3000);
//				driver.findElement(By.id("contact-submit-btn")).sendKeys(Keys.ENTER);;
//				System.out.println("Button Clicked");
//				Thread.sleep(3000);
//				if(driver.getPageSource().contains("Request submitted successfully.")) {
//					System.out.println("Test Passed");
//					Thread.sleep(3000);
//				}
//				else {
//					org.testng.Assert.fail();
//				}
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//				
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		}
//	}
	
//	@Test(priority = 2)
//	public void helpful() throws InterruptedException {
//			driver.findElement(By.xpath("//*[@id=\"b-featured_products\"]/div[1]/div/div[1]/div/div/div[1]/a/img")).click();
//			Thread.sleep(3000);
//			
//			String currentTab = driver.getWindowHandle();
//			for (String tab : driver.getWindowHandles()) {
//			   if (!tab.equals(currentTab)) {
//			       driver.switchTo().window(tab);
//			       Thread.sleep(10000);
//			   }
//			}
//				
//				driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a")).sendKeys(Keys.ENTER);;
//				Thread.sleep(7000);
//				driver.findElement(By.xpath("//*[@id=\"vote_btn_68\"]")).sendKeys(Keys.ENTER);;
//				Thread.sleep(7000);
//				driver.findElement(By.xpath("/html/body/div[9]/div/button[1]")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
//				System.out.println("Username added");
//				Thread.sleep(3000);
//				driver.findElement(By.name("password")).sendKeys(data.password_valid());
//				System.out.println("Password added");
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
//				System.out.println("Submit clicked");
//				Thread.sleep(3000);
//				if(driver.getPageSource().contains(data.session_expiry())) {
//					driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
//					System.out.println("Username added");
//					Thread.sleep(3000);
//					driver.findElement(By.name("password")).sendKeys(data.password_valid());
//					System.out.println("Password added");
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
//					System.out.println("Submit clicked");
//					Thread.sleep(3000);
//					
//					//To check that the Login is successfull after session expiry
//					if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()) {
//						System.out.println("Login successfull after session expiry");
//						Thread.sleep(7000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//				} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
//					System.out.println("Login successfull");
//					Thread.sleep(7000);
//				}
//				else {
//					System.out.println("Some error occured while login");
//					org.testng.Assert.fail();
//				}
//				
//				driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a")).sendKeys(Keys.ENTER);
//				Thread.sleep(7000);
//				driver.findElement(By.xpath("//*[@id=\"vote_btn_68\"]")).sendKeys(Keys.ENTER);
//				Thread.sleep(3000);
//				
//				if(driver.getPageSource().contains("Review voted successfully.")) {
//					
//				}
//				else {
//					org.testng.Assert.fail();
//				}
//			
//	}
	
//	@Test(priority = 2)
//	public void cart() {
//		try {
//			WebElement cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
//			if(cart.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("0")) {
//				if(driver.findElement(By.xpath("//*[@id=\"37626\"]/a")).isDisplayed()) {
//					driver.findElement(By.xpath("//*[@id=\"37626\"]/a")).sendKeys(Keys.ENTER);
//					Thread.sleep(3000);
//				}
//				else {
//					org.testng.Assert.fail();
//				}	
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//		
//			if(cart.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
//					driver.findElement(By.xpath("//*[@id=\"37626\"]/a")).click();
//					Thread.sleep(3000);
//				}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			WebElement prod_cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"37626\"]/td[1]/div/div[2]/h4")));
//			if (prod_cart.isDisplayed()) {
//				driver.findElement(By.xpath("//*[@id=\"37626\"]/td[1]/div/div[2]/h4/a")).click();
//				Thread.sleep(3000);	
//			} else {
//				org.testng.Assert.fail();
//			}
//			
//			WebElement detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
//			WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
//			WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
//			WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
//			WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
//			WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
//			
//			if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
//				Merchant_Info.sendKeys(Keys.ENTER);
//				Thread.sleep(2000);
//				WebElement merchant_info = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
//				if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
//					Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
//					Thread.sleep(2000);
//				}
//				else {
//					org.testng.Assert.fail();
//				}
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
//			Thread.sleep(2000);		
//			
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		}
//			
//	}
	
//	@Test(priority = 3)
//	public void cart1() {
//		try {
//			WebElement cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
//			if(cart.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"37626\"]/a")).isDisplayed()) {
//				driver.findElement(By.xpath("//*[@id=\"37626\"]/a")).sendKeys(Keys.ENTER);
//				Thread.sleep(3000);
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			//If cart count is 1 then click the cart and delete the cart item first then add a new product and go to detailview of that product
//			if(cart.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
//				WebElement cart_element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a")));
//				if (cart_element.isDisplayed()) {
//					WebElement webElement = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a"));
//					JavascriptExecutor executor = (JavascriptExecutor) driver;
//					executor.executeScript("arguments[0].click();", webElement);
//					Thread.sleep(3000);	
//				} else {
//					org.testng.Assert.fail();
//				}
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			WebElement clear_cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("clear-cart-btn")));
//			if(clear_cart.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/div/div[1]/h5")).getText().contains("Your Cart")) {
//				driver.findElement(By.id("clear-cart-btn")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("/html/body/div[7]/div/button[1]")).sendKeys(Keys.ENTER);
//				Thread.sleep(3000);
//				if (driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/h3")).getText().equals("YOUR CART IS CURRENTLY EMPTY.")) {
//					Reporter.log("Cart Cleared successfully");
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
//					Thread.sleep(3000);
//			} else {
//					org.testng.Assert.fail();
//			}
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//				
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		}
//		
//	}
//	
	
/*	@Test(priority = 4)
	public void valid_email() {
		try {
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			System.out.println("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			System.out.println("Username added");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			System.out.println("Password added");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			System.out.println("Submit clicked");
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
					org.testng.Assert.fail();
				}
			} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
				Reporter.log("Login successfull");
				Thread.sleep(3000);
			}
			else {
				org.testng.Assert.fail();
			}
			}

//			
//			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
//			Reporter.log("My Account Clicked successfully");
//			Thread.sleep(3000);
//			
////			if (driver.findElement(By.id("resendLink")).isDisplayed()) {
////				driver.findElement(By.id("resendLink")).sendKeys(Keys.ENTER);
////				Thread.sleep(3000);
////			} else {
////				org.testng.Assert.fail();
////			}
////			
////			
////			//Valid email
////			if(driver.findElement(By.id("new_email")).isDisplayed()) {
////				driver.findElement(By.id("new_email")).clear();
////				Thread.sleep(3000);
////				driver.findElement(By.id("new_email")).sendKeys("jigarp@atulsia.com");
////				Thread.sleep(3000);
////				driver.findElement(By.xpath("//*[@id=\"email-form\"]/div/div[3]/button[2]")).click();
////				Thread.sleep(3000);
////				if(driver.getPageSource().contains(data.change_email_message())) {
////					Reporter.log("Test Passed: Email sent");
////					driver.get("http://webmail.atulsia.com/");
////					Thread.sleep(3000);
////					driver.findElement(By.id("email")).sendKeys("jigarp@atulsia.com");
////					Thread.sleep(3000);
////					driver.findElement(By.id("password")).sendKeys("priyalpatel");
////					Thread.sleep(3000);
////					driver.findElement(By.xpath("//*[@id=\"MoreOptions\"]/td/input")).click();
////					Thread.sleep(3000);
////				
////					Date date = new Date();
////					DateFormat format = new SimpleDateFormat("dd MMM yyyy");
////					String date1 = format.format(date);
////					
////					
////					WebElement element = (new WebDriverWait(driver, 300000)).until(ExpectedConditions.visibilityOfElementLocated(By.className("mail-selectable")));
////					if (element.isDisplayed()) {
////						if(driver.findElement(By.className("mail-selectable")).getText().contains("Megastores email validation check for jigar") && element.findElement(By.id("date")).getAttribute("title").contains(date1.toString())) {
////							WebElement element1 = driver.findElement(By.className("mail-selectable"));
////							Reporter.log(driver.findElement(By.className("mail-selectable")).getText() + " Contains: Megastores email validation check for jigar");
////							Reporter.log(element1.findElement(By.id("date")).getAttribute("title"));  
////							Reporter.log("Test passed: Verification link received in email");
////							Thread.sleep(6000);
////						}
////						else {
////							org.testng.Assert.fail();
////						}
////					} 
////					else {
////						org.testng.Assert.fail();
////					}
////				}
////				else {
////					org.testng.Assert.fail();
////				}
////			}
////			else {
////				org.testng.Assert.fail();
////			}
//			}
			catch (Exception e) {
				org.testng.Assert.fail();
			}
	}
*/	
	
//	@Test(priority = 5)
//	public void delete() {
//		try {
//			WebElement address1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
//			if(address1.isDisplayed() && address1.getText().equals("Addresses")) {
//				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//				Reporter.log("Address clicked successfully");
//				Thread.sleep(3000);
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			if(driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).isDisplayed()) {
//				driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).click();
//				Reporter.log("Action clicked sucessfully");
//				Thread.sleep(3000);
//				
//				WebElement webElement = driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[2]/h5/div/div/a[2]"));
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", webElement);
//				Thread.sleep(3000);					
//				Reporter.log("Delete clicked successfully");
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//		
//				
//				if(driver.findElement(By.cssSelector(".modal.fade.show")).isDisplayed()) {
//					String delete = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
//					Thread.sleep(3000);
//					if(driver.findElement(By.xpath("//*[@id=\""+delete+"\"]/div/div/div[2]/p")).getText().equals("You want to delete address?")) {
//						driver.findElement(By.xpath("//*[@id=\""+delete+"\"]/div/div/div[3]/form/button[2]")).click();
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//				}
//				else {
//					org.testng.Assert.fail();
//				}
//			
//				if(driver.getPageSource().contains("Unable to delete. Order in progress.")) {
//					Reporter.log("Order already in progress hence cannot be deleted");
//					Thread.sleep(3000);
//				}
//				else if(driver.getPageSource().contains("Address removed.")) {
//						Reporter.log("Address deleted successfully.");
//					Thread.sleep(3000);
//				}
//				else {
//					org.testng.Assert.fail();
//				}
//		}
//		catch (Exception e){
//			org.testng.Assert.fail();
//		}	
//	}
//	
	
/*	@Test(priority = 6)
	public void edit_address() {
		try {
			WebElement address1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address1.isDisplayed() && address1.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
			}
			else {
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).click();
				Reporter.log("Action clicked sucessfully");
				Thread.sleep(3000);
				
				WebElement webElement = driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[2]/h5/div/div/a[1]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
				Thread.sleep(3000);					
				Reporter.log("Edit clicked successfully");
			}
			else {
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.cssSelector(".modal.fade.modal-address-update.show")).isDisplayed()) {
				WebElement element = driver.findElement(By.cssSelector(".modal.fade.modal-address-update.show"));
				WebElement element2 = element.findElement(By.className("modal-content"));
				WebElement element3 = element2.findElement(By.className("form"));
				String edit = element3.getAttribute("id");
				System.out.println(edit);
				WebElement edit_Address_Title = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[1]/div[1]/div/input"));
				WebElement edit_Name = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[1]/div[2]/div/input"));
				WebElement edit_Mobile = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[1]/div[3]/div/input"));
				WebElement edit_Flat_no = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[1]/div[4]/div/input"));
				WebElement edit_Bldg_name = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[1]/div[5]/div/input"));
				WebElement edit_Locality = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[2]/div[1]/div/input"));
				WebElement edit_Pincode = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[2]/div[2]/div/input"));
				WebElement edit_City = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[2]/div[3]/div/input"));
				WebElement edit_State = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[2]/div[4]/div/input"));
				WebElement edit_Country  = driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[2]/div/div[2]/div[5]/div/input"));
				
				if(driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[1]/h4")).getText().equals("Edit Address")) {
					edit_Name.clear();
					edit_Name.sendKeys(data.name());
					Thread.sleep(3000);
					edit_Mobile.clear();
					edit_Mobile.sendKeys(data.mobile_no());
					Thread.sleep(3000);
					edit_Flat_no.clear();
					edit_Flat_no.sendKeys(data.flat_no());
					Thread.sleep(3000);
					edit_Bldg_name.clear();
					edit_Bldg_name.sendKeys(data.building());
					Thread.sleep(3000);
					edit_Locality.clear();
					edit_Locality.sendKeys(data.locality());
					Thread.sleep(3000);
					edit_Locality.sendKeys(Keys.ARROW_DOWN);
					edit_Locality.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					
					//To check Pincode field is empty or not
					if(edit_Pincode.getAttribute("value").isEmpty()) {
						edit_Pincode.sendKeys(data.pincode());
						Thread.sleep(3000);	
					}
					else if(edit_Pincode.getAttribute("value").isEmpty() != true) {
						Thread.sleep(3000);
					}
					else {
						org.testng.Assert.fail();
					}
					
					//To check City field is empty or not
					if(edit_City.getAttribute("value").isEmpty()) {
						edit_City.sendKeys(data.city());
						Thread.sleep(3000);
					}
					else if(edit_City.getAttribute("value").isEmpty() != true){
						Thread.sleep(3000);
					}
					else {
						org.testng.Assert.fail();
					}
					
					//To check State field is empty or not
					if(edit_State.getAttribute("value").isEmpty()) {
						edit_State.sendKeys(data.state());
						Thread.sleep(3000);
					}
					else if(edit_State.getAttribute("value").isEmpty() != true){
						Thread.sleep(3000);
					}
					else {
						org.testng.Assert.fail();
					}
					
					//To check that the country field is empty or not
					if(edit_Country.getAttribute("value").isEmpty()) {
						edit_Country.sendKeys(data.country());
						Thread.sleep(3000);
					}
					else if(edit_Country.getAttribute("value").isEmpty() != true){
						Thread.sleep(3000);
					}
					else {
						org.testng.Assert.fail();
					}
					
					driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
				}
				else {
					org.testng.Assert.fail();
				}
				
				if(driver.getPageSource().contains("Address updated successfully.")) {
					Thread.sleep(3000);
				}
				else if(driver.getPageSource().contains("You already have address with title " + data.exist_title() + ".")) {
					Reporter.log("Does not allow to update address with existing titles.");
					Thread.sleep(3000);
				}
				else {
					org.testng.Assert.fail();
				}
			}
			else {
				org.testng.Assert.fail();
			}
			
			
		} catch (Exception e) {
			org.testng.Assert.fail();
		}
	} */
	
//	@Test(priority = 7)
//	public void delete_address() {
//		try {
//			WebElement address2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
//			if(address2.isDisplayed() && address2.getText().equals("Addresses")) {
//				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
//				Reporter.log("Address clicked successfully");
//				Thread.sleep(3000);
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			List<WebElement> card_element = driver.findElements(By.cssSelector(".card-header"));
//			int count = card_element.size();
//			System.out.println(count);
//			for(int i=0; i<count; i++) {
//				System.out.println(card_element.get(i).getText());
//				if(card_element.get(i).getText().contains(data.valid_title_default())) {
//					WebElement Action = card_element.get(i).findElement(By.id("dropdownMenuLink"));
//					Action.sendKeys(Keys.ENTER);
//					Thread.sleep(3000);
//					WebElement Delete = card_element.get(i).findElement(By.linkText("Delete"));
//					Delete.click();
//					Thread.sleep(3000);
//					String id = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
//					if(driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[1]/h4")).getText().equals("Delete Address")) {
//						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[3]/form/button[2]")).sendKeys(Keys.ENTER);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					if(driver.getPageSource().contains("Unable to delete. Order in progress.")) {
//						Reporter.log("Order already in progress hence cannot be deleted");
//						Thread.sleep(3000);
//					}
//					else if(driver.getPageSource().contains("Address removed.")) {
//						Reporter.log("Address deleted successfully.");
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					break;
//				}
//				else {
//					System.out.println("Not found at " + i);
//				}
//			}
//				
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		}
//	}
//	
//	
//	@Test(priority = 8)
//	public void detailview_cart() {
//		try {
//			WebElement cart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
//			//If cart count is 1 then click the cart and delete the cart item first then add a new product and go to detailview of that product
//			if(cart.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
//				WebElement cart_element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a")));
//				if (cart_element.isDisplayed()) {
//					WebElement webElement = driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]/a"));
//					JavascriptExecutor executor = (JavascriptExecutor) driver;
//					executor.executeScript("arguments[0].click();", webElement);
//					Thread.sleep(3000);	
//				} else {
//					org.testng.Assert.fail();
//				}
//			
//			WebElement clear_cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("clear-cart-btn")));
//			if(clear_cart.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/div/div[1]/h5")).getText().contains("Your Cart")) {
//				driver.findElement(By.id("clear-cart-btn")).click();
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("/html/body/div[7]/div/button[1]")).sendKeys(Keys.ENTER);
//				Thread.sleep(3000);
//				if (driver.findElement(By.xpath("//*[@id=\"b-cart_default\"]/div/div/h3")).getText().equals("YOUR CART IS CURRENTLY EMPTY.")) {
//					Reporter.log("Cart Cleared successfully");
//					Thread.sleep(3000);
//					driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
//					Thread.sleep(3000);
//			} else {
//					org.testng.Assert.fail();
//			}
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//			//Adding product to the cart after clearing
//			String id = driver.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
//			WebElement cart_count1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
//			if(cart_count1.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("0")) {
//				if(driver.findElement(By.cssSelector(".float-right.b-add_cart")).isDisplayed()) {
//					driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).sendKeys(Keys.ENTER);
//					Thread.sleep(3000);
//				}
//				else {
//					org.testng.Assert.fail();
//				}	
//				}
//					else {
//						org.testng.Assert.fail();
//					}
//				
//				if(cart_count1.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
//						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).click();
//						Thread.sleep(3000);
//					}
//				else {
//					org.testng.Assert.fail();
//				}
//					
//				WebElement prod_cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4")));
//				if (prod_cart.isDisplayed()) {
//					driver.findElement(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4/a")).click();
//					Thread.sleep(3000);	
//				} else {
//					org.testng.Assert.fail();
//				}
//					
//				WebElement detailview = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
//				WebElement description = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
//				WebElement Reviews = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
//				WebElement Specifications = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
//				WebElement Merchant_Info = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
//				WebElement Created_By = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
//					
//				if(description.isDisplayed() && Reviews.isDisplayed() && Specifications.isDisplayed() && Merchant_Info.isDisplayed() && Created_By.isDisplayed()) {
//					Merchant_Info.sendKeys(Keys.ENTER);
//					Thread.sleep(2000);
//					WebElement merchant_info = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
//						if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
//							Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
//							Thread.sleep(2000);
//						}
//						else {
//							org.testng.Assert.fail();
//						}
//					}
//				else {
//					org.testng.Assert.fail();
//				}
//					
//				driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
//				Thread.sleep(2000);		
//				}
//			
//			//Adding product to the cart and go to detailview if the cart count is 0
//			else if(driver.findElement(By.id("cart-count")).getText().equals("0")) {
//					String id = driver.findElement(By.cssSelector(".float-right.b-add_cart")).getAttribute("id");
//					WebElement cart_count = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[2]")));
//					if(cart_count.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("0")) {
//						if(driver.findElement(By.cssSelector(".float-right.b-add_cart")).isDisplayed()) {
//							driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).sendKeys(Keys.ENTER);
//							Thread.sleep(3000);
//						}
//						else {
//							org.testng.Assert.fail();
//						}	
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//				
//					if(cart_count.isDisplayed() && driver.findElement(By.id("cart-count")).getText().equals("1")) {
//							driver.findElement(By.xpath("//*[@id=\""+id+"\"]/a")).click();
//							Thread.sleep(3000);
//						}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					WebElement prod_cart = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4")));
//					if (prod_cart.isDisplayed()) {
//						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/td[1]/div/div[2]/h4/a")).click();
//						Thread.sleep(3000);	
//					} else {
//						org.testng.Assert.fail();
//					}
//					
//					WebElement detailview1 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]")));
//					WebElement description1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
//					WebElement Reviews1 = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
//					WebElement Specifications1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
//					WebElement Merchant_Info1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
//					WebElement Created_By1 = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
//					
//					if(description1.isDisplayed() && Reviews1.isDisplayed() && Specifications1.isDisplayed() && Merchant_Info1.isDisplayed() && Created_By1.isDisplayed()) {
//						Merchant_Info1.sendKeys(Keys.ENTER);
//						Thread.sleep(2000);
//						WebElement merchant_info = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
//						if(merchant_info.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("VRDI Mandvi")) {
//							Reporter.log("Test Passed: Navigated to detailview of VRDI product successfully");
//							Thread.sleep(2000);
//						}
//						else {
//							org.testng.Assert.fail();
//						}
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[1]/div/a/img")).click();
//					Thread.sleep(2000);		
//			}
//			else {
//				org.testng.Assert.fail();
//			}
//			
//		} catch (Exception e) {
//			org.testng.Assert.fail();
//		} 
//	}
	
//	@Test(priority = 9)
//	public void add_to_cart_diff_merchant() {
//		try {
//		Actions action = new Actions(driver);
//	    WebElement elementToHover= driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/h4"));
//	    WebElement elementToClick=driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/a/span"));
//	    action.moveToElement(elementToHover).click(elementToClick).build().perform();
//	    
//	    driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[2]/div/div/div[1]/div/ul/li[1]/div/ul/li[1]/div/div/div/div[1]/div/div/div/div/ul/li[7]/a")).click();
//	    Thread.sleep(6000);
//	    //click on product
//	    List<WebElement> allelements = driver.findElements(By.className("b-product_grid_single"));
//	    int size=allelements.size();
//	    for(int i=1;i<3;i++){
//	    	WebElement product = allelements.get(i).findElement(By.xpath("//*[@id=\"product-body\"]/div["+i+"]/div/div[1]/a/img"));
//	    	product.click();
//	    	Thread.sleep(8000);
//	    
//	    	String currentTab = driver.getWindowHandle();
//	    	for(String tab : driver.getWindowHandles()) {
//	    		if (!tab.equals(currentTab)) 
//	    		{
//	    			driver.switchTo().window(tab);
//	    			Thread.sleep(6000);
//	    	   }
//	    	}
//	    	
//	    	WebElement element = driver.findElement(By.cssSelector(".b-product_single_action.clearfix"));
//	    	String id = element.getAttribute("id");
//	    	if(element.isDisplayed() && element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).isDisplayed()) {
//	    		element.findElement(By.xpath("//*[@id=\""+id+"\"]/button[1]")).click();
//	    		System.out.println("Add to cart clicked for product from merchant " + i);
//	    		Thread.sleep(3000);
//	    		if(driver.getPageSource().contains("Product added successfully")) {
//	    			System.out.println("Product: " + id + " added successfully." );
//	    			Thread.sleep(3000);
//	    		}
//	    		else if(driver.findElement(By.cssSelector(".swal2-modal.no-animation")).isDisplayed() && driver.findElement(By.cssSelector(".swal2-cancel.styled")).isDisplayed()) {
//	    			driver.findElement(By.cssSelector(".swal2-cancel.styled")).click();
//	    			System.out.println("Cancel Button Clicked");
//	    			Thread.sleep(3000);
//	    			WebElement element1 = driver.findElement(By.cssSelector(".b-product_single_action.clearfix"));
//	    			String id1 = element1.getAttribute("id");
//	    			if(element1.isDisplayed() && element1.findElement(By.xpath("//*[@id=\""+id1+"\"]/button[1]")).isDisplayed()) {
//	    				element1.findElement(By.xpath("//*[@id=\""+id1+"\"]/button[1]")).sendKeys(Keys.ENTER);
//	    				System.out.println("Add to cart clicked again for product from merchant " + i);
//	    				Thread.sleep(3000);
//	    				if(driver.getPageSource().contains("Product added successfully")) {
//	    					System.out.println("Product: " + id1 + " added successfully." );
//	    	    			Thread.sleep(3000);
//	    				}
//	    				else if(driver.findElement(By.cssSelector(".swal2-modal.no-animation")).isDisplayed() && driver.findElement(By.xpath("/html/body/div[9]/div/button[1]")).isDisplayed()) {
//	    					WebElement Okbutton = driver.findElement(By.xpath("/html/body/div[9]/div/button[1]"));
//	    					JavascriptExecutor executor = (JavascriptExecutor) driver;
//	    					executor.executeScript("arguments[0].click();", Okbutton);
//	    					System.out.println("Ok button clicked.");
//	    					Thread.sleep(3000);
//	    					if(driver.getPageSource().contains("Product added successfully")) {
//	    						System.out.println("Product: " + id1 + " added successfully." );
//	    						Thread.sleep(3000);
//	    					}
//	    					else {
//	    						System.out.println("No message appeared for product added successfully.");
//	    						org.testng.Assert.fail();
//	    						break;
//	    					}
//	    				}
//	    				else {
//	    					System.out.println("Product not added neither a pop up appeared for diff merchant after cancel.");
//	    					org.testng.Assert.fail();
//	    					break;
//	    				}
//	    			}
//	    			else {
//	    				System.out.println("Element after cancel not displayed");
//	    				org.testng.Assert.fail();
//	    				break;
//	    			}
//	    		}
//	    		else {
//	    			System.out.println("Product not added neither a pop up appeared for diff merchant");
//	    			org.testng.Assert.fail();
//	    			break;
//	    		}
//	    	}
//	    	else {
//	    		System.out.println("Element not displayed");
//	    		org.testng.Assert.fail();
//	    		break;
//	    	}
//	    	
//	    	driver.close();
//    	    driver.switchTo().window(currentTab);
//    	    Thread.sleep(3000);
//	    }
//		
//	      
//	    driver.navigate().refresh();
//	    Thread.sleep(4000);
//	    
////	    WebElement Cart_button = driver.findElement(By.className("d-inline-block"));
////	    JavascriptExecutor executor = (JavascriptExecutor) driver;
////		executor.executeScript("arguments[0].click();", Cart_button);
////		System.out.println("Cart icon clicked.");
////	    Thread.sleep(3000);
//	  }catch (Exception e)
//	    {
//	        org.testng.Assert.fail();
//	     } 
//	}
	
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void trending() throws InterruptedException {
		String currentTab_trending = driver.getWindowHandle();
		try {
			WebElement trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"b-trending-products\"]/div[1]/h4")));
			if (driver.findElement(By.xpath("//*[@id=\"b-trending-products\"]/div[1]/h4")).getText().equals("TRENDING")) {
				
				WebElement scroll = driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[2]/div[2]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", scroll);
				Thread.sleep(5000);
				
				if(driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")).isDisplayed()) {
					Actions actions1 = new Actions(driver);
					actions1.moveToElement(driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")));
					actions1.click().build().perform();
					Reporter.log("Rogan Product clicked");
					Thread.sleep(5000);
				}
				else {
					Reporter.log("Trending Product not found.");
					Thread.sleep(6000);
					org.testng.Assert.fail();
				}
				
				//driver.findElement(By.xpath("//*[@id=\"b-trending_products\"]/div[1]/div/div[5]/div/div/div[1]/a/img")).sendKeys(Keys.ENTER);
				
			} else {
				Reporter.log("Test failed: Section does not consist of title Trending");
				Thread.sleep(6000);
				org.testng.Assert.fail();
			}
			
			for (String tab : driver.getWindowHandles()) {
			   if (!tab.equals(currentTab_trending)) {
			       driver.switchTo().window(tab);
			       Thread.sleep(3000);
			   }
			}
			
			WebElement detailview_trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/li")));
			WebElement description_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[1]/a"));
			WebElement Reviews_trending = driver.findElement(By.xpath("//*[@id=\"open_review_tab\"]/a"));
			WebElement Specifications_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[3]/a"));
			WebElement Merchant_Info_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[4]/a"));
			WebElement Created_By_trending = driver.findElement(By.xpath("//*[@id=\"product-inner-content\"]/div[2]/div/div/ul/li[5]/a"));
			
			if(description_trending.isDisplayed() && Reviews_trending.isDisplayed() && Specifications_trending.isDisplayed() && Merchant_Info_trending.isDisplayed() && Created_By_trending.isDisplayed()) {
				Merchant_Info_trending.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				WebElement merchant_info_trending = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("seller-grid")));
				if(merchant_info_trending.isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).isDisplayed() && driver.findElement(By.xpath("//*[@id=\"seller-grid\"]/div/div[2]/h3")).getText().equals("The Traditional Rogan Art")) {
					Reporter.log("Test Passed: Navigated to detailview of Rogan Art product successfully");
					Thread.sleep(2000);
				}
				else {
					driver.close();
					driver.switchTo().window(currentTab_trending);
					Reporter.log("Test failed: Merchant Info for Rogan Art is not getting displayed");
					Thread.sleep(6000);
					org.testng.Assert.fail();
				}
			}
			else {
				driver.close();
				driver.switchTo().window(currentTab_trending);
				Reporter.log("Test failed: Product description, reviews, specifications, merchant_info, created_by Tabs are not getting displayed");
				Thread.sleep(6000);
				org.testng.Assert.fail();
			}
			driver.close();
			driver.switchTo().window(currentTab_trending);
			Thread.sleep(6000);
		} catch (Exception e) {
			driver.close();
			driver.switchTo().window(currentTab_trending);
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
