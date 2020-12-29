package megastores;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import org.testng.Reporter;


public class MerchantRegistration {

	public String baseurl = "http://54.147.24.85/merchant/";
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
	


	
	  @Test(priority = 1)
	  public void openUrl() throws InterruptedException {
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
		  
		  WebElement signup = driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[2]/p[2]/a"));
		  if(signup.isDisplayed()) {
			  signup.click();
			  Thread.sleep(3000);
			  
			  notes = "Merchant registration page launched !!";
		  }
		  else {
			  Reporter.log("Merchant registration page not launched ");
				
				org.testng.Assert.fail();
		  }
	  }	
	  
  
  
  @Test(priority = 2)
  public void EmptyFields() {
	  String result="";
	  String notes = null;
	  String exception=null;
	  try {
		  if(driver.findElement(By.id("legend")).getText().contains("Merchant Registration Form"))
		  {
			  driver.findElement(By.id("userName")).sendKeys(oData.emptyUsername());
			  Thread.sleep(2000);
			  driver.findElement(By.id("firstName")).sendKeys(oData.emptyFirstname());
			  Thread.sleep(2000);
			  driver.findElement(By.id("lastName")).sendKeys(oData.emptyLastname());
			  Thread.sleep(2000);
			  driver.findElement(By.id("shopName")).sendKeys(oData.emptyShopname());
			  Thread.sleep(2000);
			  driver.findElement(By.id("password")).sendKeys(oData.emptyPassword());
			  Thread.sleep(2000);
			  driver.findElement(By.id("rePassword")).sendKeys(oData.emptyRePassword());
			  Thread.sleep(2000);
			  driver.findElement(By.id("email")).sendKeys(oData.emptyEmail());
			  Thread.sleep(2000);
			  List<WebElement> ddcountryCode = driver.findElements(By.id("select2-country-dropdown-container"));
			  ddcountryCode.get(0).isSelected();
			  Thread.sleep(2000);
			  driver.findElement(By.id("phone")).sendKeys(oData.emptyMobile());
			  Thread.sleep(2000);
			  List<WebElement> ddlCollection =  driver.findElements(By.id("select2-collection-dropdown-container"));
			  ddlCollection.get(0).isSelected();
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div/div[12]/div/span/span[1]/span/ul/li/input")).sendKeys("");
			  Thread.sleep(2000);
			  driver.findElement(By.id("pincode")).sendKeys(oData.emptyPincode());
			  Thread.sleep(2000);
			  driver.findElement(By.className("btn")).click();
			  if(!driver.findElement(By.id("tc")).isSelected())
			  {
				  System.out.println("Please accept terms & conditions not checked !!");
			  }
			  
			  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.FieldRequired())) 
			  {
				  Reporter.log("Test passed for empty fields : " + oData.FieldRequired());
					System.out.println("Test passed for empty fields : " + oData.FieldRequired());
					Thread.sleep(3000);
					
					notes = "Test passed for empty fields";
					
			  } 
			  else 
			  {
				  Reporter.log("Test failed for empty fields");
					org.testng.Assert.fail();
			  }
			  
		  }
		  else
		  {
			  Reporter.log("Test failed for empty fieldse");
				
				
				org.testng.Assert.fail();
		  }
		
	} catch (Exception e) {
		Reporter.log("Test failed for empty fields");
		
		
		org.testng.Assert.fail();
	}
	  
  }
  
  @Test(priority = 3)
public void inValidUsernameLength()  {
	  String result = "";
	  String exception = null;
	  String notes = null;
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
		  {
			  driver.findElement(By.id("userName")).sendKeys(oData.invalidusernameLength());
			  Thread.sleep(2000);
			  
			  driver.findElement(By.id("firstName")).sendKeys(Keys.SHIFT);
			  String userNameText = driver.findElement(By.id("userName")).getAttribute("value");
			  if (userNameText.length() < 5) 
			  {
				  
				  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidusernameLengthMessage())) 
				  {
					  Reporter.log("Test passed for invalid username length : " + oData.invalidusernameLengthMessage());
						System.out.println("Test passed for invalid username length : " + oData.invalidusernameLengthMessage());
						Thread.sleep(3000);
						
						notes = "Test passed for invalid username length";
						
				  } 
				  else 
				  {
					  Reporter.log("Test failed for invalid username length");
						
						
						org.testng.Assert.fail();
				  }
			  } 
			  
		    else 
			{
		    	Reporter.log("Test failed for invalid username length");
				
				
				org.testng.Assert.fail();
			}
			  
			  			  
	  }
	  else
	  {
		  Reporter.log("Test failed for invalid username length");
			
			
			org.testng.Assert.fail();
	  }
		
	} catch (Exception e) {
		Reporter.log("Test failed for invalid username length");
		
		
		org.testng.Assert.fail();
	}
	
}
  
  
  @Test(priority = 4)
public void inValidNumericUsername()  {
	  String result = "";
	  String exception = null;
	  String notes = null;
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
		  {
			  driver.findElement(By.id("userName")).clear();
			  driver.findElement(By.id("userName")).sendKeys(oData.invalidNumericUsername());
			  String userNameText = driver.findElement(By.id("userName")).getAttribute("value");

			  driver.findElement(By.id("firstName")).sendKeys(Keys.SHIFT);

			  if (userNameText.length() > 5 && userNameText.contains(oData.invalidNumericUsername())) 
			  {

			  	  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidNumericUsernameMessage())) 
			  	  {
			  		Reporter.log("Test passed for invalid numeric username : " + oData.invalidNumericUsernameMessage());
					System.out.println("Test passed for invalid numeric username : " + oData.invalidNumericUsernameMessage());
					
					notes = "Test passed for invalid numeric username";
					
					Thread.sleep(3000);
			  	  } 
			  	  else 
			  	  {
			  		Reporter.log("Test failed for invalid numeric username");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
			  	  }
			  } 
			  else 
			  {
				  Reporter.log("Test failed for invalid numeric username");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
			  }			  
			  			  
	  }
	  else
	  {
		  Reporter.log("Test failed for invalid numeric username");
			
			
			org.testng.Assert.fail();org.testng.Assert.fail();
	  }
		
	} catch (Exception e) {
		Reporter.log("Test failed for invalid numeric username");
		
		
		org.testng.Assert.fail();org.testng.Assert.fail();
	}
	
}
  

  
  @Test(priority = 5)
public void inValidNumericShopName()  {
	  String result = "";
	  String exception = null;
	  String notes = null;
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
		  {
			  driver.findElement(By.id("userName")).clear();
			  driver.findElement(By.id("firstName")).clear();
			  driver.findElement(By.id("lastName")).clear();
			  driver.findElement(By.id("shopName")).clear();
			  
			  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
			  Thread.sleep(2000);
			  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
			  Thread.sleep(2000);
			  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
			  Thread.sleep(2000);
			  driver.findElement(By.id("shopName")).sendKeys(oData.invalidNumericUsername());
			  Thread.sleep(2000);

			  driver.findElement(By.id("password")).sendKeys(Keys.SHIFT);

			  	  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidNumericUsernameMessage())) 
			  	  {
			  		Reporter.log("Test passed for invalid numeric shop name : " + oData.invalidNumericUsernameMessage());
					System.out.println("Test passed for invalid numeric shop name : " + oData.invalidNumericUsernameMessage());
					
					notes = "Test passed for invalid email";
					
					Thread.sleep(3000);
			  	  } 
			  	  else 
			  	  {
			  		Reporter.log("Test failed for invalid numeric shop name");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
			  	  }
		  }
		  else
		  {
			  Reporter.log("Test failed for invalid numeric shop name");
				
				
				org.testng.Assert.fail();org.testng.Assert.fail();
		  }
		
	} catch (Exception e) {
		Reporter.log("Test failed for invalid numeric shop name");
		
		
		org.testng.Assert.fail();org.testng.Assert.fail();
	}
	
}
  
  
  @Test(priority = 6)
public void inValidPasswordlength() {
	  String result = "";
	  String exception = null;
	  String notes = null;
	  try {
		  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
		  {
			  driver.findElement(By.id("userName")).clear();
			  driver.findElement(By.id("firstName")).clear();
			  driver.findElement(By.id("lastName")).clear();
			  driver.findElement(By.id("shopName")).clear();
			  driver.findElement(By.id("password")).clear();
			  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
			  Thread.sleep(2000);
			  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
			  Thread.sleep(2000);
			  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
			  Thread.sleep(2000);
			  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
			  Thread.sleep(2000);
			  driver.findElement(By.id("password")).sendKeys(oData.invalidPasswordLength());
			  Thread.sleep(2000);
			  String passwordText = driver.findElement(By.id("password")).getAttribute("value");

			  driver.findElement(By.id("rePassword")).sendKeys(Keys.SHIFT);

			  if (passwordText.length() < 6) 
			  {

			  	  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidPasswordLengthMessage())) 
			  	  {
			  		Reporter.log("Test passed for invalid Password length : " + oData.invalidPasswordLengthMessage());
					System.out.println("Test passed for invalid Password length : " + oData.invalidPasswordLengthMessage());
					
					notes = "Test passed for invalid email";
					
					Thread.sleep(3000);
			  	  } 
			  	  else 
			  	  {
			  		Reporter.log("Test failed for invalid Password length");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
			  	  }
			  } 
			  else 
			  {
				  Reporter.log("Test failed for invalid Password length");
					
					
					org.testng.Assert.fail();org.testng.Assert.fail();
			  }			  
			  			  
	  }
	  else
	  {
		  Reporter.log("Test failed for invalid Password length");
			
			
			org.testng.Assert.fail();org.testng.Assert.fail();
	  }
		
	} catch (Exception e) {
		Reporter.log("Test failed for invalid Password length");
		
		
		org.testng.Assert.fail();org.testng.Assert.fail();
	}
  }
	  
	  
	  @Test(priority = 7)
	public void inValidPasswordCombination() {
		  String result = "";
		  String exception = null;
		  String notes = null;
		  try {
			  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
			  {
				  driver.findElement(By.id("userName")).clear();
				  driver.findElement(By.id("firstName")).clear();
				  driver.findElement(By.id("lastName")).clear();
				  driver.findElement(By.id("shopName")).clear();
				  driver.findElement(By.id("password")).clear();
				  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
				  Thread.sleep(2000);
				  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
				  Thread.sleep(2000);
				  driver.findElement(By.id("password")).sendKeys(oData.invalidPasswordCombination());
				  Thread.sleep(2000);
				  String passwordText = driver.findElement(By.id("password")).getAttribute("value");

				  driver.findElement(By.id("rePassword")).sendKeys(Keys.SHIFT);

				  if (passwordText.length() > 6 && passwordText.contains(oData.invalidPasswordCombination())) 
				  {

				  	  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidPasswordCombinationMessage())) 
				  	  {

					  		Reporter.log("Test passed for invalid Password Combination : " + oData.invalidPasswordCombinationMessage());
							System.out.println("Test passed for invalid Password Combination : " + oData.invalidPasswordCombinationMessage());
							
							notes = "Test passed for invalid Password Combination";
							
							Thread.sleep(3000);
					} 
				  	  else 
				  	  {
				  		Reporter.log("Test failed for invalid Password Combination");
						
						
						org.testng.Assert.fail();
				  	  }
				  } 
				  else 
				  {
					  Reporter.log("Test failed for invalid Password Combination");
						
						
						org.testng.Assert.fail();
				  }			  
				  			  
		  }
		  else
		  {
			  Reporter.log("Test failed for invalid Password Combination");
				
				
				org.testng.Assert.fail();
		  }
			
		} catch (Exception e) {
			Reporter.log("Test failed for invalid Password Combination");
			
			
			org.testng.Assert.fail();
		}
	
}
	  
	  @Test(priority = 8)
		public void retypePasswordNoMatch() 
	  {
		  String result = "";
		  String exception = null;
		  String notes = null;
			 try {
				  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
				  {
					  driver.findElement(By.id("userName")).clear();
					  driver.findElement(By.id("firstName")).clear();
					  driver.findElement(By.id("lastName")).clear();
					  driver.findElement(By.id("shopName")).clear();
					  driver.findElement(By.id("password")).clear();
					  driver.findElement(By.id("rePassword")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
					  Thread.sleep(2000);
					  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("password")).sendKeys(oData.validPassword());
					  Thread.sleep(2000);
					  driver.findElement(By.id("rePassword")).sendKeys(oData.retypePasswordNoMatch());
					  Thread.sleep(2000);
					  String passwordText = driver.findElement(By.id("rePassword")).getAttribute("value");

					  driver.findElement(By.id("email")).sendKeys(Keys.SHIFT);

					  if (passwordText.length() > 6 && passwordText.contains(oData.retypePasswordNoMatch())) 
					  {

					  	  if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.retypePasswordNoMatchMessage())) 
					  	  {

						  		Reporter.log("Test passed for Retype password didn't match : " + oData.retypePasswordNoMatchMessage());
								System.out.println("Test passed for Retype password didn't match : " + oData.retypePasswordNoMatchMessage());
								
								notes = "Test passed for Retype password didn't match";
								
								Thread.sleep(3000);
					  	  } 
					  	  else 
					  	  {
					  		Reporter.log("Test passed for Retype password didn't match");
							
							
							org.testng.Assert.fail();
					  	  }
					  } 
					  else 
					  {
						  Reporter.log("Test passed for Retype password didn't match");
							
							
							org.testng.Assert.fail();
					  }			  
					  			  
			  }
			  else
			  {
				  Reporter.log("Test passed for Retype password didn't match");
					
					
					org.testng.Assert.fail();
			  }
				
			} catch (Exception e) {
				Reporter.log("Test passed for Retype password didn't match");
				
				
				org.testng.Assert.fail();
			}
		
	}
  
	  @Test(priority = 9)
		public void invalidEmail() {
		  String result = "";
		  String exception = null;
		  String notes = null;
			  try {
				  
				  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
				  {
					  driver.findElement(By.id("userName")).clear();
					  driver.findElement(By.id("firstName")).clear();
					  driver.findElement(By.id("lastName")).clear();
					  driver.findElement(By.id("shopName")).clear();
					  driver.findElement(By.id("password")).clear();
					  driver.findElement(By.id("rePassword")).clear();
					  driver.findElement(By.id("email")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
					  Thread.sleep(2000);
					  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("password")).sendKeys(oData.validPassword());
					  Thread.sleep(2000);
					  driver.findElement(By.id("rePassword")).sendKeys(oData.validReTypePassword());
					  Thread.sleep(2000);
		  			  driver.findElement(By.id("email")).sendKeys(oData.invalidEmail());
		  			  Thread.sleep(2000);
		  			driver.findElement(By.id("email")).sendKeys(Keys.TAB);
		  			Thread.sleep(2000);
					  
					  	if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidEmailMsg())) 
					  	  {
					  			Reporter.log("Test passed for Invalid Email : " + oData.invalidEmailMsg());
								System.out.println("Test passed for Invalid Email : " + oData.invalidEmailMsg());
								
								notes = "Test passed for invalid data";
								
								Thread.sleep(3000);
					  	  } 
					  	  else 
					  	  {
					  		Reporter.log("Test failed for Invalid Email");
							
							
							org.testng.Assert.fail();
					  	  }
				  }
			  else
			  {
				  Reporter.log("Test failed for Invalid Email");
					
					
					org.testng.Assert.fail();
			  }
				
			} catch (Exception e) {
				Reporter.log("Test failed for Invalid Email");
				
				
				org.testng.Assert.fail();
			}
	  }
	  
	  @Test(priority = 10)
		public void invalidMobile() {
		  String result = "";
		  String exception = null;
		  String notes = null;
			  try {
				  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
				  {
					  driver.findElement(By.id("userName")).clear();
					  driver.findElement(By.id("firstName")).clear();
					  driver.findElement(By.id("lastName")).clear();
					  driver.findElement(By.id("shopName")).clear();
					  driver.findElement(By.id("password")).clear();
					  driver.findElement(By.id("rePassword")).clear();
					  driver.findElement(By.id("email")).clear();
					  driver.findElement(By.id("phone")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
					  Thread.sleep(2000);
					  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("password")).sendKeys(oData.validPassword());
					  Thread.sleep(2000);
					  driver.findElement(By.id("rePassword")).sendKeys(oData.validReTypePassword());
					  Thread.sleep(2000);
		  			  driver.findElement(By.id("email")).sendKeys(oData.validEmail());
		  			  Thread.sleep(2000);
		  			  WebElement dd = driver.findElement(By.id("country-dropdown"));
					  Select ele  = new Select(dd);
					  ele.selectByVisibleText("India ( +91 )");
					  driver.findElement(By.id("phone")).sendKeys(oData.invalidPhoneNoLength());
		  			  Thread.sleep(2000);
					  driver.findElement(By.id("phone")).sendKeys(Keys.TAB);
					  Thread.sleep(2000);
					  	if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidPhoneNoLengthMessage())) 
					  	  {

					  		Reporter.log("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
							System.out.println("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
							
							notes = "Test passed for Invalid Phone No.";
							
							Thread.sleep(3000);
					  	  } 
					  	  else 
					  	  {
					  		Reporter.log("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
							System.out.println("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
							
							notes = "Test passed for Invalid Phone No.";
							
							Thread.sleep(3000);
					  	  }
					 }
			  else
			  {
				  Reporter.log("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
					System.out.println("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
					
					notes = "Test passed for Invalid Phone No.";
					
					Thread.sleep(3000);
			  }
				
			} catch (Exception e) {
				Reporter.log("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
				System.out.println("Test passed for Invalid Phone No. : " + oData.invalidPhoneNoLengthMessage());
				
				notes = "Test passed for Invalid Phone No.";
				
			}
	  }
	  
	  
	  @Test(priority = 11)
		public void invalidPincode() {
		  String result = "";
		  String exception = null;
		  String notes = null;
			  try {
				  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
				  {
					  driver.findElement(By.id("userName")).clear();
					  driver.findElement(By.id("firstName")).clear();
					  driver.findElement(By.id("lastName")).clear();
					  driver.findElement(By.id("shopName")).clear();
					  driver.findElement(By.id("password")).clear();
					  driver.findElement(By.id("rePassword")).clear();
					  driver.findElement(By.id("email")).clear();
					  driver.findElement(By.id("phone")).clear();
					  driver.findElement(By.id("pincode")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
					  Thread.sleep(2000);
					  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
					  Thread.sleep(2000);
					  driver.findElement(By.id("password")).sendKeys(oData.validPassword());
					  Thread.sleep(2000);
					  driver.findElement(By.id("rePassword")).sendKeys(oData.validReTypePassword());
					  Thread.sleep(2000);
		  			  driver.findElement(By.id("email")).sendKeys(oData.validEmail());
		  			  Thread.sleep(2000);
		  			  WebElement dd = driver.findElement(By.id("country-dropdown"));
					  Select ele  = new Select(dd);
					  ele.selectByVisibleText("India ( +91 )");
		  			  driver.findElement(By.id("phone")).sendKeys(oData.validMobileNo());
		  			  Thread.sleep(2000);
		  			  WebElement ddlCollection = driver.findElement(By.id("collection-dropdown"));
					  Select ele1  = new Select(ddlCollection);
					  ele1.selectByVisibleText("Handicrafts & Fashion");
					  
					 Thread.sleep(2000);
					 WebElement ddlSegment = driver.findElement(By.id("segment-dropdown"));
					  Select ele2  = new Select(ddlSegment);
					  ele2.selectByVisibleText("Accessories");
					  Thread.sleep(2000);
					  driver.findElement(By.id("pincode")).sendKeys(oData.invalidPincode());
		  			  Thread.sleep(2000);
					  driver.findElement(By.id("pincode")).sendKeys(Keys.TAB);
		  			  Thread.sleep(2000);

					  	if (driver.findElement(By.className("tooltip-inner")).getText().contains(oData.invalidPincodeMessage())) 
					  	  {

						  		Reporter.log("Test passed for Invalid Pincode : " + (oData.invalidPincodeMessage()));
								System.out.println("Test passed for Invalid Pincode : " + (oData.invalidPincodeMessage()));
								
								notes = "Test passed for Invalid Pincode";
								
								Thread.sleep(3000);
					  	  } 
					  	  else 
					  	  {
					  		Reporter.log("Test failed for Invalid Pincode ");
							
							
							org.testng.Assert.fail();
					  	  }
				  }
			  else
			  {
				  Reporter.log("Test failed for Invalid Pincode ");
					
					
					org.testng.Assert.fail();
			  }
				
			} catch (Exception e) {
				Reporter.log("Test failed for Invalid Pincode ");
				
				
				org.testng.Assert.fail();
				System.out.println(e);
			}
	  }
	  
	  @Test(priority = 12)

		public void validData() {
		  String result = "";
		  String exception = null;
		  String notes = null;
			  try {
				  if(driver.findElement(By.xpath("//*[@id=\"legend\"]/legend/b")).getText().contains("Merchant Registration Form"))
				  {
					  driver.findElement(By.id("userName")).clear();
					  driver.findElement(By.id("firstName")).clear();
					  driver.findElement(By.id("lastName")).clear();
					  driver.findElement(By.id("shopName")).clear();
					  driver.findElement(By.id("password")).clear();
					  driver.findElement(By.id("rePassword")).clear();
					  driver.findElement(By.id("email")).clear();
					  driver.findElement(By.id("phone")).clear();
					  driver.findElement(By.id("pincode")).clear();
					  driver.findElement(By.id("userName")).sendKeys(oData.validUsername());
					  Thread.sleep(3000);
					  driver.findElement(By.id("firstName")).sendKeys(oData.validFirstName());
					  Thread.sleep(3000);
					  driver.findElement(By.id("lastName")).sendKeys(oData.validLastName());
					  Thread.sleep(3000);
					  driver.findElement(By.id("shopName")).sendKeys(oData.validShopName());
					  Thread.sleep(3000);
					  driver.findElement(By.id("password")).sendKeys(oData.validPassword());
					  Thread.sleep(3000);
					  driver.findElement(By.id("rePassword")).sendKeys(oData.validReTypePassword());
					  Thread.sleep(3000);
		  			  driver.findElement(By.id("email")).sendKeys(oData.validEmail());
		  			  Thread.sleep(3000);
		  			  WebElement dd = driver.findElement(By.id("country-dropdown"));
					  Select ele  = new Select(dd);
					  ele.selectByVisibleText("India ( +91 )");
		  			  driver.findElement(By.id("phone")).sendKeys(oData.validMobileNo());
		  			  Thread.sleep(2000);
		  			  WebElement ddlCollection = driver.findElement(By.id("collection-dropdown"));
					  Select ele1  = new Select(ddlCollection);
					  ele1.selectByVisibleText("Handicrafts & Fashion");
					  Thread.sleep(2000);
					  WebElement ddlSegment = driver.findElement(By.id("segment-dropdown"));
					  Select ele2  = new Select(ddlSegment);
					  ele2.selectByVisibleText("Accessories");
					  Thread.sleep(2000);
					  driver.findElement(By.id("pincode")).sendKeys(oData.validPincode());
		  			  Thread.sleep(3000);
		  			  driver.findElement(By.id("tc")).sendKeys(Keys.SPACE);
		  			  Thread.sleep(3000);
		  			  driver.findElement(By.xpath("//*[@id='registrationForm']/div/div[18]/div/div[2]/button")).click();
		  			  Thread.sleep(3000);
		  			  //Thread.sleep(10000);
		  			  if (driver.getPageSource().contains("Enter OTP sent to your phone")) 
		  			  {
		  				  
		  				if (driver.getPageSource().contains(oData.merRegSuccessMsg())) 
					  	  {
		  						Reporter.log("Test passed for valid data : " + (oData.merRegSuccessMsg()));
								System.out.println("Test passed for valid data : " + (oData.merRegSuccessMsg()));
								
								notes = "Test passed for invalid data";
								
								Thread.sleep(3000);
					  	  } 
					  	  else 
					  	  {
					  		Reporter.log("Test failed for valid data");
							
							
							org.testng.Assert.fail();
					  	  }
						
					} 
		  			  else {
		  				Reporter.log("Test failed for valid data");
						
						
						org.testng.Assert.fail();

					}
				  }
			  else
			  {
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
