package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 2)
	public void verifyGetLoginPagetitleTest() {
		String title = loginpage.getLoginPageTitle();
		System.out.println("Login page title is :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login Page title is not matched...");
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.verifySignUpLink(), "Sign Up link is not matched...");
	}

	@Test(priority = 3)
	public void verifySignUpWithGoogleTest() {
		Assert.assertTrue(loginpage.verifySignInOptionWithGoogle());
	}

	@Test(priority = 4)
	public void verifyDoLoginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
