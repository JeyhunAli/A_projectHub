package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage{

	private WebDriver driver;



	//By homepageHeader = By.cssSelector("h1.private-page__title");
	By homepageHeader = By.xpath("//span/h1[text()='Sales Dashboard']");
	By filterdashboard = By.xpath("//span[text()=' Filter dashboard']");
	By accountname = By.cssSelector("span.account-name");
	By assignedLabel = By.xpath("//span/i18n-string[text()=\"Assigned:\"]");

	By primaryContacts = By.id("nav-primary-contacts-branch");
	By secondaryContacts = By.id("nav-secondary-contacts");



	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	@Step("home page title step")
	public String verifyHomePageTitle() {
		//	return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(ConstantsUtil.Home_Page_title, 10);

	}

	@Step("home page header step")
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


	@Step("home page Assigned Label step")
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


	@Step("home page PageChaning step")
	public ContactsPage goToContactsPage() {
		clickOnPrimaryContacts();
		return new ContactsPage(driver);

	}

	private void clickOnPrimaryContacts() {
		elementUtil.waitForElementToBeVisible(primaryContacts, 10);
		elementUtil.doActionsClick(primaryContacts);
		elementUtil.waitForElementToBeVisible(secondaryContacts, 10);
		elementUtil.doClick(secondaryContacts);

	}




}





