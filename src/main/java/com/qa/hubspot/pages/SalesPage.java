package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class SalesPage extends BasePage {

	WebDriver driver;
	
	
	
	By sales=By.xpath("//a[@id='nav-primary-sales-branch'][1]");
	By deals= By.xpath("//*[@id='nav-secondary-deals']/div[1]");
	
	public SalesPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	public String getDealsPageTitle() {
		
		
		elementUtil.doClick(sales);
		
		elementUtil.doClick(deals);
		
		
		 return elementUtil.waitForTitleToBePresent(Constants.DEAL_PAGE_TITLE, 10);

	}
	
}

