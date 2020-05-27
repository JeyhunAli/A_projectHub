package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;

/**
 * 
 * @author jey
 * this is the page class of the project this class is responsible for 
 * object repositories with the help of the by locator 
 * and n number of the page methods and page actions over here 
 * 
 * By Locators ---- object repository
 * 
 * second thing is constructor all the page have to have constructor 
 *inside the constructor im passing webdriver referense 
 *
 */

public class LoginPage extends BasePage {
	
	private WebDriver driver; 
	
	
	//1. By locator 
	By username = By.id("username");
	By password = By.id("password");
	By LoginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	By dontHaveAccount = By.xpath("//i18n-string[text()=\"Don't have an account?\"]");
	
			
	//2. Constructor 
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	//3. Page actions 
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	
	public boolean verifyTextDontHaveAccount() {
		return driver.findElement(this.dontHaveAccount).isDisplayed();
	}
	//here as a param im passing usrname,password as generic if someone will call
	//this method they can use withoud hard coded 
	//above and below username password looks same but with the help 
	//of this im differentiation
	public void doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.LoginButton).click();
	}
	

}
