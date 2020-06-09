package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {

	private WebDriver driver;
	
	By createPrimaryContact = By.xpath("//span[text()='Create contact']");
	By eMail= By.xpath("//input[@data-field='email']");
	By firstName= By.xpath("//input[@data-field='firstname']");
	By lastName=By.xpath("//input[@data-field='lastname']");
	By jobTitle=By.xpath("//input[@data-field='jobtitle']");
	By createSecondaryContact= By.xpath("(//span[text()='Create contact'])[2]");
	By contactsPageHeader= By.xpath("//i18n-string[text()='Contacts']");
	//By createAndAddOther=By.xpath("//i18n-string[text()='Create and add another']");
	By backToContacts= By.xpath("(//*[text()='Contacts'])[1]");
	public ContactsPage(WebDriver driver) {
		
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getContactsPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
		
	}
	
	public String getContactsPageHeader() {
		elementUtil.waitForElementToBeVisible(contactsPageHeader, 5);
		return elementUtil.doGetText(contactsPageHeader);
	}
	
	//public ContactsVerificationPages createContact(String email,String firstname,String lastname,String jobtitle)  {
	  public void createContact(String email,String firstname,String lastname,String jobtitle)  {
		elementUtil.waitForElementToBeVisible(createPrimaryContact, 10);
		elementUtil.doClick(createPrimaryContact);
		elementUtil.waitForElementToBeVisible(this.eMail, 5);
		elementUtil.doSendKeys(eMail,email);
		elementUtil.doSendKeys(firstName, firstname);
		elementUtil.doSendKeys(lastName, lastname);
		elementUtil.waitForElementToBeVisible(jobTitle, 10);
		elementUtil.doSendKeys(jobTitle, jobtitle);
		elementUtil.waitForElementToBeVisible(createSecondaryContact, 5);
		//elementUtil.doClick(createSecondaryContact);
		//elementUtil.clickWhenReady(createSecondaryContact, 10);
		elementUtil.doActionsClick(createSecondaryContact);
		elementUtil.clickWhenReady(backToContacts, 5);
		
		
		//return new ContactsVerificationPages(driver);
		//elementUtil.waitForTitleToBePresent(Constants.CREATED_USERS_PAGE_TITLE, 10);
		//driver.navigate().back();
		
		
			
	}
	
	
	
	
	
	
	
	
	
}
