package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	By contactsHeader = By.cssSelector("h1.private-header__heading");
	By createContactPrimary = By.xpath("//span[text()='Create contact']");
	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field=\"firstname\"]");
	By lastName = By.xpath("//input[@data-field=\"lastname\"]");
	By jobtitle = By.xpath("//input[@data-field=\"jobtitle\"]");
	By phone = By.xpath("//input[@data-field=\"phone\"]");
	
	By createContactSecondary = By.xpath("//button[@data-confirm-button=\"accept\"]");
	
	By contactsbacklink = By.xpath("(//i18n-string[text()=\"Contacts\"])[position()=1]");
	
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(ConstantsUtil.Contacts_Page_title, 10);
		
	}
	
	public String verifyContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(contactsHeader, 5);
		return elementUtil.doGetText(contactsHeader);
		
	}
	
	public void createContact(String email, String firstName, String lastName, String jobtitle, String phone) {
		elementUtil.waitForElementToBeVisible(createContactPrimary, 10);
		elementUtil.doClick(createContactPrimary);
		
		
		elementUtil.waitForElementToBeVisible(this.email, 10);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		
		elementUtil.waitForElementToBeVisible(this.jobtitle, 10);
		elementUtil.doSendKeys(this.jobtitle, jobtitle);
		elementUtil.doSendKeys(this.phone, phone);


		elementUtil.waitForElementToBeVisible(createContactSecondary, 10);
		elementUtil.doClick(createContactSecondary);
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	//elementUtil.waitForElementPresent(contactsbacklink, 10);
		elementUtil.doActionsClick(contactsbacklink);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
