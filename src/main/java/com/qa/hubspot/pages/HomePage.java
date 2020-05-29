package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;

public class HomePage extends BasePage{

	private WebDriver driver;


	//By homepageHeader = By.cssSelector("h1.private-page__title");
	By homepageHeader = By.xpath("//span/h1[text()='Sales Dashboard']");
	By filterdashboard = By.xpath("//span[text()=' Filter dashboard']");
	By accountname = By.cssSelector("span.account-name");
	By assignedLabel = By.xpath("//span/i18n-string[text()=\"Assigned:\"]");


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public String verifyHomePageHeader() {

		if(driver.findElement(homepageHeader).isDisplayed()) {
			return driver.findElement(homepageHeader).getText();

		}
		return null;
	}

	public String verifyFilterDashboardDisplayed() {

		if(driver.findElement(filterdashboard).isDisplayed()) {
			return	driver.findElement(filterdashboard).getText();

		}
		return null;


	}

	public String getLoggedInUser() {

		if(driver.findElement(accountname).isDisplayed()){
			return	driver.findElement(accountname).getText();

		}
		return null;
	}


	public String verifyAssignedLabeldisplayed() {

		if(driver.findElement(assignedLabel).isDisplayed()){
			return	driver.findElement(assignedLabel).getText();

		}
		return null;
	}




}
