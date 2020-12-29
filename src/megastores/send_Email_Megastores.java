package megastores;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class send_Email_Megastores {
	
	public static void main(String[] args) throws InterruptedException, IOException, SAXException, ParserConfigurationException, ParseException{
		
/*		//Converting epoch to date and replacing it in the html file
		System.setProperty("webdriver.chrome.driver", "/home/atulsiaeight/Desktop/Jigar/Selenium/chromedriver");
    	WebDriver driver = new ChromeDriver();
		driver.get("file:///home/atulsiaeight/Desktop/Jigar/Megastores/Selenium_Scripts/Megastores/test-output/emailable-report.html");
		Path path = Paths.get("/home/atulsiaeight/Desktop/Jigar/Megastores/Selenium_Scripts/Megastores/test-output/emailable-report.html");
		Charset charset = StandardCharsets.UTF_8;
		String content1 = new String(Files.readAllBytes(path), charset);
		content1 = content1.replace("Time (ms)", "Time (seconds)");
		Files.write(path, content1.getBytes(charset));
		
		try {
			for(int i=3; i>=0; i++) {
				if(driver.findElements(By.xpath("/html/body/table[1]/tbody/tr["+i+"]/td[5]")).size() !=0) {
					WebElement time = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr["+i+"]/td[5]"));
					String time_milli = time.getText();
					NumberFormat format = NumberFormat.getInstance(Locale.US);
					Number time_milli_final = format.parse(time_milli);
					Long number_time = time_milli_final.longValue();
					Long seconds = TimeUnit.MILLISECONDS.toSeconds(number_time);
					content1 = content1.replaceAll(time_milli, seconds.toString());
					Files.write(path, content1.getBytes(charset));
				}
				else if (driver.findElements(By.xpath("/html/body/table[1]/tbody/tr["+i+"]/th[5]")).size() !=0) {
					WebElement total_time = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr["+i+"]/th[5]"));
					String total_time_milli = total_time.getText();
					NumberFormat format1 = NumberFormat.getInstance(Locale.US);
					Number time_milli_final1 = format1.parse(total_time_milli);
					Long number_time1 = time_milli_final1.longValue();
					Long seconds1 = TimeUnit.MILLISECONDS.toSeconds(number_time1);
					content1 = content1.replaceAll(total_time_milli, seconds1.toString());
					Files.write(path, content1.getBytes(charset));
				}
				else {
					break;
				}
			}
		} finally {
			
		}
		
		try {
			for (int i = 0, j=2; i >=0 && j>=0 ; i++ , j++) {
				if(driver.findElements(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]")).size() !=0) {
					WebElement epoch = driver.findElement(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]"));
					String epoch_final = epoch.findElement(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]/td[3]")).getText();
					System.out.println(epoch_final);
					Long epoch_date = Long.parseLong(epoch_final);
					Date date = new Date(epoch_date);
					DateFormat format = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
					String date_format = format.format(date);
					System.out.println(date_format);
					content1 = content1.replaceAll(epoch_final, date_format.toString());
					Files.write(path, content1.getBytes(charset));
				}	
				else {
					break;
				}
			}
		}
		catch (Exception e){
			
		} finally {
		}
		
		try {
			for(int i=0; i>=0; i++) {
				if(driver.findElements(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]")).size() !=0) {
					WebElement time_ms = driver.findElement(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]/td[4]"));
					String time_ms_final = time_ms.findElement(By.xpath("//*[@id=\"t"+i+"\"]/tr[2]/td[4]")).getText();
					Long time_milliseconds = Long.parseLong(time_ms_final);
					Long time_seconds = TimeUnit.MILLISECONDS.toSeconds(time_milliseconds);
					content1 = content1.replaceAll(time_ms_final, time_seconds.toString());
					Files.write(path, content1.getBytes(charset));
				}
				else {
					break;
				}
			}
		} finally {
			driver.quit();
			Thread.sleep(5000);
		}
		
*/		
		//Sending email with xml parsing
		Thread.sleep(5000);
		final String username = "alka@atulsia.com";
	    final String password = "!asd@positive";
		    

	    Properties props = new Properties();
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.host", "sub4.mail.dreamhost.com");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.ssl.trust", "*");
	    props.put("mail.smtp.ssl.enable" , "true");
	    props.put("mail.smtp.socketFactory.port", "465");

		    Session session = Session.getInstance(props,
		            new javax.mail.Authenticator() {
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            });
		    try {
		    	
		    	File xmlFile = new File("C:\\Users\\Admin\\Documents\\Alka\\Selenium_scripts\\Megastores_Website\\test-output\\testng-results.xml");
				DocumentBuilderFactory docbuildFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docbuildFactory.newDocumentBuilder();
				Document document = docBuilder.parse(xmlFile);
		 
				document.getDocumentElement().normalize();
		 
				NodeList nodeList = document.getElementsByTagName("testng-results");
				NodeList nodeList1 = document.getElementsByTagName("suite");
				
				for (int i = 0; i < nodeList.getLength(); i++) {
					for(int n = 0; n < nodeList1.getLength(); n++) {
					Node node = nodeList.item(i);
					Node node1 = nodeList1.item(n);
					if (node.getNodeType() == Node.ELEMENT_NODE && node1.getNodeType() == Node.ELEMENT_NODE) {
		 
						Element element = (Element) node;
						Element element1 = (Element) node1;
						String passed =  element.getAttribute("passed");
						String failed = element.getAttribute("failed");
						String skipped = element.getAttribute("skipped");
						String duration = element1.getAttribute("duration-ms");
						Long milliseconds = Long.parseLong(duration);
						Long duration_minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds); 
//				    	Path xmlfile = Paths.get("/home/atulsiaeight/Desktop/Jigar/Megastores/Selenium_Scripts/Megastores/test-output", "testng-results.xml");
//			            Object passed = Files.getAttribute(xmlfile, "passed");
//			            Object failed = Files.getAttribute(xmlfile, "failed");
//			            Object skipped = Files.getAttribute(xmlfile, "skipped");
				    	
				        Message message = new MimeMessage(session);
				        message.setFrom(new InternetAddress("alka@atulsia.com"));
				        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("alka@atulsia.com, kailashg@atulsia.com,  salvi@atulsia.com, pooja@atulsia.com"));
				        // message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(" alka@atulsia.com"));
				        //message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("jigarp@atulsia.com"));
				        message.setSubject("Megastores Test Report- Passed:" +passed+ " Failed:" +failed+ " Skipped:" +skipped+ " Time:" +duration_minutes+ " Mins");
				        message.setText("PFA");

				        Multipart multipart = new MimeMultipart();

				        BodyPart messageBodyPart = new MimeBodyPart();
			            BodyPart attachmentBodyPart = new MimeBodyPart();
			            String file = "C:\\Users\\Admin\\Documents\\Alka\\Selenium_scripts\\Megastores_Website\\test-output\\emailable-report.html";
			            String files = file.substring(file.lastIndexOf("\\"));
			            String extension = files.substring(files.indexOf(".")); // .tar.gz
			            String content = new String(Files.readAllBytes(Paths.get(file)));
				        //List<String> lines = Files.readAllLines(Paths.get(file));
				        String fileName = "Test_Report" + extension;
				        DataSource source = new FileDataSource(file);
				        messageBodyPart.setContent(content.toString() , "text/html");
				        multipart.addBodyPart(messageBodyPart);

			            attachmentBodyPart.setDataHandler(new DataHandler(source));

			            attachmentBodyPart.setFileName(new File(fileName).getName());

			            multipart.addBodyPart(attachmentBodyPart);

			            message.setContent(multipart);

				        System.out.println("Sending");

				        Transport.send(message);

				        System.out.println("Done");		
					}
				}
			}

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }	
		}
}
