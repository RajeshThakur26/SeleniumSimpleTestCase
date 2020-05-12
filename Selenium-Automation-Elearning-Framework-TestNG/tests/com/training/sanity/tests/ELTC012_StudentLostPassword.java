package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.LostMyPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC012_StudentLostPassword {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningLoginPOM;
	private LostMyPasswordPOM LostMyPasswordPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningLoginPOM = new ElearningLoginPOM(driver); 
		LostMyPasswordPOM = new LostMyPasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
			
	}
	@Test(priority = 0)
	public void lostpasswrd() throws Exception {
		elearningLoginPOM.lostpassword.click();
				
	}
	@Test(priority = 1)
	public void sendlostid() throws Exception {
		//driver.findElement(By.xpath("//input[@id='lost_password_user']")).sendKeys("student26");
		LostMyPasswordPOM.lostusername.sendKeys("student26");
		LostMyPasswordPOM.clicksendmessage();
		
	}
	@Test(priority = 2)
	public void loginpage()throws Exception{
		elearningLoginPOM.loginpage();
		screenShot.captureScreenShot("ELTC011_LoginPage");
		
	}
}
