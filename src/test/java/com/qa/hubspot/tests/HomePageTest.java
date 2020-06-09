package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest{
	
	HomePage homepage;
	
	@BeforeClass
	public void homeSetup() {
		homepage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=2)
	public void verifyHomepageTitleTest() {
		String title= homepage.getHomePageTitle();
		Assert.assertEquals(title,Constants.HOME_PAGE_TITLE ,"Home Page title not found...");
		
	}
	
	@Test(priority=1)
	public void verifyHomePageHeaderTextTest() {
		String header=homepage.getHomePageHeaderText();
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=3)
	public void verifyLoggedInUserTest() throws InterruptedException {
		String accountName=homepage.getAccountName();
		Assert.assertEquals(accountName,prop.getProperty("accountname"), "Account Name is not correct");
		
	}
	
	
	
	
	
	
	
	
	
	

}
