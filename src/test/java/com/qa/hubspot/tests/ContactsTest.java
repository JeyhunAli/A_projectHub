package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsTest extends BaseTest{


	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeClass
	public void contactsPageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();

	}

	@Test 
	public void verifyContactsPageTitleTest() {
		String contactTitle = contactsPage.getContactsPageTitle();
		System.out.println("Contacts page title is: " + contactTitle);
		Assert.assertEquals(contactTitle, ConstantsUtil.Contacts_Page_title);
	}

	@Test
	public void verifyContactsPageHeaderTest() {
		String contactsHeader = contactsPage.verifyContactsPageHeader();
		System.out.println("Contacts Page Header is: " + contactsHeader);
		Assert.assertEquals(contactsHeader, ConstantsUtil.Contacts_Page_header);		

	}
	
	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] =  ExcelUtil.getTestData(ConstantsUtil.Contacts_sheet_Name);
		return data;
		
	}
	
	

	@Test(priority = 2, dataProvider = "getContactsTestData")
	public void verifycreateContactTest(String email, String firstName, String lastName, String jobtitle, String phone) {
		
		//contactsPage.createContact("Nastyush@gmail.com", "Nastyush", "Aliyeva", "RN", "3477777777");

		contactsPage.createContact(email, firstName, lastName, jobtitle, phone);

		
	}
	


}
