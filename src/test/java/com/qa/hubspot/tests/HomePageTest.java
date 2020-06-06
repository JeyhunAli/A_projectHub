package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantsUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


/**
 * 
 * @author jey
 * 
 * @Listeners(ExtentReportListener.class) this only applicaple for this class 
 * 
 *
 */


 //@Listeners(ExtentReportListener.class)
//@Listeners(TestAllureListener.class)
@Epic("Epic - 010: Home Page functionality and features testing design")
@Story("User Story - 012 home Page title, header Assigned Label visiblity functionality ")
public class HomePageTest extends BaseTest{
	
	HomePage homePage;
	
	@BeforeClass
	@Severity(SeverityLevel.BLOCKER)
	public void homeStup() {
	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	
@Description("this method is responsible of the home page title")
	@Test(priority = 3)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, ConstantsUtil.Home_Page_title, "Home page title is not matched...");
	}
	
	@Test(priority = 1)
	public void verifyHomePageHeaderTest() {
		String header =  homePage.verifyHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, ConstantsUtil.Home_Page_Header, "home page header is not matched...." );
		
	}
	@Description("thid method is responsible for filter dashboard is displayed")
	@Test (priority = 4)
	public void verifyFilterdashboardDisplayedTest() {
		String filterDashboard = homePage.verifyFilterDashboardDisplayed();
		System.out.println(filterDashboard);
		Assert.assertEquals(filterDashboard, ConstantsUtil.Home_Page_Filter_Dasboard, "filter dashboard not matched...." );
	}
	
	@Test(priority = 2)
	@Severity(SeverityLevel.CRITICAL)
	public void verifyLoggedInUserTest() {
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println(loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "Loggedin user not matched.... ");
	}
	
	@Test
	@Severity(SeverityLevel.NORMAL)
	public void verifyAssignedLabeldisplayedTest() {
	String assignedLabel = homePage.verifyAssignedLabeldisplayed();
	System.out.println(assignedLabel);
	Assert.assertEquals(assignedLabel, ConstantsUtil.Home_Page_Assigned_Label, "assigned label not matched...");
		
	}
	

	
	
	
	
}
