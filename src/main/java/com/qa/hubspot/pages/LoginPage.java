package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

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
	//By dontHaveAccount = By.xpath("//i18n-string[text()=\"Don't have an account?\"]");
	By dontHaveAccount = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	
			
	//2. Constructor 
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	
	//3. Page actions 
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(ConstantsUtil.Login_Page_title, 10);
		
	}
	
	public boolean verifySignUpLink() {
		//return driver.findElement(signUpLink).isDisplayed();
		return elementUtil.doIsDisplayed(signUpLink);
	}
	
	
	public String verifyTextDontHaveAccount() {
	if( driver.findElement(this.dontHaveAccount).isDisplayed()) {
		return driver.findElement(dontHaveAccount).getText();
	}
	return null;
		
	}
	//here as a param im passing usrname,password as generic if someone will call
	//this method they can use withoud hard coded 
	//above and below username password looks same but with the help 
	//of this im differentiation
	public HomePage doLogin(String username, String password) {
//		driver.findElement(this.username).sendKeys(username);
//		driver.findElement(this.password).sendKeys(password);
//		driver.findElement(this.LoginButton).click();
//		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		elementUtil.waitForElementToBeVisible(this.username, 10);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doClick(this.LoginButton);
		
		return new HomePage(driver);
		
		
		
	}
	

}
