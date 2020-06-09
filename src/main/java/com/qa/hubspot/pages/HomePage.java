package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;

	By header = By.xpath("//div/h1[@class='private-header__heading private-header__heading--solo']");

	By accounMenu = By.xpath("//a[@id='account-menu']");
	By accountName = By.xpath("//div[@class='user-info-email']");
	
	By primaryContactLink= By.id("nav-primary-contacts-branch");
	By childContactLink= By.id("nav-secondary-contacts");
	
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getHomePageTitle() {

		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);

	}

	public String getHomePageHeaderText() {

		if (elementUtil.doIsDisplayed(header)) {

			return elementUtil.doGetText(header);

		}
		return null;
	}

	public String getAccountName() throws InterruptedException {
		elementUtil.doClick(accounMenu);
		Thread.sleep(5000);
		if (elementUtil.doIsDisplayed(accountName)) {

			return elementUtil.doGetText(accountName);

		}
		return null;
	}
	
	public ContactsPage goToContactsPage() {
		clickOnContacts();//using encapsulation here
		return new ContactsPage(driver);//returning object for next landing page
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementToBeVisible(primaryContactLink, 10);
		elementUtil.doClick(primaryContactLink);
		elementUtil.waitForElementToBeVisible(childContactLink, 4);
		elementUtil.doClick(childContactLink);
		
	}

}
