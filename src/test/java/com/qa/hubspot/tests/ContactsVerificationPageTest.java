package com.qa.hubspot.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.ContactsVerificationPages;
import com.qa.hubspot.pages.HomePage;

public class ContactsVerificationPageTest extends BaseTest{
	
	HomePage homepage;
	ContactsPage contactspage;
	ContactsVerificationPages contactverificationpage;
	
	@BeforeClass
	
	public void contactsVerificationSetUp() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.goToContactsPage();
		//contactverificationpage=contactspage.createContact("puja@gmail.com", "puja", "pandey", "qaanalyst");
		
	}
	
	@Test(priority=1)
	public String verifyContactNameHeaderTest() {
		
		
		
		return contactverificationpage.getContactNameHeader();
		
	}

}
