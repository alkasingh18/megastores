package megastores;

import static org.testng.Assert.assertEquals;

import java.util.List;
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




public class Address {
	public String baseurl = "http://54.147.24.85/megastores/";
	public String driverpath = "C:\\Users\\Admin\\Documents\\Alka\\chromedriver.exe";
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
	public void goto_address() {
		String result = "";
		String exception = null;
		
		try {
			assertEquals(baseurl, driver.getCurrentUrl());
			driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/div/a[1]")).click();
			Reporter.log("Login clicked");
			Thread.sleep(5000);
			driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
			Reporter.log("Username added");
			Thread.sleep(5000);
			driver.findElement(By.name("password")).sendKeys(data.password_valid());
			Reporter.log("Password added");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
			Reporter.log("Submit clicked");
			Thread.sleep(3000);
			if(driver.getPageSource().contains(data.session_expiry())) {
				driver.findElement(By.id("username_or_mobile")).sendKeys(data.username_valid());
				Reporter.log("Username added");
				Thread.sleep(5000);
				driver.findElement(By.name("password")).sendKeys(data.password_valid());
				Reporter.log("Password added");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"login-form\"]/button")).click();
				Reporter.log("Submit clicked");
				Thread.sleep(3000);
				
				//To check that the Login is successfull after session expiry
				if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()) {
					Reporter.log("Login successfull after session expiry");
					Thread.sleep(5000);
					 
				}
				else {
					Reporter.log("Test failed: Login Not successfull after session expiry");
					Thread.sleep(5000);
					 
					org.testng.Assert.fail();
				}
			} else if(driver.findElement(By.xpath("//*[@id=\"b-header\"]/div[1]/div/div/div[3]/div/div[1]/ul/li/a")).isDisplayed()){
				Reporter.log("Login successfull");
				Thread.sleep(5000);
			}
			else {
				Reporter.log("Test failed : Login not successfull.");
				Thread.sleep(5000);
				org.testng.Assert.fail();
			}
			
			driver.findElement(By.xpath("//*[@id=\"b-menu_top_bar\"]/li[1]/a")).click();
			Reporter.log("My Account Clicked successfully");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
			Reporter.log("Address clicked successfully");
			Thread.sleep(3000);
		} catch (Exception e) {
			exception=e.getMessage();
			org.testng.Assert.fail();
		}
  }
	
	@Test(priority = 2, retryAnalyzer = Retry_Analyzer.class)
	public void empty_address() {
		String result = "";
		String exception = null;
		try {
			WebElement address = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address.isDisplayed() && address.getText().equals("Addresses")) {
				driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[1]/div/button")).click();
				Reporter.log("Address Tab clicked successfully");
				Thread.sleep(3000);
				 
			}
			else {
				Reporter.log("Test failed: Address Tab not found");
				 
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[1]/h4")).getText().equals("Add Address")) {
				WebElement Address_Title = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[1]/div/input"));
				WebElement Name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[2]/div/input"));
				WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[3]/div/input"));
				WebElement Flat_no = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[4]/div/input"));
				WebElement Bldg_name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[5]/div/input"));
				WebElement Locality = driver.findElement(By.id("add_locality"));
				WebElement Pincode = driver.findElement(By.id("add_pincode"));
				WebElement City = driver.findElement(By.id("add_city"));
				WebElement State = driver.findElement(By.id("add_state"));
				WebElement Country  = driver.findElement(By.id("add_country"));
				
				Address_Title.sendKeys(data.empty());
				Thread.sleep(3000);
				Name.sendKeys(data.empty());
				Thread.sleep(3000);
				Mobile.sendKeys(data.empty());
				Thread.sleep(3000);
				Flat_no.sendKeys(data.empty());
				Thread.sleep(3000);
				Bldg_name.sendKeys(data.empty());
				Thread.sleep(3000);
				Locality.sendKeys(data.empty());
				Thread.sleep(3000);
				Pincode.sendKeys(data.empty());
				Thread.sleep(3000);
				City.sendKeys(data.empty());
				Thread.sleep(3000);
				State.sendKeys(data.empty());
				Thread.sleep(3000);
				Country.sendKeys(data.empty());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				List<WebElement> add = driver.findElements(By.className("tooltipster-base"));
				if(driver.findElement(By.className("tooltipster-base")).isDisplayed() && driver.findElement(By.className("tooltipster-base")).getText().equals(data.field_required())) {
					int tooltip_count = add.size();
					int ten = 10;
					
					if(tooltip_count != ten) {
						Reporter.log("Test failed: Tooltip count not matching the expected count");
						 
						org.testng.Assert.fail();
					}
					else {
						System.out.println(tooltip_count + " equals " + ten);	
						Reporter.log("Test Passed: Giving error message(Field required) on all fields.");
						Thread.sleep(3000);
						 
					}
				}
				else {
						Reporter.log("Test failed: Tooltip not displayed");
						 
						org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: Add address button not found");
				 
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			 
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 3, retryAnalyzer = Retry_Analyzer.class)
	public void existing_address_title() {
		String result = "";
		String exception = null;
		try {
			WebElement Add_Address = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address-add-form\"]/div[1]/h4")));
			if(Add_Address.isDisplayed() && Add_Address.getText().equals("Add Address")) {
				WebElement Address_Title = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[1]/div/input"));
				WebElement Name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[2]/div/input"));
				WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[3]/div/input"));
				WebElement Flat_no = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[4]/div/input"));
				WebElement Bldg_name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[5]/div/input"));
				WebElement Locality = driver.findElement(By.id("add_locality"));
				WebElement Pincode = driver.findElement(By.id("add_pincode"));
				WebElement City = driver.findElement(By.id("add_city"));
				WebElement State = driver.findElement(By.id("add_state"));
				WebElement Country  = driver.findElement(By.id("add_country"));
				
				Address_Title.sendKeys(data.exist_title());
				Thread.sleep(3000);
				Name.sendKeys(data.name());
				Thread.sleep(3000);
				Mobile.sendKeys(data.mobile_no());
				Thread.sleep(3000);
				Flat_no.sendKeys(data.flat_no());
				Thread.sleep(3000);
				Bldg_name.sendKeys(data.building());
				Thread.sleep(3000);
				Locality.sendKeys(data.locality());
				Thread.sleep(3000);
				Locality.sendKeys(Keys.ARROW_DOWN);
				Locality.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				//To check Pincode field is empty or not
				if(Pincode.getAttribute("value").isEmpty()) {
					Pincode.sendKeys(data.pincode());
					Thread.sleep(3000);	
				}
				else if(Pincode.getAttribute("value").isEmpty() != true) {
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Pincode not found");
					 
					org.testng.Assert.fail();
				}
				
				//To check City field is empty or not
				if(City.getAttribute("value").isEmpty()) {
					City.sendKeys(data.city());
					Thread.sleep(3000);
				}
				else if(City.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: City not found");
					 
					org.testng.Assert.fail();
				}
				
				//To check State field is empty or not
				if(State.getAttribute("value").isEmpty()) {
					State.sendKeys(data.state());
					Thread.sleep(3000);
				}
				else if(State.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: State not found");
					 
					org.testng.Assert.fail();
				}
				
				//To check Country field is empty or not
				if(Country.getAttribute("value").isEmpty()) {
					Country.sendKeys(data.country());
					Thread.sleep(3000);
				}
				else if(Country.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Country not found");
					 
					org.testng.Assert.fail();
				}
				
				
				driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				if (driver.getPageSource().contains("You already have address with title " + data.exist_title())){
					Reporter.log("Test Passed: Not able to save address if the title already exist");
					Thread.sleep(6000);
					 
					
				}
				else {
					Reporter.log("Test failed: Not getting proper message if the user saving address with existing title");
					 
					org.testng.Assert.fail();
				}
			}
		else {
			Reporter.log("Test failed: Add Address form not getting displayed.");
			 
			org.testng.Assert.fail();		
			}
		} catch (Exception e) {
			exception=e.getMessage();
			 
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 4, retryAnalyzer = Retry_Analyzer.class)
	public void valid_add_address() {
		String result = "";
		String exception = null;
		try {
			WebElement address1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address1.isDisplayed() && address1.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[1]/div/button")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				 
				
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[1]/h4")).getText().equals("Add Address")) {
				WebElement Address_Title = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[1]/div/input"));
				WebElement Name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[2]/div/input"));
				WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[3]/div/input"));
				WebElement Flat_no = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[4]/div/input"));
				WebElement Bldg_name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[5]/div/input"));
				WebElement Locality = driver.findElement(By.id("add_locality"));
				WebElement Pincode = driver.findElement(By.id("add_pincode"));
				WebElement City = driver.findElement(By.id("add_city"));
				WebElement State = driver.findElement(By.id("add_state"));
				WebElement Country  = driver.findElement(By.id("add_country"));
				
				Address_Title.sendKeys(data.valid_title());
				Thread.sleep(3000);
				Name.sendKeys(data.name());
				Thread.sleep(3000);
				Mobile.sendKeys(data.mobile_no());
				Thread.sleep(3000);
				Flat_no.sendKeys(data.flat_no());
				Thread.sleep(3000);
				Bldg_name.sendKeys(data.building());
				Thread.sleep(3000);
				Locality.sendKeys(data.locality());
				Thread.sleep(3000);
				Locality.sendKeys(Keys.ARROW_DOWN);
				Locality.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				//To check Pincode field is empty or not
				if(Pincode.getAttribute("value").isEmpty()) {
					Pincode.sendKeys(data.pincode());
					Thread.sleep(3000);	
				}
				else if(Pincode.getAttribute("value").isEmpty() != true) {
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Pincode not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check City field is empty or not
				if(City.getAttribute("value").isEmpty()) {
					City.sendKeys(data.city());
					Thread.sleep(3000);
				}
				else if(City.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: City not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check State field is empty or not
				if(State.getAttribute("value").isEmpty()) {
					State.sendKeys(data.state());
					Thread.sleep(3000);
				}
				else if(State.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: State not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check Country field is empty or not
				if(Country.getAttribute("value").isEmpty()) {
					Country.sendKeys(data.country());
					Thread.sleep(3000);
				}
				else if(Country.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Country not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
			
				if(driver.getPageSource().contains(data.address_added_message())) {
					Reporter.log("Test Passed: Address added successfully with all the valid details");
					Thread.sleep(3000);
					 
					
				}
				else {
					Reporter.log("Test failed: Not getting expected message for address added successfully");
					 
					
					try {
                        WebElement address_wodefault = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
                        if(address_wodefault.isDisplayed() && address_wodefault.getText().equals("Addresses")) {
                            driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
                            Reporter.log("Address clicked successfully");
                            Thread.sleep(3000);
                        }
                        else {
                            Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
                            org.testng.Assert.fail();
                        }
                        
                        //After failed deleting the added address
                        List<WebElement> card_element = driver.findElements(By.cssSelector(".card-header"));
                        int count = card_element.size();
                        System.out.println(count);
                        for(int i=0; i<count; i++) {
                            System.out.println(card_element.get(i).getText());
                            if(card_element.get(i).getText().contains(data.valid_title())) {
                                WebElement Action = card_element.get(i).findElement(By.id("dropdownMenuLink"));
                                Action.sendKeys(Keys.ENTER);
                                Thread.sleep(3000);
                                WebElement Delete = card_element.get(i).findElement(By.linkText("Delete"));
                                Delete.click();
                                Thread.sleep(3000);
                                String id = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
                                if(driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[1]/h4")).getText().equals("Delete Address")) {
                                    driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[3]/form/button[2]")).sendKeys(Keys.ENTER);
                                }
                                else {
                                    Reporter.log("Test failed: Not getting text 'Delete Address' on delete button");
                                    org.testng.Assert.fail();
                                }
                                break;
                            }
                            else {
                                Reporter.log("Added Address Not found at position " + i);
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        org.testng.Assert.fail();
                    }
				}
			}
			else {
				Reporter.log("Add Address form not displayed");
				 
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 5, retryAnalyzer = Retry_Analyzer.class)
	public void valid_add_address_default() {
		String result = "";
		String exception = null;
		try {
			WebElement address1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address1.isDisplayed() && address1.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[1]/div/button")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				 
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				 
				
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[1]/h4")).getText().equals("Add Address")) {
				WebElement Address_Title = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[1]/div/input"));
				WebElement Name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[2]/div/input"));
				WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[3]/div/input"));
				WebElement Flat_no = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[4]/div/input"));
				WebElement Bldg_name = driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[1]/div[5]/div/input"));
				WebElement Locality = driver.findElement(By.id("add_locality"));
				WebElement Pincode = driver.findElement(By.id("add_pincode"));
				WebElement City = driver.findElement(By.id("add_city"));
				WebElement State = driver.findElement(By.id("add_state"));
				WebElement Country  = driver.findElement(By.id("add_country"));
				
				Address_Title.sendKeys(data.valid_title_default());
				Thread.sleep(3000);
				Name.sendKeys(data.name());
				Thread.sleep(3000);
				Mobile.sendKeys(data.mobile_no());
				Thread.sleep(3000);
				Flat_no.sendKeys(data.flat_no());
				Thread.sleep(3000);
				Bldg_name.sendKeys(data.building());
				Thread.sleep(3000);
				Locality.sendKeys(data.locality());
				Thread.sleep(3000);
				Locality.sendKeys(Keys.ARROW_DOWN);
				Locality.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				//To check Pincode field is empty or not
				if(Pincode.getAttribute("value").isEmpty()) {
					Pincode.sendKeys(data.pincode());
					Thread.sleep(3000);	
				}
				else if(Pincode.getAttribute("value").isEmpty() != true) {
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Pincode not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check City field is empty or not
				if(City.getAttribute("value").isEmpty()) {
					City.sendKeys(data.city());
					Thread.sleep(3000);
				}
				else if(City.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: City not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check State field is empty or not
				if(State.getAttribute("value").isEmpty()) {
					State.sendKeys(data.state());
					Thread.sleep(3000);
				}
				else if(State.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: State not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				//To check Country field is empty or not
				if(Country.getAttribute("value").isEmpty()) {
					Country.sendKeys(data.country());
					Thread.sleep(3000);
				}
				else if(Country.getAttribute("value").isEmpty() != true){
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: Country not getting displayed");
					 
					
					org.testng.Assert.fail();
				}
				
				driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[2]/div/div[2]/div[6]/div/label[1]")).click();
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id=\"address-add-form\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
			
				if(driver.getPageSource().contains(data.address_added_message())) {
					Reporter.log("Test Passed: Address added successfully with default and with all the valid details");
					Thread.sleep(3000);
					 
					
				}
				else {
					Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
					 
					
					try {
                        WebElement address_default = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
                        if(address_default.isDisplayed() && address_default.getText().equals("Addresses")) {
                            driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
                            Reporter.log("Address clicked successfully");
                            Thread.sleep(3000);
                        }
                        else {
                            Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
                            org.testng.Assert.fail();
                        }
                        
                        //After failed deleting the added address
                        List<WebElement> card_element = driver.findElements(By.cssSelector(".card-header"));
                        int count = card_element.size();
                        System.out.println(count);
                        for(int i=0; i<count; i++) {
                            System.out.println(card_element.get(i).getText());
                            if(card_element.get(i).getText().contains(data.valid_title_default())) {
                                WebElement Action = card_element.get(i).findElement(By.id("dropdownMenuLink"));
                                Action.sendKeys(Keys.ENTER);
                                Thread.sleep(3000);
                                WebElement Delete = card_element.get(i).findElement(By.linkText("Delete"));
                                Delete.click();
                                Thread.sleep(3000);
                                String id = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
                                if(driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[1]/h4")).getText().equals("Delete Address")) {
                                    driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[3]/form/button[2]")).sendKeys(Keys.ENTER);
                                }
                                else {
                                    Reporter.log("Test failed: Not getting text 'Delete Address' on delete button");
                                    org.testng.Assert.fail();
                                }
                                break;
                            }
                            else {
                                Reporter.log("Added Address Not found at position " + i);
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    finally {
                        org.testng.Assert.fail();
                    }
				}
			}
			else {
				Reporter.log("Add Address form not displayed");
				 
				
				org.testng.Assert.fail();	
			}	
			
		} catch (Exception e) {
			exception=e.getMessage();
			 
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 6, retryAnalyzer = Retry_Analyzer.class)
	public void edit_details()  {
		String result = "";
		String exception = null;
		try {
			WebElement address2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address2.isDisplayed() && address2.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				 
				
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
				Reporter.log("Action button not getting displayed");
				 
				
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
//					edit_Locality.clear();
//					edit_Locality.sendKeys(data.locality());
//					Thread.sleep(3000);
//					edit_Locality.sendKeys(Keys.ARROW_DOWN);
//					edit_Locality.sendKeys(Keys.ENTER);
//					Thread.sleep(3000);
//					
//					//To check Pincode field is empty or not
//					if(edit_Pincode.getAttribute("value").isEmpty()) {
//						edit_Pincode.sendKeys(data.pincode());
//						Thread.sleep(3000);	
//					}
//					else if(edit_Pincode.getAttribute("value").isEmpty() != true) {
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					//To check City field is empty or not
//					if(edit_City.getAttribute("value").isEmpty()) {
//						edit_City.sendKeys(data.city());
//						Thread.sleep(3000);
//					}
//					else if(edit_City.getAttribute("value").isEmpty() != true){
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					//To check State field is empty or not
//					if(edit_State.getAttribute("value").isEmpty()) {
//						edit_State.sendKeys(data.state());
//						Thread.sleep(3000);
//					}
//					else if(edit_State.getAttribute("value").isEmpty() != true){
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
//					//To check that the country field is empty or not
//					if(edit_Country.getAttribute("value").isEmpty()) {
//						edit_Country.sendKeys(data.country());
//						Thread.sleep(3000);
//					}
//					else if(edit_Country.getAttribute("value").isEmpty() != true){
//						Thread.sleep(3000);
//					}
//					else {
//						org.testng.Assert.fail();
//					}
//					
					driver.findElement(By.xpath("//*[@id=\""+edit+"\"]/div[3]/button[2]")).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: The form does not consist of test 'Edit Address'");
					 
					
					org.testng.Assert.fail();
				}
				
				if(driver.getPageSource().contains("Address updated successfully.")) {
					Reporter.log("Test Passed: Address getting updated successfully.");
					Thread.sleep(3000);
					 
					
				}
				else if(driver.getPageSource().contains("You already have address with title " + data.exist_title() + ".")) {
					Reporter.log("Does not allow to update address with existing titles.");
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: No message displayed after edit");
					 
					
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: CssSelector '.modal.fade.modal-address-update.show' not getting displayed");
				 
				
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			 
			
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 7, retryAnalyzer = Retry_Analyzer.class)
	public void delete_address() {
		String result = "";
		String exception = null;
		try {
			WebElement address1 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address1.isDisplayed() && address1.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				 
				 
				org.testng.Assert.fail();
			}
			
			if(driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//*[@id=\"dropdownMenuLink\"]")).click();
				Reporter.log("Action clicked sucessfully");
				Thread.sleep(3000);
				
				WebElement webElement = driver.findElement(By.xpath("//*[@id=\"addresses-tab\"]/div[1]/div/div[2]/h5/div/div/a[2]"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", webElement);
				Thread.sleep(3000);					
				Reporter.log("Delete clicked successfully");
				 
				
			}
			else {
				Reporter.log("Action button not getting displayed");
				 
				 
				org.testng.Assert.fail();
			}
				
			if(driver.findElement(By.cssSelector(".modal.fade.show")).isDisplayed()) {
				String delete = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//*[@id=\""+delete+"\"]/div/div/div[2]/p")).getText().equals("You want to delete address?")) {
					driver.findElement(By.xpath("//*[@id=\""+delete+"\"]/div/div/div[3]/form/button[2]")).click();
					Thread.sleep(3000);
				}
				else {
					Reporter.log("Test failed: On clicking delete expected message not getting displayed.");
					 
					 
					org.testng.Assert.fail();
				}
			}
			else {
				Reporter.log("Test failed: CssSelector '.modal.fade.show' not getting displayed");
				 
				 
				org.testng.Assert.fail();
			}
			
			if(driver.getPageSource().contains("Unable to delete. Order in progress.")) {
				Reporter.log("Order already in progress hence cannot be deleted");
				Thread.sleep(3000);
				 
				
			}
			else if(driver.getPageSource().contains("Address removed.")) {
				Reporter.log("Address deleted successfully.");
				Thread.sleep(3000);
				 
				
			}
			else {
				Reporter.log("Test failed: Not getting expected message while deleting Address");
				 
				 
				org.testng.Assert.fail();
			}
		} catch (Exception e) {
			exception=e.getMessage();
			 
			 
			org.testng.Assert.fail();
		}
	}
	
	//==================================Cleaning the added addresses==========================================
	
	@Test(priority = 8, retryAnalyzer = Retry_Analyzer.class)
	public void delete_added_address_no_default() {
		try {
			WebElement address2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address2.isDisplayed() && address2.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				org.testng.Assert.fail();
			}
			
			List<WebElement> card_element = driver.findElements(By.cssSelector(".card-header"));
			int count = card_element.size();
			System.out.println(count);
			for(int i=0; i<count; i++) {
				System.out.println(card_element.get(i).getText());
				if(card_element.get(i).getText().contains(data.valid_title())) {
					WebElement Action = card_element.get(i).findElement(By.id("dropdownMenuLink"));
					Action.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					WebElement Delete = card_element.get(i).findElement(By.linkText("Delete"));
					Delete.click();
					Thread.sleep(3000);
					String id = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
					if(driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[1]/h4")).getText().equals("Delete Address")) {
						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[3]/form/button[2]")).sendKeys(Keys.ENTER);
					}
					else {
						Reporter.log("Test failed: Not getting text 'Delete Address' on delete button");
						org.testng.Assert.fail();
					}
					
					if(driver.getPageSource().contains("Unable to delete. Order in progress.")) {
						Reporter.log("Order already in progress hence cannot be deleted");
						Thread.sleep(3000);
					}
					else if(driver.getPageSource().contains("Address removed.")) {
						Reporter.log("Address deleted successfully.");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Not getting expected message on deleting Address");
						org.testng.Assert.fail();
					}
					break;
				}
				else {
					Reporter.log("Added Address Not found at position " + i);
				}
			}
				
		} catch (Exception e) {
			org.testng.Assert.fail();
		}
	}
	
	@Test(priority = 9, retryAnalyzer = Retry_Analyzer.class)
	public void delete_added_address_default() {
		try {
			WebElement address2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")));
			if(address2.isDisplayed() && address2.getText().equals("Addresses")) {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[1]/ul/li[2]/a")).click();
				Reporter.log("Address clicked successfully");
				Thread.sleep(3000);
			}
			else {
				Reporter.log("Test failed: Address Tab not getting displayed or the Tab does not consist of title Addresses");
				org.testng.Assert.fail();
			}
			
			List<WebElement> card_element = driver.findElements(By.cssSelector(".card-header"));
			int count = card_element.size();
			System.out.println(count);
			for(int i=0; i<count; i++) {
				System.out.println(card_element.get(i).getText());
				if(card_element.get(i).getText().contains(data.valid_title_default())) {
					WebElement Action = card_element.get(i).findElement(By.id("dropdownMenuLink"));
					Action.sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					WebElement Delete = card_element.get(i).findElement(By.linkText("Delete"));
					Delete.click();
					Thread.sleep(3000);
					String id = driver.findElement(By.cssSelector(".modal.fade.show")).getAttribute("id");
					if(driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[1]/h4")).getText().equals("Delete Address")) {
						driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div/div/div[3]/form/button[2]")).sendKeys(Keys.ENTER);
					}
					else {
						Reporter.log("Test failed: Not getting text 'Delete Address' on delete button");
						org.testng.Assert.fail();
					}
					
					if(driver.getPageSource().contains("Unable to delete. Order in progress.")) {
						Reporter.log("Order already in progress hence cannot be deleted");
						Thread.sleep(3000);
					}
					else if(driver.getPageSource().contains("Address removed.")) {
						Reporter.log("Address deleted successfully.");
						Thread.sleep(3000);
					}
					else {
						Reporter.log("Not getting expected message on deleting Address");
						org.testng.Assert.fail();
					}
					break;
				}
				else {
					Reporter.log("Added Address Not found at position " + i + ", it might already be deleted.");
				}
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
