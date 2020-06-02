package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage{

	private WebDriver driver;
	


	//By homepageHeader = By.cssSelector("h1.private-page__title");
	By homepageHeader = By.xpath("//span/h1[text()='Sales Dashboard']");
	By filterdashboard = By.xpath("//span[text()=' Filter dashboard']");
	By accountname = By.cssSelector("span.account-name");
	By assignedLabel = By.xpath("//span/i18n-string[text()=\"Assigned:\"]");


	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String verifyHomePageTitle() {
	//	return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(ConstantsUtil.Home_Page_title, 10);

	}

	public String verifyHomePageHeader() {

//		if(driver.findElement(homepageHeader).isDisplayed()) {
//			return driver.findElement(homepageHeader).getText();
//
//		}
//		return null;
		
		
		if(elementUtil.doIsDisplayed(homepageHeader)) {
			return elementUtil.doGetText(homepageHeader);
			
		}
		return null;
		
	}

	public String verifyFilterDashboardDisplayed() {

//		if(driver.findElement(filterdashboard).isDisplayed()) {
//			return	driver.findElement(filterdashboard).getText();
//
//		}
//		return null;


	if(	elementUtil.doIsDisplayed(filterdashboard)){
		return elementUtil.doGetText(filterdashboard);
		
	}
	return null;
	}

	public String getLoggedInUser() {
//
//		if(driver.findElement(accountname).isDisplayed()){
//			return	driver.findElement(accountname).getText();
//
//		}
//		return null;
		
		if(elementUtil.doIsDisplayed(accountname)){
			return elementUtil.doGetText(accountname);
			
		}return null;
		
		
	}


	public String verifyAssignedLabeldisplayed() {

//		if(driver.findElement(assignedLabel).isDisplayed()){
//			return	driver.findElement(assignedLabel).getText();
//
//		}
//		return null;
		
	if(	elementUtil.doIsDisplayed(assignedLabel)){
		return elementUtil.doGetText(assignedLabel);
		
			
		}return null;
		
		
	}




}
