package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursePOM {
private WebDriver driver; 
	
	public MyCoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-large']")
		private WebElement Coursecatalog;
	
	@FindBy(xpath ="//li//a[contains(text(),'Edit profile')]")
		private WebElement EditProfile;
			
	public void clickEdit() {
		this.EditProfile.click();
	}
	public void ClickCousecatelog() {
		this.Coursecatalog.click();
	}
		
}
