package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ElementUtil;

public class MyContactsPages extends BasePage {
	
	private WebDriver driver;
	
	By myContacts=By.xpath("//span[text()='My contacts'][1]");
	By contactNameHeader = By.xpath("//span[text()='puja pandey']");
	
	public MyContactsPages(WebDriver driver) {
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	
	public String getContactsNameHeader() {
		elementUtil.waitForElementToBeVisible(myContacts, 5);
		elementUtil.doClick(myContacts);
		elementUtil.waitForElementToBeVisible(contactNameHeader, 5);
		return elementUtil.doGetText(contactNameHeader);
		
		
	}

}
