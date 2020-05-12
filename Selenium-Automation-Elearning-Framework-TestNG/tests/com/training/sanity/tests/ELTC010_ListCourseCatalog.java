package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.MyCoursePOM;
import com.training.pom.CoursesCatalogPOM;

public class ELTC010_ListCourseCatalog {
	
	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningLoginPOM;
	private MyCoursePOM MyCoursePOM;
	private CoursesCatalogPOM CoursesCatalogPOM;
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
		CoursesCatalogPOM = new CoursesCatalogPOM(driver);
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
		MyCoursePOM.ClickCousecatelog();	
	}
	
	@Test(priority = 2)
	public void Search() throws Exception{
		CoursesCatalogPOM.sendsearch("AWS_1");
		CoursesCatalogPOM.clickonSearch();
		Thread.sleep(5000);
		
	}
		@Test(priority =3)
	public void result() throws Exception{
		CoursesCatalogPOM.reslutvalidation();
		screenShot.captureScreenShot("ELTC010_Search_ouput");
		
	}
	
}
