package com.qa.magentoshopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.magentoshopping.util.ElementUtil;

public class MyAccountPage {

	private ElementUtil eleUtil;
	private WebDriver driver;

	private By userInfoSection = By.cssSelector(".box.box-information");
	private By searchInput=By.id("search");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean getUserInformation() {
		return eleUtil.doIsdisplayed(userInfoSection);

	}
	
	public ProductSearchPage searchProduct(String productName) {
		eleUtil.doSendKeys(searchInput, productName);
		eleUtil.performEnter(searchInput);
		return new ProductSearchPage(driver);
	}

}
