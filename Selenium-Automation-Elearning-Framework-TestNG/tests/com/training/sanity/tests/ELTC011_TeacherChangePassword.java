package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.MyCoursePOM;
import com.training.pom.ProfilePOM;

public class ELTC011_TeacherChangePassword {
	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningLoginPOM;
	private MyCoursePOM MyCoursePOM;
	private ProfilePOM ProfilePOM;
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
		MyCoursePOM = new MyCoursePOM(driver);
		ProfilePOM = new ProfilePOM(driver);
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
	public void validLoginTest() throws Exception{
		elearningLoginPOM.sendUserName("coolguru");
		elearningLoginPOM.sendPassword("coolguru");
		elearningLoginPOM.clickLoginBtn();
		Thread.sleep(5000);
		
		screenShot.captureScreenShot("ELTC010_login");
	}
	@Test(priority = 1)
	public void Coursecatalog() throws Exception{
		MyCoursePOM.clickEdit();
		
		
				
	}
	@Test(priority = 2)
	public void Changepassword() throws Exception{
		ProfilePOM.sendpassword1("coolguru");
		ProfilePOM.Sendpassword2("coolguru");
		ProfilePOM.clickSaveSetting();
		Thread.sleep(5000);
		
	}
	@Test(priority =3)
	public void Profilesave() {
		ProfilePOM.savedprofile();
		screenShot.captureScreenShot("ELTC011_Profilesaved");
	}
	
}
