package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsVerificationPages extends BasePage {

	private WebDriver driver;
	

	By contactNameHeader = By.xpath("//span[text()='puja pandey'][1]");

	public ContactsVerificationPages(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getContactNameHeader() {
		elementUtil.waitForElementToBeVisible(contactNameHeader, 10);
		return elementUtil.doGetText(contactNameHeader);
		
	}

}
