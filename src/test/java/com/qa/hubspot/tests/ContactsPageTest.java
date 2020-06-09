package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {

	HomePage homepage;
	ContactsPage contactspage;

	@BeforeClass

	public void contactsSetUp() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.goToContactsPage();

	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactspage.getContactsPageTitle();
		System.out.println("Contact Page title is:" + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public String verifyContactsPageHeaderTest() {
		return contactspage.getContactsPageHeader();
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][]=ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		return data;
	}
	@Test(priority = 3,dataProvider="getContactsTestData")
	public void verifyCreateContactTest(String email,String firstname,String lastname,String jobtitle){
		contactspage.createContact(email,firstname,lastname,jobtitle);
	}

}

