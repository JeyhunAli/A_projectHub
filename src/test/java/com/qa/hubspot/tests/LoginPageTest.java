package com.qa.hubspot.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtil;

/**
 * 
 * @author Ali jeyhun
 * 
 * quick information about this testclass
 * 1st setup method for that we need base page  first declaring basepage reference at class level then creating object of the base page 
 * 2nd we are declaring webdriver refernce at the class level then creating object of that 
 * 3rd we are declaring loginPage at the class level then creating object of it 
 * then starting wrting our test with the testan notations 
 * why im creating all this at class level and creating objects of them so i can access my driver i can 
 * access my login page and login page constructor and base page where is prop file and my browser name 
 * 
 *
 */

public class LoginPageTest {
	
	BasePage basepage;
	WebDriver driver; 
	LoginPage loginPage;
	Properties prop;


	@BeforeTest
	public void setUp() {

		basepage = new BasePage();
		prop = basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginPage = new LoginPage(driver);


	}

	@Test(priority = 2)
	public void verifyLoginPageTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is "+ title);
		Assert.assertEquals(title, ConstantsUtil.Login_Page_title, "login page title is not matched");
	}

	@Test (priority = 1)
	public void verifySignUpLink() {
		Assert.assertTrue(loginPage.verifySignUpLink(),"signup link is not displayed ");
		
		}
	
	@Test
    public void verifyAccountdontHaveText() {

		String donthaveaccountText = loginPage.verifyTextDontHaveAccount();
		
		System.out.println("The Don't have an account? text displayed: "+donthaveaccountText);
		Assert.assertEquals(donthaveaccountText, ConstantsUtil.Login_Page_Dont_Have_An_Account,"not matched");
	
	
	}


	@Test(priority = 3)
	public void verifyLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}



}
