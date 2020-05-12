package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CoursesCatalogPOM {
private WebDriver driver; 
	
	public CoursesCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='search_term']")
	private WebElement searchterm;
	
	@FindBy(xpath = "//div[@class='input-group']//button[1]")
	private WebElement clicksearch;
	
	@FindBy(xpath = "//strong[contains(text(),'Search results for')]")
	private WebElement searchvalidation;

	
	public void sendsearch(String searchterm) {
		this.searchterm.clear();
		this.searchterm.sendKeys(searchterm);
	
	}
	public void clickonSearch() {
		clicksearch.click();
	}	
	public void reslutvalidation() {
		String act = searchvalidation.getText();
		String exp = "Search results for: AWS_1";
		Assert.assertEquals(act, exp);
	}
	
		

}
	
