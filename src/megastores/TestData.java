package megastores;

public class TestData {

//==========================Login valid username and password==================================	
	
	private String username_valid = "jigar";
	private String password_valid = "mega@1234";
	
	public String username_valid() {
		return username_valid;
	}
	
	public String password_valid() {
		return password_valid;
	}
//=============================================================================================
	
//=========================Login Invalid username and password=================================
	
	private String username_invalid = "jigar9";
	
	private String password_invalid = "mega@123456";
	

	public String username_invalid() {
		return username_invalid;
	}
	
	public String password_invalid() {
		return password_invalid;
	}
//=============================================================================================
	
//========================Login empty username and password====================================	
	
	private String username_empty = "";
	private String password_empty = "";
	
	public String username_empty() {
		return username_empty;
	}
	
	public String password_empty() {
		return password_empty;
	}
//=============================================================================================
	
//========================Existing and Non-Existing email id===================================
	
	private String existing_email = "test@gmail.com";
	private String non_existing_email = "test12@gmail.com";
	
	public String existing_email() {
		return existing_email;
	}
	
	public String non_existing_email() {
		return non_existing_email;
	}
//=============================================================================================	

//=======================Existing and Non-Existing Phone number================================

	private String existing_phno = "9769773656";
	private String non_existing_phno = "8785872587";
	
	public String existing_phno() {
		return existing_phno;
	}
	
	public String non_existing_phno() {
		return non_existing_phno;
	}
//=============================================================================================	


//=======================Existing and Non-Existing username====================================
	
	private String existing_username = "jigar09";
	private String non_existing_username = "jiga19";
	
	public String existing_username() {
		return existing_username;
	}
	
	public String non_existing_username() {
		return non_existing_username;
	}
//=============================================================================================
	
//=======================Profile Change phone number test data=================================	
	//Change phone number data
	private String four_alphabets = "abcd";
	private String ten_alphabets = "abcdefghij";
	private String sixteen_alphabets = "abcdefghijklmnop";
	private String fifteen_alphabets = "abcdefghijklmno";
	private String four_numbers = "1234";
	private String ten_numbers = "1251515151";
	private String sixteen_numbers = "1234567890123456";
	private String fifteen_numbers = "123456789012345";
	
	
	public String four_alphabets() {
		return four_alphabets;
	}
	
	public String ten_alphabets() {
		return ten_alphabets;
	}
	
	public String sixteen_alphabets() {
		return sixteen_alphabets;
	}
	
	public String fifteen_alphabets() {
		return fifteen_alphabets;
	}
	
	public String four_numbers() {
		return four_numbers;
	}
	
	public String ten_numbers() {
		return ten_numbers;
	}
	
	public String sixteen_numbers() {
		return sixteen_numbers;
	}
	
	public String fifteen_numbers() {
		return fifteen_numbers;
	}
//=========================================================================================
	
//=======================One Time Password text============================================
	
	private String onetimepassword_text = "One Time Password";
	
	public String onetimepassword_text() {
		return onetimepassword_text;
	}
//=========================================================================================
	
//=======================Invalid OTP message===============================================
	
	private String invalid_otp = "Invalid OTP.";
	
	public String invalid_otp() {
		return invalid_otp;
	}
//=========================================================================================
	
//=======================User not found message============================================
	
	private String user_not_found_message = "User not found.";
	
	public String user_not_found_message() {
		return user_not_found_message;
	}
//=========================================================================================
	
//=======================Empty String======================================================	
	
	private String empty = "";
	
	public String empty() {
		return empty;
	}
//=========================================================================================
	
//=======================Forgot username success message===================================
	
	private String username_message = "Username sent to your email.";
	
	public String username_message() {
		return username_message;
	}
//=========================================================================================
	
//======================Session Expiry message=============================================
	
	private String session_expiry = "Session expired. Please login again.";
	
	public String session_expiry() {
		return session_expiry;
	}
//=========================================================================================
	
//======================Phone number already exist message=================================
	
	private String phone_no_exist = "Phone number already exist.";
	
	public String phone_no_exist() {
		return phone_no_exist;
	}
//=========================================================================================
	
//======================10 character required message======================================
	
		private String ten_character = "Please enter at least 10 characters.";
		
		public String ten_character() {
			return ten_character;
		}
//=========================================================================================
		
//======================Field required message=============================================
		
			private String field_required = "This field is required.";
			
			public String field_required() {
				return field_required;
			}
//=========================================================================================
			
//======================Valid number message===============================================
			
			private String valid_number = "Please enter a valid number.";
			
			public String valid_number() {
				return valid_number;
			}
//=========================================================================================

//======================15 character required, message=====================================
			
			private String fifteen_character = "Please enter no more than 15 characters.";
			
			public String fifteen_character() {
				return fifteen_character;
			}
//=========================================================================================

//======================OTP required message===============================================
			
			private String otp_required = "The otp field is required.";
			
			public String otp_required() {
				return otp_required;
			}
//=========================================================================================

//======================Email required message=============================================
			
			private String emailrequired = "Email is required";
			
			public String emailrequired() {
				return emailrequired;
			}
//==========================================================================================
			
//=====================Invalid Email message================================================
			private String invalid_email = "Please enter a valid email address.";
			private String invalid_email1 = "Please enter valid email address.";
			
			public String invalid_email() {
				return invalid_email;
			}
			
			public String invalid_email1() {
				return invalid_email1;
			}
//==========================================================================================		

//=====================Invalid and Valid email format=======================================
			private String inv_email_format = "adad";
			private String inv_email_format1 = "adad@gmail";
			
			public String inv_email_format() {
				return inv_email_format;
			}
			
			public String inv_email_format1() {
				return inv_email_format1;
			}
//===========================================================================================
			
//=====================Existing email message================================================
			private String existing_email_message = "Email already exist.";
			
			public String existing_email_message() {
				return existing_email_message;
			}
//===========================================================================	================
			
//=====================Change Email valid mail id============================================
			private String email_valid_id = "abcxyzgw@gmail.com";
			
			public String email_valid_id() {
				return email_valid_id;
			}
//===========================================================================================
			
//=====================Change email Message==================================================
			private String change_email_message = "Verification link sent to your mail.";
			
			public String change_email_message() {
				return change_email_message;
			}
			
//=====================Change Password data==================================================
			private String valid_pass = "mega@1234";
			private String wrong_old_pass = "mega@123456";
			private String valid_new_pass = "mega@12345";
			private String invalid_pass_min_length = "ab";
			private String min_length_pass_message = "Please enter at least 6 characters.";
			private String invalid_pass_format = "mega123";
			private String pass_format_message = "Password should be minimum of 6 characters; at least 1 lower case letter, 1 digit, and 1 special character.";
			private String pass_dont_match = "Password doesn't match";
			private String old_pass_dont_match = "Old password doesn't match.";
			private String pass_updated_successfully = "Password updated successfully.";
			
			public String pass_updated_successfully() {
				return pass_updated_successfully;
			}
			
			public String old_pass_dont_match() {
				return old_pass_dont_match;
			}
					
			public String wrong_old_pass() {
				return wrong_old_pass;
			}
			
			public String pass_dont_match() {
				return pass_dont_match;
			}
			
			public String valid_new_pass() {
				return valid_new_pass;
			}
			
			public String pass_format_message() {
				return pass_format_message;
			}
			
			public String valid_pass() {
				return valid_pass;
			}
			
			public String invalid_pass_min_length() {
				return invalid_pass_min_length;
			}
			
			public String min_length_pass_message() {
				return min_length_pass_message;
			}
			
			public String invalid_pass_format() {
				return invalid_pass_format;
			}
//========================================================================================
			
//==========================Profile Info Update===========================================
			private String profile_update_message = "Profile updated successfully.";
			private String fname = "Jigar";
			private String lname = "Patel";
			
			public String fname() {
				return fname;
			}
			
			public String lname() {
				return lname;
			}
			
			public String profile_update_message() {
				return profile_update_message;
			}
//==========================================================================================
			
//======================Clear cart message==================================================
			private String clear_cart_message = "Product removed from your cart";
			public String clear_cart_message() {
				return clear_cart_message;
			}
//==========================================================================================
			
//======================Upload image========================================================
			private String valid_image = "C:\\Users\\Admin\\Desktop\\card.png";
			public String valid_image() {
				return valid_image;
			}
			
			private String invalid_image = "C:\\Users\\Admin\\Desktop\\AF\\mega.txt";
			public String invalid_image() {
				return invalid_image;
			}
			
			private String valid_image_message = "Profile picture updated successfully.";
			public String valid_image_message() {
				return valid_image_message;
			}
			
			private String invalid_image_message= "The profile pic must be a file of type: jpg, jpeg, png.";
			public String invalid_image_message() {
				return invalid_image_message;
			}
			
			private String image_required_message = "Profile picture is required.";
			public String image_required_message() {
				return image_required_message;
			}
//===========================================================================================
			
//====================Add Address============================================================
			private String address_added_message = "Address added successfully.";
			public String address_added_message() {
				return address_added_message;
			}
			
			
			private String exist_title = "home";
			public String exist_title() {
				return exist_title;
			}
			
			private String valid_title = "Temporary Home";
			public String valid_title() {
				return valid_title;
			}
			
			private String valid_title_default = "New House1";
			public String valid_title_default() {
				return valid_title_default;
			}
			
			private String name = "Jigar";
			public String name() {
				return name;
			}
			
			private String mobile_no = "7854785487";
			public String mobile_no() {
				return mobile_no;
			}
			
			private String flat_no = "A/103";
			public String flat_no() {
				return flat_no;
			}
			
			private String building = "Suvidha Apt";
			public String building() {
				return building;
			}
			
			private String locality = "mulund west";
			public String locality() {
				return locality;
			}
			
			private String pincode = "400060";
			public String pincode() {
				return pincode;
			}
			
			private String city = "Mumbai";
			public String city() {
				return city;
			}
			
			private String state = "Maharashtra";
			public String state() {
				return state;
			}
			
			private String country = "India";
			public String country() {
				return country;
			}
//=============================Add to Cart========================================
			private String add_to_cart_message = "Product added successfully";
			public String add_to_cart_message() {
				return add_to_cart_message;
			}
			
			private String delivery_confirmation = "Your order will get deliver within 4 - 5 business days.";
			public String delivery_confirmation() {
				return delivery_confirmation;
			}
			
//=============================Registration========================================
			private String username = "Test Alka";
			public String username() {
				return username;
			}
			
			private String mobile = "7898559698";
			public String mobile() {
			return mobile;
			}
			
			private String email_id = "test4574754@test.com";
			public String email_id() {
				return email_id;
			}
			
			private String pass = "mega@123";
			public String pass() {
				return pass;
			}
}
			
			
