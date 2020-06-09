package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	
	// 1.By locators---OR

	By userName = By.xpath("//input[@id='username']");
	By passWord = By.xpath("//input[@id='password']");
	By loginButton = By.xpath("//button[@id='loginBtn']");
	By signUp = By.linkText("Sign up");
	By signInWithGoogle = By.xpath("//div/a[@class='google-sign-in']");

	// 2.Create constructor of page class

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil= new ElementUtil(this.driver);
	}

	// Page Actions

	public String getLoginPageTitle() {
		
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	public boolean verifySignUpLink() {
		//return driver.findElement(signUp).isDisplayed();
		return elementUtil.doIsDisplayed(signUp);
	}

	public boolean verifySignInOptionWithGoogle() {
		return elementUtil.doIsDisplayed(signInWithGoogle);
		//return driver.findElement(signInWithGoogle).isDisplayed();
	}

	public HomePage doLogin(String username, String password) {
		//driver.findElement(userName).sendKeys(username);
		//driver.findElement(passWord).sendKeys(password);
		//driver.findElement(loginButton).click();
		
		elementUtil.waitForElementToBeVisible(userName, 10);
		elementUtil.doSendKeys(userName,username);
		elementUtil.doSendKeys(passWord,password);
		elementUtil.doClick(loginButton);
		
		return new HomePage(driver);
	}

}
