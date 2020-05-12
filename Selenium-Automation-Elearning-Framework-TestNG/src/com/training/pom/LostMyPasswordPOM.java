package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostMyPasswordPOM {
private WebDriver driver;

	public LostMyPasswordPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath = "//input[@id='lost_password_user']")
	@FindBy(id ="lost_password_user")
	public WebElement lostusername;
	
	@FindBy(xpath = "//button[@id='lost_password_submit']")
	public WebElement sendmessage;
	
	public void clicksendmessage () {
		sendmessage.click();
	}
	
	
		
	

}
