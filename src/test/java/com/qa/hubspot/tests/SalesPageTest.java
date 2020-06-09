package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.SalesPage;
import com.qa.hubspot.utils.Constants;

public class SalesPageTest extends BasePage{
	
	SalesPage salespage;
	

	@Test
	public void verifyDealsPageTitleTest() {
		String title=salespage.getDealsPageTitle();
		Assert.assertEquals(title, Constants.DEAL_PAGE_TITLE,"Deals page title is not present...");
	}
	
	
}
