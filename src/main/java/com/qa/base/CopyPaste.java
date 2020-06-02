
//package com.qa.base;
//
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.qa.hubspot.pages.LoginPage;
//
//public class CopyPaste {
//	
//	BasePage basepage;
//	WebDriver driver; 
//	LoginPage loginPage;
//	Properties prop;
//
//
//	@BeforeTest
//	public void setUp() {
//
//		basepage = new BasePage();
//		prop = basepage.init_prop();
//		driver = basepage.init_driver(prop);
//		loginPage = new LoginPage(driver);
//
//
//	}
//
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
//
//	
//WebDriver driver; 
//	Properties prop;
//	BasePage basepage;
//	LoginPage loginPage;
//	HomePage homePage;


	
	

//	@BeforeTest
//	public void setUp() {
//
//		basepage = new BasePage();
//		prop = basepage.init_prop();
//		driver = basepage.init_driver(prop);
//		loginPage = new LoginPage(driver);
//		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//	
//	
//
//}
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
//
//	
//	
//	
//	
//}
