package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProfilePOM {
private WebDriver driver; 
	
	public ProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@id='password1']")
	private WebElement password1;
	
	@FindBy (xpath = "//input[@id='profile_password2']")
	private WebElement password2;
	
	@FindBy (xpath = "//button[@id='profile_apply_change']")
	private WebElement SaveSetting;
	
	@FindBy (xpath = "//div[@class='alert alert-info']")
	private WebElement Profilesaved;
	
	public void sendpassword1(String password1) {
		this.password1.clear();
		this.password1.sendKeys(password1);
	}	
	public void Sendpassword2(String password2) {
		this.password2.clear();
		this.password2.sendKeys(password2);
	}
		
	public void clickSaveSetting() {
		SaveSetting.click();
	}
	public void savedprofile() {
		String act = Profilesaved.getText();
		String exp = "Your new profile has been saved";
		Assert.assertEquals(act, exp);
		
	}
}
